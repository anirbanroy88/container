package com.anirban.spring.service;

public class ProductNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8872886910511443402L;
	
	public ProductNotFoundException(String productId) {
		super("Product "+productId+" is not registered");
	}

}
