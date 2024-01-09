package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.entities.User;
import web.service.UserService;

@Controller
public class AddUserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "users/add_User")
    public String getUser(ModelMap model) {
        model.addAttribute("user", new User());

        return "add_User";
    }

    @PostMapping(value = "users/add_User")
    public String addUser(@ModelAttribute User user) {
        userService.saveUser(user);

        return "add_User";
    }
}
