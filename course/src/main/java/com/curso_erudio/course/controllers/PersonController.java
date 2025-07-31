package com.curso_erudio.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso_erudio.course.model.entity.Person;
import com.curso_erudio.course.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonServices personServices;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Person> findById(@PathVariable Long id) {
		Person finded = personServices.findById(id);
		return new ResponseEntity<>(finded, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll() {
		List<Person> persons = personServices.findAll();
		return new ResponseEntity<>(persons, HttpStatus.OK);
	}
	
	@PostMapping(path = "/create")
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		var newPerson = personServices.savePerson(person);
		return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/update")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
		var updated = personServices.update(person);
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}
	

	@DeleteMapping(path = "/delete/{id}" )
	public ResponseEntity<?> deletePerson(@PathVariable Long id) {
		personServices.delePerson(id);
		return ResponseEntity.noContent().build();
	}
	
}
