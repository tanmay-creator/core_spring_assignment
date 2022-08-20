package com.demo;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class Product /* implements BeanNameAware, ApplicationContextAware */ /*
																				 * implements InitializingBean,
																				 * DisposableBean
																				 */{
	private Integer id;
	private String name;
	private BigDecimal price;
	private boolean isAvailable;

	@PostConstruct
	public void myInitProductAnnotation() {
		System.out.println("myInitProduct Annotation is called");
	}
	
	@PreDestroy
	private void myPreDestroyProductAnnotation() {
		System.out.println("myPreDestroyProduct Annotation is called");
	}
	

	private void myInitProduct() {
		System.out.println("myInitProduct xml is called");
	}
	
	private void myPreDestroyProduct() {
		System.out.println("myPreDestroyProduct xml is called");
	}
	
	public Product() {
		System.out.println("default ctr is called");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		System.out.println(" public void setId(Integer id) is called");
		this.id = id;
	}

	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		System.out.println(" public void setName is called");
		this.id = id;
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		System.out.println(" public void setPrice is called");
		this.price = price;
	}

	public boolean isAvailable() {
		
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		System.out.println(" public void isAvailable is called");
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", isAvailable=" + isAvailable + "]";
	}
	
	

	public void destroy() throws Exception {
		System.out.println("public void destroy() throws Exception ");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("public void afterPropertiesSet() throws Exception ");
	}

	public void setBeanName(String name) {
		System.out.println("public void setBeanName(String name) is called");
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("public void setApplicationContext(ApplicationContext applicationContext)");
	}


	
}
