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
    
}
