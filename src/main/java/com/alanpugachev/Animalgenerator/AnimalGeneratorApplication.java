package com.alanpugachev.Animalgenerator;

import com.alanpugachev.Animalgenerator.controllers.Generator;
import com.alanpugachev.Animalgenerator.models.Animal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnimalGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalGeneratorApplication.class, args);

		Thread thread1 = new Thread(new Generator(2));
		Thread thread2 = new Thread(new Generator(5));

		thread1.start();
		thread2.start();
	}

}
