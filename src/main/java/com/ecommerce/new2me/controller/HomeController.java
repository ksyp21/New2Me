package com.ecommerce.new2me.controller;

import com.ecommerce.new2me.common.CommonData;
import com.ecommerce.new2me.service.CategoryService;
import com.ecommerce.new2me.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.model.IModel;

@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping({"/","/home"})
    private String home(Model model){

        model.addAttribute("cartCount", CommonData.cart.size());
        model.addAttribute("cartCount",CommonData.cart.size());
        model.addAttribute("categories",categoryService.listCategory());
        model.addAttribute("products",productService.getAllProduct());
        return "index";
    }
    @GetMapping({"/shop"})
    private String shop(Model model){
        model.addAttribute("cartCount",CommonData.cart.size());
        model.addAttribute("categories",categoryService.listCategory());
        model.addAttribute("products",productService.getAllProduct());
        return "store";
    }
    @GetMapping({"/shop/category/{id}"})
    private String shopByCategory(Model model, @PathVariable int id){
        model.addAttribute("cartCount",CommonData.cart.size());
        model.addAttribute("categories",categoryService.listCategory());
        model.addAttribute("products",productService.getAllProductsByCategoryId(id));
        return "store";
    }
    @GetMapping({"/shop/viewproduct/{id}"})
    private String viewProduct(Model model, @PathVariable int id){
        model.addAttribute("product",productService.getProductById(id).get());
        model.addAttribute("cartCount",CommonData.cart.size());
        return "product";
    }
    @GetMapping("/success")
    public String succrss(){
        return "success";
    }

    @GetMapping("/search")
    public String searchProduct(Model model, @RequestParam("productName") String productName) {
        model.addAttribute("cartCount", CommonData.cart.size());
        model.addAttribute("categories", categoryService.listCategory());
        model.addAttribute("products", productService.searchProductsByName(productName));
        return "/search";
    }
}
