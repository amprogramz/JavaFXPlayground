package com.graphics.playground;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;



public class AtariLikeBreakoutWanabe extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Paddle paddle = new Paddle();

        Ball ball = new Ball(500, 50, 10);
        ball.invokeBallMovement();
        Group group = new Group();
        ObservableList list = group.getChildren();
        list.add(paddle.getPaddle());
        list.add(ball.getBall());

        Scene scene = new Scene(group, 1000, 800);
        paddle.controls(scene);

        primaryStage.setTitle("Atari Breakout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}