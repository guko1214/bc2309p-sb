package com.vtxlab.bootcamp.bootcampbeanconfig;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bootcampbeanconfig.controller.impl.PersonController;
import com.vtxlab.bootcamp.bootcampbeanconfig.model.Person;
import com.vtxlab.bootcamp.bootcampbeanconfig.service.PersonService;

//@SpringBootTest // full set of beans
@WebMvcTest(PersonController.class) // inject all web layer related beans into this test env.  (Controller)
class PersonControllerTests { // intentional not to include "public" means not to 
  
  //@Autowired
  @MockBean
  PersonService personService;

  @Autowired // @WebMvc Test -> MockMvc() Spring->  Context
  private MockMvc mockMvc;

  @Test
  void testPostUser() throws Exception {
    Person person = new Person("Steven",3);
    Mockito.when(personService.createPerson(person)).thenReturn(person);

    String contentStr = new ObjectMapper().writeValueAsString(person);
    // Pretend Postman to make call
    //mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/person",null) //
    mockMvc.perform(post("/api/v1/person") //
        .contentType(MediaType.APPLICATION_JSON) //
        // .content("{"name" : "Steven","age" " 3}"))
        .content(contentStr))
        //.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)) // assert
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // assert
        .andExpect(jsonPath("$.name").value("Steven"))
        .andExpect(jsonPath("$.age").value(3))
        //.andDo(MockMvcResultHandlers.print());
        .andDo(print());
  }

  @Test
  void testGetUser() throws Exception {
    Person person = new Person("Sally",4);
    Mockito.when(personService.getPerson(0)).thenReturn(person);

    mockMvc.perform(get("/api/v1/person/{idx}",0))
    //.accept(MediaType.APPLICATION_JSON))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // assert
    .andExpect(jsonPath("$.name").value("Sally"))
    .andExpect(jsonPath("$.age").value(4))
    .andDo(print());
  }

  @Test
  void testDeleteUser() throws Exception {
    Person person = new Person("Jenny",10);
    Mockito.when(personService.deletePerson(2)).thenReturn(person);

    mockMvc.perform(delete("/api/v1/person/{idx}",2))
    //.accept(MediaType.APPLICATION_JSON))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // assert
    .andExpect(content().string("true"))
    .andDo(print());
  }


  //@Test
  void testUpdateUser() throws Exception {
    Person person = new Person("Tommy",20);
    Mockito.when(personService.updatePerson(5,person)).thenReturn(person);

    String contentStr = new ObjectMapper().writeValueAsString(person);
    // Pretend Postman to make call
    //mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/person",null) //
    mockMvc.perform(put("/api/v1/person/{idx}","5") //
        .contentType(MediaType.APPLICATION_JSON) //
        // .content("{"name" : "Steven","age" " 3}"))
        .content(contentStr))
        //.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)) // assert
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // assert
        .andExpect(jsonPath("$.name").value("Steven"))
        .andExpect(jsonPath("$.age").value(3))
        //.andDo(MockMvcResultHandlers.print());
        .andDo(print());
  }

}
