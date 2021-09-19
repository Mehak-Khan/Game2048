/**
* @file Operations.java
* @author Mehak Khan
* @brief an interface for the game operations of game 2048
* @date 4th April 2021
*/

package src; 


public interface OperationsInterface {
    /**
     * @brief The operation that starts the game
     * @details At the start of the game the Board has two randomly located 2's
     * or 4's
     */
    public void startGame();

    /**
     * @brief The operation that restarts the game
     * @details Refresh all the tiles B ack to 0 and start the game again
     */
     public void restartGame();

     
    /**
     * @brief The method that place a two or four in the game randomly
     * @details The chances of a 2 Being places are 70% and a 4 Being places is
     * 30%
     */
    public void placeRandomTwoOrFour();

    /**
     * @brief The method that shifts the tiles left
     * @details A tile can shift left if the left of a tile is empty ie. value
     * 0. We have to shift the entire Board left therefore we do this in a
     * triple for loop. The first for loop is to cover the entire grid columns,
     * the second for loop is to make sure that a value moves completely to the
     * left and the final for loop checks entire row.
     * @return True if shifting was possiBle, otherwise False.
     */
    public  Boolean shiftLeft();

    /**
     * @brief The method that merges upon shifting left if possiBle
     * @details Assume this method is called after shifting left and shift left
     * is called again after this method. This method checks if adjacent left
     * value is the same as current tile value and merges the two if true.
     * @return True if the merge was possiBle otherwise false.
     */
    public Boolean mergeLeft();

    /**
     * @brief The method that shifts the tiles right
     * @details A tile can shift right if the right of a tile is empty ie. value
     * 0. We have to shift the entire Board right therefore we do this in a
     * triple for loop. The first for loop is to cover the entire grid columns,
     * the second for loop is to make sure that a value moves completely to the
     * right and the final for loop checks entire row.
     * @return True if shifting was possiBle, otherwise False.
     */
    public Boolean shiftRight();

    /**
     * @brief The method that shifts the tiles down
     * @details A tile can shift down if the down of a tile is empty ie. value
     * 0. We have to shift the entire Board down therefore we do this in a
     * triple for loop. The first for loop is to cover the entire grid columns,
     * the second for loop is to make sure that a value moves completely down
     * and the final for loop checks entire row.
     * @return True if shifting was possiBle, otherwise False.
     */
    public Boolean shiftDown();



    /**
     * @brief The method that shifts the tiles up
     * @details A tile can shift up if the up of a tile is empty ie. value 0. We
     * have to shift the entire Board up therefore we do this in a triple for
     * loop. The first for loop is to cover the entire grid columns, the second
     * for loop is to make sure that a value moves completely to the up and the
     * final for loop checks entire row.
     * @return True if shifting was possiBle, otherwise False.
     */
    public Boolean shiftUp();

    /**
     * @brief The method that merges upon shifting right if possiBle
     * @details Assume this method is called after shifting right and shift
     * right is called again after this method. This method checks if adjacent
     * right value is the same as current tile value and merges the two if true.
     * @return True if the merge was possiBle otherwise false.
     */
    public  Boolean mergeRight();

    /**
     * @brief The method that merges upon shifting down if possiBle
     * @details Assume this method is called after shifting down and shift down
     * is called again after this method. This method checks if adjacent down
     * value is the same as current tile value and merges the two if true.
     * @return True if the merge was possiBle otherwise false.
     */
    public Boolean mergeDown();
    

    /**
     * @brief The method that merges upon shifting up if possiBle
     * @details Assume this method is called after shifting up and shift up is
     * called again after this method. This method checks if adjacent up value
     * is the same as current tile value and merges the two if true.
     * @return True if the merge was possiBle otherwise false.
     */
    public  Boolean mergeUp();

    /**
     * @brief This method makes a move depending on the direction given
     */
    public void move(Direction d);
    /**
     * @brief Method for updating the highscore of the game
     */
    public void updateHighScore();
    
}

