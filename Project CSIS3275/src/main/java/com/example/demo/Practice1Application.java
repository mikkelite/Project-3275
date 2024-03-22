package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Practice1Application {

	public static void main(String[] args) {
		SpringApplication.run(Practice1Application.class, args);
	}
	//creating products on load
	@Bean
	ApplicationRunner init(ProductRepository productRepository) {
		List<String> reviews=new ArrayList<String>();
		reviews.add("Great stopping power, minimal noise.");
		reviews.add("Easy to install, noticeable improvement in braking.");
		List<String> reviews2 = new ArrayList<>(Arrays.asList("Great stopping power, minimal noise.","Easy to install, noticeable improvement in braking."));
		return ArgsAnnotationPointcut ->{
			productRepository.save(new product( 
				      "Brake Pads (Front)",
				      79.99,
				      15,
				      "Semi-metallic brake pads for quiet operation and excellent stopping power.",
				      4.8,
				      "Fits compatible car models",
				      reviews
				     ));
			productRepository.save(new product(
	                "Air Filter",
	                15.50,
	                40,
	                "High-quality air filter for improved engine performance and fuel efficiency.",
	                4.3,
	                "Fits  compatible car models",
	                reviews2)
						     );
		};
	}

}
