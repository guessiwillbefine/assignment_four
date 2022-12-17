package ua.vadim.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.vadim.dao.UserData;
import ua.vadim.model.User;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/auth")
public class AuthController {

    /**mapping for default authentication page*/
    @GetMapping
    public ModelAndView authPage() {
        return new ModelAndView("auth", "user", new User());
    }
    /**mapping to let user attempt to login to page*/
    @GetMapping("/login")
    public String authenticate(@ModelAttribute("user") User user, BindingResult bindingResult, HttpServletResponse response) {
        if (UserData.authenticate(user)) {
            Cookie cookie = new Cookie("auth", "true");
            cookie.setPath("/");
            cookie.setMaxAge(86400);
            response.addCookie(cookie);
            response.setContentType("text/plain");
            return "redirect:/main";
        }
        return "auth";
    }
    /**mapping to let the user try to authenticate*/
    @GetMapping("/registration")
    public ModelAndView registrationPage() {
        return new ModelAndView("registration","user",new User());
    }
    /**mapping to let the user try to register*/
    @PostMapping("/registration")
    public String register(@ModelAttribute("user") User user, HttpServletResponse response) {
        System.out.println(user);
        if (UserData.register(user)) {
            Cookie cookie = new Cookie("auth", "true");
            cookie.setPath("/");
            cookie.setMaxAge(86400);
            response.addCookie(cookie);
            response.setContentType("text/plain");
            return "redirect:/main";
        }
        return "redirect:/auth/registration";
    }
}
