package com.example.calculator;

import java.math.BigDecimal;
import java.math.BigInteger;

import junit.framework.TestCase;


public class CalculatorTestCase extends TestCase {
  private Calculator calculadora;

  public void setUp() {
    this.calculadora = new Calculator();
  }

  public void tearDown() {
    this.calculadora = null;
  }

  public void testSumarEnteros() {
     int op1 = 10;
     int op2 = 15;
     int resultadoEsperado = op1 + op2;
     int resultadoObtenido = this.calculadora.add(op1, op2);
     assertEquals("Error adding!!", resultadoEsperado, resultadoObtenido, 0);
  }
  
  public void testDividirEnteros() {
	  //...
	  //assertEquals("Error en la division!", resultadoEsperado, resultadoObtenido, 0);
	}

	public void testDividirPorCero() {     
		String a = "1231212478987482988429808779810457634781384756794987";
        int aScale = 15;
        BigDecimal aNumber = new BigDecimal(new BigInteger(a), aScale);
        BigDecimal bNumber = BigDecimal.valueOf(0L);
        try {
            aNumber.divide(bNumber);
            fail("ArithmeticException has not been caught");
        } catch (ArithmeticException e) {
            assertEquals("Improper exception message", "Division by zero", e.getMessage());
        }

	}

	
 }
