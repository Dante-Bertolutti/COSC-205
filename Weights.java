import java.io.Serializable;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Weights extends Exercise implements Serializable {

	private int weight;
	private int reps;

	public Weights(String name, int weight, int reps) {
		super(name);
		this.weight = weight;
		this.reps = reps;
		calculateCaloriesBurned(); // Call the method to calculate calories
	}

	@Override
	public void calculateCaloriesBurned() {
		double calories = reps * 0.3; // Simple formula for calories burned in weights
		setCaloriesBurned(calories); // Set the calculated calories
	}

	 public static void createWeights(Workout workout) {
	        try {
	            // Weight input
	            String weightStr = JOptionPane.showInputDialog(null, "Enter the weight in kilograms:", "Weights Workout", JOptionPane.QUESTION_MESSAGE);
	            if (weightStr == null) return; // User canceled
	            int weight = Integer.parseInt(weightStr);

	            // Reps input
	            String repsStr = JOptionPane.showInputDialog(null, "Enter the number of reps:", "Weights Workout", JOptionPane.QUESTION_MESSAGE);
	            if (repsStr == null) return; // User canceled
	            int reps = Integer.parseInt(repsStr);

	            // Exercise name input
	            String name = JOptionPane.showInputDialog(null, "Enter the name of the weightlifting exercise (e.g., 'Bench Press', 'Squat'):", "Weights Workout", JOptionPane.QUESTION_MESSAGE);
	            if (name == null || name.trim().isEmpty()) return; // User canceled or left blank

	            // Create weight exercise
	            Weights weightExercise = new Weights(name, weight, reps);
	            workout.add(weightExercise);

	            // Show calories burned
	            JOptionPane.showMessageDialog(null, "You burned " + weightExercise.getCaloriesBurned() + " calories!", "Workout Summary", JOptionPane.INFORMATION_MESSAGE);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Invalid input. Please enter numbers for weight and reps.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	/**public static void createWeights(Workout workout) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter the weight in kilograms:");
		int weight = input.nextInt();

		System.out.println("Enter the number of reps:");
		int reps = input.nextInt();

		input.nextLine(); // Clear the buffer

		System.out.println("Enter the name of the weightlifting exercise (e.g., 'Bench Press', 'Squat'):");
		String name = input.nextLine();

		Weights weightExercise = new Weights(name, weight, reps);
		workout.add(weightExercise);

		System.out.println("You burned " + weightExercise.getCaloriesBurned() + " calories!");
	}**/
	
	@Override
	public String toString() {
		return "Weights Exercise: " + getName() + "\nWeight: " + weight + " kg\nReps: " + reps + "\nCalories Burned: " + getCaloriesBurned();
	}

}
