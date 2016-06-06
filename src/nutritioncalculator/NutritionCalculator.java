/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritioncalculator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * @author kslimmo
 */
public class NutritionCalculator implements java.io.Serializable {
    /**
     * @param args the command line arguments
     */
    
    public static ArrayList<FoodItem> foodList;
    public static ArrayList<Recipe> customRecipes;
    public static UserLog currentLog;
    
    public static void loadFoodList(){
        foodList = new ArrayList<FoodItem>();
        try{
            FileInputStream fileIn = new FileInputStream("savedfiles/foodlist.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            foodList = (ArrayList<FoodItem>) in.readObject();
            in.close();
            fileIn.close();
        }catch(FileNotFoundException e){
            FoodList.loadDefaultFoodList(foodList);
            saveFoodList();
        }catch(Exception e){
            System.out.println("Something went wrong with loading the file: foodlist.ser");
        }
    }
    
    public static void loadCustomRecipes(){
        try{
            FileInputStream fileIn = new FileInputStream("savedfiles/customrecipes.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            customRecipes = (ArrayList<Recipe>) in.readObject();
        }catch(FileNotFoundException e){
            customRecipes = new ArrayList<Recipe>();
            saveCustomRecipes();
        }catch(Exception e){
            System.out.println("Something went wrong the loading the file: customrecipes.ser");
        }
      
    }
    
    public static void saveCustomRecipes(){
        try{
            FileOutputStream fileOut = new FileOutputStream("savedfiles/customrecipes.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(customRecipes);
            out.close();
            fileOut.close();
           } catch(Exception ex){
               ex.printStackTrace();
               System.out.println("Something went wrong with saving the file.");
           }
    }
    
    public static void saveFoodList(){
        try{
            FileOutputStream fileOut = new FileOutputStream("savedfiles/foodlist.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(foodList);
            out.close();
            fileOut.close();
           } catch(Exception ex){
               ex.printStackTrace();
               System.out.println("Something went wrong with saving the file.");
           }
    }
    
    public static void loadUserLog(String s){
        try{
            String filename = s.toLowerCase();
            FileInputStream fileIn = new FileInputStream("savedfiles/" + filename + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            currentLog = (UserLog) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Welcome back, " + s + "!");
        }catch(FileNotFoundException e){
            System.out.println("User log does not exist!");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong with loading the file.");
        }
    }
    
    public static void saveUserLog(){
        try{
            String filename = currentLog.getUser().toLowerCase();
            FileOutputStream fileOut = new FileOutputStream("savedfiles/" + filename + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(currentLog);
            out.close();
            fileOut.close();
            System.out.println("File saved!");
           } catch(Exception ex){
               ex.printStackTrace();
               System.out.println("Something went wrong with saving the file.");
           }
    }
    
}
