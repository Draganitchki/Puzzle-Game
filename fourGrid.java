/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlegame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author svety
 */
public class fourGrid {
    GridPane functionGrid ;
    Button click ;
    Button [][] buttonGrid = new Button [4][4];
    
    public fourGrid(){
        functionGrid = new GridPane();
        functionGrid.setGridLinesVisible(true);
        functionGrid.setHgap(4);
        functionGrid.setVgap(4);
        for(int i=0; i<4;i++){
                    for(int j=0;j<4;j++){
                        
                        click  = new Button();
                        click .setVisible(true);
                        click .setMinSize(40, 40);
                        functionGrid.add(click ,i,j);
                        buttonGrid[i][j] = click;
                        
                        final Button myButton = buttonGrid[i][j]; // figuring out I needed to do this took me almost 2 hours -.- i hate coding
                        final Button rows = buttonGrid[i][j];    
                        myButton.setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent event) {
                                if ("X".equals(myButton.getText())) {
                                    rows.setText("X");
                                    myButton.setText("O");
                                } else {
                                    myButton.setText("X");
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
}