package com.geek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {
	@Autowired
	KafkaProducer kafkaProducer;
	@GetMapping("/api/product")
public String notification( @RequestParam("product") String product
		,@RequestParam("name") String name) {
		kafkaProducer.sendMessage(name, product);
	return "Notification Send";
}
}
