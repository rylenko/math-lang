package ru.rylenko.command;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.rylenko.userCommand.AddCommand;
import ru.rylenko.command.CommandCreationException;
import ru.rylenko.command.CommandFactory;
import ru.rylenko.command.CommandFileFactory;

public class CommandFileFactoryTest {
	private CommandFactory factory;

	@Before
	public void init() {
		factory = new CommandFileFactory();
		factory.load();
	}

	@Test(expected = CommandCreationException.class)
	public void testCreate() {
		Assert.assertTrue(factory.create("+") instanceof AddCommand);
		factory.create("qkweqwej");
	}
}
