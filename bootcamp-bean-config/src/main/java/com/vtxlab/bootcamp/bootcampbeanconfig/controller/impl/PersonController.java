package com.vtxlab.bootcamp.bootcampbeanconfig.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampbeanconfig.controller.PersonOperation;
import com.vtxlab.bootcamp.bootcampbeanconfig.model.Person;
import com.vtxlab.bootcamp.bootcampbeanconfig.service.PersonService;
import com.vtxlab.bootcamp.bootcampbeanconfig.service.impl.PersonServiceimpl;


@RestController
@RequestMapping("/api/v1")
public class PersonController implements PersonOperation {
  
  @Autowired // 自動裝配 (server start)
  private PersonService personservice; // interface

  @Override
  public List<Person> getPersons() {
    return personservice.getPersons();
  }

  @Override
  public Person getPerson(int idx){
      return personservice.getPerson(idx); 
  }


  @Override
  public Person createPerson(Person person) {
    return personservice.createPerson(person);
    
  }

  @Override
  public Boolean deletePerson(int idx) {
    try {
      return personservice.deletePerson(idx) != null;
    } catch (IndexOutOfBoundsException e) {
      return false;
    }
  }

  public Person updatePerson(int idx, Person person) {
    return personservice.updatePerson(idx, person);
  };

  public Person patchPersonName(int idx, String name){
    return personservice.patchPersonName(idx, name);
  };


  public Person patchPersonAge(int idx, int age) {
    return personservice.patchPersonAge(idx, age);
  };


}
