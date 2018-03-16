package com.graphics.playground;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Pong extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Paddle paddle1 = new Paddle(50,450, 10, 100);
    private Paddle paddle2 = new Paddle(950, 450, 10, 100);
    private Ball ball = new Ball();

    @Override
    public void start(Stage primaryStage)
    {
        Group pongGroup = new Group();
        ObservableList pongList = pongGroup.getChildren();
        pongList.add(paddle1.getPaddle());
        pongList.add(paddle2.getPaddle());
        pongList.add(ball.getBall());

        Scene scene = new Scene(pongGroup, 1000, 800);
        controls(scene);

        primaryStage.setTitle("Pong");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void invokeBallMovement()
    {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(20),
                ae ->  ball.ballColide2(paddle1.getPaddle(), paddle2.getPaddle()) ));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void controls(Scene scene)
    {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key)->
        {
            switch (key.getCode()) {
                case UP:

                    if (paddle2.getY() > 0) {
                        paddle2.movePaddleUp();
                    }
                    break;
                case DOWN:
                    if (paddle2.getY() < (700-paddle2.getWidth() )) {
                        paddle2.movePaddleDown();
                    }
                    break;
                case A:
                    if (paddle1.getY() > 0) {
                        paddle1.movePaddleUp();
                    }
                    break;
                case Z:
                    if (paddle1.getY() < (700 - paddle1.getWidth() )) {
                        paddle1.movePaddleDown();
                    }
                    break;



                case SPACE:
                    invokeBallMovement();
                    break;
            }

        });
    }

}
