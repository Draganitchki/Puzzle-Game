import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;

/**
 * main class that keeps the GUI running and keeps game playing
 * @author Svetozar and Ben
 */
public class PuzzleGame extends Application {
    
    
    //Used to display the first popup window with game options
    @Override
    public void start(Stage primaryStage) {
        
        Solutions sl = new Solutions();
        
        Save save = new Save();
        
        ArrayList<fourGrid> gamePanes = new ArrayList<fourGrid>();
        ArrayList<vGrid> seePanes = new ArrayList<vGrid>();
        ArrayList<labelGrid> labelPanes = new ArrayList<labelGrid>();
        
        Button btn = new Button();
        btn.setText("Create");
        btn.setMinSize(100, 20);
        Alert invalidSelection = new Alert(AlertType.WARNING);
        invalidSelection.setHeaderText("Invalid Selection");
        invalidSelection.setContentText("This opetion is not implement yet, Please select 3x4 for grid and easy for diffculty");
        Alert hints = new Alert(AlertType.WARNING);
        hints.setHeaderText("Hints");
        
        ObservableList<String> options = 
        FXCollections.observableArrayList(
            "3x4 Grid",
            "3x5 Grid",
            "4x4 Grid",
            "4x5 Grid",
            "4x6 Grid",
            "4x7 Grid"
        );
        final ComboBox comboBox = new ComboBox(options);
        
        ObservableList<String> options2 = 
        FXCollections.observableArrayList( 
            "Easy",
            "Medium",
            "Hard"
        );
        final ComboBox comboBox2 = new ComboBox(options2);
       
        btn.setOnAction(new EventHandler<ActionEvent>() {  //picks which game to play
            
            @Override
            public void handle(ActionEvent event) {
                long startTime = System.currentTimeMillis();

            if (comboBox.getValue() == "3x4 Grid" && comboBox2.getValue() == "Easy"){  // runs the 3x4 grid
                Pane secondaryLayout = new Pane();
                
                
                GridPane gameGrid = new GridPane();  // buttons for the game
                AboutMe aboutme  = new AboutMe();  // info and story for game
                aboutme.setText();
                Clues clues = new Clues();  // clues to solve game
                clues.addClue();
                
                
                
                gameGrid.setHgap(2);
                gameGrid.setVgap(2);
                gameGrid.relocate(0,0);
                
                for (int i=0;i<3;i++){  // sets 3 grids of buttons for each of the variables
                    fourGrid g = new fourGrid();
                    gamePanes.add(g);
                }
                
                ArrayList<String> s = clues.getLables();
                ArrayList<String> temp = new ArrayList<String>();
                int count = 0;
                labelPanes.add( new labelGrid(s.get(count),1,175));
                count++;
                labelPanes.add( new labelGrid(s.get(count),1,175));
                count++;
                labelPanes.add( new labelGrid(s.get(count),175,10));
                count++;
                labelPanes.add( new labelGrid(s.get(count),175,10));
                count++;

                
                
                //sets up see panes that have categories so player knows what to solve
                for(int i=0;i<4;i++){
                    temp.add(s.get(count));
                    count++;
                }
                seePanes.add(new vGrid(temp,1,4));
                temp.clear();
                for(int i=0;i<4;i++){
                    temp.add(s.get(count));
                    count++;
                }
                seePanes.add(new vGrid(temp,1,4));
                temp.clear();
                for(int i=0;i<4;i++){
                    temp.add(s.get(count));
                    count++;
                }
                seePanes.add(new vGrid(temp,4,1));
                temp.clear();
                for(int i=0;i<4;i++){
                    temp.add(s.get(count));
                    count++;
                }
                seePanes.add(new vGrid(temp,4,1)); 
                
                
                
               

                Scene secondScene = new Scene(secondaryLayout, 1200, 700);

                gameGrid.add(seePanes.get(0).getGrid(), 1, 2);
                gameGrid.add(seePanes.get(1).getGrid(), 1, 3);
                gameGrid.add(seePanes.get(2).getGrid(), 2, 1);
                gameGrid.add(seePanes.get(3).getGrid(), 3, 1);
                
                gameGrid.add(gamePanes.get(0).getGrid(), 2, 2);
                gameGrid.add(gamePanes.get(1).getGrid(), 2, 3);
                gameGrid.add(gamePanes.get(2).getGrid(), 3, 2);
                
                
                /*
                
                the hint button adds a hint to the screen
                */
                Button b = new Button("Hint");
                b.setMinSize(100,50);
                
                b.setOnAction(new EventHandler<ActionEvent>(){
                
                @Override
                public void handle(ActionEvent e){
                    if(!clues.addClue()){  // warning if you are out of clues
                        Alert noHints = new Alert(AlertType.WARNING);
                        noHints.setHeaderText("Clues");
                        noHints.setContentText(" There are no more clues");
                        noHints.showAndWait();
                    }
                    
                }
            });
                
                /*
                the mistakes button removes mistakes
                */
                Button m = new Button("Mistakes");
                m.setMinSize(100,50);
               
                m.setOnAction(new EventHandler<ActionEvent>(){
                
               
                @Override
                public void handle(ActionEvent e){
                    ArrayList<boolean[][]> b = new ArrayList<boolean[][]>();
                    for(int a=0;a<3;a++){
                        if(a==2){
                            b.add(gamePanes.get(2).getStateBool());
                        }else if(a==1){
                            b.add(gamePanes.get(1).getStateBool());
                        }else{
                            b.add(gamePanes.get(0).getStateBool());
                        }
                    }
                    b= sl.findMistakes(b); // returns an arraylist with all the mistakes on the board
                    int j =0;
                    for(int i=0;i<3;i++){ 
                        gamePanes.get(i).removeMistakes(b.get(i));
                        j+= gamePanes.get(i).getCount();
                    }
                    Alert mistakes = new Alert(AlertType.INFORMATION);  // informs how many mistakes there have been this game and how much time added
                    mistakes.setHeaderText("Mistakes");
                    mistakes.setContentText(" There are "+j+ " total mistakes. "+(j*12)+" seconds added to time");
                    mistakes.showAndWait();
                        
                    
                }
});
                /**
                 *  undo's the last move made on the board
                 */
                Button undo = new Button("Undo");
                undo.setMinSize(100,50);
                
                undo.setOnAction(new EventHandler<ActionEvent>(){
                
                @Override
                public void handle(ActionEvent e){
                    if(!save.isEmpty()){
                        System.out.println(save);
                        ArrayList<String[][]> last = save.getSaved();
                        for(int i =0;i<3;i++){
                            gamePanes.get(i).setState(last.get(i));
                        }
                        
                    }else{ // displays warning if there are no saves
                        Alert noSaves = new Alert(AlertType.WARNING);
                        noSaves.setHeaderText("Undo");
                        noSaves.setContentText(" There is nothing to undo");
                        noSaves.showAndWait();
                    }
                }
            });
                
                HBox fourMainButtons = new HBox();
                fourMainButtons.setSpacing(20);
                fourMainButtons.getChildren().addAll(b,m,undo);
                fourMainButtons.relocate(450,600);
                
                
                
                
                gameGrid.add(labelPanes.get(0).getGrid(), 0, 2);
                gameGrid.add(labelPanes.get(1).getGrid(), 0, 3);
                gameGrid.add(labelPanes.get(2).getGrid(), 2, 0);
                gameGrid.add(labelPanes.get(3).getGrid(), 3, 0);
                secondaryLayout.getChildren().addAll(gameGrid,aboutme.getVBox(),clues.getVBox(),fourMainButtons);
                
                
                /**
                 * this makes it so whenever user moves the mouse the game checks for a mistake and updates its save information
                 */
                secondaryLayout.setOnMouseMoved(new EventHandler<MouseEvent>(){
                    
                    @Override
                    public void handle(MouseEvent e){
                        ArrayList<boolean[][]> b = new ArrayList<boolean[][]>();
                        ArrayList<String[][]> c = new ArrayList<String[][]>();
                        for(int i =0;i<3;i++){
                            b.add(gamePanes.get(i).getStateBool());
                            c.add(gamePanes.get(i).getStrings());
                        }
                        
                        if(save.checkSaved(c)){
                            save.addSave(c);
}
                        
                        
                        if(sl.checkSolutions(b)){
                            int errors = 0;
                            for(int i=0;i<3;i++){
                                errors += gamePanes.get(i).getCount();  // adds time
                            }
                            errors += clues.getErrors();
                            long finalTime = System.currentTimeMillis()- startTime +(12000*errors);
                            finalTime = finalTime /1000;
                            final Stage dialog = new Stage();
                            dialog.initModality(Modality.APPLICATION_MODAL);
                            dialog.initOwner(primaryStage);
                            VBox dialogVbox = new VBox(20);
                            dialogVbox.getChildren().add(new Text("You Won!           It Took you "+ finalTime + " seconds to complete  "));
                            Scene dialogScene = new Scene(dialogVbox, 300, 200);
                            dialog.setScene(dialogScene);
                            dialog.show();
                        }
                    }
                    
                });
                
                Stage secondStage = new Stage();
                secondStage.setTitle("3X4 Easy");
                secondStage.setScene(secondScene);
                

                secondStage.show();
                primaryStage.close();
                }
            else
            {
                invalidSelection.showAndWait(); // if wrong selection is made 
            }
            }
        });
        
        
        
        BorderPane borderA = new BorderPane();
        
        Label title = new Label("Select Your Puzzle Parameters");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
       
        
        Label body = new Label("Select your grid size and difficulty range below and"
                + " a puzzle will be initialized to match your preferences");
        body.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        body.setWrapText(true);
        GridPane gridpane = new GridPane();
        
        StackPane root = new StackPane();
        
        Scene scene = new Scene(root, 350, 120);
        AnchorPane firstABox = new AnchorPane();
        
        firstABox.setBottomAnchor(btn,0.0);
        firstABox.setRightAnchor(btn,3.0);
        firstABox.getChildren().add(btn);
        borderA.setBottom(firstABox);
        
        gridpane.add(title, 0, 0);
        gridpane.add(body, 0, 1);
        gridpane.add(comboBox,0,2);
        gridpane.add(comboBox2,0,3);
        borderA.setCenter(gridpane);
        
        
        root.getChildren().addAll(borderA);
        
        primaryStage.setTitle("Puzzle Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}