package com.AutonomicWorkLoadPredictionCloudDataCenter.Defination;

public class ResourceUsage {
	private long startTime;
	private long endTime;
	private long jobId;
	private int taskIndex;
	private long machineId;
	private double meanCPUUsageRate;
	private double canonicalMemoryUsage;
	private double assignedMemoryUsage;
	private double unmappedPageCacheMemoryUsage;
	private double totalPageCacheMemoryUsage;
	private double maximumMemoryUsage;
	private double meanDiskInputOutputTime;
	private double meanLocalDiskSpaceUsed;
	private double maximumCPUUsage;
	private double maximumDiskIOTime;
	private double cyclePerInstruction;
	private double memoryAccessPerInstruction;
	private double samplePortion;
	private double aggregationType;
	private double sampledCPUusage;
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
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
	public double getMeanCPUUsageRate() {
		return meanCPUUsageRate;
	}
	public void setMeanCPUUsageRate(double meanCPUUsageRate) {
		this.meanCPUUsageRate = meanCPUUsageRate;
	}
	public double getCanonicalMemoryUsage() {
		return canonicalMemoryUsage;
	}
	public void setCanonicalMemoryUsage(double canonicalMemoryUsage) {
		this.canonicalMemoryUsage = canonicalMemoryUsage;
	}
	public double getAssignedMemoryUsage() {
		return assignedMemoryUsage;
	}
	public void setAssignedMemoryUsage(double assignedMemoryUsage) {
		this.assignedMemoryUsage = assignedMemoryUsage;
	}
	public double getUnmappedPageCacheMemoryUsage() {
		return unmappedPageCacheMemoryUsage;
	}
	public void setUnmappedPageCacheMemoryUsage(double unmappedPageCacheMemoryUsage) {
		this.unmappedPageCacheMemoryUsage = unmappedPageCacheMemoryUsage;
	}
	public double getTotalPageCacheMemoryUsage() {
		return totalPageCacheMemoryUsage;
	}
	public void setTotalPageCacheMemoryUsage(double totalPageCacheMemoryUsage) {
		this.totalPageCacheMemoryUsage = totalPageCacheMemoryUsage;
	}
	public double getMaximumMemoryUsage() {
		return maximumMemoryUsage;
	}
	public void setMaximumMemoryUsage(double maximumMemoryUsage) {
		this.maximumMemoryUsage = maximumMemoryUsage;
	}
	public double getMeanDiskInputOutputTime() {
		return meanDiskInputOutputTime;
	}
	public void setMeanDiskInputOutputTime(double meanDiskInputOutputTime) {
		this.meanDiskInputOutputTime = meanDiskInputOutputTime;
	}
	public double getMeanLocalDiskSpaceUsed() {
		return meanLocalDiskSpaceUsed;
	}
	public void setMeanLocalDiskSpaceUsed(double meanLocalDiskSpaceUsed) {
		this.meanLocalDiskSpaceUsed = meanLocalDiskSpaceUsed;
	}
	public double getMaximumCPUUsage() {
		return maximumCPUUsage;
	}
	public void setMaximumCPUUsage(double maximumCPUUsage) {
		this.maximumCPUUsage = maximumCPUUsage;
	}
	public double getMaximumDiskIOTime() {
		return maximumDiskIOTime;
	}
	public void setMaximumDiskIOTime(double maximumDiskIOTime) {
		this.maximumDiskIOTime = maximumDiskIOTime;
	}
	public double getCyclePerInstruction() {
		return cyclePerInstruction;
	}
	public void setCyclePerInstruction(double cyclePerInstruction) {
		this.cyclePerInstruction = cyclePerInstruction;
	}
	public double getMemoryAccessPerInstruction() {
		return memoryAccessPerInstruction;
	}
	public void setMemoryAccessPerInstruction(double memoryAccessPerInstruction) {
		this.memoryAccessPerInstruction = memoryAccessPerInstruction;
	}
	public double getSamplePortion() {
		return samplePortion;
	}
	public void setSamplePortion(double samplePortion) {
		this.samplePortion = samplePortion;
	}
	public double getAggregationType() {
		return aggregationType;
	}
	public void setAggregationType(double aggregationType) {
		this.aggregationType = aggregationType;
	}
	public double getSampledCPUusage() {
		return sampledCPUusage;
	}
	public void setSampledCPUusage(double sampledCPUusage) {
		this.sampledCPUusage = sampledCPUusage;
	}
	

}
