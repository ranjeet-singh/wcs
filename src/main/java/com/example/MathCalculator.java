package com.example;

import com.example.exception.InvalidValueException;

public class MathCalculator {
	
	public int sum(int a,int b){
		System.out.println("Inside MathCalculator.sum(a,b)");
		System.out.println("Inside MathCalculator.sum(a,b), a= "+ a + "b= " +b);
		return a+b;
	}

	public int diff(int a,int b){
		return a-b;
	}

	public int divide(int a,int b) throws InvalidValueException{
		if(a==0 || b==0){
			throw new InvalidValueException("Value can not be zero!!!!");
		}
		return a/b;
	}

}
