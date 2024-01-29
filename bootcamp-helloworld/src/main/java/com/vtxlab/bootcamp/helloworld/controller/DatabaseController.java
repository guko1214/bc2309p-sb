package com.vtxlab.bootcamp.helloworld.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


public interface DatabaseController {

  // Notes:
  // 1. RequestParm & PathVariable to support Controller input params
  // 2. property: required, defaultValue
  // 3. URI has to be unique (including the Path variable)

  @GetMapping(value = {"/db/idx/{idx}","/db/idx"})
  String getName(@PathVariable(name = "idx") int index );

  @GetMapping(value = {"db/idx/{idx}/name/{name}","db/idx/{idx}/name"})
  //String setName(@PathVariable(name = "idx") int index, @PathVariable(name = "name") String name);
  //String setName(@PathVariable(name = "idx") int index, @PathVariable String name); // if variable name in path same as those in method signature
  String setName(
        @PathVariable(name = "idx") int index, //
        @PathVariable(name = "name", required = false) String name); // if variable name in path same as those in method signature

  //@GetMapping(value = "/db/fromIdx/{fromIdx}/toIdx/{toIdx}")
  // /api/v1/db/names?fromIdx=?toidx=?
  @GetMapping(value = "/db/names")
  List<String> getNames(
      @RequestParam(value= "fromidx",required = false,
      defaultValue = "0") int formIndex, //
      //@RequestParam(value = "toidx") int toIndex);
      @RequestParam(value = "toidx", required = false,
      defaultValue = "10") int toIndex);


  // db/update/idx/2?name=Mary
  @GetMapping(value = {"db/udpate/idx/{idx}"})
  String updateName(@PathVariable(name = "idx") int index, //
      @RequestParam(value = "name")String name);


}
