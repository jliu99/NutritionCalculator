/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritioncalculator;

import java.util.*;

public class MealEntry implements java.io.Serializable{

    private ArrayList<String> contents;
    
    /**
     *
     * @param foods
     */
    public MealEntry(){
        contents = new ArrayList<String>();
    }
    
    public MealEntry(ArrayList<String> foods){
        contents = foods;
    }

    /**
     *
     * @param name
     * @return
     */
    public void addFood(String name){
       contents.add(name);
    }
    public NutritionFacts totalNutritionalValue(ArrayList<FoodItem> t){
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
        
        for(int i = 0; i < contents.size(); i++){
            String food = contents.get(i);
            NutritionFacts nf = t.get(i).getNutritionFacts();
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
    
 /*
    @Override
    public String toString(){
        String str = "";
        for(NutritionFacts s : contents){
            str += s + ", ";
        }
        return "Meal: " + str;
    }
 */
}
