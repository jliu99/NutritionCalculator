package nutritioncalculator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

public class DayEntry{
    private ArrayList<MealEntry> meals;
    private String date;
    
    public DayEntry(Date d){
        meals = new ArrayList<MealEntry>();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        date = sdf.format(d);
    }
    
    public String getDate(){
        return date;
    }
    
    public void addMeal(ArrayList<String> meal){
        meals.add(new MealEntry(meal));
    }
    
    public NutritionFacts totalNutritionalValue(TreeMap t){
        int totalCalories = 0;
        int totalTotalFat = 0;
        int totalSaturatedFat = 0;
        int totalTransFat = 0;
        int totalCholesterol = 0;
        int totalSodium = 0;
        int totalPotassium = 0;
        int totalTotalCarb = 0;
        int totalDietaryFiber = 0;
        int totalProtein = 0;
        int totalSugars = 0;
        for(MealEntry m : meals){
            NutritionFacts nf = m.totalNutritionalValue(t);
            totalCalories += nf.getCalories();
            totalTotalFat += nf.getTotalFat();
            totalSaturatedFat += nf.getSaturatedFat();
            totalTransFat += nf.getTransFat();
            totalCholesterol += nf.getCholesterol();
            totalSodium += nf.getSodium();
            totalPotassium += nf.getPotassium();
            totalTotalCarb += nf.getTotalCarb();
            totalDietaryFiber += nf.getDietaryFiber();
            totalSugars += nf.getSugars();
            totalProtein += nf.getProtein();
        }
        return new NutritionFacts(totalCalories, totalTotalFat, totalSaturatedFat, totalTransFat, totalCholesterol, totalSodium, totalPotassium, totalTotalCarb, totalDietaryFiber, totalSugars, totalProtein);
    }
    
    @Override
    public String toString(){
        String str = "";
        for(MealEntry m : meals){
            str += m.toString() + "\n";
        }
        //return "Date: " + date.toString() + "/n" + "On this day you ate the following meals: /n" + str;
        return "Today you ate the following means: \n" + str;
    }
    
}
