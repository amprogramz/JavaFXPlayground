package com.graphics.playground;


import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Block
{
    private Rectangle block = new Rectangle();
    private int blockIndex;

    public Block(double x, double y, int index)
    {
        block.setX(x);
        block.setY(y);
        block.setWidth(100);
        block.setHeight(30);
        blockIndex = index;
    }

    public Rectangle getBlock()
    {
        return block;
    }
    public int getIndex()
    {
        return blockIndex;
    }


    public void destruct()
    {
        block.setX(-200);
    }
}
