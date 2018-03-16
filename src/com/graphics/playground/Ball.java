package com.graphics.playground;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


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


    public void ballColide1(Rectangle paddle, Rectangle block)
    {
        if (Colideable.collishion(circle, paddle) || Colideable.collishion(circle, block))
        {
            yMovement = -yMovement;
            circle.setCenterY(circle.getCenterY() + yMovement);
        }
        ballMovement();
    }
    public void ballColide2(Rectangle paddle, Rectangle paddle2)
    {
        if (Colideable.collishion(circle, paddle) || Colideable.collishion(circle, paddle2))
        {
            xMovement = -xMovement;
            circle.setCenterX(circle.getCenterX() + xMovement);
        }

        ballMovement();
    }

    public void ballMovement()
    {

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
