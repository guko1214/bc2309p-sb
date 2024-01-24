package com.vtxlab.bootcamp.helloworld.service.impl;

import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.helloworld.model.Database;
import com.vtxlab.bootcamp.helloworld.service.DatabaseService;

@Service
public class DatabaseServiceimpl implements DatabaseService {
  
  public String getName(int index) {
    return Database.getString(index) + " DatabaseServiceimpl";
  }

  public void setName(int index, String name) {
    Database.setString(index, name);
  }

}
