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
public class MealEntry {

    private ArrayList<String> contents;
    private NutritionFacts nf;
    public void getTotalNutrients(){
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
        
        for(int i=0; i<= contents.size(); i++){
            totalCalories += contents.get(i).getCalories();
            totalTotalFat += contents.get(i).getTotalFat();
            totalSaturatedFat += contents.get(i).getSaturatedFat();
            totalTransFat += contents.get(i).getTransFat();
            totalCholesterol += contents.get(i).getCholesterol();
            totalSodium += contents.get(i).getSodium();
            totalPotassium += contents.get(i).getPotassium();
            totalTotalCarb += contents.get(i).getTotalCarb();
            totalDietaryFiber += contents.get(i).getDietaryFiber();
            totalProtein += contents.get(i).getProtein();
            totalSugars += contents.get(i).getSugars();
        }
        System.out.println("The total number of calories is: " + totalCalories + ".");
        System.out.println("The total number of fats is: " + totalTotalFat + ".");
        System.out.println("The total number of saturated fat is: " + totalSaturatedFat + ".");
        System.out.println("The total number of trans fat is: " + totalTransFat + ".");
        System.out.println("The total number of cholesterol is: " + totalCholesterol + ".");
        System.out.println("The total number of sodium is: " + totalSodium + ".");
        System.out.println("The total number of potassium is: " + totalPotassium + ".");
        System.out.println("The total number of carbohydrates is: " + totalTotalCarb + ".");
        System.out.println("The total number of dietary fibers is: " + totalDietaryFiber + ".");
        System.out.println("The total number of protein is: " + totalProtein + ".");
        System.out.println("The total number of sugars is: " + totalSugars + ".");
        
    }

}
