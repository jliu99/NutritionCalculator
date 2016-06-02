/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritioncalculator;

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
    private Button NewLog, LoadLog, go;
   
    @FXML
    private TextField tf;
    
    @FXML
    private TextFlow tflow;
    
    private boolean newLog;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Text t1 = new Text("Welcome to the Nutrition Calculator!");
        Text t2 = new Text("Are you a new user? Then create a new log with the button below! Otherwise, if you're a returning user, click the Load Log button to get started.");
        tflow = new TextFlow(t1, t2);
        tflow.getChildren().add(t1);
        tflow.getChildren().add(t2);
        Main.stage.show();
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
     NewLog.setManaged(false);
     LoadLog.setVisible(false);
     LoadLog.setManaged(false);
     go.setVisible(true);
     go.setManaged(true);
     tflow = new TextFlow(t);
     Main.stage.show();
    }
    
    public void promptLoadLog(){
     newLog = false;
     Text t1 = new Text("Enter your name EXACTLY as it appears in your log, then press Go to begin.");
     prompt(t1);
    }
    
    public void process(){
        String name = tf.getCharacters().toString();
        name.toLowerCase();
        if(newLog){
            NutritionCalculator.currentLog = new UserLog(name);
        } else{
            NutritionCalculator.loadUserLog(name);
        }
        try {
            Main.switchStage();
        } catch (Exception ex) {
            System.out.println("Something went wrong switching stages.");
            Logger.getLogger(StartController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void displayAbout(){
        Alert dialogBox = new Alert(AlertType.INFORMATION);
        dialogBox.setTitle("About This Program");
        dialogBox.setHeaderText(null);
        dialogBox.setContentText("");
        dialogBox.showAndWait();
    }
 
    public void displayHowTo(){
        Alert dialogBox = new Alert(AlertType.INFORMATION);
        
    }
    
}
