/*
 * File: Player.java
 * Author: Arin Santry
 * Date due: 2/19/19
 * Desc: Contains methods used in Roll 'em Pigs.
 */
package rollempigspackage;

/**
 *
 * @author erins
 */
public class Player {
    private final int NUM_DICE = 2;
    private final int NUM_SIDES = 6;
    private DieLabel[] dieArray = new DieLabel[NUM_DICE];
    private int dieValue1;
    private int dieValue2;
    private int totalScore = 0;
    private int turnScore = 0;


    /*
    * rollDie
    * Perfoms the rolling of the individual die being displayed
    * on each of the two DieLabel objects
    */
    public int rollDie(DieLabel die1, DieLabel die2)
    {
        dieValue1 = die1.rollDie();
        dieValue2 = die2.rollDie();
        turnScore += dieValue1 + dieValue2;
        return turnScore;
    }

    /*
    * isTurnScoreLost
    * Returns true id the result of the roll causes the player to loose a turn
    * (one of the dice is a  1)
    * Returns false otherwise
    */
    public boolean isTurnScoreLost()
    {
        if (dieValue1 == 1 || dieValue2 == 1)
        {
            turnScore = 0;
            return true;
        }
        return false;
    }

    /*
    * isGameScoreLost
    * Returns true if the result of the roll causes to both loose a turn and
    * all the points accumulated in the game (both dice are 1's)
    * Returns false otherwise
    */
    public boolean isGameScoreLost()
    {
        if (dieValue1 == 1 && dieValue2 == 1)
        {
            turnScore = 0;
            totalScore = 0;
            return true;
        }
        return false;
    }

    /*
    * hasWon
    * Returns true if the player has scored at least 100 points
    * Returns false otherwise
    */
    public boolean hasWon()
    {
        if (getGameScore() + getTurnScore() >= 100)
            return true;
        return false;
    }

    /*
    * addTurnScoreToGameScore
    * This bethod is only to be callded when the player finishes their turn
    * Returns true if the value of the game score changes as a result
    * of the operation
    */
    public boolean addTurnScoreToGameScore()
    {
        int previousScore = totalScore;
        totalScore += turnScore;
        if (previousScore != totalScore)
            return true;
        return false;
    }

    /*
    * getTurnScore
    * Returns the current turn score
    */
    public int getTurnScore()
    {
        return turnScore;
    }

    /*
    * getGameScore
    * Returns the current game score
    */
    public int getGameScore()
    {
        return totalScore;
    }

    /*
    * reset
    * Resets the player's turn and game scores to zero for use in a new game
    */
    public void reset()
    {
        turnScore = 0;
        totalScore = 0;
    }
    
    /*
    * resetTurnScore
    * Resets the turnScore only
    */
    public void resetTurnScore()
    {
        turnScore = 0;
    }

}