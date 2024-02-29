package ru.rylenko.calculator;

import java.lang.RuntimeException;

public class CalculatorException extends RuntimeException {
	public CalculatorException(String message) {
		super(message);
	}

	public CalculatorException(String message, Throwable cause) {
		super(message, cause);
	}
}
