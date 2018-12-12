package com.AutonomicWorkLoadPredictionCloudDataCenter.Defination;

public class TaskEvent {
private long timeStamps;
private int missingInfo;
private long jobId;

private int taskIndex;
private long machineId;
private long eventType;
private String username;
private int sechedulingClass;
private int priority;
private double resourceRequestForCPU;
private double resourceRequestForRAM;
private double resourceRequestForLocalDiskSpace;
private double differentMachineConstraints;
public long getTimeStamps() {
	return timeStamps;
}
public void setTimeStamps(long timeStamps) {
	this.timeStamps = timeStamps;
}
public long getJobId() {
	return jobId;
}
public void setJobId(long jobId) {
	this.jobId = jobId;
}
public int getTaskIndex() {
	return taskIndex;
}
public void setTaskIndex(int taskIndex) {
	this.taskIndex = taskIndex;
}
public long getMachineId() {
	return machineId;
}
public void setMachineId(long machineId) {
	this.machineId = machineId;
}
public long getEventType() {
	return eventType;
}
public void setEventType(long eventType) {
	this.eventType = eventType;
}
public int getSechedulingClass() {
	return sechedulingClass;
}
public void setSechedulingClass(int sechedulingClass) {
	this.sechedulingClass = sechedulingClass;
}
public int getPriority() {
	return priority;
}
public void setPriority(int priority) {
	this.priority = priority;
}
public double getResourceRequestForCPU() {
	return resourceRequestForCPU;
}
public void setResourceRequestForCPU(double resourceRequestForCPU) {
	this.resourceRequestForCPU = resourceRequestForCPU;
}
public double getResourceRequestForRAM() {
	return resourceRequestForRAM;
}
public void setResourceRequestForRAM(double resourceRequestForRAM) {
	this.resourceRequestForRAM = resourceRequestForRAM;
}
public double getResourceRequestForLocalDiskSpace() {
	return resourceRequestForLocalDiskSpace;
}
public void setResourceRequestForLocalDiskSpace(double resourceRequestForLocalDiskSpace) {
	this.resourceRequestForLocalDiskSpace = resourceRequestForLocalDiskSpace;
}
public double getDifferentMachineConstraints() {
	return differentMachineConstraints;
}
public void setDifferentMachineConstraints(double differentMachineConstraints) {
	this.differentMachineConstraints = differentMachineConstraints;
}
public int getMissingInfo() {
	return missingInfo;
}
public void setMissingInfo(int missingInfo) {
	this.missingInfo = missingInfo;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}


}
