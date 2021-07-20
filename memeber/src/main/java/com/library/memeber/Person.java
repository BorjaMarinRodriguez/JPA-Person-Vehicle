package com.library.memeber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



// creem la clase Person

@Entity  // Anotaciò de que es una entitat
@Table	// Anotaciò de que serà una taula

public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	private int age;
	private String location;
	private String email;
	
		
	// Constructors
	
	public Person() {
		super();
	}

	public Person(String name, String surname, int age, String location, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.location = location;
		this.email = email;
	}
	
	
	// Getters i Setters
	
	

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	// toString
	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", age=" + age + ", location=" + location + ", email="
				+ email + "]";
	}
	

}
