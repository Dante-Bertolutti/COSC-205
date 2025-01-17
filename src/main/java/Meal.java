import java.util.ArrayList;

public class Meal{
    private String name;
    private String date;
    private int ID;
    private ArrayList<Food> foods = new ArrayList<>();

    public Meal(String name, String date, int ID) {
        this.name = name;
        this.date = date;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getID() {
        return ID;
    }
    public int getCalories(){
        int calories = 0;
        for(int i = 0; i < foods.size(); i++){
            calories += foods.get(i).getCalories();
        }
        return 0;
    }
    public void addFood(Food f){
        foods.add(f);
    }

    @Override
    public String toString() {
        String meal = "Meal consists of: ";
        int cal = 0;
        int pro = 0;
        for(int i = 0; i < foods.size(); i++){
            if(i == foods.size() - 1){
                meal += foods.get(i).getName();
            }else{
                meal += foods.get(i).getName() + " and ";
            }
            cal += foods.get(i).getCalories();
            pro += foods.get(i).getProtein();
        }
        String calories = "Meal had " + cal + " calories.\n";
        String protein = "Meal had " + pro + " grams of protein\n";
        return meal + "\n" + calories + protein;
    }
}
