package br.com.buscadevapi;

import br.com.buscadevapi.model.Project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuscaDevApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuscaDevApiApplication.class, args);
		Project project = Project.builder().build();

		Project p = Project.builder()


				.build();

		project.withTitle("Teste");

	}

}
