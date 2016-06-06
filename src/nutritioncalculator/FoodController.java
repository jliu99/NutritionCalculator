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
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author jl
 */


public class FoodController implements Initializable {
    
    @FXML
    private BorderPane pane;

    @FXML
    private Menu file, mode, help;

    @FXML
    private MenuItem save, close;

    @FXML
    private MenuItem ing, recipe, main;

    @FXML
    private MenuItem about;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
