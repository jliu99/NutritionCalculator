/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritioncalculator;

import java.util.*;
/**
 *
 * @author jl
 */
public class MealEntry implements java.io.Serializable{

    private ArrayList<NutritionFacts> contents;
    
    /**
     *
     * @param foods
     */
    public MealEntry(ArrayList<NutritionFacts> foods){
        contents = foods;
    }

    /**
     *
     * @param name
     * @return
     */
    public ArrayList<NutritionFacts> addFoods(NutritionFacts name){
       contents.add(DefaultFoodList.createNewIngredient(name));
       return contents;
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
        
        for(int i = 0; i < contents.size(); i++){
            NutritionFacts food = contents.get(i);
            NutritionFacts nf = (NutritionFacts)t.get(food);
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
