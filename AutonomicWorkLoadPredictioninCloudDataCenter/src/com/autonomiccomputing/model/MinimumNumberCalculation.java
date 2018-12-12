package com.autonomiccomputing.model;

public class MinimumNumberCalculation {
private Output output;
private double minimumNumber;
public MinimumNumberCalculation(Output output, double minimumNumber) {
	
	this.setOutput(output);
	this.setMinimumNumber(minimumNumber);
}
public Output getOutput() {
	return output;
}
public void setOutput(Output output) {
	this.output = output;
}
public double getMinimumNumber() {
	return minimumNumber;
}
public void setMinimumNumber(double minimumNumber) {
	this.minimumNumber = minimumNumber;
}

}
