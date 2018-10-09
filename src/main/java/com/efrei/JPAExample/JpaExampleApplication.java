package com.efrei.JPAExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaExampleApplication {

	private static final Logger log = LoggerFactory.getLogger(JpaExampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaExampleApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CityRepository repository) {
		return (args) -> {
			
			City paris = new City("Paris");
			Person tintin = new Person(1, "Tintin", 20);
			paris.getPersons().add(tintin);
			tintin.setCity(paris);
			
			repository.save(paris);
			
			log.info("Cities found with findAll():");
			log.info("-------------------------------");
			for (City city : repository.findAll()) {
				log.info(city.toString());
			}
			log.info("");

			log.info("City found with findName('Paris'):");
			log.info("--------------------------------------------");
			repository.findByName("Paris").forEach(city -> {
				log.info(city.toString());
			});
			
		};
	}

}
