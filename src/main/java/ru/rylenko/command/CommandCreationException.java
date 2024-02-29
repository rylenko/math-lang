package ru.rylenko.command;

import ru.rylenko.command.CommandException;

public class CommandCreationException extends CommandException {
	public CommandCreationException(Throwable cause) {
		super("Failed to create command.", cause);
	}
}
