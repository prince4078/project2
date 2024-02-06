package com.sparx.blogapplication;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BlogapplicationApplication {
    
	
	public static void main(String[] args) {
		SpringApplication.run(BlogapplicationApplication.class, args);

	}
    
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	

	
}
