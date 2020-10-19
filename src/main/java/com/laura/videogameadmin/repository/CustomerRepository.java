package com.laura.videogameadmin.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laura.videogameadmin.model.Customer;

@Repository
public class CustomerRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Customer save(Customer customer) {
		
		String sql = " INSERT INTO CUSTOMER (BIRTH_DATE, NAME, IDENTIFICATION) "
				+ " VALUES (?, ?, ?) ";
		jdbcTemplate.update(sql, new Object[] { 
				customer.getBirthDate(),
				customer.getName(),
				customer.getIdentification()
				});
		return customer;
	}
	
	public List<Customer> getCustomers() {
		String sql = "SELECT ID, NAME, BIRTH_DATE, IDENTIFICATION FROM CUSTOMER";
		return jdbcTemplate.query(sql,
				(rs, rowNum) -> new Customer(
						rs.getLong("ID"),
						rs.getString("NAME"),
						rs.getDate("BIRTH_DATE"),
						rs.getLong("IDENTIFICATION")
						));
}

	public List<Map<String, Object>> getCustomersFrequent() {
		String sql = " select count(cus.id) prestamos, cus.name cliente from games.loan loan, games.customer cus where loan.id_customer = cus.id group by id_customer";
		return jdbcTemplate.queryForList(sql);
	}

	public List<Map<String, Object>> getLoansByCustomer(String identification) {
		String sql = " select game.name, loan.start_date inicio, loan.end_date fin, cus.name name_customer from games.customer cus, games.game game, games.loan loan "
				+ " where loan.id_customer = cus.id and loan.id_game = game.id and cus.identification = ? "; 
		return jdbcTemplate.queryForList(sql, new Object[] {identification});
	}

	public Customer getCustomerById(Long id) {
		String sql = "SELECT ID, NAME, BIRTH_DATE, IDENTIFICATION FROM CUSTOMER WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
        new Customer(
        		rs.getLong("ID"), 
        		rs.getString("NAME"),
        		rs.getDate("BIRTH_DATE"),
        		rs.getLong("IDENTIFICATION")
				));
	}
}
