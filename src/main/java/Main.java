import java.util.Scanner;

public class Main {
            public static void main(String[] args) {
                User activeUser;
                Scanner in = new Scanner(System.in);
                System.out.println("Hello and welcome to GainsRus. Would you like to login or create an account (Type login or create)");
                String answer = in.next();
                if (answer.equalsIgnoreCase("login")){
                    activeUser = User.userLogin();
                    System.out.println("make your workout");
                    Workout.createWorkout(activeUser);
                    System.out.println("are you doing cardio or weights today?(type cardio or weights)");
                    String answer2=in.next();
                    if(answer.equalsIgnoreCase("weights")) {
                    	
                    }
                } else {
                    User.createAccount();
                }
            }

        }



