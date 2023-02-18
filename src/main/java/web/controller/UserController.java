package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.entity.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private final UserService service;
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String showAllUsers(Model model) {
        List<User> listOfAllUsers = service.getAllUsers();
        model.addAttribute("users", listOfAllUsers);
        return "users";
    }
    @RequestMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("newUser", new User());
        return "user-info";
    }
    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("newUser") User user){
        service.addUser(user);
        return "redirect:/";
    }
    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("UserID") int id, Model model){
        User user = service.getUserById(id);
        model.addAttribute("newUser", user);
        return "user-info";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("UserID") int id){
        service.deleteUserById(id);
        return "redirect:/";
    }
}
