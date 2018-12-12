package com.AutonomicWorkLoadPredictionCloudDataCenter.DataSetPreprocessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.TaskManagerPriority;
import com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading.FileAddress;

public class TaskPriorty {
	public ArrayList<TaskManagerPriority> methodTaskManager(String path) throws IOException {
		ArrayList<TaskManagerPriority> listTaskPriorties = new ArrayList<>();
		BufferedReader reader = FileAddress.readingNewFile(path); // need correct address
		String line = null;
		Scanner scanner = null;
		int index = 0;
		while ((line = reader.readLine()) != null) {
			TaskManagerPriority taskPrioity = new TaskManagerPriority();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String data = scanner.next();
				if (index == 0) {
					if (data == null) {
						taskPrioity.setJobID(0);
					} else {
						try {
							taskPrioity.setJobID(Long.parseLong(data));

						} catch (NumberFormatException e) {
							// TODO: handle exception
							taskPrioity.setJobID(0);

						}
						// System.out.println("time"+resourceUsage.getStartTime());
					}
				}
				if (index == 1) {
					if (data == null) {

						taskPrioity.setTaskIndex(0);
					} else {
						try {
							taskPrioity.setTaskIndex(Integer.parseInt(data));

						} catch (NumberFormatException e) {
							// TODO: handle exception
							taskPrioity.setTaskIndex(0);
						}
						// System.out.println("time"+resourceUsage.getStartTime());
					}
				}
				if (index == 2) {
					if (data == null) {
						taskPrioity.setInfrastucture(0);
					} else {
						try {
							taskPrioity.setInfrastucture(Integer.parseInt(data));
						} catch (NumberFormatException e) {
							// TODO: handle exception
							taskPrioity.setInfrastucture(0);
						}
						// System.out.println("time"+resourceUsage.getStartTime());
					}
				}
				if (index == 3) {
					if (data == null) {
						taskPrioity.setMonitioring(0);
					} else {
						try {
							taskPrioity.setMonitioring(Integer.parseInt(data));
						} catch (NumberFormatException e) {
							// TODO: handle exception
							taskPrioity.setMonitioring(0);
						}
						// System.out.println("time"+resourceUsage.getStartTime());
					}
				}
				if (index == 4) {
					if (data == null) {
						taskPrioity.setNormalProduction(0);
					} else {
						try {
							taskPrioity.setNormalProduction(Integer.parseInt(data));
						} catch (NumberFormatException e) {
							// TODO: handle exception
							taskPrioity.setNormalProduction(0);
						}
						// System.out.println("time"+resourceUsage.getStartTime());
					}
				}
				if (index == 5) {
					if (data == null) {
						taskPrioity.setOther(0);
					} else {
						try {
							taskPrioity.setOther(Integer.parseInt(data));
						} catch (NumberFormatException e) {
							// TODO: handle exception
							taskPrioity.setOther(0);
						}
						// System.out.println("time"+resourceUsage.getStartTime());
					}
				}

				if (index == 6) {
					if (data == null) {
						taskPrioity.setGratis(0);
					} else {
						try {
							taskPrioity.setGratis(Integer.parseInt(data));
						} catch (NumberFormatException e) {
							// TODO: handle exception
							taskPrioity.setGratis(0);
						}
						// System.out.println("time"+resourceUsage.getStartTime());
					}
				}

				index++;
			}
			index = 0;
			listTaskPriorties.add(taskPrioity);
		}
		reader.close();
		return listTaskPriorties;
	}
	
	public void taskPriority() throws IOException {
		BufferedWriter bufferedWriter= FileAddress.writingNewFile("TotalTask\\Totaltask.csv");
		ArrayList<TaskManagerPriority> listTaskMangerpriority= new ArrayList<>();
		///
		bufferedWriter.write("JobId" + "," + "taskIndex" + "," + "Infrastucture" + "," + "monitioring" + ","
				+ "normalProduction" + "," + "Other" + "," + "Gratis" + "\n");
	for(int k=0;k<=13;k++) {
		System.out.println(k+ "     "+listTaskMangerpriority.size());
		ArrayList<TaskManagerPriority> listTaskManager1= methodTaskManager("OutPutTask5\\part-0000"+k+"-of-00500.csv");
		for(int i=1;i<listTaskManager1.size();i++) {
			
			listTaskMangerpriority.add(listTaskManager1.get(i));
		}
	}
	
for(int i=0;i<listTaskMangerpriority.size();i++) {
	bufferedWriter.write(listTaskMangerpriority.get(i).getJobID()+","+listTaskMangerpriority.get(i).getTaskIndex()+","+
listTaskMangerpriority.get(i).getInfrastucture()+","+listTaskMangerpriority.get(i).getMonitioring()+","+
			listTaskMangerpriority.get(i).getNormalProduction()+","+listTaskMangerpriority.get(i).getOther()+","+listTaskMangerpriority.get(i).getGratis()+","+"\n");
}
	bufferedWriter.flush();
	bufferedWriter.close();
	}
	public static void main(String[] args) throws IOException {
		TaskPriorty taskPriorty1= new TaskPriorty();
		taskPriorty1.taskFileAdjustment();
	}
	public void removeTaskDuplicay() throws IOException {
		BufferedWriter bufferedWriter= FileAddress.writingNewFile("Totaltask\\DuplicantRemoved.csv");
		bufferedWriter.write("JobId" + "," + "taskIndex" + "," + "Infrastucture" + "," + "monitioring" + ","
				+ "normalProduction" + "," + "Other" + "," + "Gratis" + "\n");
		ArrayList<TaskManagerPriority> listTaskManagerPrioty= methodTaskManager("TotalTask\\Totaltask.csv");
		for(int i=0;i<listTaskManagerPrioty.size();i++) {
			int infrastructure= listTaskManagerPrioty.get(i).getInfrastucture();
			int monitioring=listTaskManagerPrioty.get(i).getMonitioring();
			int normalProduction=listTaskManagerPrioty.get(i).getNormalProduction();
			int other=listTaskManagerPrioty.get(i).getOther();
			int grattis=listTaskManagerPrioty.get(i).getGratis();
			for(int j=i+1;j<listTaskManagerPrioty.size();j++) {
				if(listTaskManagerPrioty.get(i).getJobID()==listTaskManagerPrioty.get(j).getJobID()) {
					infrastructure= listTaskManagerPrioty.get(j).getInfrastucture();
					 monitioring=listTaskManagerPrioty.get(j).getMonitioring();
					 normalProduction=listTaskManagerPrioty.get(j).getNormalProduction();
					other=listTaskManagerPrioty.get(j).getOther();
					 grattis=listTaskManagerPrioty.get(j).getGratis();
					 listTaskManagerPrioty.remove(j);
					 j--;
					 
				}
			}
			bufferedWriter.write(listTaskManagerPrioty.get(i).getJobID()+","+listTaskManagerPrioty.get(i).getTaskIndex()+","+
			infrastructure+","+monitioring+","+normalProduction+","+other+","+grattis+"\n");
		}
		bufferedWriter.flush();
		bufferedWriter.close();
	}
	public void taskFileAdjustment() throws IOException {
		BufferedWriter bufferedWriter= FileAddress.writingNewFile("TotalTask\\FileTask.csv");
		bufferedWriter.write("JobID"+","+"Priorty"+"\n");
		ArrayList<TaskManagerPriority> listTaskManager= methodTaskManager("TotalTask\\DuplicantRemoved.csv");
		for(int i=2;i<listTaskManager.size();i++) {
			int priority=-1;
			int inf= listTaskManager.get(i).getInfrastucture();
			int moni=listTaskManager.get(i).getMonitioring();
			int normpr=listTaskManager.get(i).getNormalProduction();
			int other =listTaskManager.get(i).getOther();
			int grattis= listTaskManager.get(i).getGratis();
			if((inf>moni)&&(inf>normpr)&&(inf>other)&&(inf>grattis)) {
				priority=5;
			}
			if((moni>inf)&&(moni>normpr)&&(moni>other)&&(moni>grattis)) {
				priority=4;
			}
			if((normpr>inf)&&(normpr>moni)&&(normpr>other)&&(normpr>grattis)) {
				priority=3;
			}
			if((other>inf)&&(other>normpr)&&(other>moni)&&(other>grattis)) {
				priority=2;
			}
			if((grattis>inf)&&(grattis>normpr)&&(grattis>moni)&&(grattis>other)) {
				priority=1;
			}
			bufferedWriter.write(listTaskManager.get(i).getJobID()+","+ priority+"\n");
		}
		bufferedWriter.flush();
		bufferedWriter.close();
	}
}
