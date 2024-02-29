package ru.rylenko.userCommand;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.rylenko.context.Context;
import ru.rylenko.context.MapStackContext;
import ru.rylenko.userCommand.PopCommand;

public class PopCommandTest {
	private PopCommand command;
	private Context context;

	@Before
	public void init() {
		command = new PopCommand();
		context = new MapStackContext();
		context.pushValue(-0.123);
	}

	@Test
	public void testExecute() {
		List<String> args = new ArrayList();
		command.execute(context, args);
		Assert.assertEquals(context.valuesCount(), 0, 0);
	}
}
