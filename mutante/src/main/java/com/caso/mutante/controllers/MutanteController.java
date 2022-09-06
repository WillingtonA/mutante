package com.caso.mutante.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.caso.mutante.dto.MutantDTO;
import com.caso.mutante.services.MutanteService;

@RestController
@RequestMapping("/mutant")
public class MutanteController {
	@Autowired
	private MutanteService mutante;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> mutant(@RequestBody MutantDTO dna) {
		return new ResponseEntity<>(mutante.mutant(dna), HttpStatus.OK); 
	}
}
