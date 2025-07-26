package com.curso_erudio.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso_erudio.course.model.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
