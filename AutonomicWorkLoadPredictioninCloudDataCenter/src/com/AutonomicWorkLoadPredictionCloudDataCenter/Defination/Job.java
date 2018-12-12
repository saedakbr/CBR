package com.AutonomicWorkLoadPredictionCloudDataCenter.Defination;

public class Job {
	private long jobID;
	private int schedulingClass;
	public long getJobID() {
		return jobID;
	}
	public void setJobID(long jobID) {
		this.jobID = jobID;
	}
	public int getSchedulingClass() {
		return schedulingClass;
	}
	public void setSchedulingClass(int schedulingClass) {
		this.schedulingClass = schedulingClass;
	}
	

}
