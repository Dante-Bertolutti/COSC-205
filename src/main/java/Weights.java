import java.io.Serializable;
import java.util.Scanner;

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
	}
	@Override
	public String toString() {
		return "Weights Exercise: " + getName() + "\nWeight: " + weight + " kg\nReps: " + reps + "\nCalories Burned: " + getCaloriesBurned();
	}

}
