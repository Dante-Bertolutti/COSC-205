
public class test {
	
	public static void main(String[] args){
		
		Exercise a = new Exercise("Bench  Press",135,10);
		
		Exercise b = new Exercise ("Shoulder Press",90,10);
		
		Workout test1 = new Workout(1, "10/01/25");
		
		test1.add(a);
		
		test1.add(b);
		
		System.out.println(test1.toString());
		Food steak = new Food("Steak", 1, 700, 50);
		Food potato = new Food("Potato", 1, 400, 0);
		Meal meal = new Meal("Dinner", "15/12/25", 1);
		meal.addFood(steak);
		meal.addFood(potato);
		System.out.println(meal);
	}

}
