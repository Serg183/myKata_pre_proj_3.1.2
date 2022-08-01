package ru.kata.spring.boot_security.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;


@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("admin/users")
    public String listUser(Model model) {
        model.addAttribute("users", userService.listUser());

        return "users";
    }

    @GetMapping("admin/create")
    public String createUserForm(User user) {
        return "create";
    }

    @PostMapping("admin/create")
    public String createUser(User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping("admin/update/{username}")
    public String updateUserForm(@PathVariable("username") String username, Model model) {
        User user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping("admin/update")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user/info")
    public String userInfo(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return "Username: " + user.getUsername();
    }

}
