package ru.rylenko.userCommand;

import java.util.List;

import ru.rylenko.command.Command;
import ru.rylenko.command.CommandExecutionException;
import ru.rylenko.context.Context;

public class MulCommand implements Command {
	@Override
	public void execute(Context context, List<String> args)
	throws CommandExecutionException {
		if (args.size() != 0) {
			throw new CommandExecutionException(
				"Invalid args count. Expected 0. Got " + args.size() + "."
			);
		} else if (context.valuesCount() < 2) {
			throw new CommandExecutionException(
				"Invalid args count. Expected at least 2. Got "
					+ context.valuesCount() + "."
			);
		}
		context.pushValue(context.popValue() * context.popValue());
	}
}