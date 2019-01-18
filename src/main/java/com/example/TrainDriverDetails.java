package com.example;

public class TrainDriverDetails {
	private int journeyId;
	private String trainId;
	private String startStation;
	private String endStation;
	private String driverName;
	private String journeyStatus;
	private String station;
	private String actualDepartureTime;
	private String departureLatenessInSecs;
	
	public TrainDriverDetails(int journeyId, String trainId, String startStation, String endStation, String driverName,
			String journeyStatus) {
		this.journeyId = journeyId;
		this.trainId = trainId;
		this.startStation = startStation;
		this.endStation = endStation;
		this.driverName = driverName;
		this.journeyStatus = journeyStatus;
	}
	
	public TrainDriverDetails(String trainId, String station, String actualDepartureTime, String driverName, String departureLatenessInSecs) {
		this.trainId = trainId;
		this.station = station;
		this.actualDepartureTime = actualDepartureTime;
		this.driverName = driverName;
		this.departureLatenessInSecs = departureLatenessInSecs;
	}
	
	public int getJourneyId() {
		return journeyId;
	}

	public String getTrainId() {
		return trainId;
	}

	public String getStation() {
		return station;
	}
	
	public String getStartStation() {
		return startStation;
	}

	public String getEndStation() {
		return endStation;
	}

	public String getDepartureLatenessInSecs() {
		return departureLatenessInSecs;
	}

	public String getDriverName() {
		return driverName;
	}

	public String getJourneyStatus() {
		return journeyStatus;
	}

	public String getActualDepartureTimeAsString() {
		return actualDepartureTime;
	}

	@Override
	public String toString() {
		return "TrainDriverDetails [journeyId=" + journeyId + ", trainId=" + trainId + ", startStation=" + startStation
				+ ", endStation=" + endStation + ", driverName=" + driverName + ", journeyStatus=" + journeyStatus
				+ "]";
	}

}
