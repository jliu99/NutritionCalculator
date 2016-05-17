/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritioncalculator;

import java.util.*;
/**
 *
 * @author jl
 */
public class MealEntry {

        private ArrayList<String> contents;
        
        public MealEntry(ArrayList<String> food){
            food = contents;
        }
        
        public ArrayList<String> getContents(){
            return contents;
        }
        
        public boolean contains(String s){
            for(String str : contents){
                if(s.equals(str)){
                    return true;
                }
            }
            return false;
        }

}
