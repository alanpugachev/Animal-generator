package com.alanpugachev.Animalgenerator;

import com.alanpugachev.Animalgenerator.models.Animal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnimalGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalGeneratorApplication.class, args);
		Animal a = new Animal();
	}

}
