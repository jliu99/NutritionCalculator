/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritioncalculator;

import java.util.ArrayList;
import java.util.Date;

public class UserLog {
    private final String user;
    private ArrayList<DayEntry> days;
    
    public UserLog(String s){
        user = s;
        days = new ArrayList<DayEntry>();
        addDay();
        //addCurrentDay();
    }
    
    public String getUser(){
        return user;
    }
    
    //testing purposes
    public void addDay(){
        days.add(new DayEntry());
    }
    
    /*public void addDay(Date d){
        days.add(new DayEntry(d));
    }
    
    public void addCurrentDay(){
        days.add(new DayEntry(new Date()));
    }
    
    public DayEntry getDayEntry(Date d){
        for(int i = 0; i < days.size(); i++){
            if(d.equals(days.get(i).getDate())){
                return days.get(i);
            }
        }
        return null;
    }
    */
    
    public DayEntry getDayEntry(int i){
        return days.get(i);
    }
    
    public ArrayList<DayEntry> getDayEntryList(){
        return days;
    }
    
    // Adds to most recent date
    public void addMeal(ArrayList<String> meal){
    //  DayEntry day = getDayEntry(days.size() - 1);
    // For testing purposes
        DayEntry d = days.get(0);
        d.addMeal(meal);
    }
    
    /*public void addMeal(Date d, ArrayList<String> meal){
        DayEntry day = getDayEntry(d);
        day.addMeal(meal);
    }*/

}