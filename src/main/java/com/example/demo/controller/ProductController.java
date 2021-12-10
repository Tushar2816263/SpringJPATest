package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService prodservice;
	
	@PostMapping("addproduct")
	public Product addproduct(@RequestBody Product product)
	{
		return this.prodservice.addProduct(product);
	}
	
	@DeleteMapping("/deleteproduct")
	public String deleteProduct(@RequestParam("id") Long id)
	{
		return this.prodservice.deleteProduct(id);
	}
	
	@GetMapping("/allproducts")
	public List<Product> allProducts()
	{
		return this.prodservice.allProducts();
	}
	
	@PutMapping("/updateproduct")
	public Product updateproduct(@RequestBody Product product)
	{
		return this.prodservice.updateProduct(product);
	}
}
