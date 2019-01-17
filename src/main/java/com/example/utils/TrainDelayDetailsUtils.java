package com.example.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.TrainDelayDetails;

public abstract class TrainDelayDetailsUtils {
	private static final File fileName = new File("DriverAndDelayDetails.txt");
	private static final String delimiter = "[|]";
	private static BufferedReader br = null;
	private static int generatedId = 1;
	
	public static List<TrainDelayDetails> getAllDelayDetails() {
		List<TrainDelayDetails> listOfDetails = new ArrayList<TrainDelayDetails>();
		br = FileUtils.getBufferedReader(fileName, delimiter);
		
		try {
			br.readLine();
			while (br.ready()) {
				String lineRead = br.readLine();
				String[] lineAsArray = lineRead.split(delimiter);
				String trainId = lineAsArray[0];
				String station = lineAsArray[1];
				String departureTime = lineAsArray[2];
				String departureLate = lineAsArray[4];
				TrainDelayDetails trainDelayDetails = new TrainDelayDetails(trainId, station, departureTime, departureLate);
				listOfDetails.add(trainDelayDetails);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listOfDetails;
	}

	
	public static int getGeneratedId() {
		return generatedId++;
	}
	
}
