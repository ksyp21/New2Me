package com.ecommerce.new2me;

import com.ecommerce.new2me.dto.ProductDto;
import com.ecommerce.new2me.model.Category;
import com.ecommerce.new2me.model.Product;
import com.ecommerce.new2me.service.CategoryService;
import com.ecommerce.new2me.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ApplicationController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
//    @GetMapping("/index")
//    public String goHome(){
//        return "index";
//    }

    @GetMapping("/admin")
    public String adminHome(){
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCat(Model model) {
        model.addAttribute("categories",categoryService.listCategory());
        return "listcategories";

    }

    @GetMapping("/admin/categories/add")
    public String getAddCat(Model model){
        model.addAttribute("category",new Category());
        return "addcategories";
    }
    @PostMapping("/admin/categories/add")
    public String postAddCat(@ModelAttribute("category")Category category){
        categoryService.createCategory(category);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id,Model model){
        Optional<Category> category =categoryService.getCategoryById(id);
        if(category.isPresent()){
            model.addAttribute("category",category.get());
            return "addcategories";
        }else return "404";
    }
    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id){
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }

    //product section
    @GetMapping("/admin/products")
    public String getproducts(Model model){
        model.addAttribute("products",productService.getAllProduct());
        return "listproduct";
    }
    @GetMapping("/admin/products/add")
    public String productAddGet(Model model){
        model.addAttribute("productDTO",new ProductDto());
        model.addAttribute("categories",categoryService.listCategory());
        return "addnewproduct";
    }
    @PostMapping("/admin/products/add")
    public String productAddPost(@ModelAttribute("ProductDTO")ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setCategory(categoryService.getCategoryById(productDto.getCategoryId()).get());
        productService.addProduct(product);
        return "redirect:/admin/products";
    }
    @GetMapping("/admin/products/delete/{id}")
    public String deleteProduct(@PathVariable long id){
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }
    @GetMapping("/admin/products/update/{id}")
    public String updateProduct(@PathVariable long id,Model model){
        Product product=productService.getProductById(id).get();
        ProductDto productDto=new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setDescription(product.getDescription());


        model.addAttribute("categories",categoryService.listCategory());
        model.addAttribute("productDTO",productDto);

        return "addnewproduct";

    }

}

