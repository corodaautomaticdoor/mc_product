package com.coroda.service;

import java.util.List;
import java.util.Optional;

import com.coroda.model.Product;


public interface ProductService {

	Product save(Product model) throws Exception;

	Product update(Product model) throws Exception;
	
	void delete(Integer id) throws Exception;

	Optional<Product> get(Integer id) throws Exception;

	Product getId(Integer id);

	Product search_model(String model);

	List<Product> search_material(String material);

	List<Product> findAll(Product model)throws Exception ;



}
