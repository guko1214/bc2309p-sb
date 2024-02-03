package com.vtxlab.bootcamp.bootcampbeanconfig.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampbeanconfig.model.Person;

@Service
public interface PersonService {
  
  List<Person> getPersons();

  Person getPerson(int idx);

  Person createPerson(Person person);

  Person deletePerson(int idx);

  Person updatePerson(int index, Person perosn);

  Person patchPersonName(int index, String name);

  Person patchPersonAge(int index, int age);
  



}
