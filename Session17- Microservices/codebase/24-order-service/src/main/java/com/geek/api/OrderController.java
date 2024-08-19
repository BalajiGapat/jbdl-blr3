package com.geek.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.geek.model.Order;
import com.geek.proxy.ProductServiceProxy;

@RestController
public class OrderController {
   @GetMapping("/order/{id}/{quantity}")
	public Order placeOrder(@PathVariable  int id,@PathVariable int quantity) {
	   String url="http://localhost:8000/"+id;
	   ResponseEntity<Order> response=
	   new RestTemplate().getForEntity(url, Order.class);
	    Order order=response.getBody();
	    order.setPrice(order.getPrice()*quantity);
	    order.setQuantity(quantity);
		return order;
	}
   @Autowired
    private ProductServiceProxy proxy;
   
   @GetMapping("/orderFeign/{id}/{quantity}")
  	public Order placeOrderWithFeign(@PathVariable  int id,@PathVariable int quantity) {
  	    Order order=proxy.getProduct(id);
  	    order.setQuantity(quantity);
  		return order;
  	}
   @Autowired
   private RestTemplate restTemplate;

   @GetMapping("/orderLoadBalance/{id}/{quantity}")
  	public Order placeOrderWithLoadBalance(@PathVariable  int id,@PathVariable int quantity) {
  	   String url="http://product-catalogue-service/"+id;
  	   ResponseEntity<Order> response=
  	   restTemplate.getForEntity(url, Order.class);
  	    Order order=response.getBody();
  	    order.setPrice(order.getPrice()*quantity);
  	    order.setQuantity(quantity);
  		return order;
  	}
}
