package com.coroda.serviceimplement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coroda.dao.ProductDAO;
import com.coroda.model.Product;
import com.coroda.service.ProductService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProductServiceImplement implements ProductService {

//the repository is instantiated
	@Autowired
	private ProductDAO productDAO;

	//the logic to the CRUD methods is implemented
	// Method save
	@Override
	public Product save(Product model) {
		return productDAO.save(model);
	}

	// Method Update
	@Override
	public Product update(Product model) {
		return productDAO.save(model);
	}

	// Method Delete
	@Override
	public void delete(Integer id) {
		productDAO.deleteById(id);
	}

	// Method Get
	// for Id
	@Override
	public Optional<Product> get(Integer id) {
		return productDAO.findById(id);
	}

	@Override
	public Product getId(Integer id) {

		Optional<Product> objopc = productDAO.findById(id);
		Product obj = null;

		if (objopc.isPresent()) {
//			LOGGER.info("registro encontrado satisfactoriamente");
			obj =  productDAO.findById(id).get();
		}

		return obj;
	}

	@Override
	public Product search_model(String model) {

		return (Product) productDAO.search_model(model);
	}

	@Override
	public List<Product> search_material(String material) {

		return  productDAO.search_material(material);
	}

	// For All
	@Override
	public List<Product> findAll(Product model) {
		return productDAO.findAll();
	}

}
