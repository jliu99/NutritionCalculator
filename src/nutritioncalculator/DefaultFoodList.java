/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritioncalculator;

import java.util.TreeMap;
import java.util.Scanner;

/**
 *
 * @author jl
 */
public class DefaultFoodList {
    
    
    public static void loadDefaultFoodList(TreeMap<String, NutritionFacts> t){
    t.put("Bananas", new NutritionFacts(100, 0, 0, 0, 0, 0, 420, 30, 3, 19, 1));
    t.put("Orange", new NutritionFacts(45, 0, 0, 0, 0, 0, 174, 11, 2, 9, 1));
    t.put("Potato", new NutritionFacts(110, 0, 0, 0, 0, 0, 620, 26, 2, 1, 3));
    t.put("Spinach", new NutritionFacts(7, 0, 0, 0, 0, 24, 167, 1, 1, 0, 1));
    t.put("Tomato", new NutritionFacts(22, 0, 0, 0, 0, 6, 292, 5, 2, 3, 1));
    t.put("Spaghetti", new NutritionFacts(221, 1, 0, 0, 0, 1, 62, 43, 3, 1, 8));
    t.put("Meatballs", new NutritionFacts(284, 13, 2, 0, 0, 792, 259, 12, 7, 2, 30));
    t.put("Hot Dog Sausage", new NutritionFacts(151, 13, 4, 0, 40, 567, 79, 2, 0, 1, 5));
    }
    
    /**
     *
     * @param name
     * @return 
     */
    public static NutritionFacts createNewIngredient(NutritionFacts name){
        NutritionFacts givenName;
        givenName = name;
        String calories;
        String totalFats;
        String saturatedFats;
        String transFat;
        String cholesterol;
        String sodium;
        String potassium;
        String totalCarbohydrate;
        String dietaryFiber;
        String sugars;
        String protein; 
        Scanner dietNumbers = new Scanner(System.in);
        System.out.print("Enter the number of calories:");
        calories = dietNumbers.nextLine();
        System.out.print("Enter the number of total fats:");
        totalFats = dietNumbers.nextLine();
        System.out.print("Enter the number of saturated fats:");
        saturatedFats = dietNumbers.nextLine();
        System.out.print("Enter the number of trans fats:");
        transFat = dietNumbers.nextLine();
        System.out.print("Enter the number of cholesterol:");
        cholesterol = dietNumbers.nextLine();
        System.out.print("Enter the number of sodium:");
        sodium = dietNumbers.nextLine();
        System.out.print("Enter the number of potassium:");
        potassium = dietNumbers.nextLine();
        System.out.print("Enter the number of total carbohydrates:");
        totalCarbohydrate = dietNumbers.nextLine();
        System.out.print("Enter the number of dietary fibers:");
        dietaryFiber = dietNumbers.nextLine();
        System.out.print("Enter the number of sugars:");
        sugars = dietNumbers.nextLine();
        System.out.print("Enter the number of proteins:");
        protein = dietNumbers.nextLine();
        
        return new NutritionFacts(Integer.parseInt(calories), Integer.parseInt(totalFats), Integer.parseInt(saturatedFats),Integer.parseInt(transFat), Integer.parseInt(cholesterol), Integer.parseInt(sodium),Integer.parseInt(potassium), Integer.parseInt(totalCarbohydrate), Integer.parseInt(dietaryFiber), Integer.parseInt(sugars), Integer.parseInt(protein));
    }
}
