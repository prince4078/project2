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
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sparx.blogapplication.jwtauth.JWTAuthenticationEntryPoint;
import com.sparx.blogapplication.jwtauth.JwtAuthenticationFilter;
import com.sparx.blogapplication.security.CustomUserDetailService;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig {

	@Autowired
	private UserDetailsService userDetailService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JWTAuthenticationEntryPoint point;
	@Autowired
	private JwtAuthenticationFilter filter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable()).authorizeRequests()
		.requestMatchers("auth/login").permitAll()
		.requestMatchers("/post/allPost").permitAll()
		.requestMatchers("/swagger-ui/**").permitAll()
		.requestMatchers("/swagger-resource").permitAll()
		.anyRequest().authenticated()
		.and().exceptionHandling(ex -> ex.authenticationEntryPoint(point))
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

}
