package com.vtxlab.bootcamp.bootcampsbcalculator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.vtxlab.bootcamp.bootcampsbcalculator.controller.impl.CalculatorController;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.Operation;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Calculator;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.CalculatorRecord;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculatorService;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {
  
  @MockBean
  CalculatorService calculatorService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void testCal1() throws Exception {
    Calculator calculator = new Calculator("3","2",Operation.ADD.getName());
    Mockito.when(calculatorService.getCalculator("3","2","ADD")).thenReturn(calculator);
    Mockito.when(calculatorService.cal("3","2","ADD")).thenReturn("6.0");    

    mockMvc.perform(get("/api/v1?x={x}&y={y}&operation={op}","3","2","ADD"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("add"))
    .andExpect(jsonPath("$.result").value("6.0"))
    .andDo(print());

    Calculator calculator2 = new Calculator("3.2","2.4",Operation.ADD.getName());
    Mockito.when(calculatorService.getCalculator("3.2","2.4","ADD")).thenReturn(calculator2);
    Mockito.when(calculatorService.cal("3.2","2.4","ADD")).thenReturn("5.6");
    
    mockMvc.perform(get("/api/v1?x={x}&y={y}&operation={op}","3.2","2.4","ADD"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.2"))
    .andExpect(jsonPath("$.y").value("2.4"))
    .andExpect(jsonPath("$.operation").value("add"))
    .andExpect(jsonPath("$.result").value("5.6"))
    .andDo(print());

    Calculator calculator3 = new Calculator("3","2",Operation.SUB.getName());
    Mockito.when(calculatorService.getCalculator("3","2","SUB")).thenReturn(calculator3);
    Mockito.when(calculatorService.cal("3","2","SUB")).thenReturn("1.0");
    
    mockMvc.perform(get("/api/v1?x={x}&y={y}&operation={op}","3","2","SUB"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("sub"))
    .andExpect(jsonPath("$.result").value("1.0"))
    .andDo(print());


    Calculator calculator4 = new Calculator("3.2","2.4",Operation.SUB.getName());
    Mockito.when(calculatorService.getCalculator("3.2","2.4","SUB")).thenReturn(calculator4);
    Mockito.when(calculatorService.cal("3.2","2.4","SUB")).thenReturn("0.8");

    mockMvc.perform(get("/api/v1?x={x}&y={y}&operation={op}","3.2","2.4","SUB"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.2"))
    .andExpect(jsonPath("$.y").value("2.4"))
    .andExpect(jsonPath("$.operation").value("sub"))
    .andExpect(jsonPath("$.result").value("0.8"))
    .andDo(print());

    Calculator calculator5 = new Calculator("3","2",Operation.MUL.getName());
    Mockito.when(calculatorService.getCalculator("3","2","MUL")).thenReturn(calculator5);
    Mockito.when(calculatorService.cal("3","2","MUL")).thenReturn("6.00");

    mockMvc.perform(get("/api/v1?x={x}&y={y}&operation={op}","3","2","MUL"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("mul"))
    .andExpect(jsonPath("$.result").value("6.00"))
    .andDo(print());

    Calculator calculator6 = new Calculator("3.2","2.4",Operation.MUL.getName());
    Mockito.when(calculatorService.getCalculator("3.2","2.4","MUL")).thenReturn(calculator6);
    Mockito.when(calculatorService.cal("3.2","2.4","MUL")).thenReturn("7.68");

    mockMvc.perform(get("/api/v1?x={x}&y={y}&operation={op}","3.2","2.4","MUL"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.2"))
    .andExpect(jsonPath("$.y").value("2.4"))
    .andExpect(jsonPath("$.operation").value("mul"))
    .andExpect(jsonPath("$.result").value("7.68"))
    .andDo(print());

    Calculator calculator7 = new Calculator("3","2",Operation.DIV.getName());
    Mockito.when(calculatorService.getCalculator("3","2","DIV")).thenReturn(calculator7);
    Mockito.when(calculatorService.cal("3","2","DIV")).thenReturn("1.50000");

    mockMvc.perform(get("/api/v1?x={x}&y={y}&operation={op}","3","2","DIV"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("div"))
    .andExpect(jsonPath("$.result").value("1.50000"))
    .andDo(print());


    Calculator calculator8 = new Calculator("3.2","2.4",Operation.DIV.getName());
    Mockito.when(calculatorService.getCalculator("3.2","2.4","DIV")).thenReturn(calculator8);
    Mockito.when(calculatorService.cal("3.2","2.4","DIV")).thenReturn("1.33333");

    mockMvc.perform(get("/api/v1?x={x}&y={y}&operation={op}","3.2","2.4","DIV"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.2"))
    .andExpect(jsonPath("$.y").value("2.4"))
    .andExpect(jsonPath("$.operation").value("div"))
    .andExpect(jsonPath("$.result").value("1.33333"))
    .andDo(print());    

  }


  @Test
  void testCal2() throws Exception {
    Calculator calculator = new Calculator("3","2",Operation.ADD.getName());
    Mockito.when(calculatorService.getCalculator("3","2","ADD")).thenReturn(calculator);
    Mockito.when(calculatorService.cal("3","2","ADD")).thenReturn("5.0");    

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}","3","2","ADD"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("add"))
    .andExpect(jsonPath("$.result").value("5.0"))
    .andDo(print());

    Calculator calculator2 = new Calculator("3.2","2.4",Operation.ADD.getName());
    Mockito.when(calculatorService.getCalculator("3.2","2.4","ADD")).thenReturn(calculator2);
    Mockito.when(calculatorService.cal("3.2","2.4","ADD")).thenReturn("5.6");

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}","3.2","2.4","ADD"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.2"))
    .andExpect(jsonPath("$.y").value("2.4"))
    .andExpect(jsonPath("$.operation").value("add"))
    .andExpect(jsonPath("$.result").value("5.6"))
    .andDo(print());

    Calculator calculator3 = new Calculator("3","2",Operation.SUB.getName());
    Mockito.when(calculatorService.getCalculator("3","2","SUB")).thenReturn(calculator3);
    Mockito.when(calculatorService.cal("3","2","SUB")).thenReturn("1.0");

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}","3","2","SUB"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("sub"))
    .andExpect(jsonPath("$.result").value("1.0"))
    .andDo(print());


    Calculator calculator4 = new Calculator("3.2","2.4",Operation.SUB.getName());
    Mockito.when(calculatorService.getCalculator("3.2","2.4","SUB")).thenReturn(calculator4);
    Mockito.when(calculatorService.cal("3.2","2.4","SUB")).thenReturn("0.8");

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}","3.2","2.4","SUB"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.2"))
    .andExpect(jsonPath("$.y").value("2.4"))
    .andExpect(jsonPath("$.operation").value("sub"))
    .andExpect(jsonPath("$.result").value("0.8"))
    .andDo(print());

    Calculator calculator5 = new Calculator("3","2",Operation.MUL.getName());
    Mockito.when(calculatorService.getCalculator("3","2","MUL")).thenReturn(calculator5);
    Mockito.when(calculatorService.cal("3","2","MUL")).thenReturn("6.00");

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}","3","2","MUL"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("mul"))
    .andExpect(jsonPath("$.result").value("6.00"))
    .andDo(print());


    Calculator calculator6 = new Calculator("3.2","2.4",Operation.MUL.getName());
    Mockito.when(calculatorService.getCalculator("3.2","2.4","MUL")).thenReturn(calculator6);
    Mockito.when(calculatorService.cal("3.2","2.4","MUL")).thenReturn("7.68");

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}","3.2","2.4","MUL"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.2"))
    .andExpect(jsonPath("$.y").value("2.4"))
    .andExpect(jsonPath("$.operation").value("mul"))
    .andExpect(jsonPath("$.result").value("7.68"))
    .andDo(print());

    Calculator calculator7 = new Calculator("3","2",Operation.DIV.getName());
    Mockito.when(calculatorService.getCalculator("3","2","DIV")).thenReturn(calculator7);
    Mockito.when(calculatorService.cal("3","2","DIV")).thenReturn("1.50000");

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}","3","2","DIV"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("div"))
    .andExpect(jsonPath("$.result").value("1.50000"))
    .andDo(print());


    Calculator calculator8 = new Calculator("3.2","2.4",Operation.DIV.getName());
    Mockito.when(calculatorService.getCalculator("3.2","2.4","DIV")).thenReturn(calculator8);
    Mockito.when(calculatorService.cal("3.2","2.4","DIV")).thenReturn("1.33333");

    mockMvc.perform(get("/api/v1/{x}/{y}/{operation}","3.2","2.4","DIV"))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.2"))
    .andExpect(jsonPath("$.y").value("2.4"))
    .andExpect(jsonPath("$.operation").value("div"))
    .andExpect(jsonPath("$.result").value("1.33333"))
    .andDo(print());    

  }


  @Test
  void testStore() throws Exception {
    Calculator calculator = new Calculator("3","2",Operation.ADD.getName());
    CalculatorRecord calculatorRecord = new CalculatorRecord("3","2",Operation.ADD.getName());
    Mockito.when(calculatorService.store(calculator)).thenReturn(calculatorRecord);

    String contentStr = new ObjectMapper().writeValueAsString(calculator);
    mockMvc.perform(post("/api/v1") //
    .accept(MediaType.APPLICATION_JSON)
    .contentType(MediaType.APPLICATION_JSON) //
    .content(contentStr))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("add"))
    .andDo(print());
    
    Calculator calculator2 = new Calculator("3.9","9.8",Operation.ADD.getName());
    CalculatorRecord calculator2Record = new CalculatorRecord("3.9","9.8",Operation.ADD.getName());
    Mockito.when(calculatorService.store(calculator2)).thenReturn(calculator2Record);

    String contentStr2 = new ObjectMapper().writeValueAsString(calculator2);
    mockMvc.perform(post("/api/v1") //
    .accept(MediaType.APPLICATION_JSON)
    .contentType(MediaType.APPLICATION_JSON) //
    .content(contentStr2))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.9"))
    .andExpect(jsonPath("$.y").value("9.8"))
    .andExpect(jsonPath("$.operation").value("add"))
    .andDo(print());

    Calculator calculator3 = new Calculator("3","2",Operation.SUB.getName());
    CalculatorRecord calculator3Record = new CalculatorRecord("3","2",Operation.SUB.getName());
    Mockito.when(calculatorService.store(calculator3)).thenReturn(calculator3Record);

    String contentStr3 = new ObjectMapper().writeValueAsString(calculator3);
    mockMvc.perform(post("/api/v1") //
    .accept(MediaType.APPLICATION_JSON)
    .contentType(MediaType.APPLICATION_JSON) //
    .content(contentStr3))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("sub"))
    .andDo(print());
        
    Calculator calculator4 = new Calculator("3.9","9.8",Operation.SUB.getName());
    CalculatorRecord calculator4Record = new CalculatorRecord("3.9","9.8",Operation.SUB.getName());
    Mockito.when(calculatorService.store(calculator4)).thenReturn(calculator4Record);

    String contentStr4 = new ObjectMapper().writeValueAsString(calculator4);
    mockMvc.perform(post("/api/v1") //
    .accept(MediaType.APPLICATION_JSON)
    .contentType(MediaType.APPLICATION_JSON) //
    .content(contentStr4))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.9"))
    .andExpect(jsonPath("$.y").value("9.8"))
    .andExpect(jsonPath("$.operation").value("sub"))
    .andDo(print());

    Calculator calculator5 = new Calculator("3","2",Operation.MUL.getName());    
    CalculatorRecord calculator5Record = new CalculatorRecord("3","2",Operation.MUL.getName());    
    Mockito.when(calculatorService.store(calculator5)).thenReturn(calculator5Record);

    String contentStr5 = new ObjectMapper().writeValueAsString(calculator5);
    mockMvc.perform(post("/api/v1") //
    .accept(MediaType.APPLICATION_JSON)
    .contentType(MediaType.APPLICATION_JSON) //
    .content(contentStr5))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("mul"))
    .andDo(print());
        
    Calculator calculator6 = new Calculator("3.9","9.8",Operation.MUL.getName());    
    CalculatorRecord calculator6Record = new CalculatorRecord("3.9","9.8",Operation.MUL.getName());    
    Mockito.when(calculatorService.store(calculator6)).thenReturn(calculator6Record);

    String contentStr6 = new ObjectMapper().writeValueAsString(calculator6);
    mockMvc.perform(post("/api/v1") //
    .accept(MediaType.APPLICATION_JSON)
    .contentType(MediaType.APPLICATION_JSON) //
    .content(contentStr6))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.9"))
    .andExpect(jsonPath("$.y").value("9.8"))
    .andExpect(jsonPath("$.operation").value("mul"))
    .andDo(print());    
                    
    Calculator calculator7 = new Calculator("3","2",Operation.DIV.getName());
    CalculatorRecord calculator7Record = new CalculatorRecord("3","2",Operation.DIV.getName());
    Mockito.when(calculatorService.store(calculator7)).thenReturn(calculator7Record);

    String contentStr7 = new ObjectMapper().writeValueAsString(calculator7);
    mockMvc.perform(post("/api/v1") //
    .accept(MediaType.APPLICATION_JSON)
    .contentType(MediaType.APPLICATION_JSON) //
    .content(contentStr7))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3"))
    .andExpect(jsonPath("$.y").value("2"))
    .andExpect(jsonPath("$.operation").value("div"))
    .andDo(print());
        
    Calculator calculator8 = new Calculator("3.9","9.8",Operation.DIV.getName());
    CalculatorRecord calculator8Record = new CalculatorRecord("3.9","9.8",Operation.DIV.getName());
    Mockito.when(calculatorService.store(calculator8)).thenReturn(calculator8Record);

    String contentStr8 = new ObjectMapper().writeValueAsString(calculator8);
    mockMvc.perform(post("/api/v1") //
    .accept(MediaType.APPLICATION_JSON)
    .contentType(MediaType.APPLICATION_JSON) //
    .content(contentStr8))
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect(jsonPath("$.x").value("3.9"))
    .andExpect(jsonPath("$.y").value("9.8"))
    .andExpect(jsonPath("$.operation").value("div"))
    .andDo(print());
  }    

  
}
