package com.graphics.playground;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;



public class AtariLikeBreakoutWanabe extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        final int recX = 500;
        int recX2 = 0;
        recX2 = recX;
        final int recY = 750;

        Rectangle rectangle = new Rectangle();
        rectangle.setX(recX);
        rectangle.setY(recY);
        rectangle.setWidth(100);
        rectangle.setHeight(10);

        Translate translateRectangle = new Translate();

        Circle circle = new Circle();
        circle.setCenterX(500);
        circle.setCenterY(50);
        circle.setRadius(10);


        Group group = new Group();
        ObservableList list = group.getChildren();
        list.add(rectangle);
        list.add(circle);

        Scene scene = new Scene(group, 1000, 800);

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
        {

            switch(key.getCode())
            {
                case RIGHT:
                    int rec2 = recX + 1;
                    translateRectangle.setX(rec2);
                    translateRectangle.setY(recY);
                    rectangle.getTransforms().addAll(translateRectangle);
                    break;
                case LEFT:
                    break;
            }
        });

        primaryStage.setTitle("Atari Breakout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
