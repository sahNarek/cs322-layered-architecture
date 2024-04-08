package am.cs322;

import org.springframework.context.annotation.Import;
import java.util.Collections;
import common.ServiceOrientedApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "am.cs322")
@Import(ServiceOrientedApplication.class)
public class Cs322HomeworkApplication {

    public static void main(String[] args) {
//        SpringApplication.run(Cs322HomeworkApplication.class, args);
        SpringApplication app = new SpringApplication(Cs322HomeworkApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "3001"));
        app.run(args);
    }
}
