package com.laura.videogameadmin.model;

import java.util.Date;

public class Customer {
	
	private Long id;
	private String name;
	private Date birthDate;
	private Long identification;
	
	public Customer() {}

	public Customer(Long id, String name, Date birthDate, Long identification) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.identification = identification;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Long getIdentification() {
		return identification;
	}

	public void setIdentification(Long identification) {
		this.identification = identification;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", identification="
				+ identification + "]";
	}
	

}
