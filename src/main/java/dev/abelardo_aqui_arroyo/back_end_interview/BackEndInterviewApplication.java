package dev.abelardo_aqui_arroyo.back_end_interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ValidationAutoConfiguration.class)
public class BackEndInterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndInterviewApplication.class, args);
	}

}
