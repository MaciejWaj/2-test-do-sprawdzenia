package pl.kurs.test2rozszerzenie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.kurs.test2rozszerzenie.service.MathService;
import pl.kurs.test2rozszerzenie.service.Operation;

@SpringBootApplication
public class Test2RozszerzenieApplication {

    public static void main(String[] args) {
        SpringApplication.run(Test2RozszerzenieApplication.class, args);

        MathService mathService = new MathService();
        mathService.run();

    }
}
