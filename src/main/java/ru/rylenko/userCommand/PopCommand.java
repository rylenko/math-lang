package ru.rylenko.userCommand;

import java.util.List;

import ru.rylenko.command.Command;
import ru.rylenko.command.CommandExecutionException;
import ru.rylenko.context.Context;

public class PopCommand implements Command {
	@Override
	public void execute(Context context, List<String> args)
	throws CommandExecutionException {
		if (args.size() != 0) {
			throw new CommandExecutionException(
				"Invalid args count. Expected 0. Got " + args.size() + "."
			);
		} else if (context.valuesCount() == 0) {
			throw new CommandExecutionException(
				"Invalid stack size. Expected at least 1. Got "
					+ context.valuesCount() + "."
			);
		}
		System.out.println(context.popValue());
	}
}