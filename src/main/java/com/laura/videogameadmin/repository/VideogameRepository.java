package com.laura.videogameadmin.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.laura.videogameadmin.model.Videogame;

@Repository
public class VideogameRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Videogame save(Videogame game) {
		
		String sql = " INSERT INTO GAME (DIRECTOR, NAME, PRICE, PRODUCTOR, PROTAGONIST, STATE, TECHNOLOGY, TITLE, YEAR) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		jdbcTemplate.update(sql, new Object[] { 
				game.getDirector(),
				game.getName(),
				game.getPrice(),
				game.getProductor(),
				game.getProtagonist(),
				"DISPONIBLE",
				game.getTechnology(),
				game.getTitle(),
				game.getYear()
				});
		return game;
	}
	
	public void update(Videogame game) {
		String sql = " UPDATE GAME SET DIRECTOR = ?, NAME =?, PRICE = ?, PRODUCTOR = ?, PROTAGONIST = ?, STATE = ?, TECHNOLOGY= ?, TITLE = ?, YEAR = ? "
				+ " WHERE ID = ? ";
		jdbcTemplate.update(sql, new Object[] { 
				game.getDirector(),
				game.getName(),
				game.getPrice(),
				game.getProductor(),
				game.getProtagonist(),
				game.getState(),
				game.getTechnology(),
				game.getTitle(),
				game.getYear(),
				game.getId()
				});
	}
	
	public void updateState(Long idVideogame, String state) {
		String sql = " UPDATE GAME SET STATE = ?"
				+ " WHERE ID = ? ";
		jdbcTemplate.update(sql, new Object[] { 
				state,
				idVideogame
				});
	}

	public List<Videogame> getVideogames() {
			String sql = "SELECT ID, DIRECTOR, NAME, PRICE, PRODUCTOR, PROTAGONIST, STATE, TECHNOLOGY, TITLE, YEAR FROM GAME";
			return jdbcTemplate.query(sql,
					(rs, rowNum) -> new Videogame(rs.getLong("ID"), 
			        		rs.getString("TITLE"),
			        		rs.getString("NAME"),
			        		rs.getString("YEAR"),
			        		rs.getString("PROTAGONIST"),
			        		rs.getString("DIRECTOR"),
			        		rs.getString("PRODUCTOR"),
			        		rs.getString("TECHNOLOGY"),
			        		rs.getString("STATE"),
			        		rs.getString("PRICE")
							));
	}

	public Videogame getVideogame(Long id) {
		String sql = "SELECT ID, DIRECTOR, NAME, PRICE, PRODUCTOR, PROTAGONIST, STATE, TECHNOLOGY, TITLE, YEAR FROM GAME WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
        new Videogame(
        		rs.getLong("ID"), 
        		rs.getString("TITLE"),
        		rs.getString("NAME"),
        		rs.getString("YEAR"),
        		rs.getString("PROTAGONIST"),
        		rs.getString("DIRECTOR"),
        		rs.getString("PRODUCTOR"),
        		rs.getString("TECHNOLOGY"),
        		rs.getString("STATE"),
        		rs.getString("PRICE")
				));
	}

	public List<Map<String, Object>> getGameFrequent() {
		String sql = " select count(loan.id_game) prestamos, game.name from games.loan loan, games.game game where loan.id_game = game.id group by id_game";
		return jdbcTemplate.queryForList(sql);
	}

	public List<Map<String, Object>> getGameByKeyword(String keyword) {
		String sql = " select title, name, year, protagonist, director, productor, technology, state, price from games.game  "
				+ " where lower(protagonist) = lower(?) or lower(director) = lower(?) or lower(productor) = lower(?)"; 
		return jdbcTemplate.queryForList(sql, new Object[] {keyword, keyword, keyword});
	}

}
