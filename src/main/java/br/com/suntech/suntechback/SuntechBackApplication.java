package br.com.suntech.suntechback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"br.com.suntech"})
@EntityScan("br.com.suntech.domain")
@EnableJpaRepositories("br.com.suntech.domain.repository")
@EnableAutoConfiguration
public class SuntechBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuntechBackApplication.class, args);
	}
}
