package com.example.calculator;

import junit.framework.TestCase;
//import junit.swingui.TestRunner;

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
     int resultadoObtenido = this.calculadora.sumar(op1, op2);
     assertEquals("Error en la suma!", resultadoEsperado, resultadoObtenido, 0);
  }
  
  public void testDividirEnteros() {
	  //...
	  //assertEquals("Error en la division!", resultadoEsperado, resultadoObtenido, 0);
	}

	public void testDividirPorCero() {     
	  //...
	  try {
	    //   ... 
	  } catch (ArithmeticException e) {
	      // ...
	  }
	}

	
 }
