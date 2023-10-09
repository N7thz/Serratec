package br.com.serratec.lojinha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
// informações basicas da api
@OpenAPIDefinition(info = @Info(title = "Lojinha OpenApi", version = "1.0", description = "API de uma lojinha"))
public class LojinhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojinhaApplication.class, args);
	}

}
