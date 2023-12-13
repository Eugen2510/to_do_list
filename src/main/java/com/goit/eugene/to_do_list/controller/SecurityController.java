package com.goit.eugene.to_do_list.controller;

import com.goit.eugene.to_do_list.entity.User;
import com.goit.eugene.to_do_list.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SecurityController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login/login";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(){
        return "registration/registration";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute User user){
        System.out.println(user);
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        userService.createUser(user);
        return "redirect:/login";
    }
}
