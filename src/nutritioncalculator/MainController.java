/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritioncalculator;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class MainController implements Initializable {
    
    @FXML
    private BorderPane pane;
     
    @FXML
    private Menu file, mode, help;
    
    @FXML
    private MenuItem save, load, close;
    
    @FXML
    private MenuItem view, edit, ing;
    
    @FXML
    private MenuItem about, howto;
    
    @FXML
    private ListView days, foodsList;
    
    
    private String flView;
    
    @FXML
    private TextFlow mainText;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        flView = "ing";
    }
    
    public void loadUser(){
        Text t = new Text("Welcome, " + NutritionCalculator.currentLog.getUser() + "! \n \n");
        Text tx = new Text("Select one of the days from the left to view its details.");
        mainText.getChildren().add(t);
        mainText.getChildren().add(tx);
        UserLog current = NutritionCalculator.currentLog;
        ArrayList<DayEntry> dayEntries = current.getDayEntryList();
        ArrayList<String> dates = new ArrayList<String>();
        for(DayEntry d : dayEntries){
            dates.add(d.getDate());
        }
        dates.add("Total");
        ObservableList<String> obvDates = FXCollections.observableArrayList(dates);
        days.getItems().addAll(obvDates);
    }
    
    public void loadFoods(){
        NutritionCalculator.loadFoodList();
        NutritionCalculator.loadCustomRecipes();
        loadFoodList();
        }
    
    public void loadFoodList(){
        ArrayList<String> items = new ArrayList<String>();
        if(flView.equals("ing")){
            Set<String> keys = NutritionCalculator.foodList.keySet();
            for(String s : keys){
                items.add(s);
            }
        } else if(flView.equals("")){
            
        }
        ObservableList<String> obvFood = FXCollections.observableArrayList(items);
        foodsList.getItems().addAll(obvFood);
    }
    
    public void toggleViewMode(){
        
    }
    
    public void toggleEditMode(){
    
    }
    
    public void toggleIngMode(){
    
    }
    
    public void displayAbout(){
        Alert dialogBox = new Alert(Alert.AlertType.INFORMATION);
        dialogBox.setTitle("About This Program");
        dialogBox.setHeaderText(null);
        dialogBox.setContentText("");
        dialogBox.showAndWait();
    }
 
    public void displayHowTo(){
        Alert dialogBox = new Alert(Alert.AlertType.INFORMATION);
        
    }
 
    public void quitProgram(){
        System.exit(-1);
    }
    
    public void saveLog(){
        NutritionCalculator.saveUserLog();
    }
    
    public void returnToStart(){
        Alert dialogBox = new Alert(Alert.AlertType.CONFIRMATION);
        dialogBox.setTitle("Are you sure?");
        dialogBox.setHeaderText(null);
        dialogBox.setContentText("This will take you back to the Main Screen.");
        try {
            Main.switchStage();
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}