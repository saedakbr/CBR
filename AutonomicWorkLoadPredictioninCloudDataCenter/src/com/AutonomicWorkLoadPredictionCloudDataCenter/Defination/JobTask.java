package com.AutonomicWorkLoadPredictionCloudDataCenter.Defination;

public class JobTask {
	private long jobId;
	private int sechdeulingClass;
	private int priority;
	public long getJobId() {
		return jobId;
	}
	public void setJobId(long jobId) {
		this.jobId = jobId;
	}
	public int getSechdeulingClass() {
		return sechdeulingClass;
	}
	public void setSechdeulingClass(int sechdeulingClass) {
		this.sechdeulingClass = sechdeulingClass;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}

}
