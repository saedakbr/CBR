package com.AutonomicWorkLoadPredictionCloudDataCenter.Defination;

public class TaskManagerPriority {
	private long JobID;
	private int taskIndex;
	private int infrastucture=0;
	private int monitioring =0;
	private int normalProduction=0;
	private int other=0;
	private int gratis=0;
	public long getJobID() {
		return JobID;
	}
	public void setJobID(long jobID) {
		JobID = jobID;
	}
	public int getTaskIndex() {
		return taskIndex;
	}
	public void setTaskIndex(int taskIndex) {
		this.taskIndex = taskIndex;
	}
	public int getInfrastucture() {
		return infrastucture;
	}
	public void setInfrastucture(int infrastucture) {
		this.infrastucture = infrastucture;
	}
	public int getMonitioring() {
		return monitioring;
	}
	public void setMonitioring(int monitioring) {
		this.monitioring = monitioring;
	}
	public int getNormalProduction() {
		return normalProduction;
	}
	public void setNormalProduction(int normalProduction) {
		this.normalProduction = normalProduction;
	}
	public int getOther() {
		return other;
	}
	public void setOther(int other) {
		this.other = other;
	}
	public int getGratis() {
		return gratis;
	}
	public void setGratis(int gratis) {
		this.gratis = gratis;
	}

}
