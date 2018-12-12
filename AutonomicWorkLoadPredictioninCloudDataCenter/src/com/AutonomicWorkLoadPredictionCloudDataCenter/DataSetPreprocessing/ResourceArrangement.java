package com.AutonomicWorkLoadPredictionCloudDataCenter.DataSetPreprocessing;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.ResourceUsage;
import com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading.FileAddress;
import com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading.RetriveDataFromFile;

public class ResourceArrangement {
public void resourceDataPreProcessing() throws IOException {
	RetriveDataFromFile retriveDataFromFile= new RetriveDataFromFile();
	for(int n=18;n<=19;n++) {
	//int n=2;
		System.out.println("starting"+n);
	BufferedWriter writer= FileAddress.writingNewFile("Output\\"+"File"+n+".csv");
	writer.write("StartTimeOfMeasurementPeriod"+","+"EndTimeOfMeasuremmentPeriod"+","+
	"JobId"+","+"TaskIndex"+","+"MachineId"+","+"MeanCPUUsageRate"+","+"CanonicalMemoryUsage"+","+
			"AssignedMemoryUsage"+","+"UnMappedPagedCacheMemoryUsage"+","+"TotalPagedCacheMemoryUsage"+","+
	"MaximumMemoryUsage"+","+"MeanDiskInputOutputTime"+","+"MeanLocalDiskSpaceUsed"+","+
			"MaximumCPUUsage"+","+"MaximumDiskInputOutputTime"+","+"CyclesPerInstruction"+","+
	"MemoryAccessPerInstruction"+","+"SamplePortion"+","+"AggregationType"+","+"SampledCPUUsage"+","+"\n");
	System.out.println("start");
	ArrayList<ResourceUsage> listResourceUsage= retriveDataFromFile.resourceUsage("Input\\"+n+".csv");
	System.out.println("Size "+listResourceUsage.size());
	System.out.println("writing");
	for(int i=0;i<listResourceUsage.size();i++) {
		long jobId= listResourceUsage.get(i).getJobId();
		int taskIndex= listResourceUsage.get(i).getTaskIndex();
		writer.write(listResourceUsage.get(i).getStartTime()+","+listResourceUsage.get(i).getEndTime()+","+
		jobId+","+listResourceUsage.get(i).getTaskIndex()+","+listResourceUsage.get(i).getMachineId()+","+
				listResourceUsage.get(i).getMeanCPUUsageRate()+","+listResourceUsage.get(i).getCanonicalMemoryUsage()+","+
		listResourceUsage.get(i).getAssignedMemoryUsage()+","+listResourceUsage.get(i).getUnmappedPageCacheMemoryUsage()+","+
				listResourceUsage.get(i).getTotalPageCacheMemoryUsage()+","+listResourceUsage.get(i).getMaximumMemoryUsage()+","+
		listResourceUsage.get(i).getMeanDiskInputOutputTime()+","+listResourceUsage.get(i).getMeanLocalDiskSpaceUsed()+","+
				listResourceUsage.get(i).getMaximumCPUUsage()+","+listResourceUsage.get(i).getMaximumDiskIOTime()+","+
				listResourceUsage.get(i).getCyclePerInstruction()+","+ listResourceUsage.get(i).getMemoryAccessPerInstruction()+","+
				listResourceUsage.get(i).getSamplePortion()+","+listResourceUsage.get(i).getAggregationType()+","+
				listResourceUsage.get(i).getSampledCPUusage()+"\n");
		for(int j=i+1;j<listResourceUsage.size();j++) {
			if((jobId==listResourceUsage.get(j).getJobId())&&(taskIndex==listResourceUsage.get(j).getTaskIndex())){
				writer.write(listResourceUsage.get(j).getStartTime()+","+listResourceUsage.get(j).getEndTime()+","+
						listResourceUsage.get(j).getJobId()+","+listResourceUsage.get(j).getTaskIndex()+","+listResourceUsage.get(j).getMachineId()+","+
								listResourceUsage.get(j).getMeanCPUUsageRate()+","+listResourceUsage.get(j).getCanonicalMemoryUsage()+","+
						listResourceUsage.get(j).getAssignedMemoryUsage()+","+listResourceUsage.get(j).getUnmappedPageCacheMemoryUsage()+","+
								listResourceUsage.get(j).getTotalPageCacheMemoryUsage()+","+listResourceUsage.get(j).getMaximumMemoryUsage()+","+
						listResourceUsage.get(j).getMeanDiskInputOutputTime()+","+listResourceUsage.get(j).getMeanLocalDiskSpaceUsed()+","+
								listResourceUsage.get(j).getMaximumCPUUsage()+","+listResourceUsage.get(j).getMaximumDiskIOTime()+","+
								listResourceUsage.get(j).getCyclePerInstruction()+","+ listResourceUsage.get(j).getMemoryAccessPerInstruction()+","+
								listResourceUsage.get(j).getSamplePortion()+","+listResourceUsage.get(j).getAggregationType()+","+
								listResourceUsage.get(j).getSampledCPUusage()+"\n");	
				listResourceUsage.remove(j);
				
							}
			//6252617448

			else {
				continue;
			}
		}
	}
	writer.flush();
	writer.close();
	System.out.println("Wrote");
	}
}
//Data should be loaded from scratch 
public static void main(String[] args) throws IOException {
	ResourceArrangement resourceArrangement= new ResourceArrangement();
	resourceArrangement.resourceDataPreProcessing();
}
}
