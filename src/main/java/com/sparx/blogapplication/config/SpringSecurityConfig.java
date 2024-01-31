package com.sparx.blogapplication.config;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.sparx.blogapplication.security.CustomUserDetailService;

@Configuration
public class SpringSecurityConfig {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CustomUserDetailService customUserDetailService;
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http.csrf().disable()
		    .authorizeHttpRequests()
		    .requestMatchers("/post/all").permitAll()
		    .requestMatchers("/user/create").permitAll()
		    .anyRequest().authenticated()
		    .and().httpBasic(); // Make sure this is configured properly
		 return http.build();
	    }
	 @Bean
	 public DaoAuthenticationProvider daoAuthenticationProvider() { 
	     DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
	     daoAuthenticationProvider.setUserDetailsService(customUserDetailService);
	     daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
	     return daoAuthenticationProvider;
	 }

	
	
	
	
    
}
