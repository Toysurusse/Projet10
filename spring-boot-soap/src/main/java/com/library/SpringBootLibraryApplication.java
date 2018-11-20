package com.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@SpringBootApplication
public class SpringBootLibraryApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootLibraryApplication .class);
	}

	@Override
	public void run(String... arg0) throws Exception {

	}

	@GetMapping("/hello")
	public Collection<String> sayHello() {
		return IntStream.range(0, 10)
				.mapToObj(i -> "Hello number " + i)
				.collect(Collectors.toList());
	}
}
