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
    ArrayList<boolean[][]> solution;
    boolean[][] b1;
    boolean[][] b2;
    boolean[][] b3;
    
    public Solutions(){
        
        solution = new ArrayList<boolean[][]>();
        
        b1 = new boolean[4][4];
        b2 = new boolean[4][4];
        b3 = new boolean[4][4];
        
      
    }
    
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
                    if(solution.get(b)[i][j]==a.get(b)[i][j]){
                        mistakes.get(b)[i][j]= true;
                    }else{
                        mistakes.get(b)[i][j]=false;
                    }
                }
            }
        }
        return mistakes; 
    }
    
}