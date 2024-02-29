package ru.rylenko.context;

public interface Context {
	public Double getVariable(String name);
	public Double peekValue();
	public Double popValue();
	public void pushValue(Double value);
	public void putVariable(String name, Double value);
	public int valuesCount();
}
