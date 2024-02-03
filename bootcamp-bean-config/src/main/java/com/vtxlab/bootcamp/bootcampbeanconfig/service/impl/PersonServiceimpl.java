package com.vtxlab.bootcamp.bootcampbeanconfig.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampbeanconfig.database.PersonDatabase;
import com.vtxlab.bootcamp.bootcampbeanconfig.model.Person;
import com.vtxlab.bootcamp.bootcampbeanconfig.service.PersonService;

@Service
public class PersonServiceimpl implements PersonService {
  
  @Override
  public List<Person> getPersons() {
    return PersonDatabase.getPersons();
  };

  @Override
  public Person getPerson(int idx) {
    return PersonDatabase.getPerson(idx);
  };

  @Override
  public Person createPerson(Person person) {
    if (PersonDatabase.getPersons().add(person)) 
      return person;
    return null;
  };

  @Override
  public Person deletePerson(int idx) {
    List<Person> ps = PersonDatabase.getPersons();
    return ps.remove(idx);
  };

  @Override
  public Person updatePerson(int index, Person person){
    return PersonDatabase.getPersons().set(index, person);
  };

  @Override
  public Person patchPersonName(int index, String name) {
    Person person = getPerson(index);
    if (person != null) {
      person.setName(name);
      return person;
    }
    return null;
  };

  @Override
  public Person patchPersonAge(int index, int age) {
    Person person = getPerson(index);
    if (person != null) {
      person.setAge(age);
      return person;
    }
    return null;
  }

}
