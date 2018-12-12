package com.autonomiccomputing.model;

public class Output {
	private double assignedMemoryUsage;
	private double memoryAccessPerInstruction;
	private double maximumDiskInputOutputTime;
	private double totalPagedCacheMemoryUsage;
	private double maximumCPUUsage;
	private double meanLocalDiskSpaceUsed;
	private double cyclesPerInstruction;
	private String classe;
	
	public Output() {
		
	}
	public Output(double assignedMemoryUsage, double memoryAccessPerInstruction, double maximumDiskInputOutputTime,
			double totalPagedCacheMemoryUsage, double maximumCPUUsage, double meanLocalDiskSpaceUsed,
			double cyclesPerInstruction, String classe) {
		super();
		this.assignedMemoryUsage = assignedMemoryUsage;
		this.memoryAccessPerInstruction = memoryAccessPerInstruction;
		this.maximumDiskInputOutputTime = maximumDiskInputOutputTime;
		this.totalPagedCacheMemoryUsage = totalPagedCacheMemoryUsage;
		this.maximumCPUUsage = maximumCPUUsage;
		this.meanLocalDiskSpaceUsed = meanLocalDiskSpaceUsed;
		this.cyclesPerInstruction = cyclesPerInstruction;
		this.setClasse(classe);
	}
	public double getAssignedMemoryUsage() {
		return assignedMemoryUsage;
	}
	public void setAssignedMemoryUsage(double assignedMemoryUsage) {
		this.assignedMemoryUsage = assignedMemoryUsage;
	}
	public double getMemoryAccessPerInstruction() {
		return memoryAccessPerInstruction;
	}
	public void setMemoryAccessPerInstruction(double memoryAccessPerInstruction) {
		this.memoryAccessPerInstruction = memoryAccessPerInstruction;
	}
	public double getMaximumDiskInputOutputTime() {
		return maximumDiskInputOutputTime;
	}
	public void setMaximumDiskInputOutputTime(double maximumDiskInputOutputTime) {
		this.maximumDiskInputOutputTime = maximumDiskInputOutputTime;
	}
	public double getTotalPagedCacheMemoryUsage() {
		return totalPagedCacheMemoryUsage;
	}
	public void setTotalPagedCacheMemoryUsage(double totalPagedCacheMemoryUsage) {
		this.totalPagedCacheMemoryUsage = totalPagedCacheMemoryUsage;
	}
	public double getMaximumCPUUsage() {
		return maximumCPUUsage;
	}
	public void setMaximumCPUUsage(double maximumCPUUsage) {
		this.maximumCPUUsage = maximumCPUUsage;
	}
	public double getMeanLocalDiskSpaceUsed() {
		return meanLocalDiskSpaceUsed;
	}
	public void setMeanLocalDiskSpaceUsed(double meanLocalDiskSpaceUsed) {
		this.meanLocalDiskSpaceUsed = meanLocalDiskSpaceUsed;
	}
	public double getCyclesPerInstruction() {
		return cyclesPerInstruction;
	}
	public void setCyclesPerInstruction(double cyclesPerInstruction) {
		this.cyclesPerInstruction = cyclesPerInstruction;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	

}
