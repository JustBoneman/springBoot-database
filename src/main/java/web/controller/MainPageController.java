package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.entities.User;
import web.service.UserService;

import java.util.List;

@Controller
public class MainPageController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String sayHello(ModelMap model) {
        List<User> users = userService.loadAllUsers();
        model.addAttribute("users", users);

        return "users";
    }

}
