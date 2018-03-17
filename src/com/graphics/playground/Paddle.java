package com.graphics.playground;

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
    public Paddle(double x, double y, double width, double height)
    {
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
    }
    public Rectangle getPaddle()
    {
    return rectangle;
    }

    public void movePaddleRight()
    {
        rectangle.setX(rectangle.getX() + MOVEMENT);
    }
    public void movePaddleLeft()
    {
        rectangle.setX(rectangle.getX() - MOVEMENT);
    }
    public void movePaddleUp()
    {
        rectangle.setY(rectangle.getY() - MOVEMENT);
    }
    public void movePaddleDown()
    {
        rectangle.setY(rectangle.getY() + MOVEMENT);
    }
    public double getX()
    {
        return rectangle.getX();
    }
    public double getY()
    {
        return rectangle.getY();
    }
    public double getWidth()
    {
        return rectangle.getWidth();
    }
    public double getHeight(){ return rectangle.getHeight(); }
}
