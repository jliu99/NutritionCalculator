/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritioncalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jl
 */
public class Main extends Application {
    private static Scene start, main, food;
    private static Stage stage;
    
    public static void showStage(){
        stage.show();
    }
    
    @Override
     public void start(Stage s) throws Exception {
         stage = s;
         
         Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
         start = new Scene(root);
         
         root = FXMLLoader.load(getClass().getResource("Main.fxml"));
         main = new Scene(root);
         
         root = FXMLLoader.load(getClass().getResource("Food.fxml"));
         food = new Scene(root);
         
         stage.setScene(start);
         stage.show();
     }
     
     public static void switchStage(String s) throws Exception {
         if(s.equals("start")){
            stage.setScene(start);
            stage.show(); 
         }else if(s.equals("main")){
             stage.setScene(main);
             stage.show();
         }else{
             stage.setScene(food);
             stage.show();
         }
     }
     

     
     public static void main(String[] args) {
         launch(args);
     }
     
 }
