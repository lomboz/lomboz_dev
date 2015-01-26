package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setShowBanner(false);
		ConfigurableApplicationContext context = app.run(args);
		UserRepository repo = context.getBean(UserRepository.class);
		repo.save(new User("Hans", "Schneider"));
		repo.save(new User("Sabine", "Schneider"));
				
	}
}
