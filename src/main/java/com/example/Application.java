package com.example;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		List<TrainDetails> listOfDetails = TrainDetailsUtils.getAllTrainDetails();
		System.out.println("Printing list of train details");
		for (TrainDetails trainDetails : listOfDetails){
			System.out.println("Train Details: " + trainDetails.toString());
		}
		
		int lowestSpeed = TrainDetailsUtils.getLowestSpeedByTrainType("156A");
		if (lowestSpeed == 0){
			System.out.println("No Details found");
		} else {
			System.out.println("Details found lowest speed is " + lowestSpeed);
		}
		
		TrainDetails trainDetailsWithHighest = TrainDetailsUtils.getTrainDetailsWithHighestEnergyByTrainType("156A");
		if (trainDetailsWithHighest == null){
			System.out.println("No Details found");
		} else {
			System.out.println("Details found highest energy is " + trainDetailsWithHighest.getEnergy()
			+ " and speed is " + trainDetailsWithHighest.getSpeed());
		}
		
	}

}
