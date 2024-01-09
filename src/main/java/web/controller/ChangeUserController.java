package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.entities.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChangeUserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "users/change_User")
    public String getUserToChange(ModelMap model) {
        model.addAttribute("user", new User());

        return "change_User";
    }

    @PostMapping(value = "users/change_User")
    public String changeUser(@ModelAttribute User user, ModelMap model) {
        List<Long> usersIds = new ArrayList<>();
        List<User> users = userService.loadAllUsers();

        for(User usr : users) {
            usersIds.add(user.getId());
        }

        if (usersIds.contains(user.getId())) {
            userService.changeUser(user);
            model.addAttribute("msg", "Successfully changed user");
        } else {
            model.addAttribute("msg", "Incorrect user id");
        }
        return "change_User";
    }
}
