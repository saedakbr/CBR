package com.autonomiccomputing.model;

public class InputOutput {
	private Input input;
	private Output output;
	//private String belongingClass;
	private int cluster;
	

	public InputOutput() {
		super();
	}
	public InputOutput(Input input, Output output, int  cluster) {
		
		this.input = input;
		this.output = output;
		this.cluster = cluster;
	}
	public Input getInput() {
		return input;
	}
	public void setInput(Input input) {
		this.input = input;
	}
	public Output getOutput() {
		return output;
	}
	public void setOutput(Output output) {
		this.output = output;
	}
	
	public int getCluster() {
		return cluster;
	}
	public void setCluster(int cluster) {
		this.cluster = cluster;
	}
	

}
