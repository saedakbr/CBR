package com.AutonomicWorkLoadPredictionCloudDataCenter.DataSetPreprocessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.Job;
import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.JobTask;
import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.ResourceUsage;
import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.Task;
import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.TaskEvent;
import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.TrainTest;
import com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading.FileAddress;
import com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading.RetriveDataFromFile;
import com.autonomiccomputing.model.Input;
import com.autonomiccomputing.model.Output;

public class CombinedDataSet {
	public ArrayList<Job> listJob(String path) throws IOException {
		BufferedReader reader = FileAddress.readingNewFile(path); // need correct address
		String line = null;
		Scanner scanner = null;
		int index = 0;

		ArrayList<Job> listAddingJob = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			Job job = new Job();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0) {
					try {
						job.setJobID(Long.parseLong(data));
					} catch (NumberFormatException e) {
						// TODO: handle exception

						job.setJobID(0);
					}
				}
				if (index == 1) {

					try {
						job.setSchedulingClass(Integer.parseInt(data));
					} catch (NumberFormatException e) {
						job.setSchedulingClass(0);
					}

				}
				index++;
			}
			index = 0;
			listAddingJob.add(job);
		}
		reader.close();

		return listAddingJob;

	}

	public ArrayList<Task> listTask(String path) throws IOException {
		BufferedReader reader = FileAddress.readingNewFile(path); // need correct address
		String line = null;
		Scanner scanner = null;
		int index = 0;

		ArrayList<Task> listAddingTask = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			Task task = new Task();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0) {
					try {
						task.setJobID(Long.parseLong(data));
					} catch (NumberFormatException e) {
						// TODO: handle exception

						task.setJobID(0);
					}
				}
				if (index == 1) {

					try {
						task.setPriorities(Integer.parseInt(data));
					} catch (NumberFormatException e) {
						task.setPriorities(0);
					}

				}
				index++;
			}
			index = 0;
			listAddingTask.add(task);
		}
		reader.close();

		return listAddingTask;

	}

	public void addingTaskAndJob() throws IOException {
		BufferedWriter bufferedWriter = FileAddress.writingNewFile("CombinedData\\taskjob.csv");
		ArrayList<Job> listjob = new CombinedDataSet().listJob("JobFolder\\removeredudent.csv");
		ArrayList<Task> listTask = new CombinedDataSet().listTask("TotalTask\\FileTask.csv");
		bufferedWriter.write("JobId" + "," + "SechedulingClass" + "," + "Priority" + "\n");
		System.out.println("Start");
		for (int i = 1; i < listjob.size(); i++) {
			long jobid = listjob.get(i).getJobID();
			for (int k = 1; k < listTask.size(); k++) {
				if (jobid == listjob.get(k).getJobID()) {
					bufferedWriter.write(jobid + "," + listjob.get(i).getSchedulingClass() + ","
							+ listTask.get(k).getPriorities() + "\n");
				}
			}
		}
		bufferedWriter.flush();
		bufferedWriter.close();

	}

