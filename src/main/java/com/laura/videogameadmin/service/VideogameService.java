package com.laura.videogameadmin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laura.videogameadmin.model.Videogame;
import com.laura.videogameadmin.repository.VideogameRepository;

@Service
public class VideogameService {
	
	@Autowired
	VideogameRepository videogameRepository;
	
	public Videogame save(Videogame game) {
		return videogameRepository.save(game);
	}
	
	public void update(Videogame game) {
		videogameRepository.update(game);
	}
	
	public void updateState(Long idVideogame, String state) {
		videogameRepository.updateState(idVideogame, state);
	}
	
	public List<Videogame> getVideogames(){
		return videogameRepository.getVideogames();
	}
	
	public Videogame getVideogameById(Long id) {
		return videogameRepository.getVideogame(id);
	}

	public List<Map<String, Object>> getGameFrequent() {
		return videogameRepository.getGameFrequent();
	}

	public List<Map<String, Object>> getGameByKeyword(String keyword) {
		return videogameRepository.getGameByKeyword(keyword);
	}

}
