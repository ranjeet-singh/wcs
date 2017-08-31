package com.example.exception;

public class ProductNotInCartException extends Exception {

	public ProductNotInCartException() {

	}

	public ProductNotInCartException(String message) {
		super(message);
	}
}
