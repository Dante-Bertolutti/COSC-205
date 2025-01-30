import java.util.Date;

public class test {
	
	public static void main(String[] args){
		
		Exercise a = new Exercise("Bench  Press",135,10);
		
		Exercise b = new Exercise ("Shoulder Press",90,10);
		
		Workout test1 = new Workout(1, "10/01/25");
		
		test1.add(a);
		
		test1.add(b);
		
		System.out.println(test1.toString());
		
//		Date sd = new Date();
//		Date ed = new Date(sd.getTime() + 50);
//		Goal g = new Goal(1, "Test", "this is a test", sd, ed);
//		System.out.println(g.calculateTimeRemaining());
		
	}

}
