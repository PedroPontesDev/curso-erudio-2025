package com.curso_erudio.course.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso_erudio.course.exceptions.ResourceNotFoundException;
import com.curso_erudio.course.model.entity.Person;
import com.curso_erudio.course.repository.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	private PersonRepository personRepo;

	public Person findById(Long Id) {
		logger.info("Finding Persons");
		Person existentPerson = personRepo.findById(Id)
								.orElseThrow(() -> new ResourceNotFoundException("RESOURCE NOT FOUND WITH THIS ID!" + Id));
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
