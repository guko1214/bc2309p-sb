package com.vtxlab.bootcamp.helloworld.service;

public interface DatabaseService {
  String getName(int index);

  void setName(int index, String name);

  String[] getNames(int fromIdx, int toIdx);

  void updateName(int index, String name);

}


