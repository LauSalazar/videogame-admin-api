package com.laura.videogameadmin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laura.videogameadmin.model.Loan;
import com.laura.videogameadmin.service.LoanService;

@RestController
@CrossOrigin(origins="http://localhost:8100")
@RequestMapping(path = "/loan")
public class LoanController {
	
	@Autowired
	LoanService loanService;
	
	@PostMapping(path = "/save")
	public ResponseEntity<Loan> save(@RequestBody Loan loan){
		loanService.save(loan);
		return new ResponseEntity<Loan>(loan, HttpStatus.OK);
	}
	
	@GetMapping(path = "/getTodaysLoans")
	public List<Map<String,Object>> getTodaysLoans() {
		return loanService.getTodaysLoans();
	}

}
