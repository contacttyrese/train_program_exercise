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

	public String getStation() {
		return station;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getDepatureLate() {
		return depatureLate;
	}

	@Override
	public String toString() {
		return "TrainDelayDetails [journeyId=" + journeyId + ", trainId=" + trainId + ", station=" + station
				+ ", departureTime=" + departureTime + ", depatureLate=" + depatureLate + "]";
	}

}
