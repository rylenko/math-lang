package ru.rylenko.userCommand;

import java.lang.NumberFormatException;
import java.util.List;

import ru.rylenko.command.Command;
import ru.rylenko.command.CommandExecutionException;
import ru.rylenko.context.Context;

public class PushCommand implements Command {
	@Override
	public void execute(Context context, List<String> args)
	throws CommandExecutionException  {
		// Check args count
		if (args.size() != 1) {
			throw new CommandExecutionException(
				"Invalid args count. Expected 1. Got " + args.size() + "."
			);
		}

		String valueString = args.get(0);
		Double value;
		try {
			// Is literal
			value = Double.parseDouble(valueString);
		} catch (NumberFormatException _e) {
			// Is variable
			value = context.getVariable(valueString);
		}
		context.pushValue(value);
	}
}