package com.laura.videogameadmin.model;

import java.util.Date;

public class Loan {
	
	private Long id;
	private Long idCustomer;
	private Long idVideogame;
	private Date startDate;
	private Date endDate;
	
	public Loan() {}

	public Loan(Long id, Long idCustomer, Long idVideogame, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.idCustomer = idCustomer;
		this.idVideogame = idVideogame;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Long getIdVideogame() {
		return idVideogame;
	}

	public void setIdVideogame(Long idVideogame) {
		this.idVideogame = idVideogame;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", idCustomer=" + idCustomer + ", idVideogame=" + idVideogame + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
	
	

}
