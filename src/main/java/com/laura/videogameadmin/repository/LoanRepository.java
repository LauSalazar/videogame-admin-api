package com.laura.videogameadmin.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laura.videogameadmin.model.Loan;

@Repository
public class LoanRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Loan save(Loan loan) {
		
		String sql = " INSERT INTO LOAN (END_DATE, ID_CUSTOMER, ID_GAME, START_DATE) "
				+ " VALUES (?, ?, ?, ?) ";
		jdbcTemplate.update(sql, new Object[] { 
				loan.getEndDate(),
				loan.getIdCustomer(),
				loan.getIdVideogame(),
				new Date()
				});
		return loan;
	}

	public List<Map<String, Object>> getTodaysLoans() {
		String sql = " select loan.id_customer, loan.id_game, loan.start_date, loan.end_date, game.name, game.year, game.state, "
				+ " cus.name customer, cus.identification, game.price "
				+ " from games.loan loan, games.game game, games.customer cus"
				+ " where loan.id_game = game.id and loan.id_customer = cus.id and date(loan.start_date) = curdate()";
		return jdbcTemplate.queryForList(sql);
	}

}
