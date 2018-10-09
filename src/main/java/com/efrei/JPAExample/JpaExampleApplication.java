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

	
	/*@Bean
	public CommandLineRunner demo(PersonRepository repository) {
		return (args) -> {
			
			repository.save(new Person(1, "Tintin", 20));
			repository.save(new Person(2, "Hadock", 50));

			log.info("Persons found with findAll():");
			log.info("-------------------------------");
			for (Person person : repository.findAll()) {
				log.info(person.toString());
			}
			log.info("");

			repository.findById(1L)
				.ifPresent(person -> {
					log.info("Person found with findById(1L):");
					log.info("--------------------------------");
					log.info(person.toString());
					log.info("");
				});

			log.info("Person found with findName('Tintin'):");
			log.info("--------------------------------------------");
			repository.findByName("Tintin").forEach(tintin -> {
				log.info(tintin.toString());
			});
			
		};
	}
*/}
