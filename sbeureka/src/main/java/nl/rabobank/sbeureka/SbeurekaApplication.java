package nl.rabobank.sbeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SbeurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbeurekaApplication.class, args);
	}
}
