package com.graphics.playground;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUITest extends Application {

    public static void main(String[] args) {
//      A static method which creates an instance of the app, then calls init(), start(), and stop() when code
//      execution is finished.
        launch(args);
    }

//    The start() method is derived from the abstract class Application. This is the entry point called by launch() where the JavaFX code
//    will be written.
    @Override
    public void start(Stage primaryStage)
    {
        Line line = new Line();
        line.setStartX(100.00);
        line.setStartY(150.00);
        line.setEndX(500);
        line.setEndY(190.00);
        //line.set(Color.RED);

        Text text = new Text();
        text.setFont(new Font(45));
        text.setX(50);
        text.setY(150);
        text.setText("hello world");


        Group group = new Group(line);
        ObservableList list = group.getChildren();
        list.add(text);

        Scene scene = new Scene(group, 600, 300);

        //scene.setFill(Color.W);

        primaryStage.setTitle("Line");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

//    The init() method is derived from the abstract class Application. This is called by launch() before start().
    @Override
    public void init()
    {

    }

//    The stop() method is derived from the abstract class Application. This is where we will define how we exit the
//    application, launch() calls this when all of the code is finished by default. To override this when the end of the
//    code has been reached, we must call the setImplicitExit(false) method and set this to false. We may also exit the
//    application at any time by using Platform.exit() or System.exit(0).
    @Override
    public void stop()
    {

    }
}
