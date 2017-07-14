package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Stack;

public class Main extends Application {
    Stage window;
    Scene scene1, scene2;
    //REF Bucky Roberts JavaFX/004_switchingScenes_
    //Whats interesting about this is the fact that we have *two* separate scenes each one can be shown separately

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        //prep for Button#1
        Label label1 = new Label("This is the first scene");
        Button button1 = new Button("Click to Show Other Panel");
        //here we have a "lambda expression"
        // there is a good tutorial on Lambda at
        // http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html
        button1.setOnAction(e -> window.setScene(scene2));

       //Laying out the children  in a vertical column
        VBox layout1 = new VBox(20); //20 represents the gaps between the children
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1,200,200);

        //setting up button #2
        Button button2 = new Button("this is a crap scene ... wanna go back? Then click this button!");
        button2.setOnAction(e-> window.setScene(scene1));


        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2=new Scene(layout2,600,300);

        //display scene #1 first
        window.setScene(scene1);
        window.setTitle("Two Different Scenes to See!");
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
