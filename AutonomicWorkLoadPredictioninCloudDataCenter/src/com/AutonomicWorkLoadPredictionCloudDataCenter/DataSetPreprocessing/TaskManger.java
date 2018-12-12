package com.AutonomicWorkLoadPredictionCloudDataCenter.DataSetPreprocessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.TaskEvent;
import com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading.FileAddress;

public class TaskManger {
public ArrayList<TaskEvent> methodTaskManager(String path) throws IOException{
	ArrayList<TaskEvent> listTaskManager= new ArrayList<>();
	BufferedReader reader = FileAddress
			.readingNewFile(path); // need correct address
	String line = null;
	Scanner scanner = null;
	int index = 0;
	while ((line = reader.readLine()) != null) {
		TaskEvent taskEvent= new TaskEvent();
		scanner = new Scanner(line);
		scanner.useDelimiter(",");
		while (scanner.hasNext()) {
			String data = scanner.next();
			if (index == 0) {
				if(data==null) {
					taskEvent.setTimeStamps(0);
				}else {
					try {
				taskEvent.setTimeStamps(Long.parseLong(data));
					}
					catch (NumberFormatException e) {
						// TODO: handle exception
						taskEvent.setTimeStamps(0);
					}
				//System.out.println("time"+resourceUsage.getStartTime());
			}}
			if (index == 1) {
				if(data==null) {
					taskEvent.setMissingInfo(0);
				}else {
					try {
						taskEvent.setMissingInfo(0);
					}
					catch (NumberFormatException e) {
						// TODO: handle exception
						taskEvent.setMissingInfo(0);
					}
				//System.out.println("time"+resourceUsage.getStartTime());
			}}
			if (index == 2) {
				if(data==null) {
					taskEvent.setJobId(0);
				}else {
					try {
						taskEvent.setJobId(Long.parseLong(data));
					}
					catch (NumberFormatException e) {
						// TODO: handle exception
						taskEvent.setJobId(0);
					}
				//System.out.println("time"+resourceUsage.getStartTime());
			}}
			if (index == 3) {
				if(data==null) {
					taskEvent.setTaskIndex(0);
				}else {
					try {
						taskEvent.setTaskIndex(Integer.parseInt(data));;
					}
					catch (NumberFormatException e) {
						// TODO: handle exception
						taskEvent.setTaskIndex(0);;
					}
				//System.out.println("time"+resourceUsage.getStartTime());
			}}
			if (index == 4) {
				if(data==null) {
					taskEvent.setMachineId(0);
				}else {
					try {
						taskEvent.setMachineId(Long.parseLong(data));
					}
					catch (NumberFormatException e) {
						// TODO: handle exception
						taskEvent.setMachineId(0);;
					}
				//System.out.println("time"+resourceUsage.getStartTime());
			}}
			if (index == 5) {
				if(data==null) {
					taskEvent.setEventType(0);;
				}else {
					try {
						taskEvent.setEventType(Long.parseLong(data));
					}
					catch (NumberFormatException e) {
						// TODO: handle exception
						taskEvent.setEventType(0);;
					}
				//System.out.println("time"+resourceUsage.getStartTime());
			}}
//			if (index == 6) {
//				if(data==null) {
//					taskEvent.setUsername("N");
//				}else {
//					try {
//						taskEvent.setUsername("N");
//					}
//					catch (NumberFormatException e) {
//						// TODO: handle exception
//						taskEvent.setUsername("N");
//					}
//				//System.out.println("time"+resourceUsage.getStartTime());
//			}}
			if (index == 7) {
				if(data==null) {
					taskEvent.setSechedulingClass(0);
				}else {
					try {
						taskEvent.setSechedulingClass(Integer.parseInt(data));
					}
					catch (NumberFormatException e) {
						// TODO: handle exception
						taskEvent.setSechedulingClass(0);
					}
				//System.out.println("time"+resourceUsage.getStartTime());
			}}
			if (index == 8) {
				if(data==null) {
					taskEvent.setPriority(0);
				}else {
					try {
						taskEvent.setPriority(Integer.parseInt(data));
					}
					catch (NumberFormatException e) {
						// TODO: handle exception
						taskEvent.setPriority(0);
					}
				//System.out.println("time"+resourceUsage.getStartTime());
			}}
			if (index == 9) {
				if(data==null) {
					taskEvent.setResourceRequestForCPU(0);
				}else {
					try {
						taskEvent.setResourceRequestForCPU(Double.parseDouble(data));
					}
					catch (NumberFormatException e) {
						// TODO: handle exception
						taskEvent.setResourceRequestForCPU(0);
					}
				//System.out.println("time"+resourceUsage.getStartTime());
			}}
			if (index == 10) {
				if(data==null) {
					taskEvent.setResourceRequestForRAM(0);
				}else {
					try {
						taskEvent.setResourceRequestForRAM(Double.parseDouble(data));
					}
					catch (NumberFormatException e) {
						// TODO: handle exception
						taskEvent.setResourceRequestForRAM(0);
					}
				//System.out.println("time"+resourceUsage.getStartTime());
			}}
			if (index == 11) {
				if(data==null) {
					taskEvent.setResourceRequestForLocalDiskSpace(0);
				}else {
					try {
						taskEvent.setResourceRequestForLocalDiskSpace(Double.parseDouble(data));
					}
					catch (NumberFormatException e) {
						// TODO: handle exception
						taskEvent.setResourceRequestForLocalDiskSpace(0);
					}
				//System.out.println("time"+resourceUsage.getStartTime());
			}}
			if (index == 12) {
				if(data==null) {
					taskEvent.setDifferentMachineConstraints(0);
				}else {
					try {
						taskEvent.setDifferentMachineConstraints(Double.parseDouble(data));
					}
					catch (NumberFormatException e) {
						// TODO: handle exception
						taskEvent.setDifferentMachineConstraints(0);
					}
				//System.out.println("time"+resourceUsage.getStartTime());
			}}
			index++;
}
		index=0;
		listTaskManager.add(taskEvent);
	}
	reader.close();
		return listTaskManager;
	}
public static void main(String[] args) throws IOException {
	TaskManger taskManager= new TaskManger();
	taskManager.taskJobPriorityFinding();
}
public void taskJobPriorityFinding() throws IOException {
	for(int k=10;k<=13;k++) {
	System.out.println("Start");
	ArrayList<TaskEvent> listTaskEvent=methodTaskManager("InputTask\\"+"part-000"+k+"-of-00500.csv");
	BufferedWriter bufferedWriter= FileAddress.writingNewFile("OutputTask\\"+"part-0000"+k+"-of-00500.csv");
	bufferedWriter.write("JobID"+","+ "TaskIndex"+","+"infrastucture"+","+"monitioring"+","+
	"normalProduction"+","+"Other"+","+"Gratis"+"\n");
	for(int i=0;i<listTaskEvent.size();i++) {
		int infrastucture=0;
		int monitioring =0;
		int normalProduction=0;
		int other=0;
		int gratis=0;
		//System.out.println(listTaskEvent.get(i).getPriority() +" index"+i);
		if(listTaskEvent.get(i).getPriority()==11) {
			infrastucture=1;
		}
		if(listTaskEvent.get(i).getPriority()==10) {
			monitioring=1;
		}
		if(listTaskEvent.get(i).getPriority()==9) {
			normalProduction=1;
		}
		if((listTaskEvent.get(i).getPriority()>=2)&&(listTaskEvent.get(i).getPriority()<=8)) {
			other=1;
		}
		if(listTaskEvent.get(i).getPriority()<=1) {
			gratis=1;
		}
		for(int j=i+1;j<listTaskEvent.size();j++) {
			//System.out.println("i"+"  "+i+"  "+j);
			if((listTaskEvent.get(i).getJobId()==listTaskEvent.get(j).getJobId())&&(
					listTaskEvent.get(i).getTaskIndex()==listTaskEvent.get(j).getTaskIndex())) {
				if(listTaskEvent.get(j).getPriority()==11) {
					infrastucture++;
				}
				if(listTaskEvent.get(j).getPriority()==10) {
					monitioring++;
				}
				if(listTaskEvent.get(j).getPriority()==9) {
					normalProduction++;
				}
				if((listTaskEvent.get(j).getPriority()>=2)&&(listTaskEvent.get(j).getPriority()<=8)) {
					other++;
				}
				if(listTaskEvent.get(j).getPriority()<=1) {
					gratis++;
				}
				listTaskEvent.remove(j);
				
				j--;
				
			}
			
		}
		bufferedWriter.write(listTaskEvent.get(i).getJobId()+","+listTaskEvent.get(i).getTaskIndex()+","+
		infrastucture+","+monitioring+","+normalProduction+","+other+","+gratis+"\n");
	}
	bufferedWriter.flush();
	bufferedWriter.close();
	System.out.println("done");
	
}}

}
