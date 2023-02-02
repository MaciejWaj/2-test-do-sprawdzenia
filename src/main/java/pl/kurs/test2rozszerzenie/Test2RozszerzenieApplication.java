package pl.kurs.test2rozszerzenie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.kurs.test2rozszerzenie.service.MathService;



@SpringBootApplication
@EnableJpaRepositories(basePackages = "pl.kurs.test2rozszerzenie.repository")
public class Test2RozszerzenieApplication {

    public static void main(String[] args) {
        SpringApplication.run(Test2RozszerzenieApplication.class, args);

        MathService mathService = new MathService();
        mathService.run();

    }
}
