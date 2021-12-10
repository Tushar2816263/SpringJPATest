package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repo.Productrepo;

@Service
public class ProductService {
	
	
	@Autowired
	Productrepo prodrepo;
	
	public Product addProduct(Product product)
	{
	  return this.prodrepo.save(product);
	}
	
	public String deleteProduct(Long id)
	{
		Optional<Product> prod = prodrepo.findById(id);
		if(prod.isPresent())
		{
			prodrepo.delete(prod.get());
			return "product deleted";
		}
		else
		{
			return "no product found";
		}
	}
	
	public Product updateProduct(Product prod)
	{
		Optional<Product> product = prodrepo.findById(prod.getId());
		if(product.isPresent())
		{
			product.get().setName(prod.getName());
			product.get().setDescription(prod.getDescription());
			product.get().setPrice(prod.getPrice());
			
		return prodrepo.save(product.get());
		}
		else
		{
			return null;
		}
	}
	
	public List<Product> allProducts()
	{
		return prodrepo.findAll();
	}

}