//	public static void main(String[] args) throws IOException {
//	//System.out.println("Size of created "+ new CombinedDataSet().finalDataSet().size());	
//	}

	public ArrayList<JobTask> listJobTask(String path) throws IOException {
		BufferedReader reader = FileAddress.readingNewFile(path); // need correct address
		String line = null;
		Scanner scanner = null;
		int index = 0;

		ArrayList<JobTask> listJobTask = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			JobTask jobTask = new JobTask();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0) {
					try {
						jobTask.setJobId(Long.parseLong(data));
					} catch (NumberFormatException e) {
						// TODO: handle exception

						jobTask.setJobId(0);
					}
				}
				if (index == 1) {

					try {
						jobTask.setSechdeulingClass(Integer.parseInt(data));
					} catch (NumberFormatException e) {
						jobTask.setSechdeulingClass(0);
					}

				}
				if (index == 2) {

					try {
						jobTask.setPriority(Integer.parseInt(data));
					} catch (NumberFormatException e) {
						jobTask.setPriority(0);
					}

				}
				index++;
			}
			index = 0;
			listJobTask.add(jobTask);
		}
		reader.close();

		return listJobTask;

	}

	public ArrayList<TrainTest> finalDataSet() throws IOException {
		ArrayList<TrainTest> listTrainTest = new ArrayList<>();
		int countone = 0;
		int counttwo = 0;
		ArrayList<Double> listMaximumDiskInputOutput= new ArrayList<>();
		BufferedWriter bufferedWriter = FileAddress.writingNewFile("CombinedData\\Task.csv");
		bufferedWriter.write("JobID" + "," + "No.ofTasks" + "," + "SechedulingClass" + "," + "Priority" + ","
				+ "AssignedMemoryUsage" + "," + "MemoryAccessPerInstruction" + "," + "MaximumDiskInputOutputTime" + ","
				+ "TotalPagedCacheMemoryUsage" + "," + "MaximumCPUUsage" + "," + "MeanLocalDiskSpaceUsed" + ","
				+ "CyclesPerInstruction" + "," + "MemoryAccessperInstructionClass" + "\n");
		ArrayList<JobTask> listJobTask = new CombinedDataSet().listJobTask("CombinedData\\taskjob.csv");
		ArrayList<ResourceUsage> listResourceUsage = new RetriveDataFromFile().resourceUsage("TotalResoure\\File.csv");
		//System.out.println("Start");
		for (int i = 1; i < listJobTask.size(); i++) {
			Output output = null;
			Input input = null;
			//System.out.println("index" + i);
			long jobID = listJobTask.get(i).getJobId();
			for (int k = 1; k < listResourceUsage.size(); k++) {
				if (jobID == listResourceUsage.get(k).getJobId()) {
					if ((listResourceUsage.get(k).getAssignedMemoryUsage() > 0.0)
							&& (listResourceUsage.get(k).getMemoryAccessPerInstruction() > 0.0)
							&& (listResourceUsage.get(k).getMaximumDiskIOTime() > 0.0)
							&& (listResourceUsage.get(k).getTotalPageCacheMemoryUsage() > 0.0)
							&& (listResourceUsage.get(k).getMaximumCPUUsage() > 0.0)
							&& (listResourceUsage.get(k).getCyclePerInstruction() > 0.0)
							&& (listResourceUsage.get(k).getMeanLocalDiskSpaceUsed() > 0.0)) {
						bufferedWriter.write(jobID + "," + listResourceUsage.get(k).getTaskIndex() + ","
								+ listJobTask.get(i).getSechdeulingClass() + "," + listJobTask.get(i).getPriority()
								+ "," + listResourceUsage.get(k).getAssignedMemoryUsage() + ","
								+ listResourceUsage.get(k).getMemoryAccessPerInstruction() + ","
								+ listResourceUsage.get(k).getMaximumDiskIOTime() + ","
								+ listResourceUsage.get(k).getTotalPageCacheMemoryUsage() + ","
								+ listResourceUsage.get(k).getMaximumCPUUsage() + ","
								+ listResourceUsage.get(k).getMeanLocalDiskSpaceUsed() + ","
								+ listResourceUsage.get(k).getCyclePerInstruction() + ",");
						input = new Input(listResourceUsage.get(k).getTaskIndex(),
								listJobTask.get(i).getSechdeulingClass(), listJobTask.get(i).getPriority());
//						if(listResourceUsage.get(k).getTotalPageCacheMemoryUsage()>0.0040)
//						listMaximumDiskInputOutput.add(listResourceUsage.get(k).getTotalPageCacheMemoryUsage());
						System.out.println("print");
						if (listResourceUsage.get(k).getTaskIndex()>50
) {
							output = new Output(listResourceUsage.get(k).getAssignedMemoryUsage(),
									listResourceUsage.get(k).getMemoryAccessPerInstruction(),
									listResourceUsage.get(k).getMaximumDiskIOTime(),
									listResourceUsage.get(k).getTotalPageCacheMemoryUsage(),
									listResourceUsage.get(k).getMaximumCPUUsage(),
									listResourceUsage.get(k).getMeanLocalDiskSpaceUsed(),
									listResourceUsage.get(k).getCyclePerInstruction(), "1");
							bufferedWriter.write("1" + "\n");
							// countone++;
							// listAssignedMemeoryUsage.add(listResourceUsage.get(k).getAssignedMemoryUsage());
						} else {
							bufferedWriter.write("0" + "\n");
							output = new Output(listResourceUsage.get(k).getAssignedMemoryUsage(),
									listResourceUsage.get(k).getMemoryAccessPerInstruction(),
									listResourceUsage.get(k).getMaximumDiskIOTime(),
									listResourceUsage.get(k).getTotalPageCacheMemoryUsage(),
									listResourceUsage.get(k).getMaximumCPUUsage(),
									listResourceUsage.get(k).getMeanLocalDiskSpaceUsed(),
									listResourceUsage.get(k).getCyclePerInstruction(), "0");

							// counttwo++;
						}
						TrainTest trainTest = new TrainTest(input, output);
						listTrainTest.add(trainTest);
					}
				}
			}
			
		}
//System.out.println("Size of memory access"+listMaximumDiskInputOutput.size());
		bufferedWriter.flush();
		bufferedWriter.close();
		// System.out.println("size "+listAssignedMemeoryUsage.size());
		return listTrainTest;

	}
	public static void main(String[] args) throws IOException {
		new CombinedDataSet().finalDataSet();
	}
}