package hiberWeb.web.controller;

import hiberWeb.model.User;
import hiberWeb.service.UserServiceImp1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserServiceImp1 userService;

    @Autowired
    public UserController(UserServiceImp1 userService) {
        this.userService = userService;
    }


    public boolean hasCurrentUserRole(String targetRole) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }

        String formattedRole = targetRole.startsWith("ROLE_")
                ? targetRole
                : "ROLE_" + targetRole;

        return authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals(formattedRole));
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') ") // Требуется роль USER
    public String userPanel(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByNick(authentication.getName());
        model.addAttribute("users", user);
        return "user";
    }

    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('ADMIN') ") // Требуется роль USER
    public String userAdminPanel(@PathVariable Long id, Model model) {

        User user = userService.findById(id);
        model.addAttribute("users", user);
        return "user";
    }

    @PostMapping("/admin/save")
    @PreAuthorize("hasRole('ADMIN')") // Требуется роль ADMIN
    public String saveUser(@ModelAttribute User user, Model model) {
        userService.save(user);
        List<User> userList = userService.findAll();
        model.addAttribute("users", userList);
        model.addAttribute("user", new User());
        return "redirect:/admin";
    }

    @GetMapping("/admin/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')") // Требуется роль ADMIN
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("user", userService.findById(id));
        return "admin";
    }

    @DeleteMapping("/admin/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')") // Требуется роль ADMIN
    @ResponseBody
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getAuthorities().toString(); //getName();
        model.addAttribute("user", username);
        return "hello";
    }

    @RequestMapping(value = "/default", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()") // Доступ только авторизованным
    public String startWeb() {
        if (hasCurrentUserRole("ADMIN")) {
            return "redirect:/admin/";
        }
        if (hasCurrentUserRole("USER")) {
            return "redirect:/user/";
        }
        return "redirect:/r/";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')") // Требуется роль ADMIN
    public String adminPage(Model model) {
        List<User> user = userService.findAll();
        model.addAttribute("users", user);
        model.addAttribute("user", new User());
        return "admin";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

}