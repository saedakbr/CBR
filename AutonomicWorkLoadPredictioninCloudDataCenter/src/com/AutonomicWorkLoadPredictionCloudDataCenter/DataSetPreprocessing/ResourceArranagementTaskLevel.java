package com.AutonomicWorkLoadPredictionCloudDataCenter.DataSetPreprocessing;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.ResourceUsage;
import com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading.FileAddress;
import com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading.RetriveDataFromFile;

public class ResourceArranagementTaskLevel {
	public void resourceArrangementTaskLevel() throws IOException {
		for(int k=14;k<=15;k++) {
		BufferedWriter writer= FileAddress.writingNewFile("OutputResourceTaskLevel\\OutputResourceTaskLevel"+k+".csv");
		writer.write("StartTimeOfMeasurementPeriod"+","+"EndTimeOfMeasuremmentPeriod"+","+
		"JobId"+","+"TaskIndex"+","+"MachineId"+","+"MeanCPUUsageRate"+","+"CanonicalMemoryUsage"+","+
				"AssignedMemoryUsage"+","+"UnMappedPagedCacheMemoryUsage"+","+"TotalPagedCacheMemoryUsage"+","+
		"MaximumMemoryUsage"+","+"MeanDiskInputOutputTime"+","+"MeanLocalDiskSpaceUsed"+","+
				"MaximumCPUUsage"+","+"MaximumDiskInputOutputTime"+","+"CyclesPerInstruction"+","+
		"MemoryAccessPerInstruction"+","+"SamplePortion"+","+"AggregationType"+","+"SampledCPUUsage"+","+"\n");
		System.out.println("DataLoading");
		ArrayList<ResourceUsage> listResourceUsage= new RetriveDataFromFile().resourceUsage("OutputResource2\\outputresource"+k+".csv");
		System.out.println("Start");
		System.out.println(listResourceUsage.size());
	outerloop:		for(int i=1;i<listResourceUsage.size();i++) {
		int size=1;
			//System.out.println("here outer loop");
			long jobId= listResourceUsage.get(i).getJobId();
			//int taskIndex= listResourceUsage.get(i).getTaskIndex();
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
				if((jobId==listResourceUsage.get(j).getJobId())) {
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
					size++;
					listResourceUsage.remove(j);
					j--;
					
					
				}
				
				
			}
			meanCpuUsageRate= meanCpuUsageRate/size;
			canonicalMemoryUsage= canonicalMemoryUsage/size;
			assignedMemoryUsage= assignedMemoryUsage/size;
			unMappedPagedCacheMemory= unMappedPagedCacheMemory/size;
			totalPageCacheMemoryUsage= totalPageCacheMemoryUsage/size;
			maximumMemoryUsage= maximumMemoryUsage/size;
			meanDiskInputOutputTime= meanDiskInputOutputTime/size;
			meanLocalDiskSpaceUsed= meanLocalDiskSpaceUsed/size;
			maximumCpuUsage=maximumCpuUsage/size;
			maximumDiskIOTime=maximumDiskIOTime/size;
			cyclePerInstruction=cyclePerInstruction/size;
			memoryAccessPerInstruction=memoryAccessPerInstruction/size;
			samplePortion=samplePortion/size;
			aggregationType=aggregationType/size;
			sampledCPUPortion=sampledCPUPortion/size;
			writer.write(listResourceUsage.get(i).getStartTime()+","+listResourceUsage.get(i).getEndTime()+","+
					listResourceUsage.get(i).getJobId()+","+size+","+listResourceUsage.get(i).getMachineId()+","+
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
		ResourceArranagementTaskLevel resourceArrangementTaskLevel= new ResourceArranagementTaskLevel();
		resourceArrangementTaskLevel.resourceArrangementTaskLevel1();
	}
	public void resourceArrangementTaskLevel1() throws IOException {
		for(int k=1;k<=15;k++) {
		BufferedWriter writer= FileAddress.writingNewFile("OutputResourceTaskLevel1\\File"+k+".csv");
		writer.write("StartTimeOfMeasurementPeriod"+","+"EndTimeOfMeasuremmentPeriod"+","+
		"JobId"+","+"TaskIndex"+","+"MachineId"+","+"MeanCPUUsageRate"+","+"CanonicalMemoryUsage"+","+
				"AssignedMemoryUsage"+","+"UnMappedPagedCacheMemoryUsage"+","+"TotalPagedCacheMemoryUsage"+","+
		"MaximumMemoryUsage"+","+"MeanDiskInputOutputTime"+","+"MeanLocalDiskSpaceUsed"+","+
				"MaximumCPUUsage"+","+"MaximumDiskInputOutputTime"+","+"CyclesPerInstruction"+","+
		"MemoryAccessPerInstruction"+","+"SamplePortion"+","+"AggregationType"+","+"SampledCPUUsage"+","+"\n");
		System.out.println("DataLoading....");
		ArrayList<ResourceUsage> listResourceUsage= new RetriveDataFromFile().resourceUsage("OutputResourceTaskLevel\\OutputResourceTaskLevel"+k+".csv");
		System.out.println("Start");
		System.out.println(listResourceUsage.size());
	outerloop:		for(int i=1;i<listResourceUsage.size();i++) {
		int size=1;
			//System.out.println("here outer loop");
			//long jobId= listResourceUsage.get(i).getJobId();
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
				if((taskIndex==listResourceUsage.get(j).getTaskIndex())) {
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
					size++;
					listResourceUsage.remove(j);
					j--;
					
					
				}
				
				
			}
			meanCpuUsageRate= meanCpuUsageRate/size;
			canonicalMemoryUsage= canonicalMemoryUsage/size;
			assignedMemoryUsage= assignedMemoryUsage/size;
			unMappedPagedCacheMemory= unMappedPagedCacheMemory/size;
			totalPageCacheMemoryUsage= totalPageCacheMemoryUsage/size;
			maximumMemoryUsage= maximumMemoryUsage/size;
			meanDiskInputOutputTime= meanDiskInputOutputTime/size;
			meanLocalDiskSpaceUsed= meanLocalDiskSpaceUsed/size;
			maximumCpuUsage=maximumCpuUsage/size;
			maximumDiskIOTime=maximumDiskIOTime/size;
			cyclePerInstruction=cyclePerInstruction/size;
			memoryAccessPerInstruction=memoryAccessPerInstruction/size;
			samplePortion=samplePortion/size;
			aggregationType=aggregationType/size;
			sampledCPUPortion=sampledCPUPortion/size;
			writer.write(listResourceUsage.get(i).getStartTime()+","+listResourceUsage.get(i).getEndTime()+","+
					listResourceUsage.get(i).getJobId()+","+taskIndex+","+listResourceUsage.get(i).getMachineId()+","+
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
}
