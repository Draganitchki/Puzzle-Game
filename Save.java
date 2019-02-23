import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * holds all the moves made this game
 * @author Svetozar and Ben
 */
public class Save {
    
    private Stack<ArrayList<String[][]>> saved;
    
    /**
     * creats an empty save 
     */
    public Save(){
        saved = new Stack<ArrayList<String[][]>>();
        //ArrayList<String[][]> a = new ArrayList<String[][]>();
        //String[][] s = new String[4][4];
        //a.add(s);
        //saved.push(a);
    }
    
    /**
     * adds a new save to the stack
     * @param s 
     */
    public void addSave(ArrayList<String[][]> s){
        saved.add(s);
    }
    
    
    /**
     * checks if a given state is the same as the last save
     * @param check - state of game to be checks
     * @return boolean weather or not to save
     */
    public boolean checkSaved(ArrayList<String[][]> check){
        boolean t = false;
        try{  //try insures there isnt an error if the stack is empty
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
    
    /**
     * checks if the save stack is empty
     * @return boolean
     */
    public boolean isEmpty(){
        return saved.isEmpty();
    }
    
    /**
     * gets and removes the last save in the stack
     * @return ArrayList<String[][]> new state from save
     */
    public ArrayList<String[][]> getSaved(){
        return saved.pop();
    }
    
    /**
     * String representation of the save file
     * @return String representation of saves
     */
    public String toString(){
        String s = "";
        for (Iterator<ArrayList<String[][]>> it = saved.iterator(); it.hasNext();) {
            ArrayList<String[][]> a = it.next();
            s+=a;
        }
        return s;
    }
    
}
