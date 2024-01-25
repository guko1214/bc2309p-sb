package com.vtxlab.bootcamp.helloworld.model;

public class Database {

  private static final int dbLength = 100;
  private static String[] strings = new String[dbLength]; 
  
  static {
    strings[0] = "Peter";
    strings[1] = "John";
  }

  public static void setString(int index, String string) {
    if (index < 0 || index > dbLength - 1)
      throw new IllegalArgumentException(); 
    strings[index] = string;
  }

  public static String getString(int index) {
    if (index < 0 || index > dbLength - 1)
      throw new IllegalArgumentException();
    return strings[index];
  }

  public static String[] getNames(int fromIdx, int toIdx) {
    if (fromIdx < 0 || fromIdx > dbLength - 1 || toIdx < 0
        || toIdx > dbLength - 1 || fromIdx > toIdx)
        throw new IllegalArgumentException();
    String[] arr = new String[toIdx - fromIdx + 1];
    // int pos = fromIdx;
    // for (int i = 0; i < toIdx +1; i++) {
    //   arr[i] = strings[pos++];
    // }
    int idx =0;
    for (int i = fromIdx; i < toIdx + 1; i++) {
      arr[idx++] = strings[i];
    }
    return arr;
  }
  
}
