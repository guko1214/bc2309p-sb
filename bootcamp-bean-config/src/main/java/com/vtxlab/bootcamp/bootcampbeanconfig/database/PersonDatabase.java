package com.vtxlab.bootcamp.bootcampbeanconfig.database;

import java.util.ArrayList;
import java.util.List;
import com.vtxlab.bootcamp.bootcampbeanconfig.model.Person;

public class PersonDatabase {
  

  private static final List<Person> persons ;

  static {
    persons = new ArrayList<>();
    persons.add(new Person("John",9));
  }

  public static List<Person> getPersons() {
    return persons;
  }

  public static Person getPerson(int idx) {
    return persons.get(idx);
  }

  public static void setPerson(int idx, Person person) {
    persons.set(idx, person);
  }

}
