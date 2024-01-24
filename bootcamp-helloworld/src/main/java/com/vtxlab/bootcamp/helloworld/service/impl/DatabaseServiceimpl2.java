package com.vtxlab.bootcamp.helloworld.service.impl;

import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.helloworld.model.Database;
import com.vtxlab.bootcamp.helloworld.service.DatabaseService;

@Service
public class DatabaseServiceimpl2{
  
  public String getName(int index) {
    return Database.getString(index) + " DatabaseServiceimpl2";
  }

  public void setName(int index, String name) {
    Database.setString(index, name);
  }

}