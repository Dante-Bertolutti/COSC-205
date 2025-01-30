public class Food {
    private String name;
    private int ID;
    private int calories;
    private int protein;

    public Food(String name, int ID, int calories, int protein){
        this.name = name;
        this.ID = ID;
        this.calories = calories;
        this.protein = protein;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }
    @Override
    public String toString() {
    	return this.name + " has " + this.calories + " calories and " + this.protein + " grams of protein.";  
    }
}
