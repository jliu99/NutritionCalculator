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

/**
 *
 * @author kslimmo
 */
public class NutritionCalculator implements java.io.Serializable {
    /**
     * @param args the command line arguments
     */
    public static TreeMap<String, NutritionFacts> foodList;
    public static UserLog currentLog;
    
    
    public static void loadFoodList(){
        try{
            FileInputStream fileIn = new FileInputStream("savedfiles/foodlist.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            foodList = (TreeMap<String, NutritionFacts>) in.readObject();
            in.close();
            fileIn.close();
        }catch(FileNotFoundException e){
            DefaultFoodList.loadDefaultFoodList(foodList);
            saveFoodList(foodList);
        }catch(Exception e){
            System.out.println("Something went wrong with loading the file.");
        }
    }
    
    public static void saveFoodList(TreeMap<String, NutritionFacts> t){
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
    
    public static void main(String[] args) {
        foodList = new TreeMap<String, NutritionFacts>();
        loadFoodList();
        currentLog = null;
        Scanner input = new Scanner(System.in);
        String command = "";
        System.out.println("Welcome! This is a WIP Nutrition Calculator.");
        System.out.println("Type: create, load, quit");
        while(!command.equals("quit")){
        command = input.nextLine();
        command = command.toLowerCase();
            if(command.equals("create")){
                
            } else if(command.equals("load")){
                System.out.println("Type your name below as you entered it before. Don't add extra spaces or characters.");
                String str = input.nextLine();
                loadUserLog(str);
            } else if(command.equals("save")){
                System.out.println("Saving...");
                saveUserLog();
            }else if(command.equals("new meal")){
                if(currentLog == null){
                    System.out.println("You haven't created a new log yet. Create a new log, then you can add meals.");
                } else {
                    System.out.println("Add items from this list that you ate for this meal by typing the names of them. The program will keep adding until you type 'end meal'.");
                    System.out.println("");
                    Set<String> keys = foodList.keySet();
                    String str = "";
                    for(String s : keys){
                        str += s + ", ";
                    }
                    System.out.println(str);
                    str = input.nextLine();
                    ArrayList<String> mealContents = new ArrayList<String>();
                    while(!str.equals("end meal")){
                        if(foodList.containsKey(str)){
                             mealContents.add(str);
                        } else{
                            System.out.println("Sorry, I do not recognize that food item: " + str + ". Try again.");
                        }
                        str = input.nextLine();
                    }
                    currentLog.addMeal(mealContents);
                    System.out.println("Meal added. You may view all the meals for this day by typing 'view log' and calculate the total nutritional value by typing 'get total'.");
                }
            } else if(command.equals("view log")){
                for(DayEntry d : currentLog.getDayEntryList()){
                    System.out.println(d.toString());
                }
            } else if(command.equals("get total")){
                for(DayEntry d: currentLog.getDayEntryList()){
                    System.out.println("For this day, the nutritional intake totals to the following.");
                    NutritionFacts nf = d.totalNutritionalValue(foodList);
                    System.out.println(nf.toString());
                }
            } else if (!command.equals("quit")){
                System.out.println("Sorry, I did not understand the command: " + command);
            }
        }
    }
}
