package com.graphics.playground;


import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class BlockGrid
{
    ArrayList<Block> blocks = new ArrayList<>();

    public BlockGrid(int amountOfBlocks, double screenWidth)
    {
        int blocksPerRow = (int)screenWidth/ 100;
        double spaceing = (screenWidth - (blocksPerRow * 100)) / (blocksPerRow + 1);
        double xSpaceUsed = spaceing;

        int collumns = amountOfBlocks / blocksPerRow;

        for(int index = 0; index < amountOfBlocks; index++)
        {
            double temp = (25 + ((25 * index) + (100 * index)));
            blocks.add(new Block(temp, spaceing, index));
        }
    }



    public ArrayList<Rectangle> getBlocks()
    {
        ArrayList<Rectangle> blocksToReturn = new ArrayList<>();
        for (int index = 0; index < blocks.size(); index++ )
        {
            blocksToReturn.add(blocks.get(index).getBlock());
        }
        return blocksToReturn;
    }
    public BlockGrid getBlockGrid()
    {
        return this;
    }

    public void checkForDestruction(Circle ball)
    {
        for(Block block : blocks)
        {
            if(Colideable.collishion(ball, blocks.get(block.getIndex()).getBlock()))
            {
                System.out.println("Block Destroyed " + block.getIndex());
                blocks.get(block.getIndex()).destruct();
            }
        }

    }

}
