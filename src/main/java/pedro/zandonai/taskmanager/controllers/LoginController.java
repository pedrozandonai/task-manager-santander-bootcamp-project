package pedro.zandonai.taskmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pedro.zandonai.taskmanager.service.TaskService;

@Controller
@RequestMapping(value = "/login", name = "loginController")
public class LoginController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public String showLoginForm() {
        return "login";
    }


}
