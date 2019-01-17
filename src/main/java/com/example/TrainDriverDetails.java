package com.example;

import java.time.LocalDateTime;

public class TrainDriverDetails {
	private int journeyId;
	private String trainId;
	private String startStation;
	private String endStation;
	private String driverName;
	private String journeyStatus;
	private boolean isDriverDetailsComplete;
	private String station;
	private LocalDateTime actualDepartureTime;
	private String departureLatenessInSecs;
	
	public TrainDriverDetails(int journeyId, String trainId, String startStation, String endStation, String driverName,
			String journeyStatus) {
		this.journeyId = journeyId;
		this.trainId = trainId;
		this.startStation = startStation;
		this.endStation = endStation;
		this.driverName = driverName;
		this.journeyStatus = journeyStatus;
		this.isDriverDetailsComplete = true;
	}
	
	public TrainDriverDetails(String trainId, String station, LocalDateTime actualDepartureTime, String driverName, String departureLatenessInSecs) {
		this.trainId = trainId;
		this.station = station;
		this.actualDepartureTime = actualDepartureTime;
		this.driverName = driverName;
		this.departureLatenessInSecs = departureLatenessInSecs;
		this.isDriverDetailsComplete = false;
	}
	
	
//	public TrainDriverDetails(String trainId, String driverName, String journeyStatus) {
//		this.trainId = trainId;
//		this.driverName = driverName;
//		this.journeyStatus = journeyStatus;
//	}

	public int getJourneyId() {
		return journeyId;
	}

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}
	
	public String getStation() {
		return startStation;
	}
	
	

//	public void setStation(String station) {
//		this.station = station;
//	}
	

	public String getStartStation() {
		return startStation;
	}
//
//	public void setStartStation(String startStation) {
//		this.startStation = startStation;
//	}
//
	public String getEndStation() {
		return endStation;
	}
//
//	public void setEndStation(String endStation) {
//		this.endStation = endStation;
//	}

	public String getDepartureLatenessInSecs() {
		return departureLatenessInSecs;
	}

//	public void setDepartureLatenessInSecs(String departureLatenessInSecs) {
//		this.departureLatenessInSecs = departureLatenessInSecs;
//	}

	public String getDriverName() {
		return driverName;
	}

//	public void setDriverName(String driverName) {
//		this.driverName = driverName;
//	}

	public String getJourneyStatus() {
		return journeyStatus;
	}

	public void setJourneyStatus(String journeyStatus) {
		this.journeyStatus = journeyStatus;
	}

	public LocalDateTime getActualDepartureTime() {
		return actualDepartureTime;
	}

	public void setActualDepartureTime(LocalDateTime actualDepartureTime) {
		this.actualDepartureTime = actualDepartureTime;
	}
	
}
