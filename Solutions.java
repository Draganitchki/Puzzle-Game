/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2Final;

import java.util.ArrayList;

/**
 * class that stores the solution to the puzzle as well as checking the current state for mistakes or winner
 * @author ben
 */
public class Solutions {
    
    
    private ArrayList<boolean[][]> solution;
    private boolean[][] b1;
    private boolean[][] b2;
    private boolean[][] b3;
    private boolean win;
    
    /**
     * constructs a solution and sets winner to false
     */
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
        // sets the disired solution
        b1[3][0]=true;
        b1[1][1]=true;
        b1[0][2]= true;
        b1[2][3]=true;
        
        b2[0][0]=true;
        b2[1][1]=true;
        b2[2][3]= true;
        b2[3][2]=true;
        
        b3[0][2]=true;
        b3[1][1]=true;
        b3[2][0]= true;
        b3[3][3]=true;
        
      solution.add(b1);
      solution.add(b2);
      solution.add(b3);
    }
    
    
    /**
     * sets the solution to a desired solution
     * @param a boolean[][] representation of the solution
     */
    public void addSolution(ArrayList<boolean[][]> a){
        solution = a;
    }
    
    /**
     * checks a provided boolean state against the solution 
     * @param a - ArrayList<boolean[][]> representation of the current board
     * @return boolean true if the solution matches, false otherwise
     */
    public boolean checkSolutions(ArrayList<boolean[][]> a){
        boolean correct = true;
        for(int b=0;b<3;b++){
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    if(solution.get(b)[i][j]!=a.get(b)[i][j]){ //this will run if there is a difference
                        //System.out.println(solution.get(b)[i][j]+ " : "+ a.get(b)[i][j]);
                        correct = false;
                    } 
                    //System.out.println(" B: "+b+" i: "+i+" j "+j+"  "+solution.get(b)[i][j]+ " : "+a.get(b)[i][j]);
                }
            }
        }
        //System.out.println("done");
        
        if(!win && correct){  // only allows it to return true once
            win = true;
        }else{
            correct = false;
        }
        
        return correct;
    }
    
    
    /**
     * checks a provided boolean state against the solution and returns a list of all differences
     * @param a - ArrayList<boolean[][]> representation of the current board
     * @return ArrayList<boolean[][]> filled with true if it matched solution and false if it didnt
     */
    public ArrayList<boolean[][]> findMistakes(ArrayList<boolean[][]> a){
        ArrayList<boolean[][]> mistakes = new ArrayList<boolean[][]>();
        boolean[][] test = new boolean[4][4];
        boolean[][] test2 = new boolean[4][4];
        boolean[][] test3 = new boolean[4][4];
        mistakes.add(test);
        mistakes.add(test2);
        mistakes.add(test3);
        
        for(int b=0;b<3;b++){
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    //System.out.print("B="+b+" i="+i+" j="+j+" testing: "+a.get(b)[i][j]+" Solution: "+solution.get(b)[i][j]);
                    if(!(solution.get(b)[i][j]==a.get(b)[i][j])){
                        mistakes.get(b)[i][j]= true;
                    }else{
                        mistakes.get(b)[i][j]=false;
                    }
                    //System.out.print(" Mistake set to "+mistakes.get(b)[i][j]+"\n");
                }
            }
        }
        return mistakes; 
    }
    
    //getters and setters
    
    /**
     * returns the wiether or not there is a winner
     * @return boolean - wiether or not there is a winner
     */
    public boolean getWin(){
        return win;
    }
    
    /**
     * sets the status of winner
     * @param a - boolean new state
     */
    public void setWin(boolean a){
        win = a;
    }
    
    
    /**
     * string representation of this class
     * @return 
     */
    @Override
    public String toString(){
        String s = "Winning Status: " + win+"/n Solution: /n";
        for(boolean[][] b : solution){
            for(boolean[] c : b){
                for(boolean a: c){
                    s+= "/n "+c;
                }
            }
        }
        return s;
    }
    
    
    /**
     * checks if a given object is equal to this
     * @param o - object being tested
     * @return boolean true if they are equal
     */
    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(o == this) return true;
        if(o.getClass() == this.getClass()){
            Solutions a = (Solutions)o;
            return ((a.getWin() == win)&&(solution == a.solution));
        }
        return false;
    }
}