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
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

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
    private MenuItem close;

    @FXML
    private MenuItem ing, recipe, main;

    @FXML
    private MenuItem about;
    
    @FXML
    private TextFlow textFlow;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Text t = new Text("I couldn't finish this by the due date but this is what the interface would have looked like. Not many of the buttons work here and if you want to go back you can't, sorry. - Janine");
        textFlow.getChildren().add(t);
    }

    public void quit(){
        System.exit(-1);
    }
    
    public void save(){
        NutritionCalculator.saveUserLog();
        NutritionCalculator.saveFoodList();
        NutritionCalculator.saveCustomRecipes();
    }
    
}
