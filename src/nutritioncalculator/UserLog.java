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
        addCurrentDay();
    }
    
    public String getUser(){
        return user;
    }

    public void addCurrentDay(){
        days.add(new DayEntry(new Date()));
    }
    
    public void addDay(Date d){
        days.add(new DayEntry(d));
    }
    
    // d must be formated as "MM/dd/yyyy"
    public DayEntry getDayEntry(String d){
        for(int i = 0; i < days.size(); i++){
            if(d.equals(days.get(i).getDate())){
                return days.get(i);
            }
        }
        return null;
    }
    
    
    public DayEntry getDayEntry(int i){
        return days.get(i);
    }
    
    public ArrayList<DayEntry> getDayEntryList(){
        return days;
    }
    
    // Adds to most recent date
    public void addMeal(ArrayList<String> meal){
      DayEntry day = getDayEntry(days.size() - 1);
      day.addMeal(meal);
    }
    
    public void addMeal(String date, ArrayList<String> meal){
        DayEntry day = getDayEntry(date);
        day.addMeal(meal);
    }

}