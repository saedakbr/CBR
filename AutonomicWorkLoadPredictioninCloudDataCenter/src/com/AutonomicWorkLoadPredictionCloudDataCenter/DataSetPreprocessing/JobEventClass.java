package com.AutonomicWorkLoadPredictionCloudDataCenter.DataSetPreprocessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.Job;
import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.JobEvent;
import com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading.FileAddress;
import com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading.RetriveDataFromFile;

public class JobEventClass {
	public void jobEvents() throws IOException {
		System.out.println("Start");
		ArrayList<JobEvent> listJobEvents=null;
		BufferedWriter bufferedWriter= FileAddress.writingNewFile("JobFolder\\jobfile.csv");
		bufferedWriter.write("JobId"+","+"SechedulingClass");
		for(int k=0;k<=13;k++) {
			//System.out.println(k);
			if(k>=10) {
			  listJobEvents= new RetriveDataFromFile().jobEvents("JobInputFolder\\part-000"+k+"-of-00500.csv");
			  System.out.println(k);
			}
			if(k<=9) {
				listJobEvents= new RetriveDataFromFile().jobEvents("JobInputFolder\\part-0000"+k+"-of-00500.csv");
				System.out.println(k);
			}
			for(int i=1;i<listJobEvents.size();i++) {
				bufferedWriter.write(listJobEvents.get(i).getJobID()+","+listJobEvents.get(i).getSchedulingClass()+"\n");
				
			}
		}
		bufferedWriter.flush();
		bufferedWriter.close();
		System.out.println("close");
	}
public static void main(String[] args) throws IOException {
	JobEventClass jb= new JobEventClass();
	jb.jobRedudency();
}
public ArrayList<Job> jobfile(String path) throws IOException {
	BufferedReader reader = FileAddress
			.readingNewFile(path); // need correct address
	//System.out.println("PAth");
	String line = null;
	Scanner scanner = null;
	int index = 0;		
	ArrayList<Job> listJob = new ArrayList<>();
	while ((line = reader.readLine()) != null) {
		Job job = new Job();
		scanner = new Scanner(line);
		scanner.useDelimiter(",");
		while (scanner.hasNext()) {
			String data = scanner.next();
			//System.out.println(data);
			if (index == 0) {
				
				try {
					
				job.setJobID(Long.parseLong(data));
				//System.out.println(job.getJobID());
				}
			catch (NumberFormatException e) {
				// TODO: handle exception
				job.setJobID(0);
			}
			}
			if (index == 1)	{
				if(data==null) {
					
				}
				try {
				job.setSchedulingClass(Integer.parseInt(data));
				//System.out.println(job.getJobID());
				}
			catch (NumberFormatException e) {
				// TODO: handle exception
				job.setJobID(0);
			}
			}
			index++;
		}
		index = 0;
		listJob.add(job);
	}
	reader.close();

	return listJob;
}
public void jobRedudency() throws IOException {
	BufferedWriter bufferedWriter= FileAddress.writingNewFile("JobFolder\\removeredudent.csv");
	bufferedWriter.write("JobID"+","+"SC"+"\n");
	ArrayList<Job> listJob= jobfile("JobFolder\\jobfile.csv");
	for(int i=1; i<listJob.size();i++) {
		//System.out.println(listJob.get(i).getJobID());
		long jobId= listJob.get(i).getJobID();
		for(int j=i+1;j<listJob.size();j++) {
			if(jobId==listJob.get(j).getJobID()) {
				System.out.println(jobId);
				listJob.remove(j);
				j--;
			}
			
		}
		bufferedWriter.write(jobId+","+listJob.get(i).getSchedulingClass()+"\n");
		
			}
	bufferedWriter.flush();
	bufferedWriter.close();
	
}
}
