package com.zensar.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;

@SpringBootApplication
@ComponentScan(basePackages = {"test","com.zensar"})
@Order(2)
public class SpringBootDemo3Application implements CommandLineRunner {

	public static void main(String[] args) {
		System.out.println("Ram");
		SpringApplication.run(SpringBootDemo3Application.class, args);
		System.out.println("Laxman");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Seeta");
		
	}

}
