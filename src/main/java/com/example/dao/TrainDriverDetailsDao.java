package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.TrainDriverDetails;

public class TrainDriverDetailsDao {
	
	private Connection connection = null;
	
	public TrainDriverDetailsDao(Connection connection) {
		this.connection = connection;
	}
	
	public void addTrainDriverDetails(TrainDriverDetails trainDriverDetails) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String sql = "INSERT INTO train_driver_details "
					+ "(journey_id, train_id, start_station, end_station, driver_name, journey_status) "
					+ "VALUES "
					+ "(" + trainDriverDetails.getJourneyId() + ",'"
					+ trainDriverDetails.getTrainId() + "','" + trainDriverDetails.getStartStation() + "','"
					+ trainDriverDetails.getEndStation() + "','" + trainDriverDetails.getDriverName() + "','"
					+ trainDriverDetails.getJourneyStatus() + "')";
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
