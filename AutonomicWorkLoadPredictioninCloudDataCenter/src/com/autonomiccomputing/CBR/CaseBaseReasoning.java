package com.autonomiccomputing.CBR;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading.FileAddress;
import com.autonomiccomputing.model.Input;
import com.autonomiccomputing.model.InputOutput;
import com.autonomiccomputing.model.MinimumNumberCalculation;
import com.autonomiccomputing.model.Output;
import com.autonomiccomputing.model.TestClassForSelectedFeature;

import weka.classifiers.trees.J48;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class CaseBaseReasoning {
	SimpleKMeans kmean = null;
	static int valuePosition = 0;

	public ArrayList<InputOutput> listInputOutput() throws Exception {
		ArrayList<InputOutput> listIO = new ArrayList<>();
		Input input = null;
		Output output = null;
		kmean = new SimpleKMeans();
		BufferedWriter bufferedWriter = FileAddress.writingNewFile("OutPutKMean\\K-means-output.csv");
		kmean.setPreserveInstancesOrder(true);
		kmean.setSeed(10);
		kmean.setPreserveInstancesOrder(true);
		kmean.setNumClusters(3); //// here clusters shoud be dynamics
		DataSource dataSource = new DataSource("TrainingTesting\\TrainingTask.csv");
		Instances unlabeled = dataSource.getDataSet();
		kmean.buildClusterer(unlabeled);
		int[] assignments = kmean.getAssignments();
		ClusterEvaluation eval = new ClusterEvaluation();
		eval.setClusterer(kmean);
		eval.evaluateClusterer(unlabeled);
		Instances labeled = new Instances(unlabeled);
		//System.out.println(labeled+"Poch gae");
		unlabeled.setClassIndex(unlabeled.numAttributes() - 1);
		J48 j48 = new J48();
		j48.setUnpruned(true);
		String[] split = null;
		for (int j = 0; j < labeled.numInstances(); j++) {
			String a = labeled.instance(j).toString();
			split = a.split(",");
			//System.out.println(Integer.valueOf(split[1])+"Value of task index");
			input = new Input(Integer.valueOf(split[1]), Integer.valueOf(split[2]), Integer.valueOf(split[3]));
			output = new Output(Double.parseDouble(split[4]), Double.parseDouble(split[5]),
					Double.parseDouble(split[6]), Double.parseDouble(split[7]), Double.parseDouble(split[8]),
					Double.parseDouble(split[9]), Double.parseDouble(split[10]),split[11]);
			InputOutput inputOutput = new InputOutput(input, output, assignments[j]);
			listIO.add(inputOutput);

		}
//		Instances instances = kmean.getClusterCentroids();
//		System.out.println(" values");
	//	System.out.println(instances);
		bufferedWriter.write(labeled.toString());
		bufferedWriter.newLine();
		bufferedWriter.flush();
		bufferedWriter.close();
		return listIO;

	}

	public HashMap<Integer, ArrayList<InputOutput>> mapOfClusterValue() throws Exception {
		HashMap<Integer, ArrayList<InputOutput>> mapOfCluster = new HashMap<>();

		for (int k = 0; k < 3; k++) {
			BufferedWriter bufferedWriter = FileAddress.writingNewFile("Cluster\\cluster" + k + ".csv");
			bufferedWriter.write("JobID" + "," + "No.ofTasks" + "," + "SechedulingClass" + "," + "Priority" + ","
					+ "AssignedMemoryUsage" + "," + "MemoryAccessPerInstruction" + "," + "MaximumDiskInputOutputTime"
					+ "," + "TotalPagedCacheMemoryUsage" + "," + "MaximumCPUUsage" + "," + "MeanLocalDiskSpaceUsed"
					+ "," + "CyclesPerInstruction" + "," + "Cluster" + "\n");
			ArrayList<InputOutput> listInputOutPut = listInputOutput();
			ArrayList<InputOutput> listInputOutputfile= new ArrayList<>();
			for (int i = 0; i < listInputOutPut.size(); i++) {
				if (listInputOutPut.get(i).getCluster() == k) {
					
					bufferedWriter.write(listInputOutPut.get(i).getInput().getJobID() + ","
							+ listInputOutPut.get(i).getInput().getTaskIndex() + ","
							+ listInputOutPut.get(i).getInput().getSechedulingClass() + ","
							+ listInputOutPut.get(i).getInput().getPriority() + ",");
					bufferedWriter.write(listInputOutPut.get(i).getOutput().getAssignedMemoryUsage() + ","
							+ listInputOutPut.get(i).getOutput().getMemoryAccessPerInstruction() + ","
							+ listInputOutPut.get(i).getOutput().getMaximumDiskInputOutputTime() + ","
							+ listInputOutPut.get(i).getOutput().getTotalPagedCacheMemoryUsage() + ","
							+ listInputOutPut.get(i).getOutput().getMaximumCPUUsage() + ","
							+ listInputOutPut.get(i).getOutput().getMeanLocalDiskSpaceUsed() + ","
							+ listInputOutPut.get(i).getOutput().getCyclesPerInstruction() + ","
							+ listInputOutPut.get(i).getCluster() + "\n");
					Input input = new Input(listInputOutPut.get(i).getInput().getTaskIndex(),
							listInputOutPut.get(i).getInput().getSechedulingClass(),
							listInputOutPut.get(i).getInput().getPriority());
					Output output = new Output(listInputOutPut.get(i).getOutput().getAssignedMemoryUsage(),
							listInputOutPut.get(i).getOutput().getMemoryAccessPerInstruction(),
							listInputOutPut.get(i).getOutput().getMaximumDiskInputOutputTime(),
							listInputOutPut.get(i).getOutput().getTotalPagedCacheMemoryUsage(),
							listInputOutPut.get(i).getOutput().getMaximumCPUUsage(),
							listInputOutPut.get(i).getOutput().getMeanLocalDiskSpaceUsed(),
							listInputOutPut.get(i).getOutput().getCyclesPerInstruction(),listInputOutPut.get(i).getOutput().getClasse());
					InputOutput inputOutput = new InputOutput(input, output, listInputOutPut.get(i).getCluster());
                    listInputOutputfile.add(inputOutput);
				}
				//System.out.println("AddedValues");
				
				//System.out.println("AddedValues");
			}
			//System.out.println(k+" value of K"+ listInputOutputfile.size());
			mapOfCluster.put(k, listInputOutputfile);
			//System.out.println("added");
			bufferedWriter.flush();
			bufferedWriter.close();

		}
//System.out.println("ended");
		return mapOfCluster;
	}

	public ArrayList<Input> listCentriodPoint() throws Exception {
		listInputOutput();
		ArrayList<Input> listCentriodPoint = new ArrayList<>();
		Input input = null;
		Instances instances = kmean.getClusterCentroids();
		String arrInstances = null;
       // System.out.println(instances);

		for (int i = 0; i < 3; i++) {
			arrInstances = instances.get(i).toString();
			String[] split = arrInstances.split(",");
			
			for (int j = 0; j < split.length - 7; j++) {
				input = new Input(Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]));

			}
			if (listCentriodPoint != null) {
				listCentriodPoint.add(input);
			}
		}

		return listCentriodPoint;

	}

	public ArrayList<Double> minimumValue(int a, int b, int c) throws Exception {
		ArrayList<Double> listMinimumValue = new ArrayList<>();
		double number = 0.0;
		ArrayList<Input> listInput = new CaseBaseReasoning().listCentriodPoint();
		if (listInput != null) {
			for (int i = 0; i < listInput.size(); i++) {
				number = square(a, listInput.get(i).getCenttaskIndex()) + square(b, listInput.get(i).getCentsechedulingClass())
						+ square(c, listInput.get(i).getCentpriority());
				number = Math.sqrt(number);
				listMinimumValue.add(number);
			}
		}
		
		return listMinimumValue;
	}

	public static double square(int num1, double num2) {
		double c;
		c = (num1 - num2);

		return c * c;

	}

	public ArrayList<MinimumNumberCalculation> listMinimumNumberCalculation(int a, int b, int c) throws Exception {
		ArrayList<Double> listminimumNumber = minimumValue(a, b, c);
		//double cal = listminimumNumber.get(0);
		
		double minimumNumber = 0.0;
		int key = 0;
		ArrayList<MinimumNumberCalculation> listMinimumNumberCalculation = new ArrayList<>();
		MinimumNumberCalculation minimumNumberCalculation = null;
		Output output = null;
		HashMap<Integer, ArrayList<InputOutput>> mapList = mapOfClusterValue();
		ArrayList<InputOutput> listInputOutput = null;
		double smallestNumber = listminimumNumber.get(0);
		System.out.println("cal");
		for (int i = 0; i < listminimumNumber.size(); i++) {
			if (smallestNumber > listminimumNumber.get(i)) {
				smallestNumber = listminimumNumber.get(i);
				valuePosition = i;
				System.out.println(valuePosition+" Result");
			}
		}
		for (Map.Entry<Integer, ArrayList<InputOutput>> traversing : mapList.entrySet()) {
			key = traversing.getKey();
		//	System.out.println(key);
			if (key == valuePosition) {
				listInputOutput = traversing.getValue();
			//	System.out.println(key+"     key");
			}
		}
		//System.out.println(listInputOutput.size());
		for (int i = 0; i < listInputOutput.size(); i++) {
			minimumNumber = square(a, listInputOutput.get(i).getInput().getTaskIndex())
					+ square(b, listInputOutput.get(i).getInput().getSechedulingClass())
					+ square(c, listInputOutput.get(i).getInput().getPriority());
			output = new Output(listInputOutput.get(i).getOutput().getAssignedMemoryUsage(),
					listInputOutput.get(i).getOutput().getMemoryAccessPerInstruction(),
					listInputOutput.get(i).getOutput().getMaximumDiskInputOutputTime(),
					listInputOutput.get(i).getOutput().getTotalPagedCacheMemoryUsage(),
					listInputOutput.get(i).getOutput().getMaximumCPUUsage(),
					listInputOutput.get(i).getOutput().getMeanLocalDiskSpaceUsed(),
					listInputOutput.get(i).getOutput().getCyclesPerInstruction(),listInputOutput.get(i).getOutput().getClasse());
			minimumNumber = Math.sqrt(minimumNumber);
			minimumNumberCalculation = new MinimumNumberCalculation(output, minimumNumber);
			listMinimumNumberCalculation.add(minimumNumberCalculation);

		}
		//System.out.println(minimumNumber+"name");
		

		return listMinimumNumberCalculation;
	}

	public TestClassForSelectedFeature finalCalculation(int a, int b, int c) throws Exception {
		TestClassForSelectedFeature TCFSF= null;
		Output output= null;
		double db=0.0;
		ArrayList<MinimumNumberCalculation> listMinimumNumberCalculation= listMinimumNumberCalculation(a, b, c);
		MinimumNumberCalculation minimumNumberCalculation= null;
		if(listMinimumNumberCalculation!= null) {
			int n1 = 0;
			MinimumNumberCalculation MNC=listMinimumNumberCalculation.get(0);
			for(int i=0;i<listMinimumNumberCalculation.size();i++) {
				if(MNC.getMinimumNumber()>listMinimumNumberCalculation.get(i).getMinimumNumber()) {
					MNC=listMinimumNumberCalculation.get(i);
					n1=i;
				}
			}
			//System.out.println("N "+n1);
			minimumNumberCalculation= new MinimumNumberCalculation(MNC.getOutput(), MNC.getMinimumNumber());
			db=MNC.getMinimumNumber();
			db=1/db;
			db=Math.round(db*100);
			output= new Output(MNC.getOutput().getAssignedMemoryUsage(),MNC.getOutput(). getMemoryAccessPerInstruction(), MNC.getOutput().getMaximumDiskInputOutputTime(), MNC.getOutput().getTotalPagedCacheMemoryUsage(), MNC.getOutput().getMaximumCPUUsage()
					, MNC.getOutput().getMeanLocalDiskSpaceUsed(), MNC.getOutput().getCyclesPerInstruction(),MNC.getOutput().getClasse());
			TCFSF= new TestClassForSelectedFeature(output, db, MNC.getMinimumNumber());
		}
		return TCFSF;
	}
	public static void main(String[] args) throws Exception {
		//new CaseBaseReasoning().listInputOutput();
		new CaseBaseReasoning().finalCalculation(5, 6, 5);
		// new CaseBaseReasoning().mapOfClusterValue();
		// new CaseBaseReasoning().listCentriodPoint();

	}

}
