package com.example;

import com.example.utils.TrainDelayDetailsUtils;

public class TrainDelayDetails {
	private int journeyId;
	private String trainId;
	private String station;
	private String departureTime;
	private String depatureLate;
	
	public TrainDelayDetails(String trainId, String station, String departureTime,
			String depatureLate) {
		this.journeyId = TrainDelayDetailsUtils.getGeneratedId();
		this.trainId = trainId;
		this.station = station;
		this.departureTime = departureTime;
		this.depatureLate = depatureLate;
	}

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
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getDepatureLate() {
		return depatureLate;
	}

	public void setDepatureLate(String depatureLate) {
		this.depatureLate = depatureLate;
	}
	
}
