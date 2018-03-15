package com.graphics.playground;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Ball {
    private Circle circle = new Circle();
    private double yMovement = 3;
    private double xMovement = 3;

    public Ball() {
        this.circle.setCenterX(500);
        this.circle.setCenterY(50);
        this.circle.setRadius(10);
    }

    public Ball(double x, double y, double radius) {
        this.circle.setCenterX(x);
        this.circle.setCenterY(y);
        this.circle.setRadius(radius);
    }

    public Circle getBall()
    {
        return circle;
    }

    public void invokeBallMovement()
    {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(20),
                ae ->  ballMovement() ));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void ballMovement() {
        if (circle.getCenterX() > 0 && circle.getCenterX() < 1000) {
            circle.setCenterX(circle.getCenterX() + xMovement);
        } else if (circle.getCenterX() <= 0) {
            xMovement = 5;
            circle.setCenterX(circle.getCenterX() + xMovement);
        } else if (circle.getCenterX() >= 1000) {
            xMovement = -xMovement;
            circle.setCenterX(circle.getCenterX() + xMovement);
        }


        if (circle.getCenterY() > 0 && circle.getCenterY() < 800) {
            circle.setCenterY(circle.getCenterY() + yMovement);
        } else if (circle.getCenterY() == 0) {
            yMovement = 5;
            circle.setCenterY(circle.getCenterY() + yMovement);
        } else if (circle.getCenterY() >= 800) {
            this.yMovement = (-5);
            circle.setCenterY(circle.getCenterY() + yMovement);

        }

    }//end ballMovement()

}//end class
