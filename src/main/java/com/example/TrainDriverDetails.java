package com.example;

public class TrainDriverDetails {
	private int journeyId;
	private String trainId;
	private String startStation;
	private String endStation;
	private String driverName;
	private String journeyStatus;
	
	public TrainDriverDetails(int journeyId, String trainId, String startStation, String endStation, String driverName,
			String journeyStatus) {
		this.journeyId = journeyId;
		this.trainId = trainId;
		this.startStation = startStation;
		this.endStation = endStation;
		this.driverName = driverName;
		this.journeyStatus = journeyStatus;
	}

	public int getJourneyId() {
		return journeyId;
	}

	public void setJourneyId(int journeyId) {
		this.journeyId = journeyId;
	}

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	public String getStartStation() {
		return startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	public String getEndStation() {
		return endStation;
	}

	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getJourneyStatus() {
		return journeyStatus;
	}

	public void setJourneyStatus(String journeyStatus) {
		this.journeyStatus = journeyStatus;
	}
	
}
