/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlegame;

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
    
    private GridPane functionGrid ;
    private int count = 0;
    private Button click ;
    private Button [][] bG = new Button [4][4];
    private String[][] t = new String[4][4];
    private boolean[][] b = new boolean[4][4];
    
    
    public fourGrid(){
        functionGrid = new GridPane();
        functionGrid.setGridLinesVisible(true);
        functionGrid.setHgap(4);
        functionGrid.setVgap(4);
        for(int i=0; i<4;i++){
                    for(int j=0;j<4;j++){
                        
                        click  = new Button(" ");
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
                                                t[i][j]= "O";
                                            }else if(bG[i][j].getText().equals("X")){
                                                t[i][j]= "X";
                                            }else{
                                                t[i][j]=" ";
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
                                    for(Button[] b : bG){
                                        for(Button c: b){
                                            c.setTextFill(Color.BLACK);
                                        }
                                        
                                    }
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
    public String[][] getState(){
        for(int i =0;i<0;i++){
            for(int j=0;j<4;j++){
                if(bG[i][j].getText().equals("O")){
                    t[i][j]= "O";
                }else if(bG[i][j].getText().equals("X")){
                    t[i][j] = "X";
                }else{
                    t[i][j]= " ";
                }
            }
        }
        return t;
    }
    public boolean[][] getStateBool(){
        for(int i =0;i<0;i++){
            for(int j=0;j<4;j++){
                if(bG[i][j].getText().equals("O")){
                    b[i][j]= true;
                }else if(bG[i][j].getText().equals("X")){
                    b[i][j] = false;
                }else{
                    b[i][j]= false;
                }
            }
        }
        return b;
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

    public void removeMistakes(boolean[][] a){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(a[i][j]== false){
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
    
     //getters and setters
    public int getCount(){
        return count;
    }
    
    public int setCount(int a){
        return count = a;
    }
    
    public String toString(){
        return "Count: " + count;
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(o == this) return true;
        if(o.getClass() == this.getClass()){
            fourGrid a = (fourGrid)o;
            return a.getCount() == count;
        }
        return false;
    }
  
}