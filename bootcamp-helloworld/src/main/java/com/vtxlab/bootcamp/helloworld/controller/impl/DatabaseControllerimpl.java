package com.vtxlab.bootcamp.helloworld.controller.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.helloworld.controller.DatabaseController;
import com.vtxlab.bootcamp.helloworld.service.DatabaseService;
import com.vtxlab.bootcamp.helloworld.service.impl.DatabaseServiceimpl;


@RestController // 
@RequestMapping(value = "/api/v1")
public class DatabaseControllerimpl implements DatabaseController {

  // JVM

  // Step 1 (before server start)
  // SpringContext, separate memory pool storing another set of objects
  // SpringContext create when server starts -> 
  // @RestController & @Service -> produce controller & service object

  @Autowired // 自動裝配 (server start)
  private DatabaseService databaseservice; // interface

  // Step 2 (before server start)
  // @Autowired will check if there is any object CAN be injected into DatabaseService in Database

  @Override
  public String getName(int index) {
    //return new DatabaseServiceimpl().getName(index);
    return databaseservice.getName(index);
  }

  @Override
  public String setName(int index, String name) {
    //DatabaseServiceimpl d = new DatabaseServiceimpl();
   //d.setName(index, name);
   String n = name == null ? "xxxx" : name;
   databaseservice.setName(index, n);
   //if (d.getName(index).equals(name)) {
   if (databaseservice.getName(index).equals(n)) {
     return "Update success, Database at " + index + " = " + name;
   } else {
    return "Update fail, " + "name=" + n + ", database name=" + databaseservice.getName(index);
   }
  }

  @Override
  public List<String> getNames(int fromIdx, int toIdx) {
    //String[] arr = databaseservice.getNames(fromIdx, toIdx);
    // List<String> arrList = new ArrayList<>();
    // for (String s : arr) {
    //   arrList.add(s);
    // }
    //return arrList;
    return Arrays.stream(databaseservice.getNames(fromIdx, toIdx)).collect(Collectors.toList());
  }

  @Override
  public String updateName(int index, String name) {
    //DatabaseServiceimpl d = new DatabaseServiceimpl();
   //d.setName(index, name);
   String n = name == null ? "xxxx" : name;
   databaseservice.setName(index, n);
   //if (d.getName(index).equals(name)) {
   if (databaseservice.getName(index).equals(n)) {
     return "Update success, Database at " + index + " = " + n;
   } else {
    return "Update fail, " + "name=" + n + ", database name=" + databaseservice.getName(index);
   }
  }

}