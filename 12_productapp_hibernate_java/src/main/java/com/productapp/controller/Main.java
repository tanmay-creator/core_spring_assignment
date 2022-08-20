package com.productapp.controller;
import java.math.BigDecimal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.productapp.config.AppConfig;
import com.productapp.entity.Product;
import com.productapp.service.ProductService;
public class Main {
	public static void main(String[] args) {

	
		
		AnnotationConfigApplicationContext applicationContext=
				new AnnotationConfigApplicationContext(AppConfig.class);
		

		ProductService productService = applicationContext.getBean("productService", ProductService.class);
		
		/*
		 * List<Product> productList=productService.getAll();
		 * 
		 * productList.forEach(p-> System.out.println(p));
		 */
//		Product product=new Product("computer", new BigDecimal(40000), true);
//		productService.addProduct(product);
//		product=new Product("pen", new BigDecimal(30), true);
//		productService.addProduct(product);
		
	    Product product=productService.getById(12);
//		product.setAvailable(true);
//		productService.updateProduct(2, product);
		System.out.println(product);
	}

}
