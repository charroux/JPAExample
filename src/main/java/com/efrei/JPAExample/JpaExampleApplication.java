package com.efrei.JPAExample;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class JpaExampleApplication {

	private static final Logger log = LoggerFactory.getLogger(JpaExampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaExampleApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CityRepository repository) {
		return (args) -> {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dateFormat.parse("2018-10-09");
			log.info(date.toString());
			
			City paris = new City("Paris");
			Person tintin = new Person("Tintin", 20);
			paris.getPersons().add(tintin);
			tintin.setCity(paris);
			
			repository.save(paris);

			log.info("-------------------------------");
			log.info("Cities found with findAll():");
			for (City city : repository.findAll()) {
				log.info(city.toString());
			}
			log.info("");

			log.info("-------------------------------");
			log.info("Persons associted with a city");
			Iterable<City> cities = repository.findAll();
			City c = cities.iterator().next();

			List<Person> persons = c.getPersons();
			log.info(persons.toString());

			log.info("--------------------------------------------");
			log.info("City found with findName('Paris'):");
			repository.findByName("Paris").forEach(city -> {
				log.info(city.toString());
			});

		};
	}

}
