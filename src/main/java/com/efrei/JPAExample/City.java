package com.efrei.JPAExample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class City {
	
	private List<Person> persons = new ArrayList<Person>();
	
	private long id;
	private String name;

	public City() {
		super();
	}

	public City(String name) {
		super();
		this.name = name;
	}

	@Id
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy="city", cascade=CascadeType.ALL)
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "City [persons=" + persons + ", id=" + id + ", name=" + name + "]";
	}
	
}
