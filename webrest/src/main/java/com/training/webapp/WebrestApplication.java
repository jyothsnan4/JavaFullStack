package com.training.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class WebrestApplication extends SpringBootServletInitializer { //observe directory structure. very important. 

	public static void main(String[] args) {
		SpringApplication.run(WebrestApplication.class, args);
	}

}
