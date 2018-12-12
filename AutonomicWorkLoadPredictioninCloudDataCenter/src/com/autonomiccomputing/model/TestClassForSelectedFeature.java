package com.autonomiccomputing.model;

public class TestClassForSelectedFeature {
	private Output output;
	private double db;
	private double Ed;
	
	public TestClassForSelectedFeature(Output output, double db, double ed) {
		//super();
		this.output = output;
		this.db = db;
		this. Ed = ed;
	}
	public Output getOutput() {
		return output;
	}
	public void setOutput(Output output) {
		this.output = output;
	}
	public double getDb() {
		return db;
	}
	public void setDb(double db) {
		this.db = db;
	}
	public double getEd() {
		return Ed;
	}
	public void setEd(double ed) {
		Ed = ed;
	}
	

}
