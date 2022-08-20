package com.productapp.controller;

import java.math.BigDecimal;
import java.util.*;
import com.productapp.dao.Product;
import com.productapp.service.ProductService;
import com.productapp.service.ProductServiceImpl;

public class Main {
	public static void main(String[] args) {

		ProductService productService = new ProductServiceImpl();
		
		List<Product> list = productService.getAll();
		for(Product p : list) {
			System.out.println(p.getName()+" "+p.getId()+" "+p.getPrice()+" ");
		}
//		System.out.println("====================");
//		System.out.println(productService.getById(2));
//		System.out.println("====================");
//		System.out.println(productService.addProduct(new Product("mobile",new BigDecimal(20000),true)));
//		System.out.println("====================");
//		System.out.println(productService.deleteProduct(4));
		System.out.println("====================");
		System.out.println(productService.updateProduct(3, new Product("iPhone",new BigDecimal(50000),false)));
	}

}
