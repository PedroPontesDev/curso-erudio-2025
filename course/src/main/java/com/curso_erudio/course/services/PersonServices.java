package com.curso_erudio.course.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso_erudio.course.controllers.TestLogController;
import com.curso_erudio.course.exceptions.ResourceNotFoundException;
import com.curso_erudio.course.model.entity.Person;
import com.curso_erudio.course.repository.PersonRepository;

import com.curso_erudio.course.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Service
public class PersonServices {

	private Logger logger = LoggerFactory.getLogger(PersonServices.class);

	
	@Autowired
	private PersonRepository personRepo;

	public Person findById(Long Id) {
		logger.debug("Finding Persons");
		Person existentPerson = personRepo.findById(Id)
								.orElseThrow(() -> {
									logger.error("Pessoa não encontrada");
									return new ResourceNotFoundException("RESOURCE NOT FOUND WITH THIS ID!");
									});
		return existentPerson;	
	}

	public List<Person> findAll() {
		logger.info("Finding Person one Person DataBase");
		
		var persons = personRepo.findAll();
		
		if(persons.isEmpty()) throw new ResourceNotFoundException("RESOURCES NOT FOUND");
		
		return persons;
	}

	public Person savePerson(Person newPerson) {
		logger.info("Saving new Person");
		if(newPerson != null) {
			return personRepo.save(newPerson);
		} throw new ResourceNotFoundException("Its not possible save this person in database");
	}
	
	public void delePerson(Long id) {
		logger.info("Deleting Person");
		Person existent = personRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found for this ID"));
		personRepo.delete(existent);
		
	}

	public Person update(Person person) {
		  logger.info("Updating one Person!");
	      Person entity = personRepo.findById(person.getId())
	                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	      entity.setAddres(person.getAddres());
	      entity.setFirstName(person.getFirstName());
	      entity.setLastName(person.getLastName());
	      entity.setGender(person.getGender());
	      personRepo.save(entity);
	      return entity;
	}

}
