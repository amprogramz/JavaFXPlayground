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
        final double REC_X = 500;
        final double REC_Y = 750;
        final double MOVEMENT = 10;

        Rectangle rectangle = new Rectangle();
        rectangle.setX(REC_X);
        rectangle.setY(REC_Y);
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
                    if(rectangle.getX() < (1000 - rectangle.getWidth()))
                    {
                        rectangle.setX(rectangle.getX() + MOVEMENT);
                    }
                    break;
                case LEFT:
                    if(rectangle.getX() > 0)
                    {
                        rectangle.setX(rectangle.getX() - MOVEMENT);
                    }
                    break;
            }
        });

        primaryStage.setTitle("Atari Breakout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
