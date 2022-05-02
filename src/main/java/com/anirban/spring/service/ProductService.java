package com.anirban.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.anirban.spring.data.ProductRepository;
import com.anirban.spring.model.Product;

@RestController
@RequestMapping("/babystore")
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productRepository.getAllProducts();
	}
	
	@GetMapping("/products/{productId}")
	public Product getProductById(@PathVariable String productId) {
		Product p = productRepository.getProduct(productId);
		if(p == null) {
			throw new ProductNotFoundException(productId);
		}
		return p;
	}

}
