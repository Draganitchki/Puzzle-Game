
package puzzlegame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * @author Svetozar Draganitchki and Ben
 * The Clues class 
 */
public class Clues {
    
    private VBox clues;
    private Text title;
    private ArrayList<Label> options;
    private int counter;
    private int errors;
    private String[] cluess;
    
    public Clues(){
        
        clues = new VBox();
        cluess = new String[15]; // Id rather use arraylist here as it will be more dynamic
        counter = 0;
        errors=0;
        clues.setStyle("-fx-background-color: white;"); 
        title = new Text("Active Clues"); 
        clues.relocate(800,50);
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        options = new ArrayList<Label>();
        clues.getChildren().add(title);
        getClues();
           
    }
// getters and setters
    public VBox getVBox(){
        return clues;
    }
    
    public String getTitle(){
        return title.getText();
    }
    
    public int getCounter(){
        return counter;
    }
        
    public int getErrors(){
        return errors;
    }
    
    public ArrayList<Label> getOptions(){
        return options;
    }
    
    public String[] getCluesTwo(){
        return cluess;
    }
    
    public int setCounter(int a){
        return counter = a;
    }
    
    public int setErrors(int a){
        return errors = a;
    }
    
    //reads text file and stores them to a String array  to be used for other classes
    private void getClues(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("Puzzle.txt"));
            for(int j=0;j<34;j++){
                br.readLine();
            }
            for(int i=0;i<15;i++){
                cluess[i] = br.readLine();
            }
            br.close();
        }
        catch(FileNotFoundException e ){
            System.out.println("fix me");//why does it printout these comments
            
        }
        catch(IOException d){
            System.out.println("plz");
        }
        
    }
    
    // This method appears to not be used 
    public ArrayList<String> getLables(){
        ArrayList<String> s = new ArrayList<String>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("Puzzle.txt"));
            for(int i=0;i<20;i++){
                s.add(br.readLine());
            }
            
        }
        catch(FileNotFoundException ex){
            
        }
        catch(IOException ex){
            
        }
        
        return s;
    }
    
    //Not sure what to say here but it seem
      public boolean addClue(){
        boolean b = true;
        if(counter<5){
            for(int i=0;i<5;i++){
                options.add(new Label (cluess[counter]));
                clues.getChildren().add(options.get(counter));
                counter ++;
                
            }
        }else if(counter<14){
            errors++;
            for(int i=0;i<3;i++){
                options.add(new Label (cluess[counter]));
                clues.getChildren().add(options.get(counter));
                counter ++;
                
            }
        }else{
            b =false;
        }
        return b;
    }
      
    @Override
      public String toString(){
          return "Title:" + title.getText() + " Counter:" + counter + " Errors:" + errors;
      }
      
      @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(o == this) return true;
        if(o.getClass() == this.getClass()){
            Clues a = (Clues)o;
            return a.getOptions() == options &&
                    a.getCounter() == counter &&
                    a.getErrors() == errors &&
                    a.getCluesTwo() == cluess;
        }
        return false;
    }
    
}

    