
package puzzlegame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javax.swing.JTextField;

/**
 *
 * By Svetozar and Ben
 * The About me class is used to make a VBox GUI with a title and editable text to enter in text that you want.
 * 
 */
public class AboutMe {
    private VBox about;
    private TextArea main;
    private Text title;
    
    
    public AboutMe(){ //main constructor of class
        about = new VBox();
        about.setStyle("-fx-background-color: white;");
        about.relocate(800,500);
        title = new Text("Backstory"); 
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        main = new TextArea("This is the Default about me");       
        about.getChildren().addAll(title,main);
    }    
    
    
//    public AboutMe(String body){ //main constructor of class with ability to change body of text
//        about = new VBox();
//        about.setStyle("-fx-background-color: white;");
//        about.relocate(800,400);
//        title = new Text("Backstory");
//        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
//        main = new TextArea(body);
//        main.setPrefSize(350, 350);
//        about.getChildren().addAll(title,main);
//    }
    
    //getter and setters 
    public VBox getVBox(){
        return about;
    }
    
    public TextArea getTextArea(){
        return main;
    }
    
    public Text getTitleText(){
        return title;
    }
    
    public void setTextArea(String a){
         main.setText(a);
    }
    
    public void setrealText(String a){
        title.setText(a);
    }
    
    //This isn't really a setText class this is more like a read from text file class. I want to rename this class.
    public void setText(){
        String s = "";
        try{
            BufferedReader fr = new BufferedReader(new FileReader("Puzzle.txt"));
            for(int j=0;j<20;j++){
                fr.readLine();
            }
            for(int i=0;i<13;i++){
                s += fr.readLine()+ "\n";
            }
            main.setText(s);
           
            main.setEditable(false);
            fr.close();
        }
        catch(FileNotFoundException e){
            System.out.printf("File" );
        }
        catch(IOException e){
            // catch it
            System.out.print("error");
        }  
    }
    
    @Override
    public String toString(){
        return "title" +title.getText() + "Main body:" + main.getText();
    }
    
//    equals method not added because this class has Gui variables and 
//    there is not reason to check them.
}
