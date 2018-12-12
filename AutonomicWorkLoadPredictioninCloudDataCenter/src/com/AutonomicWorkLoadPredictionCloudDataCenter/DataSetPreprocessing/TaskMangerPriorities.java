package com.AutonomicWorkLoadPredictionCloudDataCenter.DataSetPreprocessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.AutonomicWorkLoadPredictionCloudDataCenter.Defination.TaskManagerPriority;
import com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading.FileAddress;

public class TaskMangerPriorities {
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

	public void taskPrioritiesFilteration() throws IOException {
	for(int k=0;k<=13;k++) {
			
		
		BufferedWriter bufferedWriter = FileAddress.writingNewFile("OutPutTask5\\part-0000"+k+"-of-00500.csv");
		bufferedWriter.write("JobId" + "," + "NumberofTask" + "," + "Infrastucture" + "," + "monitioring" + ","
				+ "normalProduction" + "," + "Other" + "," + "Gratis" + "\n");

		ArrayList<TaskManagerPriority> listTaskManagerPriority = methodTaskManager("OutPutTask4\\part-0000"+k+"-of-00500.csv");
		for (int i = 1; i < listTaskManagerPriority.size(); i++) {
			int size = 1;
			int infrastructure = listTaskManagerPriority.get(i).getInfrastucture();
			int monitioring = listTaskManagerPriority.get(i).getMonitioring();
			int normalProduction = listTaskManagerPriority.get(i).getNormalProduction();
			int other = listTaskManagerPriority.get(i).getOther();
			int gratis = listTaskManagerPriority.get(i).getGratis();
			for (int j = i + 1; j < listTaskManagerPriority.size(); j++) {
				if (listTaskManagerPriority.get(i).getJobID() == listTaskManagerPriority.get(j).getJobID()) {
					size = size + 1;
					infrastructure = infrastructure + listTaskManagerPriority.get(j).getInfrastucture();
					monitioring = monitioring + listTaskManagerPriority.get(j).getMonitioring();
					normalProduction = normalProduction + listTaskManagerPriority.get(j).getNormalProduction();
					other = other + listTaskManagerPriority.get(j).getOther();
					gratis = gratis + listTaskManagerPriority.get(j).getGratis();
					listTaskManagerPriority.remove(j);
					j--;

				}

			}
			bufferedWriter.write(listTaskManagerPriority.get(i).getJobID()+","+
			size+","+infrastructure+","+monitioring+","+normalProduction+","+
					other+","+gratis+"\n");
		}
		bufferedWriter.flush();
		bufferedWriter.close();
		System.out.println("done");
	}
}
	public static void main(String[] args) throws IOException {
		TaskMangerPriorities tmp= new TaskMangerPriorities();
		tmp.taskPrioritiesFilteration();
	}
	public void taskPrioritiesFilteration2() throws IOException {
		for(int k=0;k<=13;k++) {
			
		
		BufferedWriter bufferedWriter = FileAddress.writingNewFile("OutPutTask4\\part-0000"+k+"-of-00500.csv");
		bufferedWriter.write("JobId" + "," + "jobId" + "," + "Infrastucture" + "," + "monitioring" + ","
				+ "normalProduction" + "," + "Other" + "," + "Gratis" + "\n");

		ArrayList<TaskManagerPriority> listTaskManagerPriority = methodTaskManager("OutputTask\\part-0000"+k+"-of-00500.csv");
		for (int i = 1; i < listTaskManagerPriority.size(); i++) {
			
			int infrastructure = listTaskManagerPriority.get(i).getInfrastucture();
			int monitioring = listTaskManagerPriority.get(i).getMonitioring();
			int normalProduction = listTaskManagerPriority.get(i).getNormalProduction();
			int other = listTaskManagerPriority.get(i).getOther();
			int gratis = listTaskManagerPriority.get(i).getGratis();
			if(infrastructure>0) {
				infrastructure=1;
			}
			if(monitioring>0) {
				monitioring=1;
			}
			if(normalProduction>0) {
				normalProduction=1;
			}
			if(other>0) {
				other=1;
			}
			if(gratis>0)
			{
				gratis=1;
			}
			bufferedWriter.write(listTaskManagerPriority.get(i).getJobID()+","+listTaskManagerPriority.get(i).getTaskIndex()+","+
		infrastructure+","+monitioring+","+normalProduction+","+other+","+gratis+"\n");
		}
		bufferedWriter.flush();
		bufferedWriter.close();
			
	}
}
}