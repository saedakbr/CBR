package com.AutonomicWorkLoadPredictioninCloudDataCenter.DataLoading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileAddress {
	public static BufferedWriter writingNewFile (String address) throws IOException {
		BufferedWriter writer= new BufferedWriter(new FileWriter(new File(address)));
		return writer; 
	}
	public static BufferedReader readingNewFile( String address) throws FileNotFoundException {
		BufferedReader reader= new BufferedReader(new FileReader(address));
		return reader;
	}

}
