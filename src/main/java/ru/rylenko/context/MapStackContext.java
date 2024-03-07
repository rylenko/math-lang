package ru.rylenko.context;

import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

import ru.rylenko.context.Context;

public class MapStackContext implements Context {
	private final Stack<Double> stack = new Stack<Double>();
	private final Map<String, Double> variables = new HashMap<String, Double>();

	@Override
	public Double getVariable(String name) {
		return variables.get(name);
	}

	@Override
	public Double peekValue() {
		return stack.peek();
	}

	@Override
	public Double popValue() {
		return stack.pop();
	}

	@Override
	public void pushValue(Double value) {
		stack.push(value);
	}

	@Override
	public void putVariable(String name, Double value) {
		variables.put(name, value);
	}

	@Override
	public int valuesCount() {
		return stack.size();
	}
}
