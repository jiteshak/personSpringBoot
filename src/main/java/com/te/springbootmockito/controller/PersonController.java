package com.te.springbootmockito.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.springbootmockito.entity.dto.PersonDto;
import com.te.springbootmockito.response.GenralResponse;
import com.te.springbootmockito.service.PersonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class PersonController {
	
	public final PersonService personService;
	
	@GetMapping(path = "/person{personId}")
	public ResponseEntity<GenralResponse> getPerson(@PathVariable String personId) {
		PersonDto person = personService.getPerson(personId);
		return ResponseEntity.ok().body(new GenralResponse(HttpStatus.OK,null,"Data Provided",person));
	}
	
	@PostMapping(path = "/person")
	public ResponseEntity<GenralResponse> registerPerson(@RequestBody PersonDto personDto) {
		PersonDto savePerson = personService.savePerson(personDto);
		return ResponseEntity.ok().body(new GenralResponse(HttpStatus.OK,null,"Data updated",savePerson));
	}
	
	@PutMapping(path = "/person{personId}")
	public ResponseEntity<GenralResponse> updatePerson(@PathVariable String personId,@RequestBody PersonDto personDto) {
		PersonDto updatePerson = personService.updatePerson(personId, personDto);
		return ResponseEntity.ok().body(new GenralResponse(HttpStatus.OK,null,"Data updated",updatePerson));
	}
	
	
	@DeleteMapping(path = "/person{personId}")
	public ResponseEntity<GenralResponse> DeletePerson(@PathVariable String personId,@RequestBody PersonDto personDto) {
		boolean deletePerson = personService.deletePerson(personId);
		return ResponseEntity.ok().body(new GenralResponse(HttpStatus.OK,null,"Data updated",deletePerson));
	}
	

}
