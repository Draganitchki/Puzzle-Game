/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlegame;

import java.util.ArrayList;

/**
 *
 * @author ben
 */
public class Solutions {
    
    
    private ArrayList<boolean[][]> solution;
    private boolean[][] b1;
    private boolean[][] b2;
    private boolean[][] b3;
    private boolean win;
    
    public Solutions(){
        
        solution = new ArrayList<boolean[][]>();
        
        b1 = new boolean[4][4];
        b2 = new boolean[4][4];
        b3 = new boolean[4][4];
        
        win=false;
        
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                b1[i][j]= false;
                b2[i][j]= false;
                b3[i][j] = false;
            }
        }
        // this code is repeated in GamesNClues
        b1[0][3]=true;
        b1[1][1]=true;
        b1[2][0]= true;
        b1[3][2]=true;
        
        b2[0][2]=true;
        b2[1][1]=true;
        b2[2][0]= true;
        b2[3][3]=true;
        
        b3[0][0]=true;
        b3[1][1]=true;
        b3[2][3]= true;
        b3[3][2]=true;
        
      solution.add(b1);
      solution.add(b2);
      solution.add(b3);
    }
    
    
    // adds an arraylist to another arraylist
    public void addSolution(ArrayList<boolean[][]> a){
        solution = a;
    }
    
    public boolean checkSolutions(ArrayList<boolean[][]> a){
        boolean correct = true;
        for(int b=0;b<3;b++){
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    if(solution.get(b)[i][j]!=a.get(b)[i][j]){
                        correct = false;
                    }   
                }
            }
        }
        
        if(!win && correct){
            win = true;
        }else{
            correct = false;
        }
        
        return correct;
    }
    
    public ArrayList<boolean[][]> findMistakes(ArrayList<boolean[][]> a){
        ArrayList<boolean[][]> mistakes = new ArrayList<boolean[][]>();
        mistakes.add(b1);
        mistakes.add(b2);
        mistakes.add(b3);
        
        for(int b=0;b<3;b++){
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    if(!(solution.get(b)[i][j]==a.get(b)[i][j])){
                        mistakes.get(b)[i][j]= true;
                    }else{
                        mistakes.get(b)[i][j]=false;
                    }
                }
            }
        }
        return mistakes; 
    }
    
    //getters and setters
    
    public boolean getWin(){
        return win;
    }
    
    public boolean setWin(boolean a){
        return win = a;
    }
    
    @Override
    public String toString(){
        return "Winning Status: " + win;
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(o == this) return true;
        if(o.getClass() == this.getClass()){
            Solutions a = (Solutions)o;
            return a.getWin() && win;
        }
        return false;
    }
}