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

    private Paddle paddle = new Paddle();
    private Ball ball = new Ball();

    @Override
    public void start(Stage primaryStage) {


        Group group = new Group();
        ObservableList list = group.getChildren();
        list.add(paddle.getPaddle());
        list.add(ball.getBall());

        Scene scene = new Scene(group, 1000, 800);
        controls(scene, paddle, ball);

        primaryStage.setTitle("Atari Breakout");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void controls(Scene scene, Paddle paddle, Ball ball)
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
                    ball.invokeBallMovement(paddle.getPaddle());
                    break;
            }
        });
    }

}