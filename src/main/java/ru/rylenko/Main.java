package ru.rylenko;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;

import ru.rylenko.calculator.Calculator;
import ru.rylenko.command.CommandFactory;
import ru.rylenko.command.CommandFileFactory;
import ru.rylenko.context.Context;
import ru.rylenko.context.MapStackContext;

public class Main {
	public static void main(String[] args) {
		try (
			BufferedReader commandsReader = args.length == 0
				? new BufferedReader(new InputStreamReader(System.in))
				: new BufferedReader(new FileReader(args[0]))
		) {
			// Create context
			Context context = new MapStackContext();

			// Create and load the fabric
			CommandFactory factory = new CommandFileFactory();
			factory.load();

			// Calculate
			Calculator calculator =
				new Calculator(context, factory, commandsReader, System.err);
			calculator.calculate();
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
}