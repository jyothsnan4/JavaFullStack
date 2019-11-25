package com.project.changepass.change_password;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class ChangePasswordApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ChangePasswordApplication.class, args);
	}

}
