package com.ecommerce.new2me.service;

import com.ecommerce.new2me.model.Category;
import com.ecommerce.new2me.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    public void createCategory(Category category){
        categoryRepo.save(category);
    }
    public List<Category> listCategory(){
        return categoryRepo.findAll();
    }
    public void editCategory(int categoryId, Category updateCategory){
        Category category = categoryRepo.getById(categoryId);
        category.setCategoryName(updateCategory.getCategoryName());
        category.setDescription(updateCategory.getDescription());
        category.setImageUrl(updateCategory.getImageUrl());
        categoryRepo.save(category);
    }
    public boolean findById(int categoryId){
        return categoryRepo.findById(categoryId).isPresent();
    }
    public Optional<Category> getCategoryById(int id){
        return categoryRepo.findById(id);
    }
    public void removeCategoryById(int id){
        categoryRepo.deleteById(id);
    }
}
