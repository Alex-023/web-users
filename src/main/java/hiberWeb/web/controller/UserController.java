package hiberWeb.web.controller;

import hiberWeb.model.User;
import hiberWeb.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("user", new User());
        return "users";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}

//@Controller
//@RequestMapping("/cars")
//public class CarsController {
//	private final CarService carService;
//
//	@Autowired
//	public CarsController(CarService carService) {
//		this.carService = carService;
//	}
//
//	@GetMapping(value = "")
//	public String getCars(
//			@RequestParam(value = "count", defaultValue = "5") int count,
//			Model model
//	) {
//		model.addAttribute("cars", carService.getCars(count));
//		return "cars";
//	}
//}