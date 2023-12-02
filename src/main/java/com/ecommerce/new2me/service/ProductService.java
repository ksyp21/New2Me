package com.ecommerce.new2me.service;


import com.ecommerce.new2me.model.Product;
import com.ecommerce.new2me.repository.CategoryRepo;
import com.ecommerce.new2me.repository.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }
    public void addProduct(Product product){
        productRepo.save(product);
    }
    public void removeProductById(long id){
        productRepo.deleteById(id);
    }
    public Optional<Product> getProductById(long id){
        return productRepo.findById(id);
    }
    public List<Product> getAllProductsByCategoryId(int id){
        return productRepo.findAllByCategory_Id(id);
    }

    public Object searchProductsByName(String productName) {
        List<Product> searchResults = new ArrayList<>();
        List<Product> allProducts = getAllProduct();

        for (Product product : allProducts) {
            if (product.getName().toLowerCase().contains(productName.toLowerCase())) {
                searchResults.add(product);
            }
        }

        return searchResults;
    }










}
