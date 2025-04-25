package hiberWeb.web.controller;

import hiberWeb.model.User;
import hiberWeb.service.UserServiceImp1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserServiceImp1 userService;

    @Autowired
    public UserController(UserServiceImp1 userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("user", userService.findById(id));
        return "user";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}