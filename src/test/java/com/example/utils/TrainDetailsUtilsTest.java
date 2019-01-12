package com.example.utils;

import java.util.List;

import org.junit.Test;

import com.example.TrainDetails;

import static org.junit.Assert.*;

public class TrainDetailsUtilsTest {
	
	@Test
	public void testGetAllTrainDetailsReturnListOfTrainDetails(){
		//Arrange
		List<TrainDetails> actual = TrainDetailsUtils.getAllTrainDetails();
		
		//Act
		System.out.println("Printing list of train details..");
		for (TrainDetails trainDetails : actual){
			System.out.println("Train Details: " + trainDetails.toString());
		}
		
		//Assert
		assertNotNull(actual);
		assertTrue(!actual.isEmpty());
	}
	
	@Test
	public void testGetLowestSpeedByTrainTypeReturnsHigherThanZeroWhenValidTrainType(){
		//Arrange
		int actual;
		
		//Act
		actual = TrainDetailsUtils.getLowestSpeedByTrainType("157P");
		if (actual == 0){
			System.out.println("No Details found");
		} else {
			System.out.println("Details found lowest speed is " + actual);
		}
		
		//Assert
		assertTrue(actual > 0);
	}
	
	@Test
	public void testGetLowestSpeedByTrainTypeReturnsZeroWhenInvalidTrainType(){
		//Arrange
		int actual;
		
		//Act
		actual = TrainDetailsUtils.getLowestSpeedByTrainType("random");
		if (actual == 0){
			System.out.println("No Details found");
		} else {
			System.out.println("Details found lowest speed is " + actual);
		}
		
		//Assert
		assertEquals(0, actual);
	}
	
	@Test
	public void testGetTrainDetailsWithHighestEnergyByTrainTypeReturnsNotNullWhenValidTrainType(){
		//Arrange
		TrainDetails actual;
		
		//Act
		actual = TrainDetailsUtils.getTrainDetailsWithHighestEnergyByTrainType("157P");
		if (actual == null){
			System.out.println("No Details found");
		} else {
			System.out.println("Details found Highest energy is " + actual.getEnergy() + " and speed is " + actual.getSpeed());
		}
		
		//Assert
		assertNotNull(actual);
	}
	
	@Test
	public void testGetTrainDetailsWithHighestEnergyByTrainTypeReturnsNullWhenInvalidTrainType(){
		//Arrange
		TrainDetails actual;
		
		//Act
		actual = TrainDetailsUtils.getTrainDetailsWithHighestEnergyByTrainType("random");
		if (actual == null){
			System.out.println("No Details found");
		} else {
			System.out.println("Details found Highest energy is " + actual.getEnergy() + " and speed is " + actual.getSpeed());
		}
		
		//Assert
		assertNull(actual);
	}

}
