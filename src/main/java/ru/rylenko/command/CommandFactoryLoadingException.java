package ru.rylenko.command;

import ru.rylenko.command.CommandException;

public class CommandFactoryLoadingException extends CommandException {
	public CommandFactoryLoadingException(Throwable cause) {
		super("Failed to load the commands factory.", cause);
	}
}
