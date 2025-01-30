import java.time.LocalDate;
import java.util.Date;

public class tests {
	public static void main(String[] args) {
		Date d1 = new Date();
		Goal newGoal = new Goal(d1, "Bench 300", 300, 3000);
		System.out.println(newGoal.getGoalCalories());
		newGoal.setGoalCalories(0);
		System.out.println(newGoal.getGoalCalories());
	}
	
}
