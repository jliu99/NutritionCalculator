/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritioncalculator;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

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
    private MenuItem about;
    
    @FXML
    private Button NewLog, LoadLog, go, backB;
   
    @FXML
    private TextField tf;
    
    @FXML
    private TextFlow tflow;
    
    private boolean newLog;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Text t1 = new Text("Welcome to the Nutrition Calculator! \n \n"), 
             t2 = new Text("Are you a new user? Then create a new log with the button below! Otherwise, if you're a returning user, click the Load Log button to get started.");
        tflow.getChildren().add(t1);
        tflow.getChildren().add(t2);
        
    }    
    
    public void quitProgram(){
        System.exit(-1);
    }
    
    public void promptNewLog(){
     newLog = true;
     Text t1 = new Text("Enter your name EXACTLY as you want it to appear in your log, then press Go to begin.");
     prompt(t1);
    }
    
    public void prompt(Text t){
     NewLog.setVisible(false);
     LoadLog.setVisible(false);
     go.setVisible(true);
     tf.setVisible(true);
     backB.setVisible(true);
     tflow.getChildren().clear();
     tflow.getChildren().add(t);  
    }
    
    public void promptLoadLog(){
     newLog = false;
     Text t1 = new Text("Enter your name EXACTLY as it appears in your log, then press Go to begin. If you enter your name incorrectly, nothing will happen, so that your spelling matches that of the file name before retrying.");
     prompt(t1);
    }
    
    public void process(){
        String name = tf.getCharacters().toString();
        name.toLowerCase();
        if(newLog){
            NutritionCalculator.currentLog = new UserLog(name);
            switchToMain();
        } else{
            if(NutritionCalculator.loadUserLog(name)){
                switchToMain();
            }
        }
        
    }
    
    public void switchToMain(){
        NewLog.setVisible(true);
        LoadLog.setVisible(true);
        go.setVisible(false);
        tf.setVisible(false);
        backB.setVisible(false);
        try {
            Main.switchStage("main");
        } catch (Exception ex) {
            System.out.println("Something went wrong switching stages.");
            Logger.getLogger(StartController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void goBack(){
        NewLog.setVisible(true);
        LoadLog.setVisible(true);
        go.setVisible(false);
        tf.setVisible(false);
        backB.setVisible(false);
        Text t1 = new Text("Welcome to the Nutrition Calculator! \n \n"), 
             t2 = new Text("Are you a new user? Then create a new log with the button below! Otherwise, if you're a returning user, click the Load Log button to get started.");
        tflow.getChildren().clear();
        tflow.getChildren().add(t1);
        tflow.getChildren().add(t2);
    }
    
    public void displayAbout(){
        Alert dialogBox = new Alert(AlertType.INFORMATION);
        dialogBox.setTitle("About This Program");
        dialogBox.setHeaderText(null);
        dialogBox.setContentText("");
        dialogBox.showAndWait();
    }
    
}
