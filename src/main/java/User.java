
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    public String name;
    public int maintenanceCalories;
    public ArrayList<Workout> workouts = new ArrayList<>();
    public ArrayList<Meal> meals = new ArrayList<>();
    public ArrayList<Goal> goals = new ArrayList<>();

    public User(){}
    public User(int userID, String name, int maintenanceCalories) {
        this.name = name;
        this.maintenanceCalories = maintenanceCalories;
    }
    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaintenanceCalories() {
        return maintenanceCalories;
    }

    public void setMaintenanceCalories(int maintenanceCalories) {
        this.maintenanceCalories = maintenanceCalories;
    }

    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(ArrayList<Workout> workouts) {
        this.workouts = workouts;
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }

    //Display methods
    public void displayMealsToConsole(){
        for (Meal meal: meals)
            System.out.println(meal.toString());
    }
    public void displayWorkoutsToConsole(){
        for (Workout workout: workouts) {
            System.out.println(workout.toString());
        }
    }

    //Login and Create User methods
    public static User userLogin() {
        Scanner loginInput = new Scanner(System.in);
        System.out.println("What is your name: ");
        String username = loginInput.nextLine().trim();  // Ensure trimming whitespace

        // Check if username is not empty
        if (username.isEmpty()) {
            System.out.println("Username cannot be empty!");
            return null;
        }

        // Print the filename to debug
        System.out.println("Attempting to open file: " + username + ".ser");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(username + ".ser"))) {
            User deserializedUser = (User) ois.readObject();
            System.out.println("Login Successful");
            return deserializedUser;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("User does not exist. Would you like to create one? Type (Y/N)");
            String response = loginInput.nextLine().trim();
            if (response.equalsIgnoreCase("y")) {
                createAccount();  // User is created, but the new user is not returned here
                return null; // Ideally, you'd return the newly created user or handle accordingly
            } else {
                System.out.println("Goodbye");
                return null;
            }
        }
    }

    public static void saveUser(User user){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(user.getName() + ".ser"))) {
            oos.writeObject(user);
            System.out.println("User saved");
        } catch (IOException e) {
            System.out.println("Fail");
        }
    }

    public static void createAccount(){
        User newUser = new User();
        Scanner input = new Scanner(System.in);
        System.out.println("Hello and welcome to GainsRus you would like to create an account! Please proceed with the following steps.");
        System.out.println("Enter your first name. Please make sure to press enter after each prompt");
        newUser.setName(input.nextLine());
        System.out.println("What would you like to set your maintenance calories at");
        newUser.setMaintenanceCalories(input.nextInt());
        saveUser(newUser);
    }
    public static void viewUserWorkouts(User user) {
       ArrayList<Workout> workouts = user.getWorkouts();
        for (Workout w : workouts){
            System.out.println(w.workoutSummary());
            System.out.println("------------------");
        }
    }
    public void addGoal(Goal g) {
    	goals.add(g);
    }
}
