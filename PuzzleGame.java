/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package puzzlegame;


import java.awt.Insets;
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
    
    ArrayList<Button[][]> buttons = new ArrayList<Button[][]>();
    ArrayList<boolean[][]> n = new ArrayList<boolean[][]>();
    Solutions s = new Solutions();
    GamesNClues g;
    Button[][] a = new Button[4][4];
    Button[][] b = new Button[4][4];
    Button[][] c = new Button[4][4];
    boolean[][] d = new boolean[4][4];
    
    
    @Override
    public void start(Stage primaryStage) {
        buttons.add(a);
        buttons.add(b);
        buttons.add(c);
        n.add(d);
        n.add(d);
        n.add(d);
        Button btn = new Button("Create");
        btn.setMinSize(100, 20);
        //btn.setText("Create");
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
            Label secondLabel = new Label("Hello");
            
             
            
            
            if (comboBox.getValue() == "3x4 Grid" && comboBox2.getValue() == "Easy"){
                g = new GamesNClues("3x4","Easy");
                s.addSolution(g.getSolution());
                Pane secondaryLayout = new Pane();
                GridPane gameGrid = new GridPane();
                gameGrid.setHgap(2);
                gameGrid.setVgap(2);
                gameGrid.relocate(200,200);
                
                GridPane fGrid = new GridPane(); //fGrid stands for the function grid that will contain all the buttons that do functions
                fGrid.setGridLinesVisible(true);
                fGrid.setHgap(4);
                fGrid.setVgap(4);
                for(int i=0; i<4;i++){
                    for(int j=0;j<4;j++){
                        
                        Button a = new Button(" ");
                        a.setMinSize(40, 40);
                        fGrid.add(a,i,j);
                        buttons.get(0)[i][j] = a;
                        a.setOnAction(new EventHandler<ActionEvent>() {
            
                            @Override
                            public void handle(ActionEvent event) {
                                if(a.getText()=="X"){
                                    a.setText("O");
                                }else if(a.getText()=="O"){
                                    a.setText(" ");
                                }else{
                                    a.setText("X");
                                }
                            
                            }
                        });
                    }
                }
                
                GridPane fGrid2 = new GridPane(); //fGrid stands for the function grid that will contain all the buttons that do functions
                fGrid2.setGridLinesVisible(true);
                fGrid2.setHgap(4);
                fGrid2.setVgap(4);
                for(int i=0; i<4;i++){
                    for(int j=0;j<4;j++){
                        
                        Button b = new Button(" ");
                        b.setMinSize(40, 40);
                        fGrid2.add(b,i,j);
                        buttons.get(1)[i][j] = b;
                        b.setOnAction(new EventHandler<ActionEvent>() {
            
                            @Override
                            public void handle(ActionEvent event) {
                                if(b.getText()=="X"){
                                    b.setText("O");
                                }else if(b.getText()=="O"){
                                    b.setText(" ");
                                }else{
                                    b.setText("X");
                                }
                            
                            }
                        });
                        
                    }
                }
                
                GridPane fGrid3 = new GridPane(); //fGrid stands for the function grid that will contain all the buttons that do functions
                fGrid3.setGridLinesVisible(true);
                fGrid3.setHgap(4);
                fGrid3.setVgap(4);
                for(int i=0; i<4;i++){
                    for(int j=0;j<4;j++){
                        
                        Button c = new Button(" ");
                        c.setMinSize(40, 40);
                        fGrid3.add(c,i,j);
                        buttons.get(2)[i][j] = c;
                        c.setOnAction(new EventHandler<ActionEvent>() {
            
                            @Override
                            public void handle(ActionEvent event) {
                                if(c.getText()=="X"){
                                    c.setText("O");
                                }else if(c.getText()=="O"){
                                    c.setText(" ");
                                }else{
                                    c.setText("X");
                                }
                            
                            }
                        });
                    }
                }
                //constanly updating and checking
                secondaryLayout.setOnMouseMoved(new EventHandler<MouseEvent>(){
                    
                    @Override
                    public void handle(MouseEvent e){
                        
                        
                        // updates wrong answers when a spot is marked correct
                        for(int b=0;b<3;b++){
                            for(int i=0;i<4;i++){
                                for(int j=0;j<4;j++){
                                    buttons.get(b)[i][j].setTextFill(Color.BLACK);
                                    if(buttons.get(b)[i][j].getText()=="O"){
                                        for(int x=0;x<4;x++){
                                            for(int y=0;y<4;y++){
                                                if((x==i && y!=j)||(y==j && x!=i)){
                                                    if(buttons.get(b)[x][y].getText()=="O"){
                                                        buttons.get(b)[x][y].setTextFill(Color.CRIMSON );
                                                    }else{
                                                        buttons.get(b)[x][y].setText("X");
                                                    }
                                                }
                                                
                                            }
                                        }
                                        //creates boolean array
                                        n.get(b)[i][j]= true;
                                    }else{
                                        n.get(b)[i][j]= false;
                                    }
                                   
                                }    
                                
                            }
                        }
                        if(s.checkSolutions(n)){
                            final Stage dialog = new Stage();
                            dialog.initModality(Modality.APPLICATION_MODAL);
                            dialog.initOwner(primaryStage);
                            VBox dialogVbox = new VBox(20);
                            dialogVbox.getChildren().add(new Text("You Won"));
                            Scene dialogScene = new Scene(dialogVbox, 300, 200);
                            dialog.setScene(dialogScene);
                            dialog.show();
                        }
                        
                    }
                    
                        
                    
                });{
             
                
                GridPane vGrid = new GridPane();
                vGrid.setGridLinesVisible(true);
                vGrid.setHgap(1);
                vGrid.setVgap(4);
                for(int i=0; i<1;i++){
                    for(int j=0;j<4;j++){
                        
                        Label d = new Label();
                        d.setMinSize(80, 40);
                        vGrid.add(d,i,j);
                    }
                }
                
                GridPane vGrid2 = new GridPane();
                vGrid2.setGridLinesVisible(true);
                vGrid2.setHgap(1);
                vGrid2.setVgap(4);
                for(int i=0; i<1;i++){
                    for(int j=0;j<4;j++){
                        
                        Label e = new Label();
                        e.setMinSize(80, 40);
                        vGrid2.add(e,i,j);
                    }
                }
                
                GridPane vGrid3 = new GridPane();
                vGrid3.setGridLinesVisible(true);
                vGrid3.setHgap(4);
                vGrid3.setVgap(1);
                for(int i=0; i<4;i++){
                    for(int j=0;j<1;j++){
                        
                        Label d = new Label();
                        d.setMinSize(40, 80);
                        vGrid3.add(d,i,j);
                    }
                }
                
                GridPane vGrid4 = new GridPane();
                vGrid4.setGridLinesVisible(true);
                vGrid4.setHgap(4);
                vGrid4.setVgap(1);
                for(int i=0; i<4;i++){
                    for(int j=0;j<1;j++){
                        
                        Label e = new Label();
                        e.setMinSize(40, 80);
                        vGrid4.add(e,i,j);
                    }
                }
                
                
                    Label var1 = new Label("Variable A");
                    var1.setMinSize(1, 175);
                    var1.setTextFill(Color.web("#ffffff"));
                    var1.setStyle("-fx-background-color: black;");


                     Label var2 = new Label("Variable B");
                    var2.setMinSize(1, 175);
                    var2.setTextFill(Color.web("#ffffff"));
                    var2.setStyle("-fx-color:white; -fx-background-color: black;");

                
                     Label var3 = new Label("Variable C");
                    var3.setMinSize(175, 10);
                    var3.setTextFill(Color.web("#ffffff"));
                    var3.setStyle("-fx-color:white; -fx-background-color: black;");

                     Label var4 = new Label("Variable D");
                    var4.setMinSize(175, 10);
                    var4.setTextFill(Color.web("#ffffff"));
                    var4.setStyle("-fx-color:white; -fx-background-color: black;");

                
               

                Scene secondScene = new Scene(secondaryLayout, 1300, 900);

                gameGrid.add(vGrid, 1, 2);
                gameGrid.add(vGrid2, 1, 3);
                gameGrid.add(vGrid3, 2, 1);
                gameGrid.add(vGrid4, 3, 1);
                
                gameGrid.add(fGrid, 2, 2);
                gameGrid.add(fGrid2, 3, 2);
                gameGrid.add(fGrid3, 2, 3);
                
                gameGrid.add(var1, 0, 2);
                gameGrid.add(var2, 0, 3);
                gameGrid.add(var3, 2, 0);
                gameGrid.add(var4, 3, 0);
                secondaryLayout.getChildren().add(gameGrid);
                
                Stage secondStage = new Stage();
                secondStage.setTitle("3x4 easy");
                secondStage.setScene(secondScene);
                

                secondStage.show();
                primaryStage.close();
                }
            }
            else{
                invalidSelection.showAndWait();
            }

            class EventHandlerImpl implements EventHandler<MouseEvent> {

                public EventHandlerImpl() {
                }

                @Override
                public void handle(MouseEvent event){
                    
                }
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