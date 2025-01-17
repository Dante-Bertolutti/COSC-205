
public class Exercise {

	private String name;

	private int weight;

	private int reps;

	public Exercise(String n, int w, int r) {
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
	public int getOneRepMax(int weight, int reps){
		if (reps==15) 
		return w*1.5;
	     if(reps==14) 
		return w*1.466;
		  if(reps==13) 
	    return w*1.433;
	    if(r==12) 
		return w*1.4
		if(r==11) 
	    return w*1.366
		if(r==10) 
		return w*1.333
	    if(r==9) 
	    return w*1.3
		if(r==8) 
	    return w*1.266
	    if(r==7) 
		return w*1.233
		if(r==6) 
	    return w*1.2
	    if(r==5) 
	    return w*1.167
	    if(r==4) 
	    return w*1.133
	    if(r==3) 
	    return w*1.1
	    if(r==2) 
	    return w*1.067
	    return w;
	}
}
