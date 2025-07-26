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

	private AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	private PersonRepository personRepo;

	public Person findById(Long Id) {
		logger.info("Finding Person one Person DataBase");
		Person existentPerson = personRepo.findById(Id)
								.orElseThrow(() -> new ResourceNotFoundException("RESOURCE NOT FOUND WITH THIS ID!"));
		return existentPerson;	
	}

	public List<Person> findAll() {
		logger.info("Finding Person one Person DataBase");
		
		var persons = personRepo.findAll();
		
		if(persons.isEmpty()) throw new ResourceNotFoundException("NOTHING FOUND IN THIS LITS BITCH");
		
		return persons;
	}

	

	public Person createPerson(Person newPerson) throws Exception {
		if (newPerson == null)
			throw new Exception("Pessoa está nula");
		return personRepo.save(newPerson);
	}

}
