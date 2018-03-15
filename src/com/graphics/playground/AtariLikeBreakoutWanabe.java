package com.graphics.playground;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.lang.reflect.InvocationTargetException;


public class AtariLikeBreakoutWanabe extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Circle circle = new Circle();
    private double yMovement = 5;
    private double xMovement = 3;

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



        //Circle circle = new Circle();
        this.circle.setCenterX(500);
        this.circle.setCenterY(50);
        this.circle.setRadius(10);

        Ball ball = new Ball(500, 50, 10);
        ball.invokeBallMovement();



            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(20),
                    ae ->  ballMovement() ));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();



        Group group = new Group();
        ObservableList list = group.getChildren();
        list.add(rectangle);
        list.add(circle);
        list.add(ball.getBall());

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


    public void ballMovement()
    {
        if(circle.getCenterX() > 0 && circle.getCenterX() < 1000)
        {
            circle.setCenterX(circle.getCenterX() + xMovement);
        }else if (circle.getCenterX() <= 0)
        {
            xMovement = 5;
            circle.setCenterX(circle.getCenterX() + xMovement);
        }else if (circle.getCenterX() >= 1000)
        {
            xMovement = -xMovement;
            circle.setCenterX(circle.getCenterX() + xMovement);
        }


        if(circle.getCenterY() > 0 && circle.getCenterY() < 800)
        {
            circle.setCenterY(circle.getCenterY() + yMovement);
        }else if (circle.getCenterY() == 0)
        {
            yMovement = 5;
            circle.setCenterY(circle.getCenterY() + yMovement);
        }else if (circle.getCenterY() >= 800)
        {
            this.yMovement = (-5);
            circle.setCenterY(circle.getCenterY() + yMovement);

        }
    }
}
