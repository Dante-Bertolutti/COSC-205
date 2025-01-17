
import java.util.ArrayList;

public class User {
    public int userID;
    public String name;
    public int maintenanceCalories;
    public ArrayList<Workout> workouts = new ArrayList<>();
    public ArrayList<Meal> meals = new ArrayList<>();

    public void displayMealsToConsole(ArrayList<Meal> meals){
        this.meals = meals;
        for (Meal meal: meals)
        System.out.println(meal.toString());
    }
    public void displayWorkoutsToConsole(ArrayList<Workout> workouts){
        this.workouts = workouts;
        for (Workout workout: workouts) {
            System.out.println(workout.toString());
        }
    }
}
