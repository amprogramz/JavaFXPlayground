package com.graphics.playground;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

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
        Path path = new Path();
        MoveTo startingPoint = new MoveTo(50,200);
        ArrayList<LineTo> lineTos = new ArrayList<>();
        lineTos.add(new LineTo(100, 50));
        lineTos.add(new LineTo(150, 200));
        lineTos.add(new LineTo(50, 200));
        path.getElements().add(startingPoint);
        path.getElements().addAll(lineTos);
        //path.setFillRule(FillRule.);

        Group group = new Group();
        ObservableList list = group.getChildren();
        list.add(path);

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
