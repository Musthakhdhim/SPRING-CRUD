package com.crudoperation.Crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac =SpringApplication.run(CrudApplication.class, args);
		System.out.println("bean processinfg");
	}

}
