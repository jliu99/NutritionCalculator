/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritioncalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author kslimmo
 */
public class StartController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private BorderPane pane;
     
    @FXML
    private Menu file, help;
    
    @FXML
    private MenuItem close;
    
    @FXML
    private MenuItem about, howto;
    
    @FXML
    private Button NewLog, LoadLog;
   
    @FXML
    private TextField tf;
    
    @FXML
    private Label labelOne, labelTwo, labelThree;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    public void quitProgram(){
        System.exit(-1);
    }
    
    private void saveLog() {
        NutritionCalculator.saveUserLog();
    }
    
    public void loadLog(){
        String s = tf.getCharacters().toString();
        s = s.toLowerCase();
        NutritionCalculator.loadUserLog(s);
    }
    
    public static void createNewLog(){
        String name = "";
        NutritionCalculator.currentLog = new UserLog(name);
    }
    
    public void displayAbout(){
        Alert dialogBox = new Alert(AlertType.INFORMATION);
        dialogBox.setTitle("About This Program");
        dialogBox.setHeaderText(null);
        dialogBox.setContentText("");
        dialogBox.showAndWait();
    }
 
    public void displayHowTo(){
        
    }
    
}
