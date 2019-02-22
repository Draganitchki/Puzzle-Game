/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlegame;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Svetozar and Ben
 */
public class Save {
    
    private Stack<ArrayList<String[][]>> saved;
    
    
    public Save(){
        saved = new Stack<ArrayList<String[][]>>();
        //ArrayList<String[][]> a = new ArrayList<String[][]>();
        //String[][] s = new String[4][4];
        //a.add(s);
        //saved.push(a);
    }
    
    public void addSave(ArrayList<String[][]> s){
        saved.add(s);
    }
    
    
    
    public boolean checkSaved(ArrayList<String[][]> check){
        boolean t = false;
        try{
            ArrayList<String[][]> temp = saved.peek();
            for(int b=0;b<3;b++){ 
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        if(!(temp.get(b)[i][j]==check.get(b)[i][j])){
                            t= true;
                        }
                    }
                }
            }
        }
        catch(Exception e){
            return true;
            
        }
        return t;
    }
    
    
    public boolean isEmpty(){
        return saved.isEmpty();
    }
    
    public ArrayList<String[][]> getSaved(){
        return saved.pop();
    }
    // I don't know how to make getters and setters for this class or how to do tostring and equals
    
}
