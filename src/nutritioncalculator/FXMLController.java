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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author kslimmo
 */
public class FXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private BorderPane pane;
     
     @FXML
    private Menu file;
     
     @FXML
    private Menu edit;
    
     @FXML
    private Menu help;
    
    @FXML
    private MenuItem save;
    
    @FXML
    private MenuItem close;
    
    @FXML
    private MenuItem load;
    
    @FXML
    private MenuItem about;
    
    @FXML
    private MenuItem faq;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public void quitProgram(){
        System.exit(-1);
    }
    public void saveLog(){
        
    }
    
    public void loadLog(String s){
    
    }
    
    public void displayAbout(){
        Alert dialogBox = new Alert(AlertType.INFORMATION);
        dialogBox.setTitle("About This Program");
        dialogBox.setHeaderText(null);
        dialogBox.setContentText("");
        dialogBox.showAndWait();
    }
 
    public void displayFAQ(){
    
    }
    
}
