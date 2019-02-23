import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *this creates the variables used to distinguish the catagories of the game
 * @author Svetozar and Ben
 * This class is the labels gui grid class
 */
public class vGrid {
    GridPane seeGrid;
    
    ArrayList<String> s = new ArrayList<String>();
    
    /**
     * defalt constructor
     */
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
    
    /**
     * constructor that uses info provided
     * @param s - ArrayList<String> thatcontains the text for labels
     * @param a - int the h gap
     * @param b - int the v gap
     */
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
    // ddidn't know how to do equals and tostring method for this class either
    
}
