
public class Cardio extends Exercise{
	
private int id;

private String name;

private int distanceInKm;

private int timeInSeconds;

private int caloriesburned;


public Cardio(String n, int d, int t) {
	this.name=n;
	this.distanceInKm=d;
	this.timeInSeconds=t;
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



}
