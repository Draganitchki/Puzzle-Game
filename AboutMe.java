/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlegame;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author s_draganitchki
 */
public class AboutMe {
    private VBox about;
    private Label main;
    private Text title;
    public AboutMe(){
        about = new VBox();
        about.setStyle("-fx-background-color: white;");
        about.relocate(900,500);
        title = new Text("About Me"); 
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        main = new Label ("This is the Default about me");
        main.setWrapText(true);
        about.getChildren().addAll(title,main);
    }
    
    public AboutMe(String body){
        about = new VBox();
        about.setStyle("-fx-background-color: white;");
        about.relocate(900,500);
        title = new Text("About Me");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        main = new Label (body);
        main.setWrapText(true);
        about.getChildren().addAll(title,main);
    }
    
    public VBox getVBox(){
        return about;
    }
}
