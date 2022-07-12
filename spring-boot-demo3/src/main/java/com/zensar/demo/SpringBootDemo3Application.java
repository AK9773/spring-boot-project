package com.zensar.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;

@SpringBootApplication
@ComponentScan(basePackages = {"test","com.zensar"})
@Order(2)
public class SpringBootDemo3Application{

	public static void main(String[] args) {
		System.out.println("Ram");
		SpringApplication.run(SpringBootDemo3Application.class, args);
		System.out.println("Laxman");
	}




	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
		
	}
		
}
