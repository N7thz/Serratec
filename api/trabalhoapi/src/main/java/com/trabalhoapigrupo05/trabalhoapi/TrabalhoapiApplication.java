package com.trabalhoapigrupo05.trabalhoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger OpenApi", version = "1", description = "API desenvolvida para o trabalho de API Rest - Grupo 05"))
public class TrabalhoapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabalhoapiApplication.class, args);
	}

}
