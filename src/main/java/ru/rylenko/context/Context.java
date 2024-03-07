package ru.rylenko.context;

public interface Context {
	 Double getVariable(String name);
	 Double peekValue();
	 Double popValue();
	 void pushValue(Double value);
	 void putVariable(String name, Double value);
	 int valuesCount();
}
