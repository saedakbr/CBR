package com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.JobEvent;
import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.MachineAttribute;
import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.MachineEvent;
import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.ResourceUsage;
import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.TaskConstraint;
import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.TaskEvent;

public class RetriveDataFromFile {
	public ArrayList<MachineAttribute> machineAttribute() throws IOException {
		BufferedReader reader = FileAddress
				.readingNewFile("C:\\Users\\Adeel Aslam\\Desktop\\DataSciensit\\machineAttribute"); // neeed correction
		String line = null;
		Scanner scanner = null;
		int index = 0;
		ArrayList<MachineAttribute> listMachineAttribute = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			MachineAttribute machineAttribute = new MachineAttribute();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0)
				if (index == 1)
				if (index == 2)
				if (index == 3)		
				if (index == 4)	
				if (index == 5)	
				if (index == 6)
				if (index == 7)
				if (index == 8)
				if (index == 9)
				if (index == 10)					
				if (index == 11)
				if (index == 12)						
				if (index == 13)
				if (index == 14)
				if (index == 15)
				if (index == 16)
				if (index == 17)							
				if (index == 18)
				if (index == 19)				
				index++;
			}
			index = 0;
			listMachineAttribute.add(machineAttribute);
		}
		reader.close();

		return listMachineAttribute;
	}
	public ArrayList<JobEvent> jobEvents(String path) throws IOException {
		BufferedReader reader = FileAddress
				.readingNewFile(path); // need correct address
		System.out.println("PAth");
		String line = null;
		Scanner scanner = null;
		int index = 0;		
		ArrayList<JobEvent> listJobEvent = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			JobEvent jobEvent = new JobEvent();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				//System.out.println(data);
				if (index == 0)
					//System.out.println(data);
					//jobEvent.setTimeStamp(0);
				if (index == 1)	
					if(data==null) {
						//System.out.println("no values");
					}
					//System.out.println(data);
				if (index == 2) {
					if(data==null) {
						jobEvent.setJobID(0);
						
					}
					else {
						try {
						//System.out.println("value2 "+Long.parseLong(data));	
					jobEvent.setJobID(Long.parseLong(data));
					//System.out.println(jobEvent.getJobID());
						}
						catch (NumberFormatException e) {
							// TODO: handle exception
							jobEvent.setJobID(0);
						}
					}
				}
				if (index == 3)	
					//System.out.println("b"+ data);
					//jobEvent.setEventType(Integer.parseInt(data));
				if (index == 4)	
					System.out.println(data);
				if (index == 5)	{
					jobEvent.setSchedulingClass(Integer.parseInt(data));
					//System.out.println(data+"gg");
						
				}
				index++;
			}
			index = 0;
			listJobEvent.add(jobEvent);
		}
		reader.close();

		return listJobEvent;
	}
	public ArrayList<ResourceUsage> resourceUsage(String path) throws IOException {
		BufferedReader reader = FileAddress
				.readingNewFile(path); // need correct address
		String line = null;
		Scanner scanner = null;
		int index = 0;
		ArrayList<ResourceUsage> listResourceUsage = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			ResourceUsage resourceUsage = new ResourceUsage();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0) {
					if(data==null) {
						resourceUsage.setStartTime(0);
					}else {
						try {
					resourceUsage.setStartTime(Long.parseLong(data));
						}
						catch (NumberFormatException e) {
							// TODO: handle exception
							resourceUsage.setStartTime(0);
						}
					//System.out.println("time"+resourceUsage.getStartTime());
				}}
				
				if (index == 1) {
					if(data==null) {
						resourceUsage.setEndTime(0);
					}
					else {
						try {
					resourceUsage.setEndTime(Long.parseLong(data));
						}
						catch (NumberFormatException e) {
							// TODO: handle exception
							resourceUsage.setEndTime(0);
						}
					//System.out.println("end "+resourceUsage.getEndTime());
				}}
				if (index == 2) {
					if(data==null) {
						resourceUsage.setJobId(0);
					}else {
						try {
					resourceUsage.setJobId(Long.parseLong(data));
					
					//System.out.println("JobID"+ resourceUsage.getJobId());
						}
						catch (Exception e) {
							// TODO: handle exception
							resourceUsage.setJobId(0);
						}
				}}
				if (index == 3)	{
					if(data==null) {
						resourceUsage.setTaskIndex(0);
					}else {
						try {
					resourceUsage.setTaskIndex(Integer.parseInt(data));
						}
						catch (Exception e) {
							// TODO: handle exception
							resourceUsage.setTaskIndex(0);
						}
					//System.out.println("JobID"+ resourceUsage.getTaskIndex());
				}}
				if (index == 4)	{
					if(data==null) {
						resourceUsage.setMachineId(0);
					}else {
						try {
					resourceUsage.setMachineId(Long.parseLong(data));
						}
						catch (Exception e) {
							// TODO: handle exception
							resourceUsage.setMachineId(0);
						}
					//System.out.println("JobID"+ resourceUsage.getMachineId());
				}}
				if (index == 5)	{
					if(data==null) {
						resourceUsage.setMeanCPUUsageRate(0);
					}else {
						try {
					resourceUsage.setMeanCPUUsageRate(Double.parseDouble(data));
						}
						catch (Exception e) {
							// TODO: handle exception
							resourceUsage.setMeanCPUUsageRate(0);
						}
					//System.out.println("JobID"+ resourceUsage.getMeanCPUUsageRate());
				}}
				if (index == 6) {
					if(data==null) {
						resourceUsage.setCanonicalMemoryUsage(0);
					}else {
						try {
					resourceUsage.setCanonicalMemoryUsage(Double.parseDouble(data));
						}
						catch (Exception e) {
							// TODO: handle exception
							resourceUsage.setCanonicalMemoryUsage(0);
						}
				//	System.out.println("JobID"+ resourceUsage.getCanonicalMemoryUsage());
				}}
				if (index == 7) {
					if(data==null) {
						resourceUsage.setAssignedMemoryUsage(0);
					}else {
						try {
					resourceUsage.setAssignedMemoryUsage(Double.parseDouble(data));
						}
						catch (Exception e) {
							// TODO: handle exception
							resourceUsage.setAssignedMemoryUsage(0);
						}
					//System.out.println("JobID"+ resourceUsage.getAssignedMemoryUsage());
				}}
						if (index == 8) {
							if(data==null) {
								resourceUsage.setUnmappedPageCacheMemoryUsage(0);
							}else {
								try {
							resourceUsage.setUnmappedPageCacheMemoryUsage(Double.parseDouble(data));
								}
								catch (Exception e) {
									// TODO: handle exception
									resourceUsage.setUnmappedPageCacheMemoryUsage(0);
								}
							//System.out.println("JobID"+ resourceUsage.getUnmappedPageCacheMemoryUsage());
						}}
				if (index == 9) {
					if(data==null) {
						resourceUsage.setTotalPageCacheMemoryUsage(0);
					}else {
						try {
					resourceUsage.setTotalPageCacheMemoryUsage(Double.parseDouble(data));
						}
						catch (Exception e) {
							// TODO: handle exception
							resourceUsage.setTotalPageCacheMemoryUsage(0);
						}
				//	System.out.println("JobID"+ resourceUsage.getTotalPageCacheMemoryUsage());
				}}
				if (index == 10) {
					if(data==null) {
						resourceUsage.setMaximumMemoryUsage(0);
					}else {
						try {
					resourceUsage.setMaximumMemoryUsage(Double.parseDouble(data));
						}
						catch (Exception e) {
							// TODO: handle exception
							resourceUsage.setMaximumMemoryUsage(0);
						}
					//System.out.println("JobID"+ resourceUsage.getMaximumMemoryUsage());
				}}
					
				if (index == 11) {
					if(data==null) {
						resourceUsage.setMeanDiskInputOutputTime(0);
					}else {
						try {
					resourceUsage.setMeanDiskInputOutputTime(Double.parseDouble(data));
						}
						catch (Exception e) {
							// TODO: handle exception
							resourceUsage.setMeanDiskInputOutputTime(0);
						}
				//	System.out.println("JobID"+ resourceUsage.getMeanDiskInputOutputTime());
					
				}}
				if (index == 12) {
					if(data==null) {
						resourceUsage.setMeanLocalDiskSpaceUsed(0);
					}else {
						try {
					resourceUsage.setMeanLocalDiskSpaceUsed(Double.parseDouble(data));
						}
						catch (Exception e) {
							// TODO: handle exception
							resourceUsage.setMeanLocalDiskSpaceUsed(0);
						}
				//	System.out.println("JobID"+ resourceUsage.getMeanLocalDiskSpaceUsed());
				}}
				if (index == 13) {
					if(data==null) {
						resourceUsage.setMaximumCPUUsage(0);
					}
					else {
						try {
					resourceUsage.setMaximumCPUUsage(Double.parseDouble(data));
						}
						catch (Exception e) {
							// TODO: handle exception
							resourceUsage.setMaximumCPUUsage(0);
						}
				//	System.out.println("JobID"+ resourceUsage.getMaximumCPUUsage());
				}}
				if (index == 14)
				{
					if(data==null) {
						resourceUsage.setMaximumDiskIOTime(0);
					}else {
						try {
							resourceUsage.setMaximumDiskIOTime(Double.parseDouble(data));
						}
						catch (Exception e) {
							// TODO: handle exception
							resourceUsage.setMaximumDiskIOTime(0);
						}
					
					//System.out.println("JobID"+ resourceUsage.getMaximumDiskIOTime());
				}}
				if (index == 15) {
					if(data==null) {
						resourceUsage.setCyclePerInstruction(0);
					}else {
						try {
					resourceUsage.setCyclePerInstruction(Double.parseDouble(data));
						}
						catch (Exception e) {
							// TODO: handle exception
							resourceUsage.setCyclePerInstruction(0);
						}
					//System.out.println("JobID"+ resourceUsage.getCyclePerInstruction());
				}}
				if (index == 16) {
					if(data=="") {
						resourceUsage.setMemoryAccessPerInstruction(0);
					}
					//if(Exception==NumberFormatException)
					else {
						try {
					resourceUsage.setMemoryAccessPerInstruction(Double.parseDouble(data));
						}
						catch (NumberFormatException e) {
							// TODO: handle exception
							resourceUsage.setMemoryAccessPerInstruction(0);
						}
					//System.out.println("JobID"+ resourceUsage.getMemoryAccessPerInstruction());
				}}
				if (index == 17)	{	
					if(data==null) {
						resourceUsage.setSamplePortion(0);
					}
					else {
						try {
					resourceUsage.setSamplePortion(Double.parseDouble(data));
						}
						catch (Exception e) {
							// TODO: handle exception
							resourceUsage.setSamplePortion(0);
						}
					//System.out.println("JobID"+ resourceUsage.getSamplePortion());
					}
				}
				if (index == 18) {
					if(data==null) {
						resourceUsage.setAggregationType(0);
					}
					else {
						try {
					resourceUsage.setAggregationType(Double.parseDouble(data));
						}
						catch (Exception e) {
							// TODO: handle exception
							resourceUsage.setAggregationType(0);
						}
					//System.out.println("JobID"+ resourceUsage.getAggregationType());
					}
				}
			if (index == 19) {
				if(data==null) {
					resourceUsage.setSampledCPUusage(0);
				} 
				else {
					try {
						resourceUsage.setSampledCPUusage(Double.parseDouble(data));
					}
					catch (Exception e) {
						// TODO: handle exception
						resourceUsage.setSampledCPUusage(0);
					}
				
				//System.out.println("JobID"+ resourceUsage.getSampledCPUusage());
				}
			}
				index++;
			}
			index = 0;
			listResourceUsage.add(resourceUsage);
		}
		reader.close();

		return listResourceUsage;
	}
	public ArrayList<MachineEvent> machineEvent() throws IOException {
		BufferedReader reader = FileAddress
				.readingNewFile("C:\\Users\\Adeel Aslam\\Desktop\\DataSciensit\\job events"); // need correct address
		String line = null;
		Scanner scanner = null;
		int index = 0;
	
		ArrayList<MachineEvent> listMachineEvent = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			MachineEvent machineEvent = new MachineEvent();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0)
				if (index == 1)
				if (index == 2)
				if (index == 3)		
				if (index == 4)	
				if (index == 5)	
				if (index == 6)
				if (index == 7)
				if (index == 8)
				if (index == 9)
				if (index == 10)					
				if (index == 11)
				if (index == 12)						
				if (index == 13)
				if (index == 14)
				if (index == 15)
				if (index == 16)
				if (index == 17)							
				if (index == 18)
				if (index == 19)				
				index++;
			}
			index = 0;
			listMachineEvent.add(machineEvent);
		}
		reader.close();

		return listMachineEvent;
	}
	public ArrayList<TaskConstraint> taskConstraint() throws IOException {
		BufferedReader reader = FileAddress
				.readingNewFile("C:\\Users\\Adeel Aslam\\Desktop\\DataSciensit\\job events"); // need correct address
		String line = null;
		Scanner scanner = null;
		int index = 0;
		
		ArrayList<TaskConstraint> listTaskConstraint = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			TaskConstraint taskConstraint = new TaskConstraint();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0)
					taskConstraint.setTimeStamp(Long.parseLong(data));
				if (index == 1)
					taskConstraint.setJobId(Integer.parseInt(data));
				if (index == 2)
					taskConstraint.setTaskIndex(Integer.parseInt(data));
						
				index++;
			}
			index = 0;
			listTaskConstraint.add(taskConstraint);
		}
		reader.close();

		return listTaskConstraint;
	}
	public ArrayList<TaskEvent> taskEvent() throws IOException {
		BufferedReader reader = FileAddress
				.readingNewFile("C:\\Users\\Adeel Aslam\\Desktop\\DataSciensit\\job events"); // need correct address
		String line = null;
		Scanner scanner = null;
		int index = 0;
		
		ArrayList<TaskEvent> listTaskEvent = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			TaskEvent taskEvent = new TaskEvent();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0)
					taskEvent.setTimeStamps(Long.parseLong(data));
				if (index == 1)
