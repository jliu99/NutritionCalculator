/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritioncalculator;

/**
 *
 * @author jl
 */
public class FoodItem implements java.io.Serializable {
    private String name;
    private String servingSize;
    private NutritionFacts nfacts;
    
    public FoodItem(String n, String s, NutritionFacts nf){
        name = n;
        servingSize = s;
        nfacts = nf;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String s){
        name = s;
    }
        
    public String getServingSize(){
        return name;
    }
    
    public void setServingSize(String s){
        servingSize = s;
    }
    
    public NutritionFacts getNutritionFacts(){
        return nfacts;
    }
    
    public void setNutritionFacts(NutritionFacts nf){
        nfacts = nf;
    }
    
}
