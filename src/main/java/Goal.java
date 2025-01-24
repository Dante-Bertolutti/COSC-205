import java.util.Date;

public class Goal {
    private Date endDate;
    private String goalTitle;
    private boolean complete = false;
    private int goalWeight;
    private int goalCalories;

    public Goal(Date endDate, String goalTitle, boolean complete, int goalWeight, int goalCalories) {
        this.endDate = endDate;
        this.goalTitle = goalTitle;
        this.complete = complete;
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
        this.goalWeight = goalWeight;
    }

    public void setGoalCalories(int goalCalories) {
        this.goalCalories = goalCalories;
    }
}
