
package com.vtxlab.bootcamp.bootcampsbcalculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.Operation;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Calculator;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


@WebMvcTest(Calculator.class)
public class CalculatorTest {

  @Test
  void testCal() throws Exception {

    Calculator calculator = new Calculator();
    
    assertThat(calculator.cal("2","3",Operation.ADD), is("5.0"));
    assertThat(calculator.cal("2.3","3.8",Operation.ADD), is("6.1"));
    assertThat(calculator.cal("3","2",Operation.SUB), is("1.0"));
    assertThat(calculator.cal("3.8","2.5",Operation.SUB), is("1.3"));
    assertThat(calculator.cal("2","3",Operation.SUB), is("-1.0"));
    assertThat(calculator.cal("2.3","3.8",Operation.SUB), is("-1.5"));
    assertThat(calculator.cal("3","2",Operation.MUL), is("6.00"));
    assertThat(calculator.cal("3.8","2.5",Operation.MUL), is("9.50"));
    assertThat(calculator.cal("3","2",Operation.DIV), is("1.50000"));
    assertThat(calculator.cal("3.8","2.5",Operation.DIV), is("1.52000"));

  }
}
