package com.gov.hack.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//@ComponentScan(basePackages={"com.gov.hack.demo"})
//@EnableJpaRepositories("com.gov.hack.demo.dao")
@SpringBootApplication
public class DisasterResponseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisasterResponseApplication.class, args);
	}

}
