package nutritioncalculator;

import java.util.ArrayList;
import java.util.Date;

public class DayEntry{
    private ArrayList<MealEntry> meals;
    private Date date;
    
    public DayEntry(Date d){
        date = d;
    }
    
    public Date getDate(){
        return date;
    }
    
    public void addMeal(ArrayList<String> meal){
        meals.add(new MealEntry(meal));
    }
    
    public NutritionFacts getNutritionValue(){
        //For Kelly
        return null;
    }
}
