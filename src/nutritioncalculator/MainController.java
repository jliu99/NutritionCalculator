/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritioncalculator;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
    private ListView<String> days, mealList, foodsList, foodContentsView;
    
    @FXML
    private Button loadButton;
    
    @FXML
    private Button addMealB, editMealB, deleteMealB, dayTotalB;

    @FXML
    private Button toggleFoodB, addDayB, deleteDayB;
    
    @FXML
    private Button cancelB, removeB, okB;
    
    private String flView;
    private boolean addToMealMode, editMealMode;
    private ArrayList<DayEntry> dayEntries;
    private static DayEntry currentDay;
    private static MealEntry currentMeal;
    private ArrayList<String> mealContents;
    
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
        editMealMode = false;
        mealList.setVisible(false);
        loadButton.setVisible(true);
        loadButton.setManaged(true);
        
    }
    
    public void loadUser(){
        loadButton.setVisible(false);
        mealList.setVisible(true);
        toggleFoodB.setVisible(true);
        addDayB.setVisible(true);
        deleteDayB.setVisible(true);
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
    
        MENU + GENERAL FUNCTIONALITY
    
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
        if(!addToMealMode && !editMealMode){
            Alert dialogBox = new Alert(Alert.AlertType.CONFIRMATION);
            dialogBox.setTitle("Are you sure?");
            dialogBox.setHeaderText(null);
            dialogBox.setContentText("This will take you back to the Main Screen. Make sure you have saved!");
            ButtonType ok = new ButtonType("OK");
            ButtonType cancel = new ButtonType("Cancel");
            dialogBox.getButtonTypes().setAll(ok, cancel);

            Optional<ButtonType> result = dialogBox.showAndWait();
            if (result.get() == ok){
                loadButton.setVisible(false);
            mealList.setVisible(false);
            toggleFoodB.setVisible(false);
            addDayB.setVisible(false);
            deleteDayB.setVisible(false);
            toggleViewMode();
            replaceMainTextMessage("Please press the button below to load your data into the interface.");
                try {
                    Main.switchStage("start");
                } catch (Exception ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                // User chose CANCEL or closed the dialog; returns to interface.
            }
            
            
        } else{
            Alert dialogBox = new Alert(Alert.AlertType.INFORMATION);
            dialogBox.setTitle("Oops!");
            dialogBox.setHeaderText(null);
            dialogBox.setContentText("You're still in the middle of logging a meal. Please try again after you've created or cancelled entering a meal.");
            dialogBox.showAndWait();
        }   
    }
    
      public void toggleIngMode(){
        try{
            Main.switchStage("food");
        } catch(Exception ex){
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void replaceMainTextMessage(String s){
          Text t = new Text(s);
          mainText.getChildren().clear();
          mainText.getChildren().add(t);
    }
    
    /*
    
        DAY INTERFACE
    
    */
    
    //Selects the day and loads the 
    public void selectDay(){
        mealList.setVisible(true);
        String date = days.getSelectionModel().getSelectedItem();
        if(addToMealMode || editMealMode){
            replaceMainTextMessage("Please finish creating this meal before you switch to another day.");
        }else if(date!=null && !date.equals("Total")){
            currentDay = NutritionCalculator.currentLog.getDayEntry(date);
            ArrayList<MealEntry> meals = currentDay.getMealEntryList();
            if(!meals.isEmpty()){
               replaceMainTextMessage("Your meal entries for " + date + " are shown below. Select an option to view its details.");
               refreshMealList(meals); 
            } else {
                replaceMainTextMessage("You have no meal entries for " + date + ". To add a meal, go into Edit Mode and use the Add Meal button, which will appear below.");
            }
        } else if(date.equals("Total")){
            mealList.setVisible(false);
            mainText.getChildren().clear();
            ArrayList<DayEntry> dayEntries = NutritionCalculator.currentLog.getDayEntryList();
            Text t = new Text("You have logged a total " + dayEntries.size() + " days of your eating habits. \n");
            mainText.getChildren().add(t);
            String s = NutritionCalculator.currentLog.totalNutritionalValue(NutritionCalculator.foodList, NutritionCalculator.customRecipes).toString();
            t = new Text("In these " + dayEntries.size() + " days, you have consumed the following totals of nutrients. \n \n" + s + "\n \n");
            mainText.getChildren().add(t);
            s = NutritionCalculator.currentLog.averageNutritionalValue(NutritionCalculator.foodList, NutritionCalculator.customRecipes).toString();
            t = new Text("This means your average nutritional consumption for these " + dayEntries.size() + " days is as follows. \n \n" + s);
            mainText.getChildren().add(t);
        }
    }
    
    public void addDay(){
        
    }
    
    public void removeDay(){
        if(currentDay!=null){
            Alert dialogBox = new Alert(Alert.AlertType.CONFIRMATION);
            dialogBox.setTitle("Are you sure?");
            dialogBox.setHeaderText(null);
            dialogBox.setContentText("Delete the selected day?");
            ButtonType ok = new ButtonType("OK");
            ButtonType cancel = new ButtonType("Cancel");
            dialogBox.getButtonTypes().setAll(ok, cancel);
            Optional<ButtonType> result = dialogBox.showAndWait();
            if (result.get() == ok){
                NutritionCalculator.currentLog.deleteDay(currentDay);
                currentDay = null;
                replaceMainTextMessage("Day deleted.");
            } else {
                    // User chose CANCEL or closed the dialog; returns to interface.
            }
        } else{
            replaceMainTextMessage("No day selected. Pick a day to delete then try again.");
        }
    }
    
    /*
    
        MEAL INTERFACE
    
    */
    
    public void refreshMealList(ArrayList<MealEntry> meals){
        mealList.getItems().clear();
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
    
    public void newMealMode(){
        if(currentDay==null){
            replaceMainTextMessage("You need to select a day before you can add a meal. Select a day from the list on the left, then click Add Meal again.");
        }else{
            toggleViewMode();
            okB.setVisible(true);
            removeB.setVisible(true);
            cancelB.setVisible(true);
            mealList.setVisible(false);
            foodContentsView.setVisible(true);
            if(foodContentsView.getItems()!=null){
            foodContentsView.getItems().clear();
        }
            addToMealMode = true;
            replaceMainTextMessage("You are creating a new meal for this day. To add a dish to your menu, select items from either the food item list or the custom recipe list to the right. If you add an item accidentally, you can select it and remove it using the Remove button.");
            mealContents = new ArrayList<String>();
        }
    }
    
    public void editMealMode(){
        if(mealList.getSelectionModel().getSelectedItem()==null){
            replaceMainTextMessage("You didn't select a meal to edit. Select a meal, then press the Edit Meal button again.");
        } else{
            Integer index = Integer.parseInt(mealList.getSelectionModel().getSelectedItem());
            currentMeal = currentDay.getMealEntry(index);
            mealContents = currentMeal.getContents();
            foodContentsView.setVisible(true);
            editMealMode = true;
            toggleViewMode();
            okB.setVisible(true);
            removeB.setVisible(true);
            cancelB.setVisible(true);
            mealList.setVisible(false);
            refreshFoodContentsList();
            replaceMainTextMessage("You are currently editing a meal. You can click on the food items on the right to add a food or remove a food by selecting an item and clicking Remove.");
        }
    }
    
    public void deleteMeal(){
        if(mealList.getSelectionModel().getSelectedItem()==null){
            replaceMainTextMessage("You didn't select a meal to delete. Select a meal, then press the Delete Meal button again.");
        } else{
            Alert dialogBox = new Alert(Alert.AlertType.CONFIRMATION);
            dialogBox.setTitle("Are you sure?");
            dialogBox.setHeaderText(null);
            dialogBox.setContentText("Delete the selected meal?");
            ButtonType ok = new ButtonType("OK");
            ButtonType cancel = new ButtonType("Cancel");
            dialogBox.getButtonTypes().setAll(ok, cancel);

            Optional<ButtonType> result = dialogBox.showAndWait();
            if (result.get() == ok){
                Integer index = Integer.parseInt(mealList.getSelectionModel().getSelectedItem());
                currentDay.removeMealEntry(index);
            } else {
                // User chose CANCEL or closed the dialog; returns to interface.
            }  
        }
    }
    
    public void confirmMeal(){
        if(mealContents.isEmpty()){
            replaceMainTextMessage("A meal entry cannot be empty. Add some foods to your meal, then press Okay again when you're done.");
        }else{
            toggleEditMode();
            
            foodContentsView.setVisible(false);
            mealList.setVisible(true);
            if(addToMealMode){
                currentDay.addMeal(mealContents);
            }else{
                currentMeal.setContents(mealContents);
            }
            okB.setVisible(false);
            removeB.setVisible(false);
            cancelB.setVisible(false);
            refreshMealList(currentDay.getMealEntryList());
            replaceMainTextMessage("Meal added! You should now see the meal in the list of meals for this day below.");
            addToMealMode = false;
            editMealMode = false;
        }
    }
    
    public void cancelMeal(){
        toggleEditMode();
        addToMealMode = false;
        editMealMode = false;
        foodContentsView.setVisible(false);
        mealList.setVisible(true);
        okB.setVisible(false);
        removeB.setVisible(false);
        cancelB.setVisible(false);
        replaceMainTextMessage("Meal canceled.");
    }
    
    public void toggleViewMode(){
        addMealB.setVisible(false);
        editMealB.setVisible(false);
        deleteMealB.setVisible(false);
        dayTotalB.setVisible(false);
        replaceMainTextMessage("You are now in view mode.");
    }
    
    public void toggleEditMode(){
        addMealB.setVisible(true);
        editMealB.setVisible(true);
        deleteMealB.setVisible(true);
        dayTotalB.setVisible(true);
        replaceMainTextMessage("You are now in edit mode.");
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
        if(addToMealMode || editMealMode){
            String s = foodsList.getSelectionModel().getSelectedItem();
            mealContents.add(s);
            refreshFoodContentsList();
         }
    }
    
    public void removeFood(){
        if(foodContentsView.getSelectionModel().getSelectedItem()==null){
            replaceMainTextMessage("Please select a food from the list of foods before attempting to remove it.");
        }else{
            String s = foodContentsView.getSelectionModel().getSelectedItem();
            mealContents.remove(s);
            refreshFoodContentsList();
        }    
    }
    
    public void refreshFoodContentsList(){
        ObservableList<String> mealContentsOL = FXCollections.observableArrayList(mealContents);
        foodContentsView.getItems().clear();
        foodContentsView.getItems().addAll(mealContentsOL);
    }
}