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
import static nutritioncalculator.DefaultFoodList.loadFoodList;

/**
 *
 * @author kslimmo
 */
public class NutritionCalculator implements java.io.Serializable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeMap foodList = new TreeMap();
        //for testing purposes
        foodList.put("Bananas", new NutritionFacts(100, 0, 0, 0, 0, 0, 420, 30, 3, 19, 1));
        foodList.put("Orange", new NutritionFacts(45, 0, 0, 0, 0, 0, 174, 11, 2, 9, 1));
        foodList.put("Potato", new NutritionFacts(110, 0, 0, 0, 0, 0, 620, 26, 2, 1, 3));
        foodList.put("Spinach", new NutritionFacts(7, 0, 0, 0, 0, 24, 167, 1, 1, 0, 1));
        foodList.put("Tomato", new NutritionFacts(22, 0, 0, 0, 0, 6, 292, 5, 2, 3, 1));
        foodList.put("Spaghetti", new NutritionFacts(221, 1, 0, 0, 0, 1, 62, 43, 3, 1, 8));
        foodList.put("Meatballs", new NutritionFacts(284, 13, 2, 0, 0, 792, 259, 12, 7, 2, 30));
        foodList.put("Hot Dog Sausage", new NutritionFacts(151, 13, 4, 0, 40, 567, 79, 2, 0, 1, 5));
        /*try{
            FileInputStream fileIn = new FileInputStream("foodlist.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            foodList = (TreeMap) in.readObject();
            in.close();
            fileIn.close();
        }catch(Exception e){
            loadFoodList(foodList);
           try{
            FileOutputStream fileOut = new FileOutputStream("foodlist.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(foodList);
            out.close();
            fileOut.close();
           }catch(Exception ex){
               System.out.println("Something went wrong.");
           }
        }*/
        UserLog currentLog = null;
        Scanner input = new Scanner(System.in);
        String command = "";
        System.out.println("Welcome! This is a WIP Nutrition Calculator.");
        System.out.println("Type: create, quit");
        while(!command.equals("quit")){
        command = input.nextLine();
        command = command.toLowerCase();
            if(command.equals("create")){
                System.out.println("What is your name?");
                String str = input.nextLine();
                UserLog ul = new UserLog(str);
                currentLog = ul;
                System.out.println("Log created. Today's date is already included in the log. You may add meals to your entry for this day by typing 'new meal'.");
            } else if(command.equals("new meal")){
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
