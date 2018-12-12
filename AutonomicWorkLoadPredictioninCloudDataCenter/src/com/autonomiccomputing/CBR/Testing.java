package com.autonomiccomputing.CBR;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.MachineAttribute;
import com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading.FileAddress;
import com.autonomiccomputing.model.Input;
import com.autonomiccomputing.model.InputOutput;
import com.autonomiccomputing.model.Output;
import com.autonomiccomputing.model.TestClassForSelectedFeature;

public class Testing {
	public static void main(String[] args) throws Exception {
		new Testing().AssignedMemoryUsage();
	}
	public void AssignedMemoryUsage() throws Exception {
		int truePositive = 0;
		int trueNegative = 0;
		int falsePositive = 0;
		int falseNegative = 0;
		int actualZeroNumber = 0;
		int actualOneNumber = 0;
		int predicatedZeroNumber = 0;
		int predicatedOneNumber = 0;
		int total = 0;
		ArrayList<InputOutput> listTestData = new Testing().testData();
		//System.out.println("listtest"+ listTestData.size());
		BufferedWriter clusteringResult = FileAddress.writingNewFile("ClusteringResult\\TestingTask.csv");
		BufferedWriter PredictionResult = FileAddress.writingNewFile("PredicitionResult\\TestingTask.csv");
		BufferedWriter ROC = FileAddress.writingNewFile("ROCresult\\TestingTask.csv");

		clusteringResult.write("Actual" + "," + "Predicited" + "," + "cluster" + "PredictedPercent" + "\n");
		PredictionResult
				.write("TruePositive" + "," + "TrueNegative" + "," + "FalsePositive" + "," + "FalseNegative" + "\n");
		ROC.write("Specifciticity" + "," + "Sensitivity" + "\n");
		for (int i = 1; i < listTestData.size(); i++) {
			System.out.println(" iteration   "+ i);
			//StringBuilder sb= new Testing().readFromFile();
			TestClassForSelectedFeature TCFSF = new CaseBaseReasoning().finalCalculation(
					listTestData.get(i).getInput().getTaskIndex(), listTestData.get(i).getInput().getSechedulingClass(),
					listTestData.get(i).getInput().getPriority());
			if (listTestData.get(i).getOutput().getClasse().equals("0")) {
				actualZeroNumber = actualZeroNumber + 1;
			}
			if (listTestData.get(i).getOutput().getClasse().equals("1")) {
				actualOneNumber = actualOneNumber + 1;
			}
			if (TCFSF.getOutput().getClasse().equals("0"))
				
			{
				predicatedZeroNumber = predicatedZeroNumber + 1;
			}
			if (TCFSF.getOutput().getClasse().equals("1"))
				
			{
				predicatedZeroNumber = predicatedZeroNumber + 1;
			}

			if ((listTestData.get(i).getOutput().getClasse().equals("0"))
					&& (TCFSF.getOutput().getClasse().equals("0"))) {
				truePositive = truePositive + 1;
			}
			if ((listTestData.get(i).getOutput().getClasse().equals("0"))
					&& (TCFSF.getOutput().getClasse().equals("1"))) {
				falsePositive = falsePositive + 1;
			}
			if ((listTestData.get(i).getOutput().getClasse().equals("1"))
					&& (TCFSF.getOutput().getClasse().equals("0"))) {
				falseNegative = falseNegative + 1;
			}
			if ((listTestData.get(i).getOutput().getClasse().equals("1"))
					&& (TCFSF.getOutput().getClasse().equals("1"))) {
				trueNegative = trueNegative + 1;
			}

			clusteringResult.write(listTestData.get(i).getOutput().getAssignedMemoryUsage() + ","
					+ TCFSF.getOutput().getAssignedMemoryUsage() + "," + CaseBaseReasoning.valuePosition + ","
					+ TCFSF.getDb() + "\n");
//if(TCFSF.getDb()<80.0) {
//	sb.append(listTestData.get(i).getInput().getJobID()+","+listTestData.get(i).getInput().getTaskIndex()+","+
//			listTestData.get(i).getInput().getSechedulingClass()+","+listTestData.get(i).getInput().getPriority()+","+
//			listTestData.get(i).getOutput().getAssignedMemoryUsage()+","+listTestData.get(i).getOutput().getMemoryAccessPerInstruction()+","+
//			listTestData.get(i).getOutput().getMaximumDiskInputOutputTime()+","+listTestData.get(i).getOutput().getTotalPagedCacheMemoryUsage()+","+
//			listTestData.get(i).getOutput().getMaximumCPUUsage()+","+listTestData.get(i).getOutput().getMeanLocalDiskSpaceUsed()+","+listTestData.get(i).getOutput().getCyclesPerInstruction()+","+listTestData.get(i).getOutput().getClasse());
//	new Testing().writeToFile(sb);
//	sb.append("\n");
//	System.out.println("idr aya ");
//}
			double sensitvity = truePositive + falseNegative;
			sensitvity = (truePositive / sensitvity);
			double specificity = trueNegative + falsePositive;
			//System.out.println(specificity+"value");
			if(specificity==0.0) {
				ROC.write(sensitvity + "," + specificity + "\n");
			}else {
			specificity = (trueNegative / specificity);
			ROC.write(sensitvity + "," + specificity + "\n");
			}

		}
		clusteringResult.flush();
		clusteringResult.close();
		ROC.flush();
		ROC.close();
	PredictionResult.write(truePositive +","+ trueNegative +","+ falsePositive +","+ falseNegative+"\n"+"\n");
		total = (truePositive + trueNegative + falsePositive + falseNegative);
		double accuracy = (truePositive + trueNegative);
		accuracy = (accuracy / total);
		double misclassificationRate = (falsePositive + falseNegative);
		misclassificationRate = (misclassificationRate / total);
		
		double precision = truePositive + falsePositive;
		precision=truePositive/precision;
		
		double recall=truePositive+falseNegative;
		recall=truePositive/recall;
		double Fmeasure=(2*((precision)*(recall)));
		Fmeasure=(Fmeasure)/(precision+recall);
		
		PredictionResult.write("," + "Accuracy" + "," + accuracy + "\n");
		PredictionResult.write("," + "Misclassification Rate " + "," + misclassificationRate + "\n");
		PredictionResult.write("," + "Precision " + "," + precision + "\n");
		PredictionResult.write("," + "Fmeasure " + "," + Fmeasure + "\n");
		PredictionResult.write("," + "Recall " + "," + recall + "\n");
		

		// System.out.println("Result "+accuracy+" "+misclassificationRate+"
		// "+truePositiveRate+" "+falsePositiveRate+" "+specificity+"
		// "+precision+" "+prevalence);
		PredictionResult.flush();
		PredictionResult.close();
		// bufferwriter.flush();
		System.out.println(" First Done");

	}

