import java.util.Date;

public class Goal {
    private Date endDate;
    private String goalTitle;
    private boolean complete = false;
    private int goalWeight;
    private int goalCalories;

    public Goal(Date endDate, String goalTitle, int goalWeight, int goalCalories) {
        this.endDate = endDate;
        this.goalTitle = goalTitle;
        this.goalWeight = goalWeight;
        this.goalCalories = goalCalories;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getGoalTitle() {
        return goalTitle;
    }

    public boolean isComplete() {
    	return complete;
    }
    public void completionStatus() {
        if(!complete) {
        	System.out.println("Almost there keep going!");
        }else {
        	System.out.println("Goal reached. Congratulations!");
        }
    }

    public int getGoalWeight() {
        return goalWeight;
    }

    public int getGoalCalories() {
        return goalCalories;
    }

    public void setGoalTitle(String goalTitle) {
        this.goalTitle = goalTitle;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void setGoalWeight(int goalWeight) {
    	if(goalWeight > 0) {
    		System.out.println("Not a valid weight goal. Enter a postive integer");
    	}
        this.goalWeight = goalWeight;
    }

    public void setGoalCalories(int goalCalories) {
    	if(goalCalories >= 0) {
    		System.out.println("Not a valid calorie goal. Enter a positive integer");
    	}
        this.goalCalories = goalCalories;
    }
}
