package com.vtxlab.bootcamp.bootcampsbcalculator.database;

import java.util.ArrayList;
import java.util.List;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Calculator;

public class CalculatorDatabase {

  private static final List<Calculator> calculators;

  static {
    calculators = new ArrayList<>();
  }

  public static List<Calculator> getCalculators() {
    return calculators;
  }

  public static Calculator getCalculator(int idx) {
    return calculators.get(idx);
  }

  public static void setCalculator(int idx, Calculator calculator) {
    calculators.set(idx, calculator);
  }
}
