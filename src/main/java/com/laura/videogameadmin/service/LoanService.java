package com.laura.videogameadmin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laura.videogameadmin.model.Loan;
import com.laura.videogameadmin.repository.LoanRepository;
import com.laura.videogameadmin.repository.VideogameRepository;

@Service
public class LoanService {

	@Autowired
	LoanRepository loanRepository;
	
	@Autowired
	VideogameRepository gameRepository;
	
	public Loan save(Loan loan) {
		loanRepository.save(loan);
		gameRepository.updateState(loan.getIdVideogame(), "PRESTADO");
		return loan;
	}

	public List<Map<String, Object>> getTodaysLoans() {
		return loanRepository.getTodaysLoans();
	}
}
