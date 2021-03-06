/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlegame;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 *
 * @author Svetozar Draganitchki 
 */
public class labelGrid {
    
    
    private Label var;
    
    
    //a default constructor if user doesn't want to add values
    public labelGrid(){
        var = new Label("Default");
        var.setTextFill(Color.web("#ffffff"));
        var.setStyle("-fx-color:white; -fx-background-color: black;");
    }
    
    //Second constructor for user that wants to add custome name and size of labels
    public labelGrid(String a, int b, int c){
        var = new Label(a);
        var.setMinSize(b,c);
        var.setTextFill(Color.web("#ffffff"));
        var.setStyle("-fx-color:white; -fx-background-color: black;");
    }
    
    
    //returns the label called grid to keep up with consistancy of rest of the code
    public Label getGrid(){
        return var;
    }
    
    @Override
    public String toString(){
        return "Label:" + var;
    }
    
    // equals method not added as this class just has gui variables.
}
