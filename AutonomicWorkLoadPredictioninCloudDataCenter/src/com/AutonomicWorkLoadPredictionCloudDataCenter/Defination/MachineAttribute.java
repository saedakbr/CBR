package com.AutonomicWorkLoadPredictionCloudDataCenter.Defination;

public class MachineAttribute {
private long timeStamp;
private int machineID;
private int attributeDeleted;
public long getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(long timeStamp) {
	this.timeStamp = timeStamp;
}
public int getMachineID() {
	return machineID;
}
public void setMachineID(int machineID) {
	this.machineID = machineID;
}
public int getAttributeDeleted() {
	return attributeDeleted;
}
public void setAttributeDeleted(int attributeDeleted) {
	this.attributeDeleted = attributeDeleted;
}

}
