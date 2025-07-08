package Arthurp11.com.github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "arthurp11.com.github")
@EnableJpaRepositories(basePackages = "arthurp11.com.github.repositories")
@EntityScan(basePackages = "model") // <-- adicione isso
public class Startup {

	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
	}

}
