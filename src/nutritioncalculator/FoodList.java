/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritioncalculator;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Scanner;

/**
 *
 * @author jl
 */
public class FoodList {
    
    
    public static void loadDefaultFoodList(ArrayList<FoodItem> t){
    t.add(new FoodItem("Banana", "1 medium banana (7\" to 7-7/8\" long, 118g)", new NutritionFacts(105, 0.4, 0.1, 0, 0, 1, 422, 27, 3.1, 14, 1.3)));
    t.add(new FoodItem("Orange", "1 fruit (2-5/8\" diameter, 131g)", new NutritionFacts(62, 0.2, 0, 0, 0, 0, 237, 15, 3.1, 12, 1.2)));
    t.add(new FoodItem("Potato", "1 medium potato (2 1/4\" to 3 1/4\" diameter, 213g)", (new NutritionFacts(163, 0.2, 0.1, 0, 0, 13, 897, 37, 4.7, 1.7, 4.3))));
    t.add(new FoodItem("Spinach", "1 cup (30g)", new NutritionFacts(7, 0.1, 0, 0, 0, 24, 167, 1.1, 0.7, 0.1, 0.9)));
    t.add(new FoodItem("Tomato", "1 medium whole (2 3/5\" diameter, 123g)", new NutritionFacts(22, 0.2, 0, 0, 0, 6, 292, 4.8, 1.5, 3.3, 1.1)));
    t.add(new FoodItem("Spaghetti Pasta", "1 cup (140g)", new NutritionFacts(221, 1.3, 0.2, 0, 0, 1, 62, 43, 2.5, 0.7, 8)));
    t.add(new FoodItem("Meatballs", "1 cup (144g)", new NutritionFacts(284, 13, 2.1, 0, 0, 792, 259, 12, 7, 1.8, 30)));
    t.add(new FoodItem("Prego Traditional Pasta Sauce", "1 cup (272 g)", new NutritionFacts(140, 3, 0, 0, 4, 960, 810, 26.2, 6, 20.2, 4)));
    t.add(new FoodItem("Hot Dog Sausage", "1 hot dog (52g)", new NutritionFacts(151, 13, 4, 0, 40, 567, 79, 2.2, 0, 1, 5)));
    }
    
    public static void createNewIngredient(ArrayList<FoodItem> t, String s){
        NutritionFacts nf;
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
        
        nf = new NutritionFacts(Integer.parseInt(calories), Integer.parseInt(totalFats), Integer.parseInt(saturatedFats),Integer.parseInt(transFat), Integer.parseInt(cholesterol), Integer.parseInt(sodium),Integer.parseInt(potassium), Integer.parseInt(totalCarbohydrate), Integer.parseInt(dietaryFiber), Integer.parseInt(sugars), Integer.parseInt(protein));
        
        
    }
    
}
