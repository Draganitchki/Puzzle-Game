/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package puzzlegame;


import java.awt.Insets;
import java.util.ArrayList;
import java.util.Stack;
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
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;

/**
 *
 * @author svety
 */
public class PuzzleGame extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Solutions sl = new Solutions();
        
       
        
        Stack<ArrayList<String[][]>> save = new Stack<ArrayList<String[][]>>();
        save.add(new ArrayList<String[][]>());
        
        ArrayList<fourGrid> gamePanes = new ArrayList<fourGrid>();
        ArrayList<vGrid> seePanes = new ArrayList<vGrid>();
        ArrayList<labelGrid> labelPanes = new ArrayList<labelGrid>();
        
        Button btn = new Button();
        btn.setText("Create");
        btn.setMinSize(100, 20);
        Alert invalidSelection = new Alert(AlertType.WARNING);
        invalidSelection.setHeaderText("Invalid Selection");
        invalidSelection.setContentText("This opetion is not implement yet, Please select 3x4 for grid and easy for diffculty");
        
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
        
//        boolean fsCombo = comboBox.getSelectionModel().selectFirst();
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                long startTime = System.currentTimeMillis();
                
            Label secondLabel = new Label("Hello");
             
            
            
            if (comboBox.getValue() == "3x4 Grid" && comboBox2.getValue() == "Easy"){
                Pane secondaryLayout = new Pane();
                
                
                GridPane gameGrid = new GridPane();
                AboutMe aboutme  = new AboutMe("Enter Main Text here for about me");
                aboutme.setText();
                Clues clues = new Clues();
                clues.addClue();
                
                
                
                gameGrid.setHgap(2);
                gameGrid.setVgap(2);
                gameGrid.relocate(0,0);
                
                for (int i=0;i<3;i++){
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
                
                
                
               

                Scene secondScene = new Scene(secondaryLayout, 1300, 900);

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
                
                b.setOnAction(new EventHandler<ActionEvent>(){
                
                @Override
                public void handle(ActionEvent e){
                    clues.addClue();
                    
                }
            });
                
                /*
                the mistakes button removes mistakes
                */
                Button m = new Button("Mistakes");
                
                m.setOnAction(new EventHandler<ActionEvent>(){
                
                @Override
                public void handle(ActionEvent e){
                    ArrayList<boolean[][]> b = new ArrayList<boolean[][]>();
                    for(fourGrid g : gamePanes){
                        b.add(g.getState());
                    }
                    b= sl.findMistakes(b);
                    for(int i=0;i<3;i++){
                        gamePanes.get(i).removeMistakes(b.get(i));
                    }
                        
                    
                }
            });
                
                Button undo = new Button("Undo");
                
                undo.setOnAction(new EventHandler<ActionEvent>(){
                
                @Override
                public void handle(ActionEvent e){
                    if(!save.isEmpty()){
                        ArrayList<String[][]> last = save.pop();
                        for(int i =0;i<3;i++){
                            gamePanes.get(i).setState(last.get(i));
                        }
                        
                    }
                }
            });
                
                GridPane buttons = new GridPane();
                buttons.setHgap(30);
                buttons.setVgap(30);
                buttons.add(b, 1, 2, 1, 10);
                buttons.add(m,1,5);
                buttons.add(undo,1,7);
                
                
                gameGrid.add(buttons, 3, 3);
                
                gameGrid.add(labelPanes.get(0).getGrid(), 0, 2);
                gameGrid.add(labelPanes.get(1).getGrid(), 0, 3);
                gameGrid.add(labelPanes.get(2).getGrid(), 2, 0);
                gameGrid.add(labelPanes.get(3).getGrid(), 3, 0);
                secondaryLayout.getChildren().addAll(gameGrid,aboutme.getVBox(),clues.getVBox());
                
                
                
                secondaryLayout.setOnMouseMoved(new EventHandler<MouseEvent>(){
                    
                    @Override
                    public void handle(MouseEvent e){
                        ArrayList<boolean[][]> b = new ArrayList<boolean[][]>();
                        ArrayList<String[][]> c = new ArrayList<String[][]>();
                        for(fourGrid g : gamePanes){
                            b.add(g.getState());
                            c.add(g.getStrings());
                        }
                        if(!save.peek().equals(c)){
                            save.push(c);
                        }
                        
                        
                        if(sl.checkSolutions(b)){
                            int errors = 0;
                            for(int i=0;i<3;i++){
                                errors += gamePanes.get(i).getCount();
                            }
                            errors += clues.getErrors();
                            long finalTime = System.currentTimeMillis()- startTime +(12000*errors);
                            finalTime = finalTime /1000;
                            final Stage dialog = new Stage();
                            dialog.initModality(Modality.APPLICATION_MODAL);
                            dialog.initOwner(primaryStage);
                            VBox dialogVbox = new VBox(20);
                            dialogVbox.getChildren().add(new Text("You Won!/n It Took you "+ finalTime + " seconds to complete /n "));
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
                invalidSelection.showAndWait();
            }
            }
        });
        
        
        
        
        Label title = new Label("Select Your Puzzle Parameters");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        
        Label body = new Label("Select your grid size and difficulty range below and"
                + "a puzzle will be initialized to match your preferences");
        body.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        body.setWrapText(true);
        GridPane gridpane = new GridPane();
        
        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        root.getChildren().add(comboBox);
        
        Scene scene = new Scene(root, 300, 250);
        
        gridpane.add(title, 0, 0);
        gridpane.add(body, 0, 1);
        gridpane.add(comboBox,0,2);
        gridpane.add(comboBox2,0,3);
        gridpane.add(btn,1,4);
        
        root.getChildren().add(gridpane);
        
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