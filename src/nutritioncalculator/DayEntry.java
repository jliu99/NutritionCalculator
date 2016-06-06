package nutritioncalculator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

public class DayEntry implements java.io.Serializable {
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
    
    public void addMeal(){
        meals.add(new MealEntry());
    }
    
    public void addMeal(ArrayList<String> meal){
        meals.add(new MealEntry(meal));
    }
    
    public MealEntry getMealEntry(int i){
        return meals.get(i);
    }
    
    public ArrayList<MealEntry> getMealEntryList(){
        return meals;
    }
    
    public MealEntry removeMealEntry(int i){
        return meals.remove(i);
    }
    
    public NutritionFacts totalNutritionalValue(ArrayList<FoodItem> t, ArrayList<Recipe> r){
        double totalCalories = 0;
        double totalTotalFat = 0;
        double totalSaturatedFat = 0;
        double totalTransFat = 0;
        double totalCholesterol = 0;
        double totalSodium = 0;
        double totalPotassium = 0;
        double totalTotalCarb = 0;
        double totalDietaryFiber = 0;
        double totalProtein = 0;
        double totalSugars = 0;
        for(MealEntry m : meals){
            NutritionFacts nf = m.totalNutritionalValue(t, r);
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
    
    public NutritionFacts averageNutritionalValue(ArrayList<FoodItem> t, ArrayList<Recipe> r){
        NutritionFacts nf = totalNutritionalValue(t, r);
        nf.setCalories(nf.getCalories() / meals.size());
        nf.setTotalFat(nf.getTotalFat() / meals.size());
        nf.setSaturatedFat(nf.getSaturatedFat() / meals.size());
        nf.setTransFat(nf.getTransFat() / meals.size());
        nf.setCholesterol(nf.getCholesterol() / meals.size());
        nf.setSodium(nf.getSodium() / meals.size());
        nf.setPotassium(nf.getPotassium() / meals.size());
        nf.setTotalCarb(nf.getTotalCarb() / meals.size());
        nf.setDietaryFiber(nf.getDietaryFiber() / meals.size());
        nf.setSugars(nf.getSugars() / meals.size());
        nf.setProtein(nf.getProtein() / meals.size());
        return nf;
    }
    
    @Override
    public String toString(){
        String str = "";
        for(MealEntry m : meals){
            str += m.toString() + "\n";
        }
        //return "Date: " + date.toString() + "/n" + "On this day you ate the following meals: /n" + str;
        return "Today you ate the following meals: \n" + str;
    }
    
}
