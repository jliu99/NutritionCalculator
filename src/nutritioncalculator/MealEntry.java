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
    
    public ArrayList<String> getContents(){
        return contents;
    }
    
    public void setContents(ArrayList<String> c){
        contents = c;
    }
    
    public void addFood(String name){
       contents.add(name);
    }
    
    public void removeFood(String name){
        contents.remove(name);
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
        
        for(int i = 0; i < contents.size(); i++){
            String food = contents.get(i);
            FoodItem f = null;
            Recipe rec = null;
            NutritionFacts nf = null;
            boolean foodFound = false;
            for(int j = 0; j < t.size(); j++){
                if(t.get(j).getName().equals(food)){
                    f = t.get(j);
                    nf = f.getNutritionFacts();
                    foodFound = true;
                    break;
                } else {
                    nf = new NutritionFacts(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
                }
            }
            if(!foodFound){
                for(int j = 0; j < r.size(); j++){
                    if(r.get(j).getName().equals(food)){
                    rec = r.get(j);
                    nf = rec.getNutritionFacts(t);
                    foodFound = true;
                    break;
                    }
                }
            }
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
        String str = contents.get(0);
        for(int i = 1; i < contents.size(); i++){
            str += ", " + contents.get(i);
        }
        NutritionFacts nf = totalNutritionalValue(NutritionCalculator.foodList, NutritionCalculator.customRecipes);
        return "This meal contains the following ingredients: \n \n" + str + "\n\nAltogether, this meal has the folloiwing nutritional value.\n \n" + nf.toString();
    }
}
