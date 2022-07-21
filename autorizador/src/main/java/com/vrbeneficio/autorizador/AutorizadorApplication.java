package com.vrbeneficio.autorizador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "application")
public class AutorizadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutorizadorApplication.class, args);
	}

}
