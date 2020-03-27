package com.efrei.JPAExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/cities")
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void addCity(@RequestBody City city) throws Exception {
		cityRepository.save(city);
		if(city.getName().equals("London")){
			throw new Exception();
		}
	}
	
	
}
