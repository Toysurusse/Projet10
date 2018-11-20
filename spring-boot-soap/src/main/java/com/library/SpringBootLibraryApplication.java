package com.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class SpringBootLibraryApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

	}

}
