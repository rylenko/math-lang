package ru.rylenko.userCommand;

import java.util.List;

import ru.rylenko.command.Command;
import ru.rylenko.command.CommandExecutionException;
import ru.rylenko.context.Context;

public class DefineCommand implements Command {
	@Override
	public void execute(Context context, List<String> args)
	throws CommandExecutionException {
		if (args.size() != 2) {
			throw new CommandExecutionException(
				"Invalid args count. Expected 2. Got " + args.size() + "."
			);
		}
		Double value = Double.parseDouble(args.get(1));
		context.putVariable(args.get(0), value);
	}
}