package org.example.controllers;

import org.example.model.Authority;
import org.example.model.User;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController {
//    @Autowired
    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/register"})
    public String registerForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "register";
    }
    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") User user, Model model) {
//        String validator = validate(user);
//
//        if (!validator.isEmpty()) {
//            model.addAttribute("validator", validator);
//            return "register";
//        }
        user.getAuthorities().add(new Authority(user, "ROLE_USER"));

        userService.saveUser(user);
        return "redirect:/login";
    }
    private String validate(User user) {
        if (userService.getUser(user.getUsername()) != null) {
            return "użytkownik o takiej nazwie istnieje";
        } else if (user.getUsername().isEmpty() || user.getPassword().isEmpty())
        {
            return "wypełnij wszystkie pola";
        }
        return "";
    }
}
