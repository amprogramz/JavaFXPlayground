package com.graphics.playground;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Colideable
{

    //I know this sort of makes things redundant
    public static boolean collishion(Circle circle, Rectangle paddle)
    {
        if(circle.intersects(paddle.getLayoutBounds()))
        {
            return true;
        }
        return false;
    }

    public static boolean collishion(Circle circle, ArrayList<Rectangle> blocks)
    {

        for(int index = 0; index < blocks.size(); index++)
        {
            if (circle.intersects(blocks.get(index).getLayoutBounds()))
            {
                return true;
            }
        }

        return false;
    }

    public static double getRelativePositionCircleCollidedX(Circle circle, Rectangle paddle)
    {
        System.out.println((circle.getCenterX() - paddle.getX()) / paddle.getWidth());
        return (circle.getCenterX() - paddle.getX()) / paddle.getWidth();

    }
    public static double getRelativePositionCircleCollidedY(Circle circle, Rectangle paddle)
    {
        return (circle.getCenterY() - paddle.getY()) / paddle.getHeight();
    }


}
