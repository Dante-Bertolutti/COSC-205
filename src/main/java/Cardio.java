import java.io.Serializable;
import java.util.Scanner;

public class Cardio extends Exercise implements Serializable {

    private int distanceInKm;
    private int timeInSeconds;

    public Cardio(String name, int distanceInKm, int timeInSeconds) {
        super(name);
        this.distanceInKm = distanceInKm;
        this.timeInSeconds = timeInSeconds;
        calculateCaloriesBurned(); // Call the method to calculate calories
    }

    @Override
    public void calculateCaloriesBurned() {
        double speed = (double) distanceInKm / (timeInSeconds / 3600.0);
        double calories = 0.05 * distanceInKm * speed;
        setCaloriesBurned(calories); // Set the calculated calories
    }


    public static void createCardio(Workout workout) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the distance in kilometers:");
        int distance = input.nextInt();

        System.out.println("Enter the time in seconds:");
        int time = input.nextInt();

        input.nextLine(); // Clear the buffer

        System.out.println("Enter the name of the cardio activity (e.g., 'Running', 'Cycling'):");
        String name = input.nextLine();

        Cardio cardioExercise = new Cardio(name, distance, time);
        workout.add(cardioExercise);

        System.out.println("You burned " + cardioExercise.getCaloriesBurned() + " calories!");
    }
    @Override
    public String toString() {
        return "Cardio Exercise: " + getName() + "\nDistance: " + distanceInKm + " km\nTime: " + timeInSeconds + " seconds\nCalories Burned: " + getCaloriesBurned();
    }

}
