import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Workout implements Serializable {

	static int count=0;
	
	private int workoutId;

    private String date;

    private ArrayList<Exercise> exercises;

    public Workout(int i, String d) {
        this.workoutId = count;
        this.date = d;
        this.exercises = new ArrayList<>();
    }

    public void add(Exercise e) {
        this.exercises.add(e);
    }

    public String toString() {
    	int calsburned=0;
    	String result ="";
        for (Exercise e : exercises) {
            result += e.getName() + "\n";
            calsburned+=e.getCaloriesBurned();
        }
        
        return result+" "+calsburned+" is the number of calories burned in this workout";
    }

    public String getDate() {
        return this.date;
    }

    public int getWorkoutId() {
        return this.workoutId;
    }

    public ArrayList<Exercise> getExercises() {
        return this.exercises;
    }
    public static Workout createWorkout(User user) {
        LocalDate currentDate = LocalDate.now();
        
        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        
        // Format the current date
        String formattedDate = currentDate.format(formatter);
    	
    	Workout w = new Workout(count,formattedDate);
    	
    	user.workouts.add(w);
    	
    	System.out.println(user.workouts.size());
    	
    	return w;
    	
    }
}
