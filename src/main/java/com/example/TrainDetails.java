package com.example;

public class TrainDetails {
	
	private String trainType;
	private int speed; //kmph
	private int energy; //kwh
	
	public TrainDetails(String trainType, int speed, int energy){
		this.trainType = trainType;
		this.speed = speed;
		this.energy = energy;
	}
	
	public String getTrainType(){
		return trainType;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public int getEnergy(){
		return energy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + energy;
		result = prime * result + speed;
		result = prime * result + ((trainType == null) ? 0 : trainType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainDetails other = (TrainDetails) obj;
		if (energy != other.energy)
			return false;
		if (speed != other.speed)
			return false;
		if (trainType == null) {
			if (other.trainType != null)
				return false;
		} else if (!trainType.equals(other.trainType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrainDetails [trainType=" + trainType + ", speed=" + speed + ", energy=" + energy + "]";
	}
	
}
