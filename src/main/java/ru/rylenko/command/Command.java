package ru.rylenko.command;

import java.util.List;

import ru.rylenko.context.Context;
import ru.rylenko.command.CommandExecutionException;

public interface Command {
	void execute(Context context, List<String> args)
		throws CommandExecutionException;
}