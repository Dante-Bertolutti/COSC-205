
public class test {
	
	public static void main(String[] args){
		
		Weights a = new Weights("Bench  Press",135,10);
		
		Weights b = new Weights("Shoulder Press",90,10);
		
		Cardio c = new Cardio("Running",5,600);
		
		Workout test1 = new Workout(1, "10/01/25");
		
		test1.add(a);
		
		test1.add(b);
		
		test1.add(c);
		
		System.out.println(test1.toString());
		
	}

}
