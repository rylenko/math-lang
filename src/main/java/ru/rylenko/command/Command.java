package ru.rylenko.command;

import java.util.List;

import ru.rylenko.context.Context;
import ru.rylenko.command.CommandExecutionException;

public interface Command {
	public void execute(Context context, List<String> args)
		throws CommandExecutionException;
}