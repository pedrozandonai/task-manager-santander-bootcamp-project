package pedro.zandonai.taskmanager.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pedro.zandonai.taskmanager.models.User;
import pedro.zandonai.taskmanager.service.UserService;

@Controller
@RequestMapping("/signin")
public class SignInController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showSignInPage(Model model) {
        model.addAttribute("user", new User());
        return "signin";
    }

    @PostMapping
    public String processSignInForm(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "signin";
        }

        userService.createUser(user);
        model.addAttribute("user", user);

        return "initialPage";
    }
}

