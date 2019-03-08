package com.efrei.JPAExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestWebService {

	CityRepository cityRepository;

	@Autowired
	public RestWebService(CityRepository cityRepository) {
		super();
		this.cityRepository = cityRepository;
	}
	
	@GetMapping("/cities")
	public Iterable<City> getCities(){
		return cityRepository.findAll();
	}
	
	
}
