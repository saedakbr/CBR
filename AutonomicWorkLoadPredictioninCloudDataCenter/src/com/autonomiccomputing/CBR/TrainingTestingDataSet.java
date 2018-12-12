package com.autonomiccomputing.CBR;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.AutonomicWorkLoadPredictionCloudDataCenter.DataSetPreprocessing.CombinedDataSet;
import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.TrainTest;
import com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading.FileAddress;

public class TrainingTestingDataSet {
	public TrainTest TrainingTest() throws IOException {
		ArrayList<TrainTest> listTrainTest = new CombinedDataSet().finalDataSet();
		// System.out.println(listTrainTest.get(0).getInput().getTaskIndex());
		Collections.shuffle(listTrainTest);
		// System.out.println(listTrainTest.get(0).getInput().getTaskIndex());
		TrainTest trainTest = new TrainTest();
		ArrayList<TrainTest> listTraining = new ArrayList<>();
		ArrayList<TrainTest> listTesting = new ArrayList<>();
		for (int i = 0; i < listTrainTest.size() - 2320; i++) {
			listTraining.add(listTrainTest.get(i));
		}
		
		System.out.println(listTraining.size());
		for (int i = 5411; i < listTrainTest.size(); i++) {
			listTesting.add(listTrainTest.get(i));
		}
		System.out.println(listTesting.size());
		trainTest.setListTraining(listTraining);
		trainTest.setListTesting(listTesting);
		return trainTest;

	}

	public static void main(String[] args) throws IOException {
		new TrainingTestingDataSet().training();
		new TrainingTestingDataSet().testing();
		// System.out.println(trainTest.getListTesting().get(0).getInput().getTaskIndex()+"Size");

	}

	public void training() throws IOException {
		BufferedWriter bufferedWriter = FileAddress
				.writingNewFile("TrainingTesting\\TrainingTask.csv");
		bufferedWriter.write("JobID" + "," + "No.ofTasks" + "," + "SechedulingClass" + "," + "Priority" + ","
				+ "AssignedMemoryUsage" + "," + "MemoryAccessPerInstruction" + "," + "MaximumDiskInputOutputTime" + ","
				+ "TotalPagedCacheMemoryUsage" + "," + "MaximumCPUUsage" + "," + "MeanLocalDiskSpaceUsed" + ","
				+ "CyclesPerInstruction" + "," + "MemoryAccessPerInstructionClass" + "\n");
		ArrayList<TrainTest> listTrainTest = new TrainingTestingDataSet().TrainingTest().getListTraining();
		for (int i = 0; i < listTrainTest.size(); i++) {
			bufferedWriter.write(
					listTrainTest.get(i).getInput().getJobID() + "," + listTrainTest.get(i).getInput().getTaskIndex()
							+ "," + listTrainTest.get(i).getInput().getSechedulingClass() + ","
							+ listTrainTest.get(i).getInput().getPriority()+",");
			bufferedWriter.write(listTrainTest.get(i).getOutput().getAssignedMemoryUsage() + ","
					+ listTrainTest.get(i).getOutput().getMemoryAccessPerInstruction() + ","
					+ listTrainTest.get(i).getOutput().getMaximumDiskInputOutputTime() + ","
					+ listTrainTest.get(i).getOutput().getTotalPagedCacheMemoryUsage() + ","
					+ listTrainTest.get(i).getOutput().getMaximumCPUUsage() + ","
					+ listTrainTest.get(i).getOutput().getMeanLocalDiskSpaceUsed() + ","
					+ listTrainTest.get(i).getOutput().getCyclesPerInstruction() + ","
					+ listTrainTest.get(i).getOutput().getClasse() + "\n");

		}
		bufferedWriter.flush();
		bufferedWriter.close();
	}
	public void testing() throws IOException {
		BufferedWriter bufferedWriter = FileAddress
				.writingNewFile("TrainingTesting\\TestingTask.csv");
		bufferedWriter.write("JobID" + "," + "No.ofTasks" + "," + "SechedulingClass" + "," + "Priority" + ","
				+ "AssignedMemoryUsage" + "," + "MemoryAccessPerInstruction" + "," + "MaximumDiskInputOutputTime" + ","
				+ "TotalPagedCacheMemoryUsage" + "," + "MaximumCPUUsage" + "," + "MeanLocalDiskSpaceUsed" + ","
				+ "CyclesPerInstruction" + "," + "MemoryAccessPerInstructionClass" + "\n");
		ArrayList<TrainTest> listTrainTest = new TrainingTestingDataSet().TrainingTest().getListTesting();
		for (int i = 0; i < listTrainTest.size(); i++) {
			bufferedWriter.write(
					listTrainTest.get(i).getInput().getJobID() + "," + listTrainTest.get(i).getInput().getTaskIndex()
							+ "," + listTrainTest.get(i).getInput().getSechedulingClass() + ","
							+ listTrainTest.get(i).getInput().getPriority()+",");
			bufferedWriter.write(listTrainTest.get(i).getOutput().getAssignedMemoryUsage() + ","
					+ listTrainTest.get(i).getOutput().getMemoryAccessPerInstruction() + ","
					+ listTrainTest.get(i).getOutput().getMaximumDiskInputOutputTime() + ","
					+ listTrainTest.get(i).getOutput().getTotalPagedCacheMemoryUsage() + ","
					+ listTrainTest.get(i).getOutput().getMaximumCPUUsage() + ","
					+ listTrainTest.get(i).getOutput().getMeanLocalDiskSpaceUsed() + ","
					+ listTrainTest.get(i).getOutput().getCyclesPerInstruction() + ","
					+ listTrainTest.get(i).getOutput().getClasse() + "\n");

		}
		bufferedWriter.flush();
		bufferedWriter.close();
	}
}
