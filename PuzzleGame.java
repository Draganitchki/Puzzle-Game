/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlegame;


import java.awt.Insets;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author svety
 */
public class PuzzleGame extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Create");
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
                        
                        Button a = new Button();
                        a.setMinSize(40, 40);
                        fGrid.add(a,i,j);
                    }
                }
                
                GridPane fGrid2 = new GridPane(); //fGrid stands for the function grid that will contain all the buttons that do functions
                fGrid2.setGridLinesVisible(true);
                fGrid2.setHgap(4);
                fGrid2.setVgap(4);
                for(int i=0; i<4;i++){
                    for(int j=0;j<4;j++){
                        
                        Button b = new Button();
                        b.setMinSize(40, 40);
                        fGrid2.add(b,i,j);
                    }
                }
                
                GridPane fGrid3 = new GridPane(); //fGrid stands for the function grid that will contain all the buttons that do functions
                fGrid3.setGridLinesVisible(true);
                fGrid3.setHgap(4);
                fGrid3.setVgap(4);
                for(int i=0; i<4;i++){
                    for(int j=0;j<4;j++){
                        
                        Button c = new Button();
                        c.setMinSize(40, 40);
                        fGrid3.add(c,i,j);
                    }
                }
                
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
                secondStage.setTitle("New Stage");
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
        
        primaryStage.setTitle("Hello World!");
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