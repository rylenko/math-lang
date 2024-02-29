package ru.rylenko.userCommand;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.rylenko.context.Context;
import ru.rylenko.context.MapStackContext;
import ru.rylenko.userCommand.DefineCommand;

public class DefineCommandTest {
	private DefineCommand command;
	private Context context;

	@Before
	public void init() {
		command = new DefineCommand();
		context = new MapStackContext();
	}

	@Test
	public void testExecute() {
		List<String> args = Arrays.asList("x", "-15");
		command.execute(context, args);
		Assert.assertEquals(context.getVariable("x"), -15.0, 0);
	}
}
