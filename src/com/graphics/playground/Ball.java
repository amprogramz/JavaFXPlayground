package com.graphics.playground;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Ball {
    private Circle circle = new Circle();
    private double yMovement = 5;
    private double xMovement = 5;

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

    public void invokeBallMovement(Rectangle paddle)
    {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(20),
                ae ->  ballMovement(paddle) ));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void ballMovement(Rectangle paddle)
    {
        if (Colideable.collishion(circle, paddle))
        {
            yMovement = -yMovement;
            circle.setCenterY(circle.getCenterY() + yMovement);
        }

        if (circle.getCenterX() > circle.getRadius() && circle.getCenterX() < (1000 - circle.getRadius())) {
            circle.setCenterX(circle.getCenterX() + xMovement);
        } else if (circle.getCenterX() <= circle.getRadius()) {
            xMovement = -xMovement;
            circle.setCenterX(circle.getCenterX() + xMovement);
        } else if (circle.getCenterX() >= (1000 - circle.getRadius() )) {
            xMovement = -xMovement;
            circle.setCenterX(circle.getCenterX() + xMovement);
        }


        if (circle.getCenterY() > circle.getRadius() && circle.getCenterY() < (800 - circle.getRadius() )) {
            circle.setCenterY(circle.getCenterY() + yMovement);
        } else if (circle.getCenterY() <= circle.getRadius() ) {
            yMovement = -yMovement;
            circle.setCenterY(circle.getCenterY() + yMovement);
        } else if (circle.getCenterY() >= (800 - circle.getRadius() )) {
            this.yMovement = -yMovement;
            circle.setCenterY(circle.getCenterY() + yMovement);

        }

    }//end ballMovement()

}//end class