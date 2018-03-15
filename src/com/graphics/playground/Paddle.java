package com.graphics.playground;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Paddle
{
    private Rectangle rectangle = new Rectangle();

    private double REC_X = 500;
    private double REC_Y = 750;
    private double MOVEMENT = 10;

    public Paddle()
    {
        rectangle.setX(REC_X);
        rectangle.setY(REC_Y);
        rectangle.setWidth(100);
        rectangle.setHeight(10);
    }
    public Paddle(double width, double height)
    {
        rectangle.setX(REC_X);
        rectangle.setY(REC_Y);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
    }
    public Rectangle getPaddle()
    {
    return rectangle;
    }


    public void controls(Scene scene)
    {
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) ->
        {

            switch (key.getCode()) {
                case RIGHT:
                    if (rectangle.getX() < (1000 - rectangle.getWidth())) {
                        rectangle.setX(rectangle.getX() + MOVEMENT);
                    }
                    break;
                case LEFT:
                    if (rectangle.getX() > 0) {
                        rectangle.setX(rectangle.getX() - MOVEMENT);
                    }
                    break;
            }
        });
    }
}
