package com.geek.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.geek.model.Product;
import com.geek.service.ProductService;

@RestController
public class ProductApi {
   @Autowired
	ProductService service;
   @Autowired
    Environment env;
     
   @GetMapping("/{id}")
	public Product searchProduct(@PathVariable  int id) {
		List<Product> plist=service.allProducts();
		Product product=
		plist.stream().filter(p->p.getId()==id).findFirst().get();
		int port= Integer.parseInt(env.getProperty("local.server.port"));
		product.setPortNo(port);
		return product;
	}
}
