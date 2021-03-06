package com.example.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.TrainDriverDetails;

public abstract class TrainDriverDetailsUtils {
	private static final File fileName = new File("DriverAndDelayDetails.txt");
	private static final String delimiter = "[|]";
	private static BufferedReader br = null;
	private static int generatedId = 1;
	private static String driverJourneyStatus = "";
	
	public static List<TrainDriverDetails> getAllDriverDetails() {
		List<TrainDriverDetails> listOfCompleteDriverDetails = new ArrayList<TrainDriverDetails>();
		TrainDriverDetails tdd = null;
		
		List<TrainDriverDetails> listOfIncompleteDriverDetails = getAllIncompleteDriverDetails();
		String[] arrayOfUniqueTrainIds = getArrayOfUniqueTrainIdsFromListOfIncompleteDriverDetails(listOfIncompleteDriverDetails);
		String[] arrayOfUniqueDriverNames = getArrayOfUniqueDriverNamesFromListOfIncompleteDriverDetails(listOfIncompleteDriverDetails);
		
		for (String trainId : arrayOfUniqueTrainIds) {
			List<TrainDriverDetails> listOfIncompleteDriverDetailsByTrainId = getListOfIncompleteDriverDetailsByTrainId(trainId, listOfIncompleteDriverDetails);
			sortListOfIncompleteDriverDetailsOnDepartureTime(listOfIncompleteDriverDetailsByTrainId);
			for (String driverName : arrayOfUniqueDriverNames) {
				String startStation = getFirstStationByDriverName(driverName, listOfIncompleteDriverDetailsByTrainId);
				if (!startStation.equals("N/A")) {
					String endStation = getLastStationByDriverNameAndSetJourneyStatus(driverName, listOfIncompleteDriverDetailsByTrainId);
					String journeyStatus = driverJourneyStatus;
					tdd = new TrainDriverDetails(getGeneratedId(), trainId, startStation, endStation, driverName, journeyStatus);
					listOfCompleteDriverDetails.add(tdd);
				}
			}
		}
		
		return listOfCompleteDriverDetails;
	}
	
	public static List<TrainDriverDetails> getAllIncompleteDriverDetails() {
		List<TrainDriverDetails> listOfIncompleteDriverDetails = new ArrayList<TrainDriverDetails>();
		br = FileUtils.getBufferedReader(fileName, delimiter);
		
		try {
			br.readLine();
			while (br.ready()) {
				String lineRead = br.readLine();
				String[] lineAsArray = lineRead.split(delimiter);
				String trainId = lineAsArray[0];
				String station = lineAsArray[1];
				String actualDepartureTimeAsString = lineAsArray[2];
				String driverName = lineAsArray[3];
				String departureLatenessInSecs = lineAsArray[4];
				TrainDriverDetails trainDriverDetails = new TrainDriverDetails(trainId, station, actualDepartureTimeAsString, driverName, departureLatenessInSecs);
				if (trainDriverDetails != null) {
					listOfIncompleteDriverDetails.add(trainDriverDetails);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listOfIncompleteDriverDetails;
	}
	
	public static String[] getArrayOfUniqueTrainIdsFromListOfIncompleteDriverDetails(List<TrainDriverDetails> listOfIncompleteDriverDetails) {
		Set<String> uniqueTrainIds = new HashSet<String>();
		listOfIncompleteDriverDetails.forEach((trainDriverDetails) -> {
			uniqueTrainIds.add(trainDriverDetails.getTrainId());
		});
		String[] uniqueTrainIdsAsArray = uniqueTrainIds.toArray(new String[uniqueTrainIds.size()]);
		return uniqueTrainIdsAsArray;
	}
	
	public static String[] getArrayOfUniqueDriverNamesFromListOfIncompleteDriverDetails(List<TrainDriverDetails> listOfIncompleteDriverDetails) {
		Set<String> uniqueDriverNames = new HashSet<String>();
		listOfIncompleteDriverDetails.forEach((trainDriverDetails) -> {
			uniqueDriverNames.add(trainDriverDetails.getDriverName());
		});
		String[] uniqueDriverNamesAsArray = uniqueDriverNames.toArray(new String[uniqueDriverNames.size()]);
		return uniqueDriverNamesAsArray;
	}
	
	private static List<TrainDriverDetails> getListOfIncompleteDriverDetailsByTrainId(String trainId, List<TrainDriverDetails> listOfDetails){
		List<TrainDriverDetails> newList = new ArrayList<TrainDriverDetails>();
		listOfDetails.forEach((trainDriverDetails) -> {
			if (trainDriverDetails.getTrainId().equals(trainId)){
				newList.add(trainDriverDetails);
			}
		});
		return newList;
	}
	
	private static void sortListOfIncompleteDriverDetailsOnDepartureTime(List<TrainDriverDetails> trainDriverDetails) {
		Comparator<TrainDriverDetails> comparatorLambda = (TrainDriverDetails tdd1, TrainDriverDetails tdd2) -> tdd1.getActualDepartureTimeAsString().compareTo(tdd2.getActualDepartureTimeAsString());
		trainDriverDetails.sort(comparatorLambda);
	}
	
	private static String getFirstStationByDriverName(String driverName, List<TrainDriverDetails> sortedListOfDetails) {
		String firstStation = "";
		int counter = 0;
		boolean wasDriverNameFound = false;
		boolean dismissSearchForDriverName = false;
		while (!wasDriverNameFound && !dismissSearchForDriverName) {
			TrainDriverDetails details = sortedListOfDetails.get(counter);
			if (details.getDriverName().equals(driverName)) {
				firstStation = details.getStation();
				wasDriverNameFound = true;
			}
			counter++;
			if (counter == sortedListOfDetails.size() - 1) {
				firstStation = "N/A";
				dismissSearchForDriverName = true;
			}
		}
		return firstStation;
	}
	
	private static String getLastStationByDriverNameAndSetJourneyStatus(String driverName, List<TrainDriverDetails> sortedListOfDetails) {
		String intermediateStation = "";
		String lastStation = "";
		String journeyStatus = "";
		for (TrainDriverDetails trainDriverDetails : sortedListOfDetails) {
			if (trainDriverDetails.getDriverName().equals(driverName)) {
				intermediateStation = trainDriverDetails.getStation();
			}
			journeyStatus = isJourneyInProgress(trainDriverDetails.getDepartureLatenessInSecs());
		}
		lastStation = intermediateStation;
		driverJourneyStatus = journeyStatus;
		return lastStation;
	}
	
	public static int getGeneratedId() {
		return generatedId++;
	}
	
	private static String isJourneyInProgress(String latenessInSecs) {
		String status = "";
		if (latenessInSecs.equals("NA")) {
			status = "COMPLETED";
		} else {
			status = "INPROGRESS";
		}
		return status;
	}
	
}
