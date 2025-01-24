
public class Cardio extends Exercise{
	
private int id;

private String name;

private int distanceInKm;

private int timeInSeconds;

private int caloriesburned;


public Cardio(String n, int id, int d, int t, int c) {
	this.name=n;
	this.distanceInKm=d;
	this.timeInSeconds=t;
	this.id=id;
	this.caloriesburned=c;
}

public String getName() {
	return this.name;
}

public double getAverageSpeed() {
	
	return distanceInKm*3600/timeInSeconds;
	
}

public int getTime(){
	return timeInSeconds;
}

public int getDistance() {
	return distanceInKm;
}

public int getCaloriesBurned() {
	return caloriesburned;
}



}
