package ru.rylenko.userCommand;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.rylenko.context.Context;
import ru.rylenko.context.MapStackContext;
import ru.rylenko.userCommand.PushCommand;

public class PushCommandTest {
	private PushCommand command;
	private Context context;

	@Before
	public void init() {
		command = new PushCommand();
		context = new MapStackContext();
		context.pushValue(-3.14);
		context.putVariable("x", 13.13);
	}

	@Test
	public void testExecute() {
		List<String> args = Arrays.asList("x");
		command.execute(context, args);
		Assert.assertEquals(context.popValue(), 13.13, 0);
		Assert.assertEquals(context.popValue(), -3.14, 0);
	}
}
