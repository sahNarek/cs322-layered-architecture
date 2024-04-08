package banking;

import common.ServiceOrientedApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.util.Collections;


@SpringBootApplication(scanBasePackages = {"banking"})
@Import(ServiceOrientedApplication.class)
public class BankingApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BankingApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "3000"));
        app.run(args);
    }
}