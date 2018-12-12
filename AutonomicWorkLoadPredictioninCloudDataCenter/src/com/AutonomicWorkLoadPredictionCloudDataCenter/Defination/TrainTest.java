package com.AutonomicWorkLoadPredictionCloudDataCenter.Defination;

import java.util.ArrayList;

import com.autonomiccomputing.model.Input;
import com.autonomiccomputing.model.Output;

public class TrainTest {
private Input input;
private Output output;
private ArrayList<TrainTest> listTraining;
private ArrayList<TrainTest> listTesting;
public TrainTest() {
	// TODO Auto-generated constructor stub
}
public TrainTest(Input input, Output output) {
	this.input = input;
	this.output = output;
}
public Output getOutput() {
	return output;
}
public void setOutput(Output output) {
	this.output = output;
}
public Input getInput() {
	return input;
}
public void setInput(Input input) {
	this.input = input;
}
public ArrayList<TrainTest> getListTraining() {
	return listTraining;
}
public void setListTraining(ArrayList<TrainTest> listTraining) {
	this.listTraining = listTraining;
}
public ArrayList<TrainTest> getListTesting() {
	return listTesting;
}
public void setListTesting(ArrayList<TrainTest> listTesting) {
	this.listTesting = listTesting;
}

}
