package com.laura.videogameadmin.model;

public class Videogame {
	
	private Long id;
	private String title;
	private String name;
	private String year;
	private String protagonist;
	private String director;
	private String productor;
	private String technology;
	private String state;
	private String price;
	
	public Videogame() {}

	public Videogame(Long id, String title, String name, String year, String protagonist, String director,
			String productor, String technology, String state, String price) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.year = year;
		this.protagonist = protagonist;
		this.director = director;
		this.productor = productor;
		this.technology = technology;
		this.state = state;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getProtagonist() {
		return protagonist;
	}

	public void setProtagonist(String protagonist) {
		this.protagonist = protagonist;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProductor() {
		return productor;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Videogame [id=" + id + ", title=" + title + ", name=" + name + ", year=" + year + ", protagonist="
				+ protagonist + ", director=" + director + ", productor=" + productor + ", technology=" + technology
				+ ", state=" + state + ", price=" + price + "]";
	}
	

}
