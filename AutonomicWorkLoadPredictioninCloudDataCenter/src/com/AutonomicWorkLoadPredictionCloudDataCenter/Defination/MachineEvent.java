package com.AutonomicWorkLoadPredictionCloudDataCenter.Defination;

public class MachineEvent {
private long timeStamp;
private int machineID;
private int eventType;
private int cpuCapacity;
private int memoryCapacity;
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
public int getEventType() {
	return eventType;
}
public void setEventType(int eventType) {
	this.eventType = eventType;
}
public int getCpuCapacity() {
	return cpuCapacity;
}
public void setCpuCapacity(int cpuCapacity) {
	this.cpuCapacity = cpuCapacity;
}
public int getMemoryCapacity() {
	return memoryCapacity;
}
public void setMemoryCapacity(int memoryCapacity) {
	this.memoryCapacity = memoryCapacity;
}

}
