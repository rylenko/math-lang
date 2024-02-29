package ru.rylenko.command;

import ru.rylenko.command.Command;
import ru.rylenko.command.CommandCreationException;
import ru.rylenko.command.CommandFactoryLoadingException;

public interface CommandFactory {
	public Command create(String command) throws CommandCreationException;
	public void load() throws CommandFactoryLoadingException;
}
