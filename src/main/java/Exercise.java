abstract class Exercise {

	public String name;
	public int id;
	public double caloriesBurned;
	static int count = 0;

	// Constructor
	public Exercise(String name) {
		this.name = name;
		this.id = count++;
	}

	// Getters and Setters
	public String getName() {
		return this.name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCaloriesBurned() {
		return caloriesBurned;
	}

	public void setCaloriesBurned(double caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}

	// Abstract method to be implemented by subclasses
	public abstract void calculateCaloriesBurned();
}
