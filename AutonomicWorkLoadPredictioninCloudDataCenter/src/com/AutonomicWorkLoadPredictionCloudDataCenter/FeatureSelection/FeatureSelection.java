package com.AutonomicWorkLoadPredictionCloudDataCenter.FeatureSelection;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.ResourceUsage;
import com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading.FileAddress;
import com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading.RetriveDataFromFile;

public class FeatureSelection {
public void resourceSelection() throws IOException {
	BufferedWriter bufferedWriter= FileAddress.writingNewFile("TotalResoure\\FeatureSelectionFile.csv");
	bufferedWriter.write("MeanCPUUsage"+","+"CannocialMemoryUsage"+","+"AssignedMemoryUsage"+","+
	"UnmappedPagedCacheMemoryUsage"+","+"TotalPagedCacheMemoryUsage"+","+"MaximumMemoryUsage"+","+
			"MeanDiskInputOutputTime"+","+"MeanLocalDiskSpaceUsed"+","+"MaximumCPUUsage"+","+
	"MaximumDiskInputOutputTime"+","+"CyclesPerInstruction"+","+"MemoryAccessPerInstruction"+","+
			"SamplePortion"+","+"AggregationType"+","+"SampledCPUUsage"+"\n");
	ArrayList<ResourceUsage> listResource= new RetriveDataFromFile().resourceUsage("TotalResoure\\File.csv");
	for(int i=1;i<listResource.size();i++) {
		bufferedWriter.write(listResource.get(i).getMeanCPUUsageRate()+","+listResource.get(i).getCanonicalMemoryUsage()+","+
listResource.get(i).getAssignedMemoryUsage()+","+listResource.get(i).getUnmappedPageCacheMemoryUsage()+","+
				listResource.get(i).getTotalPageCacheMemoryUsage()+","+listResource.get(i).getMaximumMemoryUsage()+","+
				listResource.get(i).getMeanDiskInputOutputTime()+","+listResource.get(i).getMeanLocalDiskSpaceUsed()+","+
				listResource.get(i).getMaximumCPUUsage()+","+listResource.get(i).getMaximumDiskIOTime()+","+
				listResource.get(i).getCyclePerInstruction()+","+listResource.get(i).getMemoryAccessPerInstruction()+","+
				listResource.get(i).getSamplePortion()+","+listResource.get(i).getAggregationType()+","+listResource.get(i).getSampledCPUusage()+"\n");
	}
	bufferedWriter.flush();
	bufferedWriter.close();
}
public static void main(String[] args) throws IOException {
	FeatureSelection featureSelection= new FeatureSelection();
	featureSelection.resourceSelection();
}
}
