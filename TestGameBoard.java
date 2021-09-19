/**
* @file TestGameBoard.java
* @author Mehak Khan
* @brief Testing GameBoard module
* @date 8th April 2021
*/

package src;
import org.junit.*;
import static org.junit.Assert.*;

public class TestGameBoard {


	@Before
	public void setUp() {

	}

	@After
	public void tearDown() {

	}

	@Test
	public void testSetGameAndGetGame() {
		GameBoard.setGame();
		for (int i = 0; i < GameBoard.getSize(); i++) {
			for (int j = 0; j < GameBoard.getSize(); j++) {
				GameBoard.getGame()[i][j].equals(new TileT(0));
			}
		}
	}

	@Test
	public void testGetValue() {
		GameBoard.setGame();
		assertTrue(GameBoard.getValue(0, 2) == 0);
	}

	@Test
	public void testGetValueNonZero() {
		GameBoard.setGame();
		GameBoard.getGame()[0][2].setVal(10);
		assertTrue(GameBoard.getValue(0, 2) == 10);

	}

	@Test
	public void testGetTile() {
		GameBoard.setGame();
		assertTrue(GameBoard.getTile(0,3) == GameBoard.getGame()[0][3]);
	}

	@Test
	public void testSetScoreAndGetScore() {
		GameBoard.setScore(1);
		assertTrue(GameBoard.getScore() == 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetScoreException() {
		GameBoard.setScore(-1);

	}


	@Test
	public void testSetHighScoreAndGetScore() {
		GameBoard.setScore(13);
		assertTrue(GameBoard.getScore() == 13);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetHighScoreException() {
		GameBoard.setScore(-1);

	}

	@Test
	public void testGetSize() {
		assertTrue(GameBoard.getSize() == 4);
	}

	@Test
	public void testGameOverTrue() {
	int k = 1;
	GameBoard.setGame();
	 for (int i = 1; i < GameBoard.getSize() + 1; i++) {
		for (int j = 1; j < GameBoard.getSize() + 1; j++) {
				GameBoard.getGame()[i-1][j-1].setVal(k);
				k++;
			}
	}
	assertTrue(GameBoard.gameOver());
}

	@Test
	public void testGameOverFalse() {
		GameBoard.setGame();
		assertTrue(!GameBoard.gameOver());
	}

	@Test
	public void testGameOverFalse2() {
		GameBoard.setGame();
	 for (int i = 1; i < GameBoard.getSize() + 1; i++) {
	for (int j = 1; j < GameBoard.getSize() + 1; j++) {
			GameBoard.getGame()[i-1][j-1].setVal(i);
		
			}
	}	
	assertTrue(!GameBoard.gameOver());	
	}

	@Test 
	public void testGameWonFalse() {
		GameBoard.setGame();
		assertTrue(!GameBoard.gameWon());

	}

	@Test
	public void testGameWonTrue() {
		GameBoard.setGame();
		GameBoard.getGame()[0][3].setVal(2048);
		assertTrue(GameBoard.gameWon());
	}

}