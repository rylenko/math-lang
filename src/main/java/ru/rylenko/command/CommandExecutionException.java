package ru.rylenko.command;

import ru.rylenko.command.CommandException;

public class CommandExecutionException extends CommandException {
	public CommandExecutionException(String message) {
		super(message);
	}

	public CommandExecutionException(String message, Throwable cause) {
		super(message, cause);
	}
}
