package nutritioncalculator;

public class NutritionFacts implements java.io.Serializable {
    private double calories;
    private double total_fat;
    private double saturated_fat;
    private double trans_fat;
    private double cholesterol;
    private double sodium;
    private double potassium;
    private double total_carbohydrate;
    private double dietary_fiber;
    private double sugars;
    private double protein;
    
    public NutritionFacts(double cal, double tf, double sf, double tsf, double chol, double sod, double p, double tc, double df, double sug, double pro){
        calories = cal;
        total_fat = tf;
        saturated_fat = sf;
        trans_fat = tsf;
        cholesterol = chol;
        sodium = sod;
        potassium = p;
        total_carbohydrate = tc;
        dietary_fiber = df;
        sugars = sug;
        protein = pro;
    }
    
    public double getCalories(){
        return calories;
    }
    
    public void setCalories(double amount){
        calories = amount;
    }
    
    public double getTotalFat(){
        return total_fat;
    }
    
    public void setTotalFat(double amount){
        total_fat = amount;
    }
    
    public double getSaturatedFat(){
        return saturated_fat;
    }
    
    public void setSaturatedFat(double amount){
        saturated_fat = amount;
    }
    
    public double getTransFat(){
        return trans_fat;
    }
    
    public void setTransFat(double amount){
        trans_fat = amount;
    }
    
    public double getCholesterol(){
        return cholesterol;
    }
    
    public void setCholesterol(double amount){
        cholesterol = amount;
    }
    
    public double getSodium(){
        return sodium;
    }
    
    public void setSodium(double amount){
        sodium = amount;
    }
    
    public double getPotassium(){
        return potassium;
    }
    
    public void setPotassium(double amount){
        potassium = amount;
    }
    
    public double getTotalCarb(){
        return total_carbohydrate;
    }
    
    public void setTotalCarb(double amount){
        total_carbohydrate = amount;
    }
    
    public double getDietaryFiber(){
        return dietary_fiber;
    }
    
    public void setDietaryFiber(double amount){
        dietary_fiber = amount;
    }
    
    public double getSugars(){
        return sugars;
    }
    
    public void setSugars(double amount){
        sugars = amount;
    }
    
    public double getProtein(){
        return protein;
    }
    
    public void setProtein(double amount){
        protein = amount;
    }
    
    @Override
    public String toString(){   
        return "Calories: " + calories + " cal \nTotal Fat: " + total_fat + " g \nSaturated Fat: " + saturated_fat
                + " g \nTrans Fat: " + trans_fat + " g \nCholesterol: " + cholesterol + " mg \nSodium: " + sodium
                + " mg \nTotal Carbohydrate: " + total_carbohydrate + " g \nDietary Fiber: " + dietary_fiber
                + " g \nSugars: " + sugars + " g \nProtein: " + protein + " g";
    }
}