package com.ecommerce.new2me.controller;

import com.ecommerce.new2me.common.CommonData;
import com.ecommerce.new2me.model.Product;
import com.ecommerce.new2me.service.ProductService;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CartController {
    @Autowired
    ProductService productService;
    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id){
        CommonData.cart.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }
    @GetMapping("/cart")
    public String cartGet(Model model){
        model.addAttribute("cartCount",CommonData.cart.size());
        model.addAttribute("total",CommonData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart",CommonData.cart);
        return "cart";
    }
    @GetMapping("/cart/removeItem/{index}")
    public String cartItemsRemove(@PathVariable int index){
        CommonData.cart.remove(index);
        return "redirect:/cart";
    }
    @GetMapping("/checkout")
    public String checkout(Model model){
        model.addAttribute("totalwithdelivery", CommonData.cart.stream().mapToDouble(Product::getPrice).sum() + 150);
        model.addAttribute("total",CommonData.cart.stream().mapToDouble(Product::getPrice).sum());
        return "checkout";
    }
    @GetMapping("/addToWishlist/{id}")
    public String addToWishlist(@PathVariable int id){
        CommonData.wishlist.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }
    @GetMapping("/wishlist")
    public String wishlistGet(Model model){
        model.addAttribute("wishlist",CommonData.wishlist);
        return "wishlist";
    }
    @GetMapping("/wishlist/removeItem/{index}")
    public String wishlistItemsRemove(@PathVariable int index){
        CommonData.wishlist.remove(index);
        return "redirect:/wishlist";
    }
//    @GetMapping("/success")
//    public String succrss(){
//        return "success";
//    }
//    @GetMapping("/payment")
//    public String makePayment(Model model){
//        model.addAttribute("")
//    }


}
