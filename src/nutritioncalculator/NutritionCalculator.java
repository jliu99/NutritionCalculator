/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritioncalculator;

import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author kslimmo
 */
public class NutritionCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //for testing purposes
        TreeMap foodList = new TreeMap();
        foodList.put("Bananas", new NutritionFacts(100, 0, 0, 0, 0, 0, 30, 3, 19, 1));
        
        Scanner input = new Scanner(System.in);
        String command = "";
        System.out.println("Welcome! This is a WIP Nutrition Calculator.");
        System.out.println("Type: create, quit");
        while(!command.equals("quit")){
        command = input.nextLine();
        command = command.toLowerCase();
            if(command.equals("create")){
                //UserLog ul = new UserLog();
                System.out.println("Created new log");
            } else if (! command.equals("quit")){
                System.out.println("Sorry, I did not understand the command: " + command);
            }
        }
    }
}
