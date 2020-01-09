package com.coroda.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.coroda.exception.ResourceNotFoundException;
import com.coroda.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.coroda.model.Product;
import com.coroda.service.ProductService;

@RestController
@RequestMapping(Constants.MAIN_PATH)

public class ProductController {
	
	
//our service is instantiated
	@Autowired
	ProductService productService;


	@PostMapping
	public ResponseEntity<?> save(@Valid@RequestBody Product model) throws Exception {

			Product obj = productService.save(model);

			return new ResponseEntity<>(obj, HttpStatus.OK);


	}

	
	@PutMapping
	public Product update(@Valid@RequestBody Product model) throws Exception {
		return productService.update(model);
	}

	
	@DeleteMapping(Constants.ID)
	public void delete(@Valid@PathVariable("id") Integer id) throws Exception {
		productService.delete(id);
	}

	
	@GetMapping(Constants.ID)
	public ResponseEntity<?> get(@Valid@PathVariable("id") Integer id) throws Exception {
		Product obj = productService.getId(id);

		if(obj==null) {
//			LOGGER.warn("el producto no se encuentra registrado");
			throw new ResourceNotFoundException("El producto con Id N°"+ id +" no existe");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	
	@GetMapping
	public List<Product> findAll() throws Exception {
		return productService.findAll(null);

	}


	@GetMapping(Constants.MODEL)
	public ResponseEntity<?> searchModel(@Valid@PathVariable("model") String modelo) throws Exception {
		Product obj = (Product) productService.search_model(modelo);

		if(obj==null) {
//			LOGGER.warn("el producto no se encuentra registrado");
			throw new ResourceNotFoundException("El modelo "+ modelo +" no existe");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@GetMapping(Constants.MATERIAL)
	public ResponseEntity<?> searchMaterial(@Valid@PathVariable("material") String material) throws Exception {
		List<Product> obj =  productService.search_material(material);

		if(obj==null) {
//			LOGGER.warn("el producto no se encuentra registrado");
			throw new ResourceNotFoundException("El modelo "+ material +" no existe");
		}
		return new ResponseEntity<>(obj, HttpStatus.OK);
	}
}
