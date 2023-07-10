package com.ecommerce.new2me.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/shop/category/shop/category/2")
    public String redirectLaptop(){
        return "redirect:/shop/category/2";
    }
    @GetMapping("/shop/category/shop/category/3")
    public String redirectCamera(){
        return "redirect:/shop/category/3";
    }
    @GetMapping("/shop/category/shop/category/4")
    public String redirectHeadphone(){
        return "redirect:/shop/category/4";
    }
    @GetMapping("/shop/category/shop/category/1")
    public String redirectMobile(){
        return "redirect:/shop/category/1";
    }

}
