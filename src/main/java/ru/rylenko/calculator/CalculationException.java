package ru.rylenko.calculator;

import ru.rylenko.calculator.CalculatorException;

public class CalculationException extends CalculatorException {
	public CalculationException(Throwable cause) {
		super("Failed to calculate.", cause);
	}
}
