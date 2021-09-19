/**
* @file GameBoard.java
* @author Mehak Khan
* @brief an Abstract Object for the status of the game board of game 2048
* @date 4th April 2021
*/
package src; 

/**
* @brief An Abstract Object for the basic board status of the game 
* @details The Abstract Object has the board size, the tiles, and the current score of the game
*/

public class GameBoard {

	private static final int SIZE = 4;
	private static final int GOAL = 2048;
	private static TileT[][] game;
	private static int score;
	private static int highscore;

/**
* @brief The method that sets the game initally. All the tiles are initialized with value 0. Assume this method is called before any other access program in the module.
*/
	public static void setGame() {
		game = new TileT[SIZE][SIZE];
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize(); j++) {
				game[i][j] = new TileT(0);
			}
		}
	}

/**
* @brief Getter for the tiles of the game
* @return A 2D array of TileT
*/
	public static TileT[][] getGame() {
		return game;
	}

    /**
     * @brief Gets the value of a specific tile
     * @param x the x position of tile
     * @param y the y position of tile
     * @return The value of the tile
     */
    public static int getValue(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("X and Y paramters cannot be 0");
        }
        return getTile(x, y).getVal();

    }
    /**
     * @brief Gets the tile at a specific position
     * @param x the x position of tile
     * @param y the y position of tile
     * @return The value of the tile
     */
    public static TileT getTile(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("X and Y paramters cannot be 0");
        }
        return game[x][y];
    }

/**
* @brief Setter for the score of the game
* @param sc The score of the game
*/
	public static void setScore(int sc) {
		if (sc < 0) {
			throw new IllegalArgumentException("Score cannot be less than 0");
		}
		score = sc;
	}

/**
* @brief Getter for the score of the gamr
* @return Integer value representing the score of the game
*/
	public static int getScore() {
		return score;
	}

/**
* @brief Setter for the highscore of the game
* @param hsc The highscore of the game
*/
	public static void setHighScore(int hsc) {
		if (hsc < 0) {
			throw new IllegalArgumentException("Highscore cannot be less than 0");
		}
		highscore = hsc;
	}

/**
* @brief Getter for the highscore of the gamr
* @return Integer value representing the highscore of the game
*/
	public static int getHighScore() {
		return highscore;
	}


/**
* @brief Getter for the size of the board
* @return The size of the board
*/
   public static int getSize() {
   	return SIZE;
   }


    /**
    * @brief Checks if the value is on the board to make sure no array out of bounds arises
    * @param i The x position of the tiles
    * @param j The y position of the tiles
    * @return Boolean if the position value is possible to be on the board and not out of bounds
     */
    private static boolean checkValue(int i, int j) {
        return (i > 0 && i < getSize() -1 && j > 0 && j < getSize() - 1);
    }

/**
* @brief Checks if the game status is game over or not
* @details A game is not over if there is an empty cell on the board or if there is space to move adjacent
* @return True if game is over otherwise false
*/

	 public static boolean gameOver() {
     boolean gameOver = true;
     for (int i = 0; i < getSize(); i++) {
      for (int j = 0; j < getSize(); j++) {
                //CHECK IF GAMEBOARD IS NOT EMPTY
                if (getGame()[i][j].getVal() == 0) {
                    return false;
                }
            }
        }
        
        for (int k = 0; k < getSize(); k++) {
        for (int l = 0; l < getSize(); l++) {
           if (k + 1 < getSize() - 1) {
              if (getGame()[k][l].getVal() == getGame()[k + 1][l].getVal()) {
                gameOver = false;
              }
              
           }
           if (k - 1 > -1) {
            if (getGame()[k][l].getVal() == getGame()[k - 1][l].getVal()) {
              gameOver = false;
            }
           }
           if (l + 1 < getSize() - 1) {
            if (getGame()[k][l].getVal() == getGame()[k][l + 1].getVal()) {
              gameOver = false;
            }
           }
           if (l - 1 > -1 ) {
            if (getGame()[k][l].getVal() == getGame()[k][l - 1].getVal()) {
              gameOver = false;
            }
           }
           
             
                           

                    }

                }
        

                return gameOver;
            }



/**
* @brief Check if the game was won
* @return True if game was won, otherwise false
*/
      public static boolean gameWon() {
      	for (int i = 0; i < getSize(); i++) {
      		for (int j =0; j < getSize(); j++) {
      			if (getGame()[i][j].getVal() == GOAL) {
      				return true;
      			}
      		}
      	}
      	return false;


      }



}