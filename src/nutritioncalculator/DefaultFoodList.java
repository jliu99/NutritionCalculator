/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritioncalculator;

import java.util.TreeMap;

/**
 *
 * @author jl
 */
public class DefaultFoodList {
    public static void loadFoodList(TreeMap t){
    t.put("Bananas", new NutritionFacts(100, 0, 0, 0, 0, 0, 420, 30, 3, 19, 1));
    t.put("Orange", new NutritionFacts(45, 0, 0, 0, 0, 0, 174, 11, 2, 9, 1));
    t.put("Potato", new NutritionFacts(110, 0, 0, 0, 0, 0, 620, 26, 2, 1, 3));
    t.put("Spinach", new NutritionFacts(7, 0, 0, 0, 0, 24, 167, 1, 1, 0, 1));
    t.put("Tomato", new NutritionFacts(22, 0, 0, 0, 0, 6, 292, 5, 2, 3, 1));
    t.put("Spaghetti", new NutritionFacts(221, 1, 0, 0, 0, 1, 62, 43, 3, 1, 8));
    t.put("Meatballs", new NutritionFacts(284, 13, 2, 0, 0, 792, 259, 12, 7, 2, 30));
    t.put("Hot Dog Sausage", new NutritionFacts(151, 13, 4, 0, 40, 567, 79, 2, 0, 1, 5));
    }
}
