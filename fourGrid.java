/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2Final;

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
 * this class creates and controls the buttons used for the grid
 * they update when pressed or when the mistake button is pressed
 * @author svety and ben
 */
public class fourGrid {
    
    private GridPane functionGrid ;
    private int count = 0;
    private Button click ;
    private Button [][] bG = new Button [4][4];
    private String[][] t = new String[4][4];
    private boolean[][] b = new boolean[4][4];
    
    /**
     * constructor for the button GUI
     * implemented in PuzzleGames
     */
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
                        
                        final Button a = bG[i][j]; 
                            //when the button is pressed, the state of all the buttons is updated
                            a.setOnAction(new EventHandler<ActionEvent>() {
            
                            @Override
                            public void handle(ActionEvent event) {
                                a.setTextFill(Color.BLACK);
                                if(a.getText()=="X"){
                                    a.setText("O");
                                    int x=0;
                                    int y=0;
                                    for(int i=0;i<4;i++){  //checks and updates the other buttons which must be false if this is true
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
                                    // after updating buttons, checks for direct conflics and marks them red
                                    for(int i=0;i<4;i++){
                                        for(int j=0;j<4;j++){
                                            if((!(bG[i][j].equals(bG[x][y]))) && ((x==i && y!=j)||(x!=i && y==j))){
                                                if(bG[i][j].getText().equals("O")){
                                                    bG[i][j].setTextFill(Color.CRIMSON);  //only 1 button in each colom or row should be O
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
                 Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));  // this marks which buttons have been pressed as well as getting rid of red errors
                                    for(Button[] b : bG){
                                        for(Button c: b){
                                            c.setTextFill(Color.BLACK); // gets rid of conflics collor on next button push
                                        }
                                        
                                    }
                                }
                            
                            }
                        });
                    }
        }
        
    }
    /**
     * get method for the button grid
     * @return functionGrid - GridPane
     */
    public GridPane getGrid(){
        return functionGrid;
    }
    /**
     * get method for individual button
     * @return click - Button
     */
    public Button getButton(){
        return click;
    }
    /**
     * gets the current state of all buttons
     * used for save
     * @return String[][] representation of board
     */
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
    
    /**
     * gets a boolean representation of the board
     * this allows unpressed buttons to be treated the same as buttons marked x
     * used for finding winner and mistakes
     * @return boolean[][] representation of the board
     */
    public boolean[][] getStateBool(){
        for(int i =0;i<4;i++){
            for(int j=0;j<4;j++){
                if(bG[i][j].getText()=="O"){
                    b[i][j]= true;
                }else if(bG[i][j].getText()=="X"){
                    b[i][j] = false;
                }else{
                    b[i][j]= false;
                }
            }
        }
        return b;
    }
    
    /**
     * get method for the text of each of the buttons
     * @return String[][]
     */
    public String[][] getStrings(){
        String[][] s = new String[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                s[i][j] = bG[i][j].getText();
            }
        }
        return s;
    }
    
    /**
     * sets the state of the buttons to match a given state
     * @param newState - String[][] the new state to set the board to
     */
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

    /**
     * finds, removes, and reports any mistakes that are present
     * @param a - boolean[][] representation of which buttons dont match the solution
     */
    public void removeMistakes(boolean[][] a){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                //System.out.println(a[i][j]);
                if(a[i][j]== true){
                    if(bG[i][j].getText().equals("O")){
                        bG[i][j].setBackground(new Background(new BackgroundFill(
                        Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));  // marks errors red
                        bG[i][j].setText(" ");
                        count++;
                    }else if(bG[i][j].getText().equals("X")){  // doesnt count these errors in count
                        bG[i][j].setText(" ");
                    }
                }
                    
                
            }
        }
        //System.out.println("  ");
    }
    
    /**
     * gets the count of total mistakes
     * @return int - number of mistakes
     */
    public int getCount(){
        return count;
    }
    
    /**
     * manually sets number of mistakes
     * @param a - int new mistake number
     */
    public void setCount(int a){
        count = a;
    }
    /**
     * String representation of this class
     * @return 
     */
    public String toString(){
        String s="Count: "+ count;
        for(String[] a: this.getState()){
            for(String b: a){
                s+=" "+b;
            }
        }
        return s;
    }
    
    
    /**
     * Equals method
     * @param o an object to be tested
     * @return boolean true or false
     */
    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(o == this) return true;
        if(o.getClass() == this.getClass()){
            fourGrid a = (fourGrid)o;
            return ((a.getCount() == count)&&(a.getState()==this.getState()));
        }
        return false;
    }
  
}