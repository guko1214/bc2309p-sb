package com.vtxlab.bootcamp.bootcampsbcalculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.Operation;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Calculator;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculatorService;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.impl.CalculatorServiceimpl;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

//@WebMvcTest(CalculatorServiceimpl.class)
@ExtendWith(MockitoExtension.class)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestInstance(TestInstance.Lifecycle.PER_METHOD) 
public class CalculatorServiceimplTest {

  @InjectMocks
  private CalculatorServiceimpl calculatorServiceimpl;

  //@Mock
  @Spy
  private Calculator calculator;

  // @BeforeEach
  // void init() {
  //   MockitoAnnotations.openMocks(this);
  // }

  @Test
  void testCal() throws Exception {

    //CalculatorServiceimpl calculatorServiceimpl = new CalculatorServiceimpl();
    calculatorServiceimpl.calculator = calculator;

    when(calculator.cal("2","3",Operation.ADD)).thenReturn("6.0");
    when(calculator.cal("2","3",Operation.SUB)).thenReturn("5.0"); 
    when(calculator.cal("2","3",Operation.MUL)).thenReturn("5.0");
    when(calculator.cal("2","3",Operation.DIV)).thenReturn("5.0");

    assertThat(calculatorServiceimpl.cal("2","3","ADD"), is("6.0"));    
    assertThat(calculatorServiceimpl.cal("2","3","SUB"), is("5.0"));
    assertThat(calculatorServiceimpl.cal("2","3","MUL"), is("5.0"));
    assertThat(calculatorServiceimpl.cal("2","3","DIV"), is("5.0"));

  }

  @Test
  void testGetCalculator() throws Exception {

    //CalculatorServiceimpl calculatorServiceimpl = new CalculatorServiceimpl();
    //Calculator c = Calculator.builder().x("2.0").y("3.0").operation("Add").build();
    Calculator c = new Calculator("2.0","3.0","ADD");
    //assertThat(calculatorServiceimpl.getCalculator("2.0", "3.0", "ADD").hashCode() == (c.hashCode()),is(true));
    // assertThat(calculatorServiceimpl.getCalculator("2.0", "3.0", "ADD").equals(c),is(true));
    // assertEquals(calculatorServiceimpl.getCalculator("2.0", "3.0", "ADD"),c);
    assertThat(calculatorServiceimpl.getCalculator("2.0", "3.0", "ADD").toString(),is(c.toString()));
    Calculator c2 = Calculator.builder().x("2.3").y("3.8").operation("ADD").build();   
    assertThat(calculatorServiceimpl.getCalculator("2.3", "3.8", "ADD").toString(),is(c2.toString()));
    Calculator c3 = Calculator.builder().x("2.0").y("3.0").operation("SUB").build();    
    assertThat(calculatorServiceimpl.getCalculator("2.0", "3.0", "SUB").toString(),is(c3.toString()));
    Calculator c4 = Calculator.builder().x("2.3").y("3.8").operation("SUB").build();
    assertThat(calculatorServiceimpl.getCalculator("2.3", "3.8", "SUB").toString(),is(c4.toString()));
  }

  @Test
  void testStore() throws Exception {

    CalculatorServiceimpl calculatorServiceimpl3 = new CalculatorServiceimpl();
    Calculator c = Calculator.builder().x("2.0").y("3.0").operation("ADD").build();
    assertThat(calculatorServiceimpl3.store(c).toString(),equalTo(c.toString()));
    Calculator c2 = Calculator.builder().x("2.3").y("3.8").operation("ADD").build();   
    assertThat(calculatorServiceimpl3.store(c2).toString(),is(c2.toString()));
    Calculator c3 = Calculator.builder().x("2.0").y("3.0").operation("SUB").build();    
    assertThat(calculatorServiceimpl3.store(c3).toString(),is(c3.toString()));
    Calculator c4 = Calculator.builder().x("2.3").y("3.8").operation("SUB").build();
    assertThat(calculatorServiceimpl3.store(c4).toString(),is(c4.toString()));
  }
}
