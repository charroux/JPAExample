package com.efrei.JPAExample;

import javax.persistence.EntityManager;

public class Main {

	public static void main(String[] args) {
		EntityManager entityManager;
		
		Person tintin = new Person(1, "Tintin", 20);
		
		entityManager.persist(tintin);
		
		Person person = entityManager.find(Person.class, 1);
		
		entityManager.remove(tintin);
	}

}
