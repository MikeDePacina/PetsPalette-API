package com.example.Pets.Palette;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;

@SpringBootApplication()
public class PetsPaletteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetsPaletteApplication.class, args);
	}

}
