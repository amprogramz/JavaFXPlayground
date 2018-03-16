package com.graphics.playground;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

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

}
