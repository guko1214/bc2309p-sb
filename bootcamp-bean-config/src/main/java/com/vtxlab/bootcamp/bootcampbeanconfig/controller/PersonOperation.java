package com.vtxlab.bootcamp.bootcampbeanconfig.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PatchExchange;
import com.vtxlab.bootcamp.bootcampbeanconfig.model.Person;

public interface PersonOperation {
  
  @GetMapping(value = "/persons")
  List<Person> getPersons();

  @GetMapping(value = "/person/{idx}")
  Person getPerson(@PathVariable(name = "idx")int idx);


  @PostMapping(value = "/person")
  Person createPerson(@RequestBody Person person);

  @DeleteMapping(value = "/person/{idx}")
  Boolean deletePerson(@PathVariable(name = "idx") int idx);

  @PutMapping(value = "/person/{idx}")
  Person updatePerson(@PathVariable int idx, @RequestBody Person person);

  @PatchMapping(value = "/person/{idx}/name/{name}")
  Person patchPersonName(@PathVariable int idx, @PathVariable String name);

  @PatchMapping(value = "/person/{idx}/age/{age}")
  Person patchPersonAge(@PathVariable int idx, @PathVariable int age);

}
