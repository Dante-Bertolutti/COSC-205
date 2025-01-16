
public class Workout {
	
	private int workoutId;
	
	private String date;
	
	private ArrayList<Exercises> exercises;
	
	public Workout(int i, String d) {
		this.workoutId= i;
		this.date=d;
		this.exercises=new ArrayList<>();
	}
	
	public void add(Exercise e) {
		this.exercises.add(e);
	}
	
	public String toString() {
		String result = "";
		for(Exercise e : exercises)
			result +=e.getName()+" "+e.getWeight()+" "e.getReps()+"\n";
		return result;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public int getWorkoutId(){
		return this.workoutId;
	}
	
	public ArrayList<Exercises> getExercises(){
		return this.exercises;
	}

}
