package com.library.memeber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



// creem la clase Person

@Entity  // Anotaciò de que es una entitat
@Table	// Anotaciò de que serà una taula
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String type;
	private String type2;
	private String value;
	private boolean insured;
	
	
	//Constructors
	public Vehicle(String name, String type, String type2, String value, boolean insured) {
		super();
		this.name = name;
		this.type = type;
		this.type2 = type2;
		this.value = value;
		this.insured = insured;
	}


	public Vehicle() {
		super();
	}


	// Getters i Setters
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getType2() {
		return type2;
	}


	public void setType2(String type2) {
		this.type2 = type2;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public boolean isInsured() {
		return insured;
	}


	public void setInsured(boolean insured) {
		this.insured = insured;
	}


	// toString
	
	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", type=" + type + ", type2=" + type2 + ", value=" + value + ", insured="
				+ insured + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
