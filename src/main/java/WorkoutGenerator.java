import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class WorkoutGenerator {


	// Arrays of weightlifting exercises with 3x10-15 rep range
	private String[] upperBodyExercises = {
			"Bench Press 3x10-15",
			"Overhead Press 3x10-15",
			"Pull-ups 3x10-15",
			"Dumbbell Chest Press 3x10-15",
			"Incline Dumbbell Press 3x10-15",
			"Barbell Row 3x10-15",
			"Lat Pulldown 3x10-15",
			"Dumbbell Shoulder Press 3x10-15",
			"Barbell Bicep Curls 3x10-15",
			"Tricep Dips 3x10-15"
	};

	private String[] lowerBodyExercises = {
			"Back Squat 3x10-15",
			"Front Squat 3x10-15",
			"Deadlift 3x10-15",
			"Romanian Deadlift 3x10-15",
			"Leg Press 3x10-15",
			"Lunges (with Barbell) 3x10-15 (each leg)",
			"Bulgarian Split Squats 3x10-15 (each leg)",
			"Hip Thrusts 3x10-15",
			"Leg Curls (Machine) 3x10-15",
			"Calf Raises 3x10-15"
	};

	// Random object for selecting random exercises
	private Random random = new Random();

	// Method to generate 6 random workouts (either upper or lower body)
	public void generateWorkout(String type) {
		// Decide if the workout will be upper body or lower body
		boolean isUpperBody = random.nextBoolean();

		Set<String> selectedExercises = new HashSet<>();  // Set to track selected exercises

		if (type.equals("U")) {
			// Print 6 random unique upper body exercises
			System.out.println("Upper Body Workout:");
			while (selectedExercises.size() < 6) {
				String upperBodyWorkout = upperBodyExercises[random.nextInt(upperBodyExercises.length)];
				selectedExercises.add(upperBodyWorkout);  // Add to set (duplicate will be ignored)
			}
		}if(type.equals("L")){
			// Print 6 random unique lower body exercises
			System.out.println("Lower Body Workout:");
			while (selectedExercises.size() < 6) {
				String lowerBodyWorkout = lowerBodyExercises[random.nextInt(lowerBodyExercises.length)];
				selectedExercises.add(lowerBodyWorkout);  // Add to set (duplicate will be ignored)
			}
		}
		if(type.equals("F")){
			// Print 6 random unique lower body exercises
			System.out.println("Full Body Workout:");
			while (selectedExercises.size() < 3) {
				String lowerBodyWorkout = lowerBodyExercises[random.nextInt(lowerBodyExercises.length)];
				selectedExercises.add(lowerBodyWorkout);  // Add to set (duplicate will be ignored)
			}
			while (selectedExercises.size() < 6) {
				String upperBodyWorkout = upperBodyExercises[random.nextInt(upperBodyExercises.length)];
				selectedExercises.add(upperBodyWorkout);
			}
		}

		// Print the selected exercises
		for (String exercise : selectedExercises) {
			System.out.println(exercise);
		}
	}
}

