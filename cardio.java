import java.io.Serializable;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
        try {
            // Distance input
            String distanceStr = JOptionPane.showInputDialog(null, "Enter the distance in kilometers:", "Cardio Workout", JOptionPane.QUESTION_MESSAGE);
            if (distanceStr == null) return; // User canceled
            int distance = Integer.parseInt(distanceStr);

            // Time input
            String timeStr = JOptionPane.showInputDialog(null, "Enter the time in seconds:", "Cardio Workout", JOptionPane.QUESTION_MESSAGE);
            if (timeStr == null) return; // User canceled
            int time = Integer.parseInt(timeStr);

            // Activity name input
            String name = JOptionPane.showInputDialog(null, "Enter the name of the cardio activity (e.g., 'Running', 'Cycling'):", "Cardio Workout", JOptionPane.QUESTION_MESSAGE);
            if (name == null || name.trim().isEmpty()) return; // User canceled or left blank

            // Create cardio exercise
            Cardio cardioExercise = new Cardio(name, distance, time);
            workout.add(cardioExercise);

            // Show calories burned
            JOptionPane.showMessageDialog(null, "You burned " + cardioExercise.getCaloriesBurned() + " calories!", "Workout Summary", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter numbers for distance and time.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


   /*** public static void createCardio(Workout workout) {
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
    } **/
    @Override
    public String toString() {
        return "Cardio Exercise: " + getName() + "\nDistance: " + distanceInKm + " km\nTime: " + timeInSeconds + " seconds\nCalories Burned: " + getCaloriesBurned();
    }

}
