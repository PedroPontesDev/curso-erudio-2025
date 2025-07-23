package com.curso_erudio.course.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.curso_erudio.course.model.entity.Person;

@Service
public class PersonServices {

	private AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public Person findById(String Id) {
		logger.info("Finding one person");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Pedro");
		person.setLastName("Henrique");
		person.setGender("Male");
		person.setAddres("Sepetiba - Rio de Janeiro");
		return person;
	}

	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	public Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Firstname" + i);
		person.setLastName("Lastname" + i);
		person.setGender("Male");
		person.setAddres("Rio de Janeiro");
		return person;
	}
	
	public Person createPerson(Person newPerson) throws Exception {
		if(newPerson == null ) throw new Exception("Pessoa está nula");
		return newPerson;
	}
	
	

}
