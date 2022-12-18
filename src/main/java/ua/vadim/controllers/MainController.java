package ua.vadim.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.vadim.dao.UserData;
import ua.vadim.model.User;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

@Controller
@RequestMapping("/main")
public class MainController {
    @GetMapping
    public ModelAndView getPage(HttpServletRequest request) {
        Optional<Cookie> authCookie = Arrays.stream(request.getCookies())
                .filter(x -> x.getName().equals("auth"))
                .findFirst();
        if (authCookie.isPresent()) {
            return new ModelAndView("main");
        }
        return new ModelAndView("auth", "user", new User())
                .addObject("invalid", "false");
    }

    @GetMapping("/users")
    public ModelAndView getMainPage(HttpServletRequest request) {
        Optional<Cookie> authCookie = Arrays.stream(request.getCookies())
                .filter(x -> x.getName().equals("auth"))
                .findFirst();
        if (authCookie.isPresent()) {
            return new ModelAndView("users", "users", UserData.getAll());
        }
        return new ModelAndView("auth", "user", new User());
    }

    @GetMapping("/logout")
    public ModelAndView getOut(HttpServletRequest request) {
        Arrays.stream(request.getCookies())
                .filter(x -> x.getName().equals("auth"))
                .findFirst()
                .ifPresent(value -> value.setMaxAge(0));
        return new ModelAndView("auth", "user", new User());
    }
}
