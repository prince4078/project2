package com.sparx.blogapplication;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition(
		info=@Info(
				title="Student Api",
				description="performing Crud operation ",
				summary="This is Student api performing crud on student class ",
				termsOfService="t&c",
				contact=@Contact(
						name="Peter",
						email="peter@gmail.com"
						),
				license=@License(
						name="demo license"
						),
				version="v1"
				
				
				),
	            servers= {
                          @Server(
                        		  description="dev",
                        		  url="http://localhost:8087/"
                        		  ),
                          @Server(
                        		  description="test",
                        		  url="http://localhost:8087/"
                        		  )
                          
	            				
	            		
	            },
	            security = @SecurityRequirement(
              		  name="auth"
              		  )
      				
		)
@SecurityScheme(
		name="auth",
		in=SecuritySchemeIn.HEADER,
		type=SecuritySchemeType.HTTP,
		description="security scheme",
		bearerFormat="JWT",
		scheme="bearer"
		
		)
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
