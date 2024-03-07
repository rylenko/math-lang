package ru.rylenko.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import ru.rylenko.calculator.CalculationException;
import ru.rylenko.command.Command;
import ru.rylenko.command.CommandFactory;
import ru.rylenko.command.CommandCreationException;
import ru.rylenko.command.CommandExecutionException;
import ru.rylenko.command.CommandFactoryLoadingException;
import ru.rylenko.context.Context;

public class Calculator {
	final private Context context;
	final private PrintStream errorsStream;
	final private CommandFactory factory;
	final private BufferedReader reader;

	public Calculator(
		Context context,
		CommandFactory factory,
		BufferedReader reader,
		PrintStream errorsStream
	) {
		this.context = context;
		this.factory = factory;
		this.errorsStream = errorsStream;
		this.reader = reader;
	}

	public void calculate() throws CalculationException {
		String line;
		long lineNumber = 0;

		try {
			// Read commands and write results
			while ((line = reader.readLine()) != null) {
				lineNumber++;

				// Split line and check splitted args length
				String[] tokens = line.trim().split("\\s+");
				if (tokens.length == 0) {
					continue;
				}

				// Get command arguments
				String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);

				try {
					// Create command with factory and execute it
					factory.create(tokens[0]).execute(context, Arrays.asList(args));
				} catch (CommandCreationException | CommandExecutionException e) {
					e.printStackTrace(errorsStream);
				}
			}
		} catch (CommandFactoryLoadingException | IOException e) {
			throw new CalculationException(e);
		}
	}

	public Context context() {
		return context;
	}
}
