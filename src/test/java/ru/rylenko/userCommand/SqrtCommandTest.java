package ru.rylenko.userCommand;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.rylenko.context.Context;
import ru.rylenko.context.MapStackContext;
import ru.rylenko.userCommand.SqrtCommand;

public class SqrtCommandTest {
	private SqrtCommand command;
	private Context context;

	@Before
	public void init() {
		command = new SqrtCommand();
		context = new MapStackContext();
		context.pushValue(121.0);
		context.pushValue(0.16);
	}

	@Test
	public void testExecute() {
		List<String> args = new ArrayList();
		command.execute(context, args);
		Assert.assertEquals(context.popValue(), 0.4, 0);
		command.execute(context, args);
		Assert.assertEquals(context.peekValue(), 11, 0);
		Assert.assertEquals(context.valuesCount(), 1);
	}
}
