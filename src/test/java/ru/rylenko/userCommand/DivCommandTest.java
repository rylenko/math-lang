package ru.rylenko.userCommand;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.rylenko.context.Context;
import ru.rylenko.context.MapStackContext;
import ru.rylenko.userCommand.DivCommand;

public class DivCommandTest {
	private DivCommand command;
	private Context context;

	@Before
	public void init() {
		command = new DivCommand();
		context = new MapStackContext();
		context.pushValue(2.12);
		context.pushValue(4.24);
		context.pushValue(0.5);
	}

	@Test
	public void testExecute() {
		List<String> args = new ArrayList();
		command.execute(context, args);
		Assert.assertEquals(context.peekValue(), 8.48, 0);
		command.execute(context, args);
		Assert.assertEquals(context.peekValue(), 0.25, 0);
		Assert.assertEquals(context.valuesCount(), 1);
	}
}
