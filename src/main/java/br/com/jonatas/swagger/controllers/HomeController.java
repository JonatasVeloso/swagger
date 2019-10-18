package br.com.jonatas.swagger.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping(path = "teste/")
	public ResponseEntity<String> teste() throws JsonProcessingException {
		try {
			System.out.println("Entrou!");
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString("Sucesso!"),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(e.getMessage()),
					HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		}
	}
	
	@GetMapping(path = "teste/{nome}")
	public ResponseEntity<String> nome(@PathVariable String nome) throws JsonProcessingException {
		try {
			System.out.println("Prazer " + nome);
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString("Foi um sucesso " + nome),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(e.getMessage()),
					HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		}
		
		
	}
	
}
