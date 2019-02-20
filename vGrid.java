/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlegame;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author svety
 */
public class vGrid {
    GridPane seeGrid;
    public vGrid(){
        seeGrid = new GridPane();
        seeGrid.setGridLinesVisible(true);
        seeGrid.setHgap(4);
        seeGrid.setVgap(4);
        for(int i=0; i<4;i++){
                    for(int j=0;j<4;j++){
                        
                        Label d = new Label("Default");
                        d.setMinSize(80, 40);
                        seeGrid.add(d,i,j);
                    }
        }
        
    }
    
    public vGrid(String c,int a, int b){
        seeGrid = new GridPane();
        seeGrid.setGridLinesVisible(true);
        seeGrid.setHgap(a);
        seeGrid.setVgap(b);
        for(int i=0; i<a;i++){
                    for(int j=0;j<b;j++){
                        
                        Label d = new Label(c);
                        d.setMinSize(b*40,a*40);
                        seeGrid.add(d,i,j);
                    }
        }
    }
    
    public GridPane getGrid(){
        return seeGrid;
    }
}
