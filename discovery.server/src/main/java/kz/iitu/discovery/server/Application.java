package kz.iitu.discovery.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaSer
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
