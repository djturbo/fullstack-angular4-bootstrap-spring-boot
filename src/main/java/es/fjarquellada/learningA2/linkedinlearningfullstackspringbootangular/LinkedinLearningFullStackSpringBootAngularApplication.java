package es.fjarquellada.learningA2.linkedinlearningfullstackspringbootangular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class LinkedinLearningFullStackSpringBootAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkedinLearningFullStackSpringBootAngularApplication.class, args);
	}
}
