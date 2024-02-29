package ru.rylenko.command;

import java.io.InputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.lang.IllegalAccessException;
import java.lang.InstantiationException;
import java.lang.NullPointerException;
import java.util.Properties;

import ru.rylenko.command.Command;
import ru.rylenko.command.CommandCreationException;
import ru.rylenko.command.CommandFactory;
import ru.rylenko.command.CommandFactoryLoadingException;


public class CommandFileFactory implements CommandFactory {
	private static final String PATH =
		"/ru/rylenko/command/CommandFileFactory.properties";

	private Properties aliases = new Properties();

	@Override
	public Command create(String command) throws CommandCreationException {
		try {
			Class cls = Class.forName(aliases.getProperty(command));
			return (Command)cls.newInstance();
		} catch (
			ClassNotFoundException
			| IllegalAccessException
			| InstantiationException
			| NullPointerException e
		) {
			throw new CommandCreationException(e);
		}
	}

	@Override
	public void load() throws CommandFactoryLoadingException {
		try (
			InputStream stream = CommandFileFactory.class.getResourceAsStream(PATH)
		) {
			aliases.load(stream);
		} catch (IOException e) {
			throw new CommandFactoryLoadingException(e);
		}
	}
}
