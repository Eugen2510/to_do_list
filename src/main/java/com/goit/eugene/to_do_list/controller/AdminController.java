package com.goit.eugene.to_do_list.controller;

import com.goit.eugene.to_do_list.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    @GetMapping("/users-list")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "admin/users_list";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam String username){
        userService.deleteUser(username);
        return "redirect:/admin/users-list";
    }
}
