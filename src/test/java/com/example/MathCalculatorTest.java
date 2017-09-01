package com.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.example.exception.InvalidValueException;

@RunWith(JUnit4.class)
public class MathCalculatorTest {

	MathCalculator calculator;
	
	@Before
	public void init(){
		//System.out.println("Inside init()");
		calculator = new MathCalculator();
	}
	
	@After
	public void clean(){
		//System.out.println("Inside clean()");
		calculator = null;
	}

	@Test(expected=InvalidValueException.class)
	public void divideForException() throws InvalidValueException{
		calculator.divide(10,0);
	}

	
	@Test
	public void divideTwoNumbers(){
		try {
			int rs = calculator.divide(50,2);
			Assert.assertEquals(25, rs);
		} catch (InvalidValueException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void subtractTwoNegativeNumbers(){
		int rs = calculator.diff(-10, -5);
		Assert.assertEquals(-5, rs);
	}
	
	@Test
	public void subtractPositiveNegativeNumber(){
		int rs = calculator.diff(10, -5);
		Assert.assertEquals(15, rs);
	}

	@Test
	public void subtractTwoNumbers(){
		int rs = calculator.diff(10, 5);
		Assert.assertEquals(5, rs);
	}


	@Test
	public void addTwoNegativeNumber(){
		int rs = calculator.sum(-10, -5);
		Assert.assertEquals(-15, rs);
	}
	
	@Test
	public void addPositiveNegativeNumber(){
		Assert.assertEquals(5, calculator.sum(10, -5));
	}
	
	@Test
	public void addTwoNumbers(){
		int rs = calculator.sum(10, 5);
		Assert.assertEquals(15, rs);
	}
	
	@Test
	public void addTwoSameNumbers(){
		int rs = calculator.sum(10, 10);
		Assert.assertEquals(20, rs);
	}

	//SLA testing
	@Test(timeout=5000)
	public void addingNumbersShouldTakeLessThenFiveSeconds(){
		calculator.sum(10, 5);
	}

}
