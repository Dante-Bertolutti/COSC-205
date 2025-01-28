import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User activeUser;
        Scanner in = new Scanner(System.in);

        System.out.println("Hello and welcome to GainsRus. Would you like to login or create an account (Type login or create)");
        String answer = in.nextLine().trim(); // Use nextLine() to read the entire input line

        if (answer.equalsIgnoreCase("login")) {
            activeUser = User.userLogin();
            System.out.println("Welcome " + activeUser.getName());
            User.viewUserWorkouts(activeUser);
            System.out.println("Would you like to create a new workout? (Y/N)");
            if (in.nextLine().equalsIgnoreCase("Y")){
                Workout.createWorkout(activeUser);
                User.saveUser(activeUser);
            } else {
                System.out.println("Thank you for using GainsRus");
            }
        } else if (answer.equalsIgnoreCase("create")) {
            User.createAccount();
        } else {
            System.out.println("Invalid option. Please type 'login' or 'create'.");
        }

        in.close();  // Close the scanner once it's done
    }
}
