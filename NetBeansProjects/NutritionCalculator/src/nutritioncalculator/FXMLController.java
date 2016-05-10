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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
