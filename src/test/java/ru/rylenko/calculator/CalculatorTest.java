package ru.rylenko.calculator;

import java.io.BufferedReader;
import java.io.StringReader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.rylenko.command.Command;
import ru.rylenko.command.CommandFactory;
import ru.rylenko.command.CommandFileFactory;
import ru.rylenko.context.Context;
import ru.rylenko.context.MapStackContext;

public class CalculatorTest {
	private Calculator calculator;

	@Before
	public void init() {
		Context context = new MapStackContext();
		context.pushValue(-1.0);
		context.pushValue(2.13);

		CommandFactory factory = new CommandFileFactory();
		factory.load();

		calculator = new Calculator(
			context,
			factory,
			new BufferedReader(new StringReader("+")),
			System.err
		);
	}

	@Test
	public void testCalculate() {
		calculator.calculate();
		Assert.assertEquals(calculator.context().valuesCount(), 1, 0);
		Assert.assertEquals(calculator.context().peekValue(), 1.13, 0);
	}
}
