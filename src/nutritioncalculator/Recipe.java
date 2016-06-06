/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nutritioncalculator;

import java.util.*;

public class Recipe {
    private String name;
    private TreeMap<FoodItem, Double> ingredients;
   
    public Recipe(){
        
    }
    
    public Recipe(String s, TreeMap<FoodItem, Double> list){
        name=s;
        ingredients=list;
    }
    
    public String getName(){
        return name;
    }
    
    public TreeMap<FoodItem, Double> getIngredients(){
        return ingredients;
    }
    
    public void setName(String s){
        name = s;
    }
    
    public void setIngredients(TreeMap<FoodItem, Double> t){
        ingredients = t;
    }
    
    public NutritionFacts getNutritionFacts(ArrayList<FoodItem> f){
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
        
        Set<FoodItem> keys = ingredients.keySet();
        ArrayList<String> food = new ArrayList<String>();
        for(FoodItem fi : keys){
            food.add(fi.getName());
        }
        Collection values = ingredients.values();
        for(String s : food){
            
        }
        return new NutritionFacts(totalCalories, totalTotalFat, totalSaturatedFat, totalTransFat, totalCholesterol, totalSodium, totalPotassium, totalTotalCarb, totalDietaryFiber, totalSugars, totalProtein);
    }
    
}
