package com.graphics.playground;


import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Block
{
    private Rectangle block = new Rectangle();

    public Block(double x, double y)
    {
        block.setX(x);
        block.setY(y);
        block.setWidth(100);
        block.setHeight(30);
    }

    public Rectangle getBlock()
    {
        return block;
    }

    public void checkCollision(Circle ball)
    {
        if (Colideable.collishion(ball, block))
        {
            destruct();
        }
    }

    public void destruct()
    {

    }
}
