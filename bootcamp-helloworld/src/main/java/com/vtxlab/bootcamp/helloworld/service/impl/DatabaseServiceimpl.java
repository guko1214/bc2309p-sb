package com.vtxlab.bootcamp.helloworld.service.impl;

import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.helloworld.model.Database;
import com.vtxlab.bootcamp.helloworld.service.DatabaseService;

@Service
public class DatabaseServiceimpl implements DatabaseService {
  
  @Override
  public String getName(int index) {
    return Database.getString(index);// + " DatabaseServiceimpl";
  }

  @Override
  public void setName(int index, String name) {
    Database.setString(index, name);
  }

  @Override
  public String[] getNames(int fromIdx, int toIdx) {
    return Database.getNames(fromIdx, toIdx);
  };

  @Override
  public void updateName(int index, String name) {
    
    Database.setString(index, name);
  }

}
