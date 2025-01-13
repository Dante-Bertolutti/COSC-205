
public class Workout {
	
	private int workoutId;
	
	private String date;
	
	private ArrayList<Exercises> exercises;
	
	public Workout(int i, String d) {
		this.workoutId= i;
		this.date=d;
		this.exercises=new ArrayList<>();
	}
	
	public String toString() {
		String result = "";
		for(Exercise e : exercises)
			result +=e.getName()+" ";
		return result;
	}
	
	public void add(Exercise e) {
		exercises.add(e);
	}
}
