import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Workout implements Serializable {

    static int count = 0;

    private int workoutId;
    private String date;
    private ArrayList<Exercise> exercises;

    // Constructor
    public Workout(String date) {
        this.workoutId = count++;
        this.date = date;
        this.exercises = new ArrayList<>();
    }

    // Add exercise to the workout
    public void add(Exercise e) {
        this.exercises.add(e);
    }

    // toString method using StringBuilder for better performance
    public String toString() {
        double calsBurned = 0;
        StringBuilder result = new StringBuilder();
        for (Exercise e : exercises) {
            result.append(e.getName()).append("\n");
            calsBurned += e.getCaloriesBurned();
        }

        result.append(calsBurned).append(" is the number of calories burned in this workout");
        return result.toString();
    }

    // Getters
    public String getDate() {
        return this.date;
    }

    public int getWorkoutId() {
        return this.workoutId;
    }

    public ArrayList<Exercise> getExercises() {
        return this.exercises;
    }

    public String workoutSummary() {
        StringBuilder summary = new StringBuilder();
        double totalCalories = 0;

        summary.append("Workout Summary - Date: ").append(date).append("\n");

        for (Exercise exercise : exercises) {
            summary.append(exercise.toString()).append("\n");
            totalCalories += exercise.getCaloriesBurned();
        }

        summary.append("Total Calories Burned: ").append(totalCalories).append("\n");
        return summary.toString();
    }

    // Static method to create a workout for a user
    public static void createWorkout(User user) {
        Scanner input = new Scanner(System.in);
        boolean workoutStatus = true;

        // Get current date
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        String formattedDate = currentDate.format(formatter);

        // Create new workout object
        Workout w = new Workout(formattedDate);
        System.out.println("Starting workout on Date: " + formattedDate);

        // Loop for workout choices
        while (workoutStatus) {
            System.out.println("Would you like to do weights or cardio? Enter 'close' to stop the workout.");
            String choice = input.nextLine().trim(); // Ensure input is trimmed

            if (choice.equalsIgnoreCase("cardio")) {
                Cardio.createCardio(w); // Ensure this method exists and works
            } else if (choice.equalsIgnoreCase("weights")) {
                Weights.createWeights(w); // Ensure this method exists and works
            } else if (choice.equalsIgnoreCase("close")) {
                System.out.println(w.workoutSummary());
                user.workouts.add(w);
                workoutStatus = false; // Close the workout
            } else {
                System.out.println("Invalid choice. Please enter 'cardio', 'weights', or 'close'.");
            }
        }

        // Add workout to the user's list


        input.close(); // Close the scanner
    }



}
