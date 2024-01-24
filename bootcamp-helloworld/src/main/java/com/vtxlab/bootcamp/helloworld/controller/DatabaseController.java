package com.vtxlab.bootcamp.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


public interface DatabaseController {

  @GetMapping(value = "/db/idx/{idx}")
  String getName(@PathVariable(name = "idx") int index );

  @GetMapping(value = "db/idx/{idx}/name/{name}")
  //String setName(@PathVariable(name = "idx") int index, @PathVariable(name = "name") String name);
  String setName(@PathVariable(name = "idx") int index, @PathVariable String name); // if variable name in path same as those in method signature

}
