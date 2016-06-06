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
import javafx.scene.control.Button;
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
    private MenuItem about;
    
    @FXML
    private ListView<String> days, mealList, foodsList, mealContentView;
    
    @FXML
    private Button loadButton;
    
    @FXML
    private Button addMealB, editMealB, deleteMealB;

    @FXML
    private Button toggleFoodB;
    
    private String flView;
    private boolean addToMealMode;
    private ArrayList<DayEntry> dayEntries = new ArrayList<DayEntry>();
    
    @FXML
    private TextFlow mainText;
    
    /*
    
        START UP
    
    */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Text t = new Text("Please press the button below to load your data into the interface.");
        mainText.getChildren().add(t);
        flView = "ing";
        addToMealMode = false;
        loadButton.setVisible(true);
        toggleViewMode();
    }
    
    public void loadUser(){
        loadButton.setVisible(false);
        toggleFoodB.setVisible(true);
        mainText.getChildren().clear();
        Text t = new Text("Welcome, " + NutritionCalculator.currentLog.getUser() + "! \n \n");
        Text tx = new Text("Select one of the days from the left to view its details. This will populate the list below with all of the meals you have added so far. If you are a new user, this should be empty. \n \n");
        Text txt = new Text("On the right are all of the food items and recipes you have loaded in so far. If you are a completely new user, it is only showing the default ones; you can add in more later. If you are a new user but are not the first to use this program, the users before you may have added new food items and recipes. \n \n");
        Text t1 = new Text("You are currently in view mode. To edit a meal entry you will have to switch to edit mode by using the buttons in the menu bar under Mode. If you want to edit your food item and recipe lists, you can also access that mode in the same menu.");
        mainText.getChildren().add(t);
        mainText.getChildren().add(tx);
        mainText.getChildren().add(txt);
        mainText.getChildren().add(t1);
        UserLog current = NutritionCalculator.currentLog;
        dayEntries = current.getDayEntryList();
        ArrayList<String> dates = new ArrayList<String>();
        for(DayEntry d : dayEntries){
            dates.add(d.getDate());
        }
        dates.add("Total");
        ObservableList<String> obvDates = FXCollections.observableArrayList(dates);
        days.getItems().addAll(obvDates);
        NutritionCalculator.loadFoodList();
        NutritionCalculator.loadCustomRecipes();
        loadFoodList();
    }
    
    /*
    
        MENU
    
    */
    
     public void displayAbout(){
        Alert dialogBox = new Alert(Alert.AlertType.INFORMATION);
        dialogBox.setTitle("About This Program");
        dialogBox.setHeaderText(null);
        dialogBox.setContentText("");
        dialogBox.showAndWait();
    }
 
    public void quitProgram(){
        System.exit(-1);
    }
    
    public void saveLog(){
        try{
            NutritionCalculator.saveUserLog();
            Alert dialogBox = new Alert(Alert.AlertType.INFORMATION);
            dialogBox.setTitle("Save: Successful");
            dialogBox.setHeaderText(null);
            dialogBox.setContentText("The save went through!");
            dialogBox.showAndWait();
        }catch(Exception e){
            Alert dialogBox = new Alert(Alert.AlertType.INFORMATION);
            dialogBox.setTitle("Save: Unsuccessful");
            dialogBox.setHeaderText(null);
            dialogBox.setContentText("The save did not go through. Check the program's saved files folder and try again.");
            dialogBox.showAndWait();
        }
        
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
    
    /*
    
        DAY + MEAL INTERFACE
    
    */
    
    //Selects the day and loads the 
    public void selectDay(){
        String date = days.getSelectionModel().getSelectedItem();
        if(date!=null && !date.equals("Total")){
            DayEntry currentDay = NutritionCalculator.currentLog.getDayEntry(date);
            ArrayList<MealEntry> meals = currentDay.getMealEntryList();
            if(!meals.isEmpty()){
                Text t = new Text("Your meal entries for " + date + " are shown below. Select an option to view its details.");
                ArrayList<String> items = new ArrayList<String>();
                int i = 1;
                for(MealEntry m : meals){
                    items.add("Meal " + i);
                    i++;
                }
                ObservableList<String> mealOL = FXCollections.observableArrayList(items);
                try{
                    ObservableList<String> ol = mealList.getItems();
                    if(ol == null){
                        mealList.getItems().clear();
                    }
                }catch(Exception e){
            
                }
            mealList.getItems().addAll(mealOL);
            }
        } else if(date.equals("Total")){
            
        }
    }
    
    public void newMeal(){
        mealContentView.setVisible(true);
        addToMealMode = true;
        Text t = new Text("You are creating a new meal. To add a dish to your menu, select food items from either the");
        mainText.getChildren().clear();
        mainText.getChildren().add(t);
    }
    
    public void toggleViewMode(){
        addMealB.setVisible(false);
        editMealB.setVisible(false);
        deleteMealB.setVisible(false);
    }
    
    public void toggleEditMode(){
        addMealB.setVisible(true);
        editMealB.setVisible(true);
        deleteMealB.setVisible(true);
        Text t = new Text("You are now in edit mode.");
        mainText.getChildren().clear();
        mainText.getChildren().add(t);
    }
    
    /*
    
        FOOD + RECIPE INTERFACE 
    
    */
    
    public void toggleFoodList(){
        if(flView.equals("ing")){
            flView = "rec";
            loadFoodList();
        }else{
            flView = "ing";
            loadFoodList();
        }
    }
    
    public void toggleIngMode(){
        addMealB.setVisible(false);
        editMealB.setVisible(false);
        deleteMealB.setVisible(false);
    }
    
    //Loads the food on the right based on which list the user specifies
    public void loadFoodList(){
        ArrayList<String> items = new ArrayList<String>();
        if(flView.equals("ing")){
            ArrayList<FoodItem> foods = NutritionCalculator.foodList;
            for(FoodItem f : foods){
                String s = f.getName();
                items.add(s);
            }
        } else if(flView.equals("rec")){
            ArrayList<Recipe> recipes = NutritionCalculator.customRecipes;
            for(Recipe r : recipes){
                String s = r.getName();
                items.add(s);
            }
        }
        ObservableList<String> obvFood = FXCollections.observableArrayList(items);
        foodsList.getItems().clear();
        foodsList.getItems().addAll(obvFood);
    }
    
    public void addFood(){
        if(addToMealMode){
            
            mealContentView.getItems();
        }
    }
    
}