//					taskEvent.setJobId(Integer.parseInt(data));
				if (index == 2)
					taskEvent.setJobId(Integer.parseInt(data));
					
				if (index == 3)
					taskEvent.setTaskIndex(Integer.parseInt(data));
					
				if (index == 4)	
					taskEvent.setMachineId(Integer.parseInt(data));
				
				if (index == 5)	

					taskEvent.setEventType(Long.parseLong(data));
					
				if (index == 6)
					//taskEvent.setSechedulingClass(Integer.parseInt(data));
				if (index == 7)
					taskEvent.setSechedulingClass(Integer.parseInt(data));
				if (index == 8)
					taskEvent.setPriority(Integer.parseInt(data));
				if (index == 9)
					taskEvent.setResourceRequestForCPU(Double.parseDouble(data));
				if (index == 10)
					taskEvent.setResourceRequestForRAM(Double.parseDouble(data));
				if (index == 11)
					taskEvent.setResourceRequestForLocalDiskSpace(Double.parseDouble(data));
							
				index++;
			}
			index = 0;
			listTaskEvent.add(taskEvent);
		}
		reader.close();

		return listTaskEvent;
		

	}
	public static void Logic(String[] args) {
		//int [] array= new int[] {1,2,3,1,4,1,5,4};
		ArrayList<Integer> arrayListint = new ArrayList<>();
		
		for(int i=0;i<arrayListint.size();i++) {
			int a= arrayListint.get(i);
			for(int j=i+1;j<arrayListint.size();j++) {
				if (a==arrayListint.get(j)) {
					System.out.println(a+"space"+ arrayListint.get(j));
					arrayListint.remove(j);
							
					
				}
				else {
					continue;
				}
			}
			for(int k=0;k<arrayListint.size();k++)
			System.out.println("Printing of array"+arrayListint.get(k));
		}
	}
	}
