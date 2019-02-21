/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package puzzlegame;

import java.util.ArrayList;

/**
 *
 * @author ben
 */
public class GamesNClues {
    
    ArrayList<boolean[][]> solution;
    String size;
    String dificulty;
            
            
            public GamesNClues(String grid,String level){
                size=grid;
                dificulty = level;
                solution = new ArrayList<boolean[][]>();
                
                
            }
            
            public ArrayList<boolean[][]> getSolution(){
                
                if(size == "3x4" && dificulty == "Easy"){
                    boolean[][] a= new boolean[4][4];
                    boolean[][] b = new boolean[4][4];
                    boolean[][] c = new boolean[4][4];
                    for(int i=0;i<4;i++){
                        for(int j = 0;j<4;j++){
                            a[i][j]= false;
                            b[i][j]= false;
                            c[i][j]= false;
                        }
                    }
                    a[0][0] = true;
                    a[1][3] = true;
                    a[2][2] = true;
                    a[3][1]= true;
                    solution.add(a);
                    b[0][1] = true;
                    b[1][2] = true;
                    b[2][3] = true;
                    b[3][1] = true;
                    solution.add(b);
                    c[0][1] = true;
                    c[1][0] = true;
                    c[2][3] = true;
                    c[3][2] = true;
                    solution.add(c);
                }
                return solution;
            }
    
}