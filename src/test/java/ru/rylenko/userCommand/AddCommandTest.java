package ru.rylenko.userCommand;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.rylenko.context.Context;
import ru.rylenko.context.MapStackContext;
import ru.rylenko.userCommand.AddCommand;

public class AddCommandTest {
	private AddCommand command;
	private Context context;

	@Before
	public void init() {
		command = new AddCommand();
		context = new MapStackContext();
		context.pushValue(0.13);
		context.pushValue(0.14);
		context.pushValue(1.75);
	}

	@Test
	public void testExecute() {
		List<String> args = new ArrayList();
		command.execute(context, args);
		Assert.assertEquals(context.peekValue(), 1.89, 1e-15);
		command.execute(context, args);
		Assert.assertEquals(context.peekValue(), 2.02, 1e-15);
		Assert.assertEquals(context.valuesCount(), 1);
	}
}
