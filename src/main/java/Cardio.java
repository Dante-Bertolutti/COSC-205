import java.util.Scanner;

public class Cardio extends Exercise {

    public static int id;

    private String name;

    private double distanceInKm;

    private int timeInSeconds;

    private double caloriesburned;


    public Cardio(){
        id++;
        caloriesburned = ((double) timeInSeconds / 60) * 3;
    }
    Cardio(String n, int d, int t) {
        this.name = n;
        this.distanceInKm = d;
        this.timeInSeconds = t;
        caloriesburned = ((double) timeInSeconds / 60) * 3;
        id++;
    }

    public String getName() {
        return this.name;
    }

    public double getAverageSpeed() {

        return distanceInKm * 3600 / timeInSeconds;

    }

    //Getters And Setters
    public int getTime() {
        return timeInSeconds;
    }

    public double getDistance() {
        return distanceInKm;
    }

    public double getDistanceInKm(){
        return caloriesburned;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDistanceInKm(double distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public void setTimeInSeconds(int timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    public void setCaloriesburned(int caloriesburned) {
        this.caloriesburned = caloriesburned;
    }

    public void createCardio(Workout workout) {
        Cardio cardio = new Cardio();
        Scanner input = new Scanner(System.in);
        System.out.println("How far did you travel in kilometers");
        cardio.setDistanceInKm(input.nextDouble());
        System.out.println("How long did it take you in seconds");
        cardio.setTimeInSeconds(input.nextInt());
        System.out.println("Great job your average speed was: " + getAverageSpeed() + " and you burned " + getCaloriesBurned() + " Calories");
        workout.add(cardio);
    }


}
