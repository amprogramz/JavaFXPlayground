package com.graphics.playground;

public class Score
{
    private int score;
    private int score2;
    private int lives;
    private int lives2;

    public Score(int lives)
    {
        score = 0;
        lives = lives;
    }

    public Score(int lives, int lives2)
    {
        score = 0;
        score2 = 0;
        this.lives = lives;
        this.lives2 = lives;
    }

    public void setScore(int score)
    {
        this.score = + score;
    }
    public void setScore2(int socre)
    {
        this.score2 = + score;
    }
    public int getScore()
    {
        return score;
    }
    public int getScore2()
    {
        return score2;
    }

    public void rsetLives(int lives)
    {
        this.lives = lives;
    }
    public void resetLives2(int lives)
    {
        this.lives2 = lives;
    }
    public void decrementLives()
    {
        lives--;
    }
    public void decrementLives2()
    {
        lives2--;
    }
    public int getLives()
    {
        return lives;
    }
    public int getLives2()
    {
        return lives2;
    }


}
