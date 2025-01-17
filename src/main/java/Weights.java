
public class Weights extends Exercise{
	
	private String name;

	private int weight;

	private int reps;
	
	private int caloriesburned;

	public Weights(String n, int w, int r) {
		this.name=n;
		this.weight=w;
		this.reps=r;
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
}
