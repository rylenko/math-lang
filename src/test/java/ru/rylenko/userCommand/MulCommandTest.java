package ru.rylenko.userCommand;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.rylenko.context.Context;
import ru.rylenko.context.MapStackContext;
import ru.rylenko.userCommand.MulCommand;

public class MulCommandTest {
	private MulCommand command;
	private Context context;

	@Before
	public void init() {
		command = new MulCommand();
		context = new MapStackContext();
		context.pushValue(2.0);
		context.pushValue(3.5);
		context.pushValue(1.0);
	}

	@Test
	public void testExecute() {
		List<String> args = new ArrayList();
		command.execute(context, args);
		Assert.assertEquals(context.peekValue(), 3.5, 0);
		command.execute(context, args);
		Assert.assertEquals(context.peekValue(), 7.0, 0);
		Assert.assertEquals(context.valuesCount(), 1);
	}
}
