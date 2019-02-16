/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstwindow;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author s_draganitchki
 */
public class FirstWindow extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Create");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            Label secondLabel = new Label("Hello");
             
            
            
            
            StackPane secondaryLayout = new StackPane();
            secondaryLayout.getChildren().add(secondLabel);
             
            Scene secondScene = new Scene(secondaryLayout, 200, 100);
                
            Stage secondStage = new Stage();
            secondStage.setTitle("New Stage");
            secondStage.setScene(secondScene);
             
            secondStage.show();
            primaryStage.close();
            }
        });
        
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
        
        Label title = new Label("Select Your Puzzle Parameters");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 17));
        
        Label body = new Label("Select your grid size and difficulty range below and"
                + "a puzzle will be initialized to match your preferences");
        body.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
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
