package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.example.dao.TrainDelayDetailsDao;
import com.example.dao.TrainDriverDetailsDao;
import com.example.utils.TrainDelayDetailsUtils;
import com.example.utils.TrainDriverDetailsUtils;

public class Application {

	public static void main(String[] args) {
		Connection connection = null;
		String user = "test";
		String password = "password";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		try {
//			connection = DriverManager.getConnection(url, user, password);
			System.out.println("connection successfully established..");
			final TrainDelayDetailsDao trainDelayDetailsDao = new TrainDelayDetailsDao(connection);
			final TrainDriverDetailsDao trainDriverDetailsDao = new TrainDriverDetailsDao(connection);
			
			List<TrainDelayDetails> listOfDelayDetails = TrainDelayDetailsUtils.getAllDelayDetails();
			List<TrainDriverDetails> listOfDriverDetails = TrainDriverDetailsUtils.getAllDriverDetails();
			
//			listOfDelayDetails.forEach(details -> trainDelayDetailsDao.addTrainDelayDetails(details));
//			listOfDriverDetails.forEach(details -> trainDriverDetailsDao.addTrainDriverDetails(details));
			
			System.out.println("success");
			connection.close();
		} catch (SQLException exception) {
			System.out.println("connection unsuccessful..");
			exception.printStackTrace();
		} finally {
			
		}
	}

}
