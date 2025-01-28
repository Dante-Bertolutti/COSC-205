import java.util.Scanner;

public class Weights extends Exercise{
	
	private String name;
	
	static int count=0;
	
	private int id;

	private int weight;

	private int reps;
	
	private double caloriesburned;

	public Weights(String name, int weight, int reps) {
		super(name);
		this.weight=weight;
		this.reps=reps;
		this.id=count;
		count++;
		this.caloriesburned=reps*(0.3);
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Weights.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCaloriesburned() {
		return caloriesburned;
	}

	public void setCaloriesburned(double caloriesburned) {
		this.caloriesburned = caloriesburned;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public String getName() {
		return this.name;
	}
	public int getWeight() {
		return this.weight;
	}
	public int getReps() {
		return this.reps;
	}
	public double getOneRepMax(double w, int reps){
		if (reps == 15)
			return w * 1.5;
		if (reps == 14)
			return w * 1.466;
		if (reps == 13)
			return w * 1.433;
		if (reps == 12)
			return w * 1.4;
		if (reps == 11)
			return w * 1.366;
		if (reps == 10)
			return w * 1.333;
		if (reps == 9)
			return w * 1.3;
		if (reps == 8)
			return w * 1.266;
		if (reps == 7)
			return w * 1.233;
		if (reps == 6)
			return w * 1.2;
		if (reps == 5)
			return w * 1.167;
		if (reps == 4)
			return w * 1.133;
		if (reps == 3)
			return w * 1.1;
		if (reps == 2)
			return w * 1.067;
		return w;

	}
	
	public static void CreateWorkout(Workout w) {
		Scanner in = new Scanner(System.in);
	//	String answer="";
		//while()
		System.out.println("add set");
		
	//	Scanner s = new
		
	}

	@Override
	public void calculateCaloriesBurned() {
		// TODO Auto-generated method stub
		caloriesburned=caloriesburned*1;
	}
}
