package nutritioncalculator;

public class NutritionFacts {
    private int calories;
    private int total_fat;
    private int saturated_fat;
    private int trans_fat;
    private int cholesterol;
    private int sodium;
    private int potassium;
    private int total_carbohydrate;
    private int dietary_fiber;
    private int sugars;
    private int protein;
    
    public NutritionFacts(int cal, int tf, int sf, int tsf, int chol, int sod, int p, int tc, int df, int sug, int pro){
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
    
    public int getCalories(){
        return calories;
    }
    
    public void setCalories(int amount){
        calories = amount;
    }
    
    public int getTotalFat(){
        return total_fat;
    }
    
    public void setTotalFat(int amount){
        total_fat = amount;
    }
    
    public int getSaturatedFat(){
        return saturated_fat;
    }
    
    public void setSaturatedFat(int amount){
        saturated_fat = amount;
    }
    
    public int getTransFat(){
        return trans_fat;
    }
    
    public void setTransFat(int amount){
        trans_fat = amount;
    }
    
    public int getCholesterol(){
        return cholesterol;
    }
    
    public void setCholesterol(int amount){
        cholesterol = amount;
    }
    
    public int getSodium(){
        return sodium;
    }
    
    public void setSodium(int amount){
        sodium = amount;
    }
    
    public int getPotassium(){
        return potassium;
    }
    
    public void setPotassium(int amount){
        potassium = amount;
    }
    
    public int getTotalCarb(){
        return total_carbohydrate;
    }
    
    public void setTotalCarb(int amount){
        total_carbohydrate = amount;
    }
    
    public int getDietaryFiber(){
        return dietary_fiber;
    }
    
    public void setDietaryFiber(int amount){
        dietary_fiber = amount;
    }
    
    public int getSugars(){
        return sugars;
    }
    
    public void setSugars(int amount){
        sugars = amount;
    }
    
    public int getProtein(){
        return protein;
    }
    
    public void setProtein(int amount){
        protein = amount;
    }
    
    @Override
    public String toString(){   
        return "Calories: " + calories + "\nTotal Fat: " + total_fat + "\nSaturated Fat: " + saturated_fat
                + "\nTrans Fat: " + trans_fat + "\nCholesterol: " + cholesterol + "\nSodium: " + sodium
                + "\nTotal Carbohydrate: " + total_carbohydrate + "\nDietary Fiber: " + dietary_fiber
                + "\nSugars: " + sugars + "\nProtein: " + protein;
    }
}