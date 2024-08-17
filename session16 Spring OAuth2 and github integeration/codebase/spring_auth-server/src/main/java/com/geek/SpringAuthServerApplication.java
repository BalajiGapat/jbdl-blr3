package com.geek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//http://localhost:9000/.well-known/openid-configuration
@SpringBootApplication
public class SpringAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAuthServerApplication.class, args);
	}

}
