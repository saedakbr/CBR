package com.AutonomicWorkLoadPredictionCloudDataCenter.Defination;

public class JobEvent {
	private long timeStamp;
	private long jobID;
	private int eventType;
	private int schedulingClass;
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public long getJobID() {
		return jobID;
	}
	public void setJobID(long jobID) {
		this.jobID = jobID;
	}
	public int getEventType() {
		return eventType;
	}
	public void setEventType(int eventType) {
		this.eventType = eventType;
	}
	public int getSchedulingClass() {
		return schedulingClass;
	}
	public void setSchedulingClass(int schedulingClass) {
		this.schedulingClass = schedulingClass;
	}
	

}
