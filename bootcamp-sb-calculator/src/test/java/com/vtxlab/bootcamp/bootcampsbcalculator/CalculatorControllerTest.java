package com.vtxlab.bootcamp.bootcampsbcalculator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.vtxlab.bootcamp.bootcampsbcalculator.controller.impl.CalculatorController;
import com.vtxlab.bootcamp.bootcampsbcalculator.dto.CalculatorDTO;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.Operation;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Calculator;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculatorService;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {
  
  @MockBean
  CalculatorService calculatorService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void testCal1() throws Exception {
    Calculator calculator = new Calculator("3","2",Operation.ADD);
    Mockito.when(calculatorService.cal("3","2","ADD")).thenReturn(calculator);

    mockMvc.perform(get("/api/v1?x={x}&y={y}&operation={op}","3","2","ADD"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("add"))
    .andExpect(jsonPath("$.result").value("5.0"))
    .andDo(print());

    Calculator calculator2 = new Calculator("3.2","2.4",Operation.ADD);
    Mockito.when(calculatorService.cal("3.2","2.4","ADD")).thenReturn(calculator2);

    mockMvc.perform(get("/api/v1?x={x}&y={y}&operation={op}","3.2","2.4","ADD"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.2"))
    .andExpect(jsonPath("$.y").value("2.4"))
    .andExpect(jsonPath("$.operation").value("add"))
    .andExpect(jsonPath("$.result").value("5.6"))
    .andDo(print());

    Calculator calculator3 = new Calculator("3","2",Operation.SUB);
    Mockito.when(calculatorService.cal("3","2","SUB")).thenReturn(calculator3);

    mockMvc.perform(get("/api/v1?x={x}&y={y}&operation={op}","3","2","SUB"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("sub"))
    .andExpect(jsonPath("$.result").value("1.0"))
    .andDo(print());


    Calculator calculator4 = new Calculator("3.2","2.4",Operation.SUB);
    Mockito.when(calculatorService.cal("3.2","2.4","SUB")).thenReturn(calculator4);

    mockMvc.perform(get("/api/v1?x={x}&y={y}&operation={op}","3.2","2.4","SUB"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.2"))
    .andExpect(jsonPath("$.y").value("2.4"))
    .andExpect(jsonPath("$.operation").value("sub"))
    .andExpect(jsonPath("$.result").value("0.8"))
    .andDo(print());

    Calculator calculator5 = new Calculator("3","2",Operation.MUL);
    Mockito.when(calculatorService.cal("3","2","MUL")).thenReturn(calculator5);

    mockMvc.perform(get("/api/v1?x={x}&y={y}&operation={op}","3","2","MUL"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("mul"))
    .andExpect(jsonPath("$.result").value("6.00"))
    .andDo(print());


    Calculator calculator6 = new Calculator("3.2","2.4",Operation.MUL);
    Mockito.when(calculatorService.cal("3.2","2.4","MUL")).thenReturn(calculator6);

    mockMvc.perform(get("/api/v1?x={x}&y={y}&operation={op}","3.2","2.4","MUL"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.2"))
    .andExpect(jsonPath("$.y").value("2.4"))
    .andExpect(jsonPath("$.operation").value("mul"))
    .andExpect(jsonPath("$.result").value("7.68"))
    .andDo(print());

    Calculator calculator7 = new Calculator("3","2",Operation.DIV);
    Mockito.when(calculatorService.cal("3","2","DIV")).thenReturn(calculator7);

    mockMvc.perform(get("/api/v1?x={x}&y={y}&operation={op}","3","2","DIV"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("div"))
    .andExpect(jsonPath("$.result").value("1.50000"))
    .andDo(print());


    Calculator calculator8 = new Calculator("3.2","2.4",Operation.DIV);
    Mockito.when(calculatorService.cal("3.2","2.4","DIV")).thenReturn(calculator8);

    mockMvc.perform(get("/api/v1?x={x}&y={y}&operation={op}","3.2","2.4","DIV"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.2"))
    .andExpect(jsonPath("$.y").value("2.4"))
    .andExpect(jsonPath("$.operation").value("div"))
    .andExpect(jsonPath("$.result").value("1.33333"))
    .andDo(print());    

  }

  @Test
  void testStore() throws Exception {
    Calculator calculator = new Calculator("3","2",Operation.ADD);
    Mockito.when(calculatorService.cal("3","2","ADD")).thenReturn(calculator);

    
  }


  @Test
  void testCal2() throws Exception {
    Calculator calculator = new Calculator("3","2",Operation.ADD);
    Mockito.when(calculatorService.cal("3","2","ADD")).thenReturn(calculator);

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}","3","2","ADD"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("add"))
    .andExpect(jsonPath("$.result").value("5.0"))
    .andDo(print());

    Calculator calculator2 = new Calculator("3.2","2.4",Operation.ADD);
    Mockito.when(calculatorService.cal("3.2","2.4","ADD")).thenReturn(calculator2);

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}","3.2","2.4","ADD"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.2"))
    .andExpect(jsonPath("$.y").value("2.4"))
    .andExpect(jsonPath("$.operation").value("add"))
    .andExpect(jsonPath("$.result").value("5.6"))
    .andDo(print());

    Calculator calculator3 = new Calculator("3","2",Operation.SUB);
    Mockito.when(calculatorService.cal("3","2","SUB")).thenReturn(calculator3);

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}","3","2","SUB"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("sub"))
    .andExpect(jsonPath("$.result").value("1.0"))
    .andDo(print());


    Calculator calculator4 = new Calculator("3.2","2.4",Operation.SUB);
    Mockito.when(calculatorService.cal("3.2","2.4","SUB")).thenReturn(calculator4);

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}","3.2","2.4","SUB"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.2"))
    .andExpect(jsonPath("$.y").value("2.4"))
    .andExpect(jsonPath("$.operation").value("sub"))
    .andExpect(jsonPath("$.result").value("0.8"))
    .andDo(print());

    Calculator calculator5 = new Calculator("3","2",Operation.MUL);
    Mockito.when(calculatorService.cal("3","2","MUL")).thenReturn(calculator5);

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}","3","2","MUL"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("mul"))
    .andExpect(jsonPath("$.result").value("6.00"))
    .andDo(print());


    Calculator calculator6 = new Calculator("3.2","2.4",Operation.MUL);
    Mockito.when(calculatorService.cal("3.2","2.4","MUL")).thenReturn(calculator6);

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}","3.2","2.4","MUL"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.2"))
    .andExpect(jsonPath("$.y").value("2.4"))
    .andExpect(jsonPath("$.operation").value("mul"))
    .andExpect(jsonPath("$.result").value("7.68"))
    .andDo(print());

    Calculator calculator7 = new Calculator("3","2",Operation.DIV);
    Mockito.when(calculatorService.cal("3","2","DIV")).thenReturn(calculator7);

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}","3","2","DIV"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("div"))
    .andExpect(jsonPath("$.result").value("1.50000"))
    .andDo(print());


    Calculator calculator8 = new Calculator("3.2","2.4",Operation.DIV);
    Mockito.when(calculatorService.cal("3.2","2.4","DIV")).thenReturn(calculator8);

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}","3.2","2.4","DIV"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.2"))
    .andExpect(jsonPath("$.y").value("2.4"))
    .andExpect(jsonPath("$.operation").value("div"))
    .andExpect(jsonPath("$.result").value("1.33333"))
    .andDo(print());    

  }

  
}
