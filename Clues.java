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
import java.util.ArrayList;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    private int errors;
    private String[] cluess;
    public Clues(){
        clues = new VBox();
        cluess = new String[15];
        counter = 0;
        errors=0;
        clues.setStyle("-fx-background-color: white;");
        title = new Text("Active Clues"); 
        clues.relocate(800,50);
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        options = new ArrayList<Label>();
        clues.getChildren().add(title);
        getClues();
           
    }

    public VBox getVBox(){
        return clues;
    }
    
    private void getClues(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("Puzzle.txt"));
            for(int j=0;j<14;j++){
                br.readLine();
            }
            for(int i=0;i<15;i++){
                cluess[i] = br.readLine();
            }
            br.close();
        }
        catch(FileNotFoundException e ){
            System.out.println("fix me");
            
        }
        catch(IOException d){
            System.out.println("plz");
        }
        
    }
    
    public void addClue(){
        if(counter<5){
            for(int i=0;i<5;i++){
                options.add(new Label (cluess[counter]));
                clues.getChildren().add(options.get(counter));
                counter ++;
            }
        }else if(counter<14){
            errors++;
            for(int i=0;i<3;i++){
                options.add(new Label (cluess[counter]));
                clues.getChildren().add(options.get(counter));
                counter ++;
            }
        }
    }
    
    public int getErrors(){
        return errors;
    }
}
