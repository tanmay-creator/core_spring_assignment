package com.productapp.controller;
import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.productapp.entity.Product;
import com.productapp.service.ProductService;
public class Main {
	public static void main(String[] args) {

	
		
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("productapp.xml");
		

		ProductService productService = applicationContext.getBean("productService", ProductService.class);
		
		/*
		 * List<Product> productList=productService.getAll();
		 * 
		 * productList.forEach(p-> System.out.println(p));
		 */
	
		
		Product product=productService.getById(12);
//		product.setAvailable(true);
//		productService.updateProduct(2, product);
		System.out.println(product);
	}

}
