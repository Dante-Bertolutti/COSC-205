import java.util.Date;

public class Goal {
    private Date endDate;
    private String goalTitle;
    private boolean complete = false;
    private Workout workout;
    private Meal diet;

    public Goal(Date endDate, String goalTitle, boolean complete, Workout workout, Meal diet) {
        this.endDate = endDate;
        this.goalTitle = goalTitle;
        this.complete = complete;
        this.workout = workout;
        this.diet = diet;
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

    public Workout getWorkout() {
        return workout;
    }

    public Meal getDiet() {
        return diet;
    }
}
