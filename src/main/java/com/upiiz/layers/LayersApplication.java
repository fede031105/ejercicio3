package com.upiiz.layers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.upiiz.layers.categorias.entities")
@EnableJpaRepositories(basePackages = "com.upiiz.layers.categorias")
public class LayersApplication {

	public static void main(String[] args) {
		SpringApplication.run(LayersApplication.class, args);
	}
}