package com.curso_erudio.course.controllers;

import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso_erudio.course.model.entity.Person;
import com.curso_erudio.course.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonServices personServices;
	
	@RequestMapping(path = "/{id}", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> findById(@PathVariable Long id) {
		Person finded = personServices.findById(id);
		return new ResponseEntity<>(finded, HttpStatus.OK);
	}

}
