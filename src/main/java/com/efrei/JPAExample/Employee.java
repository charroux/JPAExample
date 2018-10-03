package com.efrei.JPAExample;

import javax.persistence.Entity;

@Entity
public class Employee extends Person{

	private int salary;
	
	public Employee(long id, String name, int age) {
		super(id, name, age);
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
