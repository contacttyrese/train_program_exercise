package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.TrainDelayDetails;

public class TrainDelayDetailsDao {
	
	private Connection connection = null;
	
	public TrainDelayDetailsDao(Connection connection) {
		this.connection = connection;
	}
	
	public void addTrainDelayDetails(TrainDelayDetails trainDelayDetails) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String sql = "INSERT INTO train_delay_details "
					+ "(journey_id, train_id, station, departure_time, departure_late) "
					+ "VALUES "
					+ "(" + trainDelayDetails.getJourneyId() + ",'"
					+ trainDelayDetails.getTrainId() + "','" + trainDelayDetails.getStation() + "','"
					+ trainDelayDetails.getDepartureTime() + "','" + trainDelayDetails.getDepatureLate()
					+ "')";
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
