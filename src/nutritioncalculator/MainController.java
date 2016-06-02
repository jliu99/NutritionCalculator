/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritioncalculator;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class MainController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserLog current = NutritionCalculator.currentLog;
        ArrayList<DayEntry> dayEntries = current.getDayEntryList();
        ArrayList<String> dates = new ArrayList<String>();
        for(DayEntry d : dayEntries){
            dates.add(d.getDate());
        }
        dates.add("Total");
        ObservableList<String> obvDates = FXCollections.observableArrayList(dates);
        days.setItems(obvDates);
        Text tx = new Text("Select one of the days from the left to view its details.");
        tflow = new TextFlow(tx);
    }
    
    @FXML
    private BorderPane pane;
     
    @FXML
    private Menu file, help;
    
    @FXML
    private MenuItem save, load, close;
    
    @FXML
    private MenuItem about, howto;
    
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
    
    @FXML
    private ListView days;
    
    @FXML
    private TextFlow tflow;
 
    public void saveLog(){
        NutritionCalculator.saveUserLog();
        NutritionCalculator.saveFoodList(NutritionCalculator.foodList);
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