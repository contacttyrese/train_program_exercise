package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class TrainDetailsUtils {
	private static final File fileName = new File("TrainDetails.txt");
	private static final String delimiter = "-";
	private static BufferedReader br = null;
	
	public static List<TrainDetails> getAllTrainDetails(){
		List<TrainDetails> listOfDetails = new ArrayList<TrainDetails>();
		br = FileUtils.getBufferedReader(fileName, delimiter);
		
		try {
			br.readLine();
			while (br.ready()) {
				String lineRead = br.readLine();
				String[] lineAsArray = lineRead.split(delimiter); 
				String trainType = lineAsArray[0];
				int speed = Integer.parseInt(lineAsArray[1]);
				int energy = Integer.parseInt(lineAsArray[2]);
				TrainDetails trainDetails = new TrainDetails(trainType, speed, energy);
				listOfDetails.add(trainDetails);
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		
		return listOfDetails;
	}
	
	public static int getLowestSpeedByTrainType(String trainType){
		List<TrainDetails> listOfDetailsFound = getAllTrainDetailsByTrainType(trainType);
		int lowestSpeed = 0;
		
		if (!listOfDetailsFound.isEmpty()){
			for (TrainDetails trainDetails : listOfDetailsFound){
				if (trainDetails.getSpeed() < lowestSpeed || lowestSpeed == 0){
					lowestSpeed = trainDetails.getSpeed();
				}
			}
		} else {
//			System.out.println("No Details found");
		}
		return lowestSpeed;
	}
	
	public static TrainDetails getTrainDetailsWithHighestEnergyByTrainType(String trainType){
		List<TrainDetails> listOfDetailsFound = getAllTrainDetailsByTrainType(trainType);
		TrainDetails trainDetailsWithHighest = null;
		
		if (!listOfDetailsFound.isEmpty()){
			trainDetailsWithHighest = listOfDetailsFound.get(0);
			for (TrainDetails trainDetails : listOfDetailsFound){
				if (trainDetails.getEnergy() > trainDetailsWithHighest.getEnergy()){
					trainDetailsWithHighest = trainDetails;
				}
			}
		} else {
//			System.out.println("No Details found");
		}
		return trainDetailsWithHighest;
	}
	
	private static List<TrainDetails> getAllTrainDetailsByTrainType(String trainType){
		List<TrainDetails> listOfDetailsFound = new ArrayList<TrainDetails>();
		for (TrainDetails trainDetails : getAllTrainDetails()){
			if (trainDetails.getTrainType().equalsIgnoreCase(trainType)){
				listOfDetailsFound.add(trainDetails);
			}
		}
		return listOfDetailsFound;
	}

}
