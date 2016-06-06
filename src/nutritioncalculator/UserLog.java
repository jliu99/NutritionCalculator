/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritioncalculator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserLog implements java.io.Serializable {
    private final String user;
    private ArrayList<DayEntry> days;
    
    public UserLog(String s){
        user = s;
        days = new ArrayList<DayEntry>();
        days.add(new DayEntry(new Date()));
    }
    
    public String getUser(){
        return user;
    }
    
    public void addDay(Date d){
        days.add(new DayEntry(d));
    }
    
    // d must be formatted as "MM/dd/yyyy"
    public void addDay(String d){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        try {
            sdf.parse(d);
        }catch(Exception e){
            System.out.println("Sorry, that is not a valid date. Please try again.");
        }
        
    }
    
    // d must be formatred as "MM/dd/yyyy"
    public DayEntry getDayEntry(String d){
        for(int i = 0; i < days.size(); i++){
            if(d.equals(days.get(i).getDate())){
                return days.get(i);
            }
        }
        return null;
    }
    
    public DayEntry getDayEntry(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String date = "";
        date = sdf.format(d);
        for (int i = 0; i < days.size(); i++) {
            if (date.equals(days.get(i).getDate())) {
                return days.get(i);
            }
        }
        return null;
    }
    
    public DayEntry getDayEntry(int i){
        return days.get(i);
    }
    
    public ArrayList<DayEntry> getDayEntryList(){
        return days;
    }
    
    public void addMeal(String date, ArrayList<String> meal){
        DayEntry day = getDayEntry(date);
        day.addMeal(meal);
    }
    
    public void deleteDay(Date d){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String date = "";
        date = sdf.format(d);
        for (int i = 0; i < days.size(); i++) {
            if (date.equals(days.get(i).getDate())) {
                days.remove(days.get(i));
            }
        }
    }
    
    public void deleteDay(String s){
        for (int i = 0; i < days.size(); i++) {
            if (s.equals(days.get(i).getDate())) {
                days.remove(days.get(i));
            }
        }
    }
    
    public void deleteDay(DayEntry d){
        for (int i = 0; i < days.size(); i++) {
            if(d.equals(days.get(i))) {
                days.remove(days.get(i));
            }
        }
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
        for(DayEntry d : days){
            NutritionFacts nf = d.totalNutritionalValue(t, r);
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
        nf.setCalories(nf.getCalories() / days.size());
        nf.setTotalFat(nf.getTotalFat() / days.size());
        nf.setSaturatedFat(nf.getSaturatedFat() / days.size());
        nf.setTransFat(nf.getTransFat() / days.size());
        nf.setCholesterol(nf.getCholesterol() / days.size());
        nf.setSodium(nf.getSodium() / days.size());
        nf.setPotassium(nf.getPotassium() / days.size());
        nf.setTotalCarb(nf.getTotalCarb() / days.size());
        nf.setDietaryFiber(nf.getDietaryFiber() / days.size());
        nf.setSugars(nf.getSugars() / days.size());
        nf.setProtein(nf.getProtein() / days.size());
        return nf;
    }
}