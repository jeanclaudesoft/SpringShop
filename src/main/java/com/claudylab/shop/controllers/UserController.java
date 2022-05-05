package com.claudylab.shop.controllers;

import com.claudylab.shop.models.Category;
import com.claudylab.shop.models.User;
import com.claudylab.shop.services.CategoryService;
import com.claudylab.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String viewUsers(Model model){
        model.addAttribute("usersList",userService.usersList());
        return "Users/usersList";
    }

    @GetMapping("/add")
    public String addView(){
        return "Users/addUser";
    }

    @PostMapping("/save")
    public String saveUser(User user){
        user.setRoles("ROLE_ADMIN");
        userService.createUser(user);
        return "redirect:/users/list";
    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/users/list";
    }

}
