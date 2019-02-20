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
 * @author svety
 */
public class labelGrid {
    private Label var;
    
    public labelGrid(){
        var = new Label("Default");
        var.setTextFill(Color.web("#ffffff"));
        var.setStyle("-fx-color:white; -fx-background-color: black;");
    }
    
    public labelGrid(String a, int b, int c){
        var = new Label(a);
        var.setMinSize(b,c);
        var.setTextFill(Color.web("#ffffff"));
        var.setStyle("-fx-color:white; -fx-background-color: black;");
    }
    
    public Label getGrid(){
        return var;
    }
}