	public ArrayList<InputOutput> testData() throws IOException {

		BufferedReader reader = FileAddress.readingNewFile("TrainingTesting\\TestingTask.csv"); // neeed
																													// correction
		String line = null;
		Scanner scanner = null;
		int index = 0;
		ArrayList<InputOutput> listInputOutput = new ArrayList<>();

		while ((line = reader.readLine()) != null) {
			InputOutput inputOutput = new InputOutput();
			Input input = new Input();
			Output output = new Output();

			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0) {
					try {
						input.setJobID(Long.parseLong(data));
					} catch (Exception e) {
						// TODO: handle exception
						input.setJobID(0);
					}
				}
				if (index == 1) {
					try {
						input.setTaskIndex(Integer.parseInt(data));
					} catch (Exception e) {
						// TODO: handle exception
						input.setTaskIndex(0);
					}
				}
				if (index == 2) {
					try {
						input.setSechedulingClass(Integer.parseInt(data));
					} catch (Exception e) {
						// TODO: handle exception
						input.setSechedulingClass(0);
					}
				}
				if (index == 3) {
					try {
						input.setPriority(Integer.parseInt(data));
					} catch (Exception e) {
						// TODO: handle exception
						input.setPriority(0);

					}
				}
				if (index == 4) {
					try {
						output.setAssignedMemoryUsage(Double.parseDouble(data));
					} catch (Exception e) {
						output.setAssignedMemoryUsage(0);
					}
				}
				if (index == 5) {
					try {
						output.setMemoryAccessPerInstruction(Double.parseDouble(data));
					} catch (Exception e) {
						// TODO: handle exception
						output.setMemoryAccessPerInstruction(0);
					}
				}
				if (index == 6) {
					try {
						output.setMaximumDiskInputOutputTime(Double.parseDouble(data));
					} catch (Exception e) {
						// TODO: handle exception
						output.setMaximumDiskInputOutputTime(0);
					}
				}
				if (index == 7) {
					try {
						output.setTotalPagedCacheMemoryUsage(Double.parseDouble(data));
					} catch (Exception e) {
						output.setTotalPagedCacheMemoryUsage(0);
					}
				}
				if (index == 8) {
					try {
						output.setMaximumCPUUsage(Double.parseDouble(data));
					} catch (Exception e) {
						output.setMaximumCPUUsage(0);
						// TODO: handle exception
					}
				}
				if (index == 9) {
					try {
						output.setMeanLocalDiskSpaceUsed(Double.parseDouble(data));
					} catch (Exception e) {
						// TODO: handle exception
						output.setMeanLocalDiskSpaceUsed(0);
					}
				}
				if (index == 10) {
					try {
						output.setCyclesPerInstruction(Double.parseDouble(data));
					} catch (Exception e) {
						// TODO: handle exception
						output.setCyclesPerInstruction(0);
					}
				}
				if (index == 11) {
					try {
						output.setClasse(data);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}

				index++;
			}
			index = 0;
			inputOutput.setInput(input);
			inputOutput.setOutput(output);
			listInputOutput.add(inputOutput);
		}
		reader.close();

		return listInputOutput;

	}
	private static void writeToFile(StringBuilder sb) throws IOException {
		File file = new File("TrainingTesting\\TrainingDataAssignedMemoryUsage.csv");
		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(file), Charset.forName("utf-8")));
		// because evca canot read this
		writer.write(sb.toString());
		writer.close();
	}

	private static StringBuilder readFromFile() throws IOException {
		StringBuilder sb = new StringBuilder();
		File file = new File("TrainingTesting\\TrainingDataAssignedMemoryUsage.csv");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}

		reader.close();

		return sb;
	}

}
