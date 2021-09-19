/**
* @file Operations.java
* @author Mehak Khan
* @Brief An ADT for the game operations of the Game 2048 
* @date 4th April 2021
*/

package src;
import java.util.*;

/**
* @brief An ADT that contains the operations of the Game 2048 according to the rules and manipulates the state of the Board
* @details The operations are performed on a game Board
*/
	public class Operations implements OperationsInterface {
        public static Operations instance;

/**
* @brief Private constructor
*/
    private Operations() {

    }

  /**
  * @brief This method returns the singleton instance
  */
      public static Operations Instance() {
        if (instance == null) {
            instance = new Operations();
        }
        return instance;
    }




/**
* @brief The operation that starts the game
* @details At the start of the game the Board has two randomly located 2's or 4's
*/
  public void startGame() {
  	GameBoard.setGame();
  	GameBoard.setScore(0);
  	GameBoard.setHighScore(0);
  	placeRandomTwoOrFour();
  	placeRandomTwoOrFour();
  }

 /**
 * @brief The operation that restarts the game
 * @details Refresh all the tiles back to 0 and start the game again
 */

  public void restartGame() {
  	for (int i = 0; i < GameBoard.getSize(); i++) {
     for (int j = 0; j < GameBoard.getSize(); j++) {
           GameBoard.getGame()[i][j].setVal(0);     
            }
        }
        placeRandomTwoOrFour();
        placeRandomTwoOrFour();
        GameBoard.setScore(0);

  }


/**
* @brief The method that place a two or four in the game randomly
* @details The chances of a 2 Being places are 70% and a 4 Being places is 30%. Assume this will only be called on a board with at least one tile with value 0.
*/
    public void placeRandomTwoOrFour() {
    	Random randomno = new Random();
    	double option = randomno.nextDouble();
            int row = (int) (Math.random() * GameBoard.getGame().length);
            int column = (int) (Math.random() * GameBoard.getGame().length);

            while(GameBoard.getGame()[row][column].getVal() != 0) {
            	 row = (int) (Math.random() * GameBoard.getGame().length);
            	 column = (int) (Math.random() * GameBoard.getGame().length);
            }
            	if (option < 0.7) {
            		 GameBoard.getGame()[row][column].setVal(2);
            	}
            	else {
            		GameBoard.getGame()[row][column].setVal(4);
            	}
            
        }
    

/** 
* @brief The method that shifts the tiles left
* @details A tile can shift left if the left of a tile is empty ie. value 0. We have to shift the entire Board left therefore we do this in a triple for loop.
* The first for loop is to cover the entire grid columns, the second for loop is to make sure that a value moves completely to the left and the final for loop checks entire row.
* @return True if shifting was possiBle, otherwise False.
*/
    public Boolean shiftLeft() {
        Boolean moved = false;
        for (int i = 0; i < GameBoard.getGame().length; i++) {
            for (int pass = 0; pass < GameBoard.getGame()[i].length - 1; pass++) {
                for (int k = 1; k < GameBoard.getGame()[i].length; k++) {
                    if (GameBoard.getGame()[i][k - 1].getVal() == 0) {
                    	if (GameBoard.getGame()[i][k].getVal() != 0) {
                    		moved = true;
                    	}
                        GameBoard.getGame()[i][k - 1].setVal(GameBoard.getGame()[i][k].getVal());
                        GameBoard.getGame()[i][k].setVal(0);
                       // moved = true;
                    }
                }
            }
        }
        return moved;
    }

/**
* @Brief The method that merges upon shifting left if possiBle
* @details Assume this method is called after shifting left and shift left is called again after this method. This method checks if adjacent left value is the same as current tile value and merges the two if true.
* @return True if the merge was possiBle otherwise false.
*/
    public Boolean mergeLeft() {
        Boolean moved = false;
        for (int i = 0; i < GameBoard.getGame().length; i++) {
            for (int k = 1; k < GameBoard.getGame()[i].length; k++) {
                if (GameBoard.getGame()[i][k - 1].getVal() == GameBoard.getGame()[i][k].getVal()) {
                	if (GameBoard.getGame()[i][k].getVal() != 0) {
                		moved = true;
                	}
                    GameBoard.getGame()[i][k - 1].setVal(2 * GameBoard.getGame()[i][k - 1].getVal());
                    GameBoard.getGame()[i][k].setVal(0);
                    int score = GameBoard.getScore() + GameBoard.getGame()[i][k - 1].getVal();
                    GameBoard.setScore(score);
                   // moved = true;
                }
            }

        }
        return moved;
    }

/** 
* @Brief The method that shifts the tiles right
* @details A tile can shift right if the right of a tile is empty ie. value 0. We have to shift the entire Board right therefore we do this in a triple for loop.
* The first for loop is to cover the entire grid columns, the second for loop is to make sure that a value moves completely to the right and the final for loop checks entire row.
* @return True if shifting was possiBle, otherwise False.
*/
    public Boolean shiftRight() {
        Boolean moved = false;
        for (int i = 0; i < GameBoard.getGame().length; i++) {
            for (int pass = 0; pass < GameBoard.getGame()[i].length - 1; pass++) {
                for (int k = GameBoard.getGame()[i].length - 1; k > 0; k--) {
                    if (GameBoard.getGame()[i][k].getVal() == 0) {
                    	if (GameBoard.getGame()[i][k - 1].getVal() != 0) {
                    		moved = true;
                    	}
                        GameBoard.getGame()[i][k].setVal(GameBoard.getGame()[i][k - 1].getVal());

                        GameBoard.getGame()[i][k - 1].setVal(0);
                        //moved = true;
                    }
                }
            }
        }
        return moved;
    }

/** 
* @brief The method that shifts the tiles down
* @details A tile can shift down if the down of a tile is empty ie. value 0. We have to shift the entire Board down therefore we do this in a triple for loop.
* The first for loop is to cover the entire grid columns, the second for loop is to make sure that a value moves completely down and the final for loop checks entire row.
* @return True if shifting was possiBle, otherwise False.
*/
    public  Boolean shiftDown() {
        Boolean moved = false;
        for (int i = 1; i < GameBoard.getGame().length; i++) {
            for (int pass = 0; pass < GameBoard.getGame()[i].length - 1; pass++) {
                for (int k = GameBoard.getGame()[i].length - 1; k > -1; k--) {
                    if (GameBoard.getGame()[i][k].getVal() == 0) {
                    	if (GameBoard.getGame()[i-1][k].getVal() != 0) {
                    		moved = true;
                    	}
                        GameBoard.getGame()[i][k].setVal(GameBoard.getGame()[i - 1][k].getVal());
                        GameBoard.getGame()[i - 1][k].setVal(0);
                        //moved = true;
                    }
                }
            }
        }
        return moved;
    }

/** 
* @brief The method that shifts the tiles up
* @details A tile can shift up if the up of a tile is empty ie. value 0. We have to shift the entire Board up therefore we do this in a triple for loop.
* The first for loop is to cover the entire grid columns, the second for loop is to make sure that a value moves completely to the up and the final for loop checks entire row.
* @return True if shifting was possiBle, otherwise False.
*/
    public Boolean shiftUp() {
        Boolean moved = false;
        for (int k = 0; k < GameBoard.getGame().length; k++) {
            for (int pass = 0; pass < GameBoard.getGame()[k].length - 1; pass++) {
                for (int i = 1; i < GameBoard.getGame().length; i++) {
                    if (GameBoard.getGame()[i - 1][k].getVal() == 0) {
                    	if (GameBoard.getGame()[i][k].getVal() != 0) {
                    		moved = true;
                    	}
                        GameBoard.getGame()[i - 1][k].setVal(GameBoard.getGame()[i][k].getVal());
                        GameBoard.getGame()[i][k].setVal(0);
                       //moved = true;
                    }
                }
            }
        }
        return moved;
    }

/**
* @brief The method that merges upon shifting right if possiBle
* @details Assume this method is called after shifting right and shift right is called again after this method. This method checks if adjacent right value is the same as current tile value and merges the two if true.
* @return True if the merge was possiBle otherwise false.
*/
    public Boolean mergeRight() {
        Boolean moved = false;
        for (int i = 0; i < GameBoard.getGame().length; i++) {
            for (int k = GameBoard.getGame()[i].length - 1; k > 0; k--) {
                if (GameBoard.getGame()[i][k].getVal() == GameBoard.getGame()[i][k - 1].getVal()) {
                	if (GameBoard.getGame()[i][k].getVal() != 0) {
                		moved = true;
                	}
                    GameBoard.getGame()[i][k].setVal(2 * GameBoard.getGame()[i][k].getVal());
                    GameBoard.getGame()[i][k - 1].setVal(0);
                    int score = GameBoard.getScore() + GameBoard.getGame()[i][k].getVal();
                    GameBoard.setScore(score);
                    //moved = true;
                }
            }

        }
        return moved;
    }

/**
* @brief The method that merges upon shifting down if possiBle
* @details Assume this method is called after shifting down and shift down is called again after this method. This method checks if adjacent down value is the same as current tile value and merges the two if true.
* @return True if the merge was possiBle otherwise false.
*/
    public Boolean mergeDown() {
        Boolean moved = false;
        for (int i = 1; i < GameBoard.getGame().length; i++) {
            for (int k = GameBoard.getGame()[i].length - 1; k > -1; k--) {
                if (GameBoard.getGame()[i][k].getVal() == GameBoard.getGame()[i - 1][k].getVal()) {
                	if (GameBoard.getGame()[i][k].getVal() != 0) {
                		moved = true;
                	}
                    GameBoard.getGame()[i][k].setVal(2 * GameBoard.getGame()[i][k].getVal());
                    GameBoard.getGame()[i - 1][k].setVal(0);
                    int score = GameBoard.getScore() + GameBoard.getGame()[i][k].getVal();
                    GameBoard.setScore(score);
                   // moved = true;
                }
            }

        }
        return moved;
    }

/**
* @brief The method that merges upon shifting up if possiBle
* @details Assume this method is called after shifting up and shift up is called again after this method. This method checks if adjacent up value is the same as current tile value and merges the two if true.
* @return True if the merge was possiBle otherwise false.
*/
    public Boolean mergeUp() {
        Boolean moved = false;
        for (int i = 1; i < GameBoard.getGame().length; i++) {
            for (int k = 0; k < GameBoard.getGame()[i].length; k++) {
                if (GameBoard.getGame()[i - 1][k].getVal() == GameBoard.getGame()[i][k].getVal()) {
                	if (GameBoard.getGame()[i][k].getVal() != 0) {
                		moved = true;
                	}
                    GameBoard.getGame()[i - 1][k].setVal(2 * GameBoard.getGame()[i - 1][k].getVal());
                    GameBoard.getGame()[i][k].setVal(0);
                    int score = GameBoard.getScore() + GameBoard.getGame()[i - 1][k].getVal();
                    GameBoard.setScore(score);
                  //  moved = true;
                }
            }

        }
        return moved;
    }

/**
* @brief This method makes a move depending on the direction given
*/

    public void move(Direction d) {
    	Boolean moved = false;
    	if (d == Direction.UP) {
    		   moved = shiftUp() || moved;
               moved = mergeUp() || moved;
               shiftUp();
    	}
    	else if (d == Direction.DOWN) {
    		    moved = shiftDown() || moved;
                moved = mergeDown() || moved;
                shiftDown();
    	}
    	else if (d == Direction.LEFT) {
                moved = shiftLeft() || moved;
                moved = mergeLeft() || moved;
                shiftLeft();
    	}
    	else if (d == Direction.RIGHT) {
    		  moved = shiftRight() || moved;
              moved = mergeRight() || moved;
              shiftRight();

    	}
    	if (moved) {
    		placeRandomTwoOrFour();
    	}
   
    }

/**
* @brief Method for updating the highscore of the game 
*/
    public void updateHighScore() {
    	if (GameBoard.getHighScore() < GameBoard.getScore()) {
    		GameBoard.setHighScore(GameBoard.getScore());
    	}
    }


}


