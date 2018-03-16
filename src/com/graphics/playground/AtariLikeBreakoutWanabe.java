package com.graphics.playground;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;


import java.util.ArrayList;


public class AtariLikeBreakoutWanabe extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Paddle paddle = new Paddle();
    private Ball ball = new Ball();
    private Block block = new Block(5,5);
    private BlockGrid blocks = new BlockGrid(8, 1000);

    @Override
    public void start(Stage primaryStage) {


        Group group = new Group();
        ObservableList list = group.getChildren();
        list.add(paddle.getPaddle());
        list.add(ball.getBall());
        list.add(block.getBlock());
        list.add(new Block(110,5).getBlock());
        list.add(new Block(215, 5).getBlock());


        Scene scene = new Scene(group, 1000, 800);
        controls(scene);

        primaryStage.setTitle("Atari Breakout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void invokeBallMovement()
    {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(20),
                ae ->  ball.ballColide2(paddle.getPaddle(), block.getBlock()) ));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void controls(Scene scene)
    {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
        {

            switch (key.getCode()) {
                case RIGHT:
                    if (paddle.getX() < (1000 - paddle.getWidth()))
                    {
                        paddle.movePaddleRight();
                    }
                    break;
                case LEFT:
                    if (paddle.getX() > 0)
                    {
                        paddle.movePaddleLeft();
                    }
                    break;
                case SPACE:
                    invokeBallMovement();
                    break;
            }
        });
    }

}