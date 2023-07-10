package com.ecommerce.new2me.controller;

import com.ecommerce.new2me.model.Category;
import com.ecommerce.new2me.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    @GetMapping("/list")
    public List<Category> listCategory(){
        categoryService.listCategory();
        return categoryService.listCategory();
    }


}
