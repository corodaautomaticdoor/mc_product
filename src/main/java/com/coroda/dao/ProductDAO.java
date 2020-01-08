package com.coroda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coroda.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


//the repository is connected to the model through the jpa
public interface ProductDAO extends JpaRepository<Product, Integer>{
//     @Modifying
//     @Query(value =  "INSERT INTO product (model, material,description,dimensions,cost) VALUE (?,?,?,?,?)" ,nativeQuery = true )
//     List<Product> insert(Product model);

//     @Modifying
//     @Query(
//             value =
//                     "insert into Users (name, age, email, status) values (:name, :age, :email, :status)",
//             nativeQuery = true)
//     void insertUser(@Param("name") String name, @Param("age") Integer age,
//                     @Param("status") Integer status, @Param("email") String email);

//     @Query(value =  "select * from product", nativeQuery = true)
//     List<Product> search(Product model);
//


}
