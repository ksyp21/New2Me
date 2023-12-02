package com.ecommerce.new2me.repository;

import com.ecommerce.new2me.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    List<Product> findAllByCategory_Id(int id);
}
