
import java.util.ArrayList;

public class User {
    public int userID;
    public String name;
    public int maintenanceCalories;
    public ArrayList<Workout> workouts = new ArrayList<>();
    public ArrayList<Meal> meals = new ArrayList<>();

    public User(int userID, String name, int maintenanceCalories) {
        this.userID = userID;
        this.name = name;
        this.maintenanceCalories = maintenanceCalories;
    }

    public void displayMealsToConsole(){
        for (Meal meal: meals)
            System.out.println(meal.toString());
    }
    public void displayWorkoutsToConsole(){
        for (Workout workout: workouts) {
            System.out.println(workout.toString());
        }
    }
}
