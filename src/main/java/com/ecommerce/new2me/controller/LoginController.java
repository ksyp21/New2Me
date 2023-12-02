package com.ecommerce.new2me.controller;

import com.ecommerce.new2me.common.CommonData;
import com.ecommerce.new2me.model.Role;
import com.ecommerce.new2me.model.User;
import com.ecommerce.new2me.repository.RoleRepo;
import com.ecommerce.new2me.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;

    @GetMapping("/login")
    public String login(){
        CommonData.cart.clear();
        return "login";
    }
    @GetMapping("/register")
    public String registerGet(){
        return "register";
    }
    @PostMapping("/register")
    public String registerPost(@ModelAttribute("user")User user, HttpServletRequest request) throws ServletException {
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepo.findById(2).get());
        user.setRoles(roles);
        userRepo.save(user);
        request.login(user.getEmail(),password);
        return "redirect:/";
    }
}
