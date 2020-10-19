package com.laura.videogameadmin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laura.videogameadmin.model.Videogame;
import com.laura.videogameadmin.service.VideogameService;

@RestController
@CrossOrigin(origins="http://localhost:8100")
@RequestMapping(path = "/game")
public class VideogameController {
	
	@Autowired
	VideogameService videogameService;
	
	@PostMapping(path = "/save")
	public ResponseEntity<Videogame> save(@RequestBody Videogame game){
		videogameService.save(game);
		return new ResponseEntity<Videogame>(game, HttpStatus.OK);
	}
	
	@PutMapping(path = "/update")
	public ResponseEntity<Videogame> updateSong(@RequestBody Videogame game) {
		videogameService.update(game);
		return new ResponseEntity<Videogame>(game, HttpStatus.OK);
	}

	@GetMapping(path = "/getGameById/{id}")
	public Videogame getSongById(@PathVariable Long id) {
		return videogameService.getVideogameById(id); 
	}
	
	@GetMapping(path = "/getGames")
	public List<Videogame> getSongs() {
		return videogameService.getVideogames();
	}
	
	@GetMapping(path = "/getGameFrequent")
	public List<Map<String,Object>> getGameFrequent() {
		return videogameService.getGameFrequent();
	}
	
	@GetMapping(path = "/getGameByKeyword/{keyword}")
	public List<Map<String, Object>> getGameByKeyword(@PathVariable String keyword) {
		return videogameService.getGameByKeyword(keyword); 
	}
}
