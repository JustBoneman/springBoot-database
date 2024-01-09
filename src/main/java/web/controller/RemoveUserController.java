package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.entities.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RemoveUserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "users/remove_User")
    public String getUserToRemove() {
        return "remove_User";
    }

    @PostMapping(value = "users/remove_User")
    public String removeUser(@RequestParam("userId") long userId, ModelMap model) {
        List<Long> usersIds = new ArrayList<>();
        List<User> users = userService.loadAllUsers();

        for(User user : users) {
            usersIds.add(user.getId());
        }

        if (usersIds.contains(userId)) {
            userService.removeUser(userId);
            model.addAttribute("msg", "Successfully removed user");
        } else {
            model.addAttribute("msg", "Incorrect user id");
        }

        return "remove_User";
    }
}
