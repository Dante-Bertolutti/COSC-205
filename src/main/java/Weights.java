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
		this.caloriesburned=reps*(0.1);
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

	public double getCaloriesBurned() {
		return caloriesburned;
	}

	public void setCaloriesBurned(double caloriesburned) {
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
	
	public static void createWeights(Workout work) {
	    Scanner in = new Scanner(System.in);
	    String answer = "";
	    
	    System.out.println("Would you like to see an example workout? F - Full body, L - Lower Body, U - Upper Body or C to continue");
	    answer = in.nextLine();
	    if(answer.toUpperCase().equals("F")) {
	        WorkoutGenerator workoutGenerator = new WorkoutGenerator();
	        workoutGenerator.generateWorkout("F");
	    }
	    if(answer.toUpperCase().equals("L")) {
	        WorkoutGenerator workoutGenerator = new WorkoutGenerator();
	        workoutGenerator.generateWorkout("L");
	    }
	    if(answer.toUpperCase().equals("U")) {
	        WorkoutGenerator workoutGenerator = new WorkoutGenerator();
	        workoutGenerator.generateWorkout("U");
	    }
	    
	    while(!answer.equalsIgnoreCase("done")) {
	        // Variables for each exercise set
	        String n = "";
	        int w = 0;
	        int r = 0;

	        // Input exercise details
	        System.out.println("Input exercise name:");
	        n = in.nextLine(); // Use nextLine() to allow for multi-word exercise names
	        System.out.println("Input amount of weight:");
	        w = in.nextInt();
	        System.out.println("Input number of reps:");
	        r = in.nextInt();
	        
	        // Create the Weights object and add to Workout
	        Weights currentSet = new Weights(n, w, r);
	        work.add(currentSet);

	        // Prompt the user to either continue or finish
	        System.out.println("Enter 'done' if weightlifting is concluded, or type anything else to continue.");
	        in.nextLine(); // Consume newline left by nextInt()
	        answer = in.nextLine();  // Read the user's response
	    }
	}

	@Override
	public void calculateCaloriesBurned() {
		// TODO Auto-generated method stub
		caloriesburned=caloriesburned*1;
	}
	public String toString() {
		return super.getName()+" "+this.getWeight()+"lbs x"+this.getReps();
	}
}
