package ua.vadim.controllers;

import org.springframework.stereotype.Controller;
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

    /**
     * mapping for default authentication page
     */
    @GetMapping
    public ModelAndView authPage() {
        return new ModelAndView("auth","user",new User())
                .addObject( "invalid", "false");
    }

    /**
     * mapping to let user attempt to login to page
     */
    @GetMapping("/login")
    public ModelAndView authenticate(@ModelAttribute("user") User user, HttpServletResponse response) {
        if (UserData.authenticate(user)) {
            Cookie cookie = new Cookie("auth", "true");
            cookie.setPath("/");
            cookie.setMaxAge(86400);
            response.addCookie(cookie);
            response.setContentType("text/plain");
            return new ModelAndView("main", "users", UserData.getAll());
        }
        return new ModelAndView("auth",  "user",new User())
                .addObject( "invalid", "true");
    }

    /**
     * mapping to let the user try to authenticate
     */
    @GetMapping("/registration")
    public ModelAndView registrationPage() {
        return new ModelAndView("registration", "user", new User())
                .addObject( "invalid", "false");
    }

    /**
     * mapping to let the user try to register
     */
    @PostMapping("/registration")
    public ModelAndView register(@ModelAttribute("user") User user, HttpServletResponse response) {
        if (UserData.register(user)) {
            Cookie cookie = new Cookie("auth", "true");
            cookie.setPath("/");
            cookie.setMaxAge(86400);
            response.addCookie(cookie);
            response.setContentType("text/plain");
            return new ModelAndView("redirect:/main");
        }
        System.err.println("ne regnulo");
        return new ModelAndView("registration", "user", new User())
                .addObject( "invalid", "true");
    }
}
