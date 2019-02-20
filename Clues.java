/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlegame;

import java.util.ArrayList;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author s_draganitchki
 */
public class Clues {
    private VBox clues;
    private Text title;
    private ArrayList<Label> options;
    private int counter;
    public Clues(){
        clues = new VBox();
        clues.setStyle("-fx-background-color: white;");
        title = new Text("Active Clues"); 
        clues.relocate(900,200);
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        options = new ArrayList<Label>();
           clues.getChildren().add(title);
    }

    public VBox getVBox(){
        return clues;
    }
    
    public void addClue(String a){
        options.add(new Label (a));
        clues.getChildren().add(options.get(counter));
        counter ++;
    }
}
