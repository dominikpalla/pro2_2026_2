package cz.uhk.spring2.controller;

import cz.uhk.spring2.model.User;
import cz.uhk.spring2.service.UserService;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users_list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("user", new User());
        return "users_edit";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable long id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "users_detail";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable long id, Model model){
        User u = userService.getUser(id);
        if (u != null) {
            model.addAttribute("user", u);
            return "users_edit";
        }else{
            return "redirect:/users/";
        }
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable long id){
        userService.deleteUser(id);
        return "redirect:/users/";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute User user){
        userService.saveUser(user);
        return "redirect:/users/";
    }

}
