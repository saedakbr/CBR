package com.autonomiccomputing.model;

public class Input {
	private double centtaskIndex;
	private double centsechedulingClass;
	private double centpriority;
	
	private long jobID;
	private int sechedulingClass;
	private int priority;
	private int taskIndex;
	public Input() {
		// TODO Auto-generated constructor stub
	}
	
	public Input(double centtaskIndex, double centsechedulingClass, double centpriority) {
		
		this.setCenttaskIndex(centtaskIndex);
		this.setCentsechedulingClass(centsechedulingClass);
		this.setCentpriority(centpriority);
	}

	public Input(int taskIndex,int sechedulingClass, int priority) {
		this.taskIndex=taskIndex;
		this.sechedulingClass = sechedulingClass;
		this.priority = priority;
	}
	public long getJobID() {
		return jobID;
	}
	public void setJobID(long jobID) {
		this.jobID = jobID;
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
	public int getTaskIndex() {
		return taskIndex;
	}
	public void setTaskIndex(int taskIndex) {
		this.taskIndex = taskIndex;
	}

	public double getCenttaskIndex() {
		return centtaskIndex;
	}

	public void setCenttaskIndex(double centtaskIndex) {
		this.centtaskIndex = centtaskIndex;
	}

	public double getCentsechedulingClass() {
		return centsechedulingClass;
	}

	public void setCentsechedulingClass(double centsechedulingClass) {
		this.centsechedulingClass = centsechedulingClass;
	}

	public double getCentpriority() {
		return centpriority;
	}

	public void setCentpriority(double centpriority) {
		this.centpriority = centpriority;
	}
	

}
