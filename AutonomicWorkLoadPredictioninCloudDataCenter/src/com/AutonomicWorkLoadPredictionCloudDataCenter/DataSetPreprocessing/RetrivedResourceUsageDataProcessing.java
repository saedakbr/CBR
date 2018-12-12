package com.AutonomicWorkLoadPredictionCloudDataCenter.DataSetPreprocessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.ResourceUsage;
import com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading.FileAddress;
import com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading.RetriveDataFromFile;

public class RetrivedResourceUsageDataProcessing {
	public void retrivedResourceUsageDataProcessing () throws IOException {
		for(int m=18;m<=19;m++) {
		BufferedWriter writer= FileAddress.writingNewFile("Output2\\File"+m+".csv");
		writer.write("StartTimeOfMeasurementPeriod"+","+"EndTimeOfMeasuremmentPeriod"+","+
		"JobId"+","+"TaskIndex"+","+"MachineId"+","+"MeanCPUUsageRate"+","+"CanonicalMemoryUsage"+","+
				"AssignedMemoryUsage"+","+"UnMappedPagedCacheMemoryUsage"+","+"TotalPagedCacheMemoryUsage"+","+
		"MaximumMemoryUsage"+","+"MeanDiskInputOutputTime"+","+"MeanLocalDiskSpaceUsed"+","+
				"MaximumCPUUsage"+","+"MaximumDiskInputOutputTime"+","+"CyclesPerInstruction"+","+
		"MemoryAccessPerInstruction"+","+"SamplePortion"+","+"AggregationType"+","+"SampledCPUUsage"+","+"\n");
		System.out.println("DataLoading");
		ArrayList<ResourceUsage> listResourceUsage= new RetriveDataFromFile().resourceUsage("Output\\File"+m+".csv");
		System.out.println("Start");
		System.out.println(listResourceUsage.size());
outerloop:		for(int i=1;i<listResourceUsage.size();i++) {
			//System.out.println("here outer loop");
			long jobId= listResourceUsage.get(i).getJobId();
			int taskIndex= listResourceUsage.get(i).getTaskIndex();
			double meanCpuUsageRate= listResourceUsage.get(i).getMeanCPUUsageRate();
			double canonicalMemoryUsage= listResourceUsage.get(i).getCanonicalMemoryUsage();
			double assignedMemoryUsage= listResourceUsage.get(i).getAssignedMemoryUsage();
			double unMappedPagedCacheMemory= listResourceUsage.get(i).getUnmappedPageCacheMemoryUsage();
			double totalPageCacheMemoryUsage= listResourceUsage.get(i).getTotalPageCacheMemoryUsage();
			double maximumMemoryUsage= listResourceUsage.get(i).getMaximumMemoryUsage();
			double meanDiskInputOutputTime= listResourceUsage.get(i).getMeanDiskInputOutputTime();
			double meanLocalDiskSpaceUsed= listResourceUsage.get(i).getMeanLocalDiskSpaceUsed();
			double maximumCpuUsage= listResourceUsage.get(i).getMaximumCPUUsage();
			double maximumDiskIOTime= listResourceUsage.get(i).getMaximumDiskIOTime();
			double cyclePerInstruction= listResourceUsage.get(i).getCyclePerInstruction();
			double memoryAccessPerInstruction= listResourceUsage.get(i).getMemoryAccessPerInstruction();
			double samplePortion = listResourceUsage.get(i).getSamplePortion();
			double aggregationType= listResourceUsage.get(i).getAggregationType();
			double sampledCPUPortion= listResourceUsage.get(i).getSampledCPUusage();
			long endtime= listResourceUsage.get(i).getEndTime();
		innerloop:	for(int j=i+1;j<listResourceUsage.size();j++) {
				if((jobId==listResourceUsage.get(j).getJobId())&&(taskIndex==listResourceUsage.get(j).getTaskIndex())) {
					endtime= listResourceUsage.get(j).getEndTime();
					meanCpuUsageRate= meanCpuUsageRate+listResourceUsage.get(j).getMeanCPUUsageRate();
					canonicalMemoryUsage= canonicalMemoryUsage+listResourceUsage.get(j).getCanonicalMemoryUsage();
					assignedMemoryUsage= assignedMemoryUsage+ listResourceUsage.get(j).getAssignedMemoryUsage();
					unMappedPagedCacheMemory= unMappedPagedCacheMemory+listResourceUsage.get(j).getUnmappedPageCacheMemoryUsage();
					totalPageCacheMemoryUsage= totalPageCacheMemoryUsage+listResourceUsage.get(j).getTotalPageCacheMemoryUsage();
					maximumMemoryUsage= maximumMemoryUsage+listResourceUsage.get(j).getMaximumMemoryUsage();
					meanDiskInputOutputTime= meanDiskInputOutputTime+listResourceUsage.get(j).getMeanDiskInputOutputTime();
					meanLocalDiskSpaceUsed= meanLocalDiskSpaceUsed+listResourceUsage.get(j).getMeanLocalDiskSpaceUsed();
					maximumCpuUsage=maximumCpuUsage+listResourceUsage.get(j).getMaximumCPUUsage();
					maximumDiskIOTime=maximumDiskIOTime+listResourceUsage.get(j).getMaximumDiskIOTime();
					cyclePerInstruction=cyclePerInstruction+listResourceUsage.get(j).getCyclePerInstruction();
					memoryAccessPerInstruction=memoryAccessPerInstruction+listResourceUsage.get(j).getMemoryAccessPerInstruction();
					samplePortion=samplePortion+listResourceUsage.get(j).getSamplePortion();
					aggregationType=aggregationType+listResourceUsage.get(j).getAggregationType();
					sampledCPUPortion=sampledCPUPortion+listResourceUsage.get(j).getSampledCPUusage();
					//System.out.println("removing index"+j);
					listResourceUsage.remove(j);
					j--;
					
					
				}
				else {
					//System.out.println(j+" index");
					break innerloop;
				}
				
			}
			writer.write(listResourceUsage.get(i).getStartTime()+","+endtime+","+
					listResourceUsage.get(i).getJobId()+","+listResourceUsage.get(i).getTaskIndex()+","+listResourceUsage.get(i).getMachineId()+","+
					meanCpuUsageRate+","+canonicalMemoryUsage+","+assignedMemoryUsage+","+unMappedPagedCacheMemory+","+
					totalPageCacheMemoryUsage+","+maximumMemoryUsage+","+meanDiskInputOutputTime+","+
					meanLocalDiskSpaceUsed+","+maximumCpuUsage+","+maximumDiskIOTime+","+cyclePerInstruction+","+memoryAccessPerInstruction+","+
					samplePortion+","+aggregationType+","+sampledCPUPortion+"\n");
			
			
		}
		writer.flush();
		writer.close();
		System.out.println("wrote");
	}}
//	public static void main(String[] args) throws IOException {
//		RetrivedResourceUsageDataProcessing rrUSDP= new RetrivedResourceUsageDataProcessing();
//		rrUSDP.retrivedResourceUsageDataProcessing();
//	}
	public static void test() {
		ArrayList<Integer> list= new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(4);
		list.add(1);
		list.add(1);
		int n=0;
		 int q= 9;
		 for(int i=0;i<list.size();i++){
			 n=1;
		        for(int j=i+1;j<list.size();j++){
		            if(list.get(i).equals(list.get(j))){
		                list.remove(j);
		                j--;
		                n++;
		            }
		           
		        }
System.out.println("After Removing duplicate:"+n);
		    }
		    
	}
//	public static void main(String[] args) {
//		test();
//	}
public void finilizeData() throws IOException {
	for(int k=2;k<=15;k++) {
	BufferedWriter writer= FileAddress.writingNewFile("OutputResource2\\outputresource"+k+".csv");
	writer.write("StartTimeOfMeasurementPeriod"+","+"EndTimeOfMeasuremmentPeriod"+","+
	"JobId"+","+"TaskIndex"+","+"MachineId"+","+"MeanCPUUsageRate"+","+"CanonicalMemoryUsage"+","+
			"AssignedMemoryUsage"+","+"UnMappedPagedCacheMemoryUsage"+","+"TotalPagedCacheMemoryUsage"+","+
	"MaximumMemoryUsage"+","+"MeanDiskInputOutputTime"+","+"MeanLocalDiskSpaceUsed"+","+
			"MaximumCPUUsage"+","+"MaximumDiskInputOutputTime"+","+"CyclesPerInstruction"+","+
	"MemoryAccessPerInstruction"+","+"SamplePortion"+","+"AggregationType"+","+"SampledCPUUsage"+","+"\n");
	System.out.println("DataLoading");
	ArrayList<ResourceUsage> listResourceUsage= new RetriveDataFromFile().resourceUsage("Output2\\File"+k+".csv");
	System.out.println("Start");
	System.out.println(listResourceUsage.size());
outerloop:		for(int i=1;i<listResourceUsage.size();i++) {
		//System.out.println("here outer loop");
		long jobId= listResourceUsage.get(i).getJobId();
		int taskIndex= listResourceUsage.get(i).getTaskIndex();
		double meanCpuUsageRate= listResourceUsage.get(i).getMeanCPUUsageRate();
		double canonicalMemoryUsage= listResourceUsage.get(i).getCanonicalMemoryUsage();
		double assignedMemoryUsage= listResourceUsage.get(i).getAssignedMemoryUsage();
		double unMappedPagedCacheMemory= listResourceUsage.get(i).getUnmappedPageCacheMemoryUsage();
		double totalPageCacheMemoryUsage= listResourceUsage.get(i).getTotalPageCacheMemoryUsage();
		double maximumMemoryUsage= listResourceUsage.get(i).getMaximumMemoryUsage();
		double meanDiskInputOutputTime= listResourceUsage.get(i).getMeanDiskInputOutputTime();
		double meanLocalDiskSpaceUsed= listResourceUsage.get(i).getMeanLocalDiskSpaceUsed();
		double maximumCpuUsage= listResourceUsage.get(i).getMaximumCPUUsage();
		double maximumDiskIOTime= listResourceUsage.get(i).getMaximumDiskIOTime();
		double cyclePerInstruction= listResourceUsage.get(i).getCyclePerInstruction();
		double memoryAccessPerInstruction= listResourceUsage.get(i).getMemoryAccessPerInstruction();
		double samplePortion = listResourceUsage.get(i).getSamplePortion();
		double aggregationType= listResourceUsage.get(i).getAggregationType();
		double sampledCPUPortion= listResourceUsage.get(i).getSampledCPUusage();
		long endtime= listResourceUsage.get(i).getEndTime();
	innerloop:	for(int j=i+1;j<listResourceUsage.size();j++) {
			if((jobId==listResourceUsage.get(j).getJobId())&&(taskIndex==listResourceUsage.get(j).getTaskIndex())) {
				//endtime= listResourceUsage.get(j).getEndTime();
				meanCpuUsageRate= meanCpuUsageRate+listResourceUsage.get(j).getMeanCPUUsageRate();
				canonicalMemoryUsage= canonicalMemoryUsage+listResourceUsage.get(j).getCanonicalMemoryUsage();
				assignedMemoryUsage= assignedMemoryUsage+ listResourceUsage.get(j).getAssignedMemoryUsage();
				unMappedPagedCacheMemory= unMappedPagedCacheMemory+listResourceUsage.get(j).getUnmappedPageCacheMemoryUsage();
				totalPageCacheMemoryUsage= totalPageCacheMemoryUsage+listResourceUsage.get(j).getTotalPageCacheMemoryUsage();
				maximumMemoryUsage= maximumMemoryUsage+listResourceUsage.get(j).getMaximumMemoryUsage();
				meanDiskInputOutputTime= meanDiskInputOutputTime+listResourceUsage.get(j).getMeanDiskInputOutputTime();
				meanLocalDiskSpaceUsed= meanLocalDiskSpaceUsed+listResourceUsage.get(j).getMeanLocalDiskSpaceUsed();
				maximumCpuUsage=maximumCpuUsage+listResourceUsage.get(j).getMaximumCPUUsage();
				maximumDiskIOTime=maximumDiskIOTime+listResourceUsage.get(j).getMaximumDiskIOTime();
				cyclePerInstruction=cyclePerInstruction+listResourceUsage.get(j).getCyclePerInstruction();
				memoryAccessPerInstruction=memoryAccessPerInstruction+listResourceUsage.get(j).getMemoryAccessPerInstruction();
				samplePortion=samplePortion+listResourceUsage.get(j).getSamplePortion();
				aggregationType=aggregationType+listResourceUsage.get(j).getAggregationType();
				sampledCPUPortion=sampledCPUPortion+listResourceUsage.get(j).getSampledCPUusage();
				//System.out.println("removing index"+j);
				listResourceUsage.remove(j);
				j--;
				
				
			}
			
			
		}
		writer.write(listResourceUsage.get(i).getStartTime()+","+listResourceUsage.get(i).getEndTime()+","+
				listResourceUsage.get(i).getJobId()+","+listResourceUsage.get(i).getTaskIndex()+","+listResourceUsage.get(i).getMachineId()+","+
				meanCpuUsageRate+","+canonicalMemoryUsage+","+assignedMemoryUsage+","+unMappedPagedCacheMemory+","+
				totalPageCacheMemoryUsage+","+maximumMemoryUsage+","+meanDiskInputOutputTime+","+
				meanLocalDiskSpaceUsed+","+maximumCpuUsage+","+maximumDiskIOTime+","+cyclePerInstruction+","+memoryAccessPerInstruction+","+
				samplePortion+","+aggregationType+","+sampledCPUPortion+"\n");
		
		
	}
	writer.flush();
	writer.close();
	System.out.println("wrote");
	}
}
public static void main(String[] args) throws IOException {
	RetrivedResourceUsageDataProcessing rt= new RetrivedResourceUsageDataProcessing();

rt.finilizeData();
}
}
