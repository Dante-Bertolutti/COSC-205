import java.util.ArrayList;

public class Workout {

    private int workoutId;

    private String date;

    private ArrayList<Exercise> exercises;

    public Workout(int i, String d) {
        this.workoutId = i;
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
}
