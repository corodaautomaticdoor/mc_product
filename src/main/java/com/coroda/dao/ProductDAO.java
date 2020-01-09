package com.coroda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coroda.model.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


//the repository is connected to the model through the jpa
public interface ProductDAO extends JpaRepository<Product, Integer>{
    
     @Query(value =  "select * from product p where p.model in (:model)", nativeQuery = true)
     Product search_model(String model);

    @Query(value =  "select * from product p WHERE p.material in  (:material)", nativeQuery = true)
    List<Product> search_material(String material);




}
