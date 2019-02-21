/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package puzzlegame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javax.swing.JTextField;

/**
 *
 * @author s_draganitchki
 */
public class AboutMe {
    private VBox about;
    private TextArea main;
    private Text title;
    public AboutMe(){
        about = new VBox();
        about.setStyle("-fx-background-color: white;");
        about.relocate(900,500);
        title = new Text("Backstory"); 
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        main = new TextArea("This is the Default about me");
       
        about.getChildren().add(title);
        about.getChildren().add(main);
    }    
    
    
    public AboutMe(String body){
        about = new VBox();
        about.setStyle("-fx-background-color: white;");
        about.relocate(800,400);
        title = new Text("Backstory");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        main = new TextArea("test");
        main.setPrefSize(350, 350);
        about.getChildren().addAll(title,main);
    }
    
    public VBox getVBox(){
        return about;
    }
    
    public void setText(){
        String s = "";
        try{
            BufferedReader fr = new BufferedReader(new FileReader("Puzzle.txt"));
            for(int j=0;j<20;j++){
                fr.readLine();
            }
            for(int i=0;i<13;i++){
                s += fr.readLine()+ "\n";
            }
            main.setText(s);
           
            main.setEditable(false);
            fr.close();
        }
        catch(FileNotFoundException e){
            System.out.printf("File" );
        }
        catch(IOException e){
            // catch it
            System.out.print("error");
        }
    }
}
