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
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author svety
 */
public class vGrid {
    GridPane seeGrid;
    
    ArrayList<String> s = new ArrayList<String>();
    public vGrid(){
        seeGrid = new GridPane();
        seeGrid.setGridLinesVisible(true);
        seeGrid.setHgap(4);
        seeGrid.setVgap(4);
        for(int i=0; i<4;i++){
                    for(int j=0;j<4;j++){
                        
                        Label d = new Label("Default");
                        d.setMinSize(60, 60);
                        seeGrid.add(d,i,j);
                    }
        }
        
    }
    
    
    public vGrid(ArrayList<String> s,int a, int b){
        seeGrid = new GridPane();
        seeGrid.setGridLinesVisible(true);
        seeGrid.setHgap(a);
        seeGrid.setVgap(b);
        int count =0;
        
        for(int i=0; i<a;i++){
                    for(int j=0;j<b;j++){
                        
                        Label d = new Label(s.get(count));
                        count++;
                        if(a<b){
                            d.setMinSize(b*30,a*60);
                        }else{
                            d.setMinSize(b*60,a*30);
                        }
                        seeGrid.add(d,i,j);
                    }
        }
    }
    public GridPane getGrid(){
        return seeGrid;
    }
    
}
