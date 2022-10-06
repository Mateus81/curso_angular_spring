package clientes.src.main.java.io.github.mateus81.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableJpaRepositories
@SpringBootApplication
public class ClientesApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

}
