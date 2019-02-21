/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package puzzlegame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author svety
 */
public class fourGrid {
    GridPane functionGrid ;
    int count = 0;
    Button click ;
    Button [][] bG = new Button [4][4];
    boolean[][] t = new boolean[4][4];
    public fourGrid(){
        functionGrid = new GridPane();
        functionGrid.setGridLinesVisible(true);
        functionGrid.setHgap(4);
        functionGrid.setVgap(4);
        for(int i=0; i<4;i++){
                    for(int j=0;j<4;j++){
                        
                        click  = new Button();
                        click .setVisible(true);
                        click .setMinSize(60, 60);
                        functionGrid.add(click ,i,j);
                        bG[i][j] = click;
                        
                        final Button a = bG[i][j]; // figuring out I needed to do this took me almost 2 hours -.- i hate coding

                            a.setOnAction(new EventHandler<ActionEvent>() {
            
                            @Override
                            public void handle(ActionEvent event) {
                                a.setTextFill(Color.BLACK);
                                if(a.getText()=="X"){
                                    a.setText("O");
                                    int x=0;
                                    int y=0;
                                    for(int i=0;i<4;i++){
                                        for(int j=0;j<4;j++){
                                            if(bG[i][j].equals(a)){
                                                x = i;
                                                y =j;
                                            }
                                            if(bG[i][j].getText().equals("O")){
                                                t[i][j]= true;
                                            }else{
                                                t[i][j]= false;
                                            }
                                        }
                                    }
                                    for(int i=0;i<4;i++){
                                        for(int j=0;j<4;j++){
                                            if((!(bG[i][j].equals(bG[x][y]))) && ((x==i && y!=j)||(x!=i && y==j))){
                                                if(bG[i][j].getText().equals("O")){
                                                    bG[i][j].setTextFill(Color.CRIMSON);
                                                }else{
                                                    bG[i][j].setTextFill(Color.BLACK);
                                                    bG[i][j].setText("X");
                                                }
                                            }else{
                                                bG[i][j].setTextFill(Color.BLACK);
                                            }
                                        }
                                    }
                                }else if(a.getText()=="O"){
                                    a.setText(" ");
                                    a.setTextFill(Color.BLACK);
                                }else{
                                    a.setText("X");
                                    a.setBackground(new Background(new BackgroundFill(
                Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                                }
                            
                            }
                        });
                    }
        }
        
    }
    
    public GridPane getGrid(){
        return functionGrid;
    }
    
    public Button getButton(){
        return click;
    }
    public boolean[][] getState(){
        for(int i =0;i<0;i++){
            for(int j=0;j<4;j++){
                if(bG[i][j].getText().equals("O")){
                    t[i][j]= true;
                }else{
                    t[i][j] = false;
                }
            }
        }
        return t;
    }
    public String[][] getStrings(){
        String[][] s = new String[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                s[i][j] = bG[i][j].getText();
            }
        }
        return s;
    }
    
    public void setState(String[][] newState){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(newState[i][j].equals("O")){
                    bG[i][j].setText("O");
                }else if(newState[i][j].equals("X")){
                    bG[i][j].setText("X");
                }else{
                    bG[i][j].setText(" ");
                }
            }
        }
    }
    
    public int getCount(){
        return count;
    }
    public void removeMistakes(boolean[][] b){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if((b[i][j]==t[i][j])){
                    if(bG[i][j].getText().equals("O")){
                        bG[i][j].setBackground(new Background(new BackgroundFill(
                Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                        bG[i][j].setText(" ");
                        count++;
                    }
                }
            }
        }
    }
    
}
