/**
* @file TestOperations.java
* @author Mehak Khan
* @brief Testing Operations module
* @date 8th April 2021
*/

package src;
import org.junit.*;
import static org.junit.Assert.*;

public class TestOperations {
	Operations operations;

	@Before
	public void setUp() {
		operations = Operations.Instance();
	}

	@After
	public void tearDown() {
		operations = null;

	}

	@Test
	public void testStartGame() {
		int cell = 0;
		int zero = 0;
		operations.startGame();
		assertTrue(GameBoard.getScore() == 0);
		assertTrue(GameBoard.getHighScore() == 0);

		for (int i = 0; i < GameBoard.getSize(); i ++) {
		for (int j = 0; j < GameBoard.getSize(); j++) {
			if (GameBoard.getGame()[i][j].getVal() == 2 || GameBoard.getGame()[i][j].getVal() == 4 ) {
				cell++;
			}
			else if (GameBoard.getGame()[i][j].getVal() == 0) {
				zero++;
			}
		}
		}
		assertTrue(cell == 2); //Two random tiles with value 2 or 4
		assertTrue(zero == GameBoard.getSize()*GameBoard.getSize()- 2); //all other cells are 0
	}

	@Test
	public void testRestartGame() {
		int cell = 0;
		int zero = 0;
		operations.restartGame();
		assertTrue(GameBoard.getScore() == 0);
		
		for (int i = 0; i < GameBoard.getSize(); i ++) {
		for (int j = 0; j < GameBoard.getSize(); j++) {
			if (GameBoard.getGame()[i][j].getVal() == 2 || GameBoard.getGame()[i][j].getVal() == 4 ) {
				cell++;
			}

			else if (GameBoard.getGame()[i][j].getVal() == 0) {
				zero++;
			}
		}
		}
		assertTrue(cell == 2); //Two random tiles with value 2 or 4
		assertTrue(zero == GameBoard.getSize()*GameBoard.getSize()- 2); //all other cells are 0
	}

	@Test
	public void testRandomTwoOrFour() {
		GameBoard.setGame();
		operations.placeRandomTwoOrFour();
		int cell = 0;
				for (int i = 0; i < GameBoard.getSize(); i ++) {
		for (int j = 0; j < GameBoard.getSize(); j++) {
			if (GameBoard.getGame()[i][j].getVal() == 2 || GameBoard.getGame()[i][j].getVal() == 4 ) {
				cell++;
			}

	}
}
	assertTrue(cell == 1);


	}

    @Test
    public void testshiftLeft() {
 		GameBoard.setGame();
		GameBoard.getGame()[0][GameBoard.getSize()-1].setVal(44);
		assertTrue(operations.shiftLeft());
		assertTrue(GameBoard.getGame()[0][0].getVal() == 44);   	

    }

	@Test
	public void testShiftRight() {
		GameBoard.setGame();
		GameBoard.getGame()[0][0].setVal(5);
		assertTrue(operations.shiftRight());
		assertTrue(GameBoard.getGame()[0][GameBoard.getSize()-1].getVal() == 5);
	}

	@Test
	public void testShiftUp() {
		GameBoard.setGame();
		GameBoard.getGame()[GameBoard.getSize() -1][0].setVal(55);
		assertTrue(operations.shiftUp());
		assertTrue(GameBoard.getGame()[0][0].getVal() == 55);
	}

	@Test
	public void testShiftDown() {
		GameBoard.setGame();
		GameBoard.getGame()[0][0].setVal(4);
		assertTrue(operations.shiftDown());
		assertTrue(GameBoard.getGame()[GameBoard.getSize()-1][0].getVal() == 4);
	}

	@Test
	public void testShiftLeftFalse() {
		GameBoard.setGame();
		GameBoard.getGame()[0][0].setVal(5);
		GameBoard.getGame()[0][1].setVal(6);
		assertTrue(!operations.shiftLeft());
	}

	@Test
	public void testShiftRightFalse() {
		GameBoard.setGame();
		GameBoard.getGame()[0][0].setVal(5);
		GameBoard.getGame()[0][1].setVal(6);
		GameBoard.getGame()[0][2].setVal(7);
		GameBoard.getGame()[0][3].setVal(8);
		assertTrue(!operations.shiftRight());
	}

	@Test
	public void testShiftUpFalse() {
		GameBoard.setGame();
		GameBoard.getGame()[0][0].setVal(1);
		assertTrue(!operations.shiftUp());
	}

	@Test
	public void testShiftDownFalse() {
		GameBoard.setGame();
		GameBoard.getGame()[3][0].setVal(2);
		GameBoard.getGame()[2][0].setVal(1);
		assertTrue(!operations.shiftDown());

	}

	@Test
	public void testMergeLeft() {
		GameBoard.setGame();
		GameBoard.getGame()[0][0].setVal(2);
		GameBoard.getGame()[0][1].setVal(2);
		assertTrue(operations.mergeLeft());
		assertTrue(GameBoard.getGame()[0][0].getVal() == 4);
	}

	@Test
	public void testMergeRight() {
		GameBoard.setGame();
		GameBoard.getGame()[0][3].setVal(2);
		GameBoard.getGame()[0][2].setVal(2);
		assertTrue(operations.mergeRight());
		assertTrue(GameBoard.getGame()[0][3].getVal() == 4);
	}

	@Test
	public void testMergeUp() {
		GameBoard.setGame();
		GameBoard.getGame()[0][0].setVal(2);
		GameBoard.getGame()[1][0].setVal(2);
		assertTrue(operations.mergeUp());
		assertTrue(GameBoard.getGame()[0][0].getVal() == 4);
	}

	@Test
	public void testMergeDown() {
		GameBoard.setGame();
		GameBoard.getGame()[3][0].setVal(2);
		GameBoard.getGame()[2][0].setVal(2);
		assertTrue(operations.mergeDown());
		assertTrue(GameBoard.getGame()[3][0].getVal() == 4);
	}

	@Test
	public void testMergeLeftFalse() {
		GameBoard.setGame();
		GameBoard.getGame()[0][0].setVal(2);
		GameBoard.getGame()[0][1].setVal(3);
		assertTrue(!operations.mergeLeft());

	}

	@Test
	public void testMergeRightFalse() {
		GameBoard.setGame();
		GameBoard.getGame()[0][3].setVal(2);
		GameBoard.getGame()[0][2].setVal(3);
		assertTrue(!operations.mergeRight());

	}

	@Test
	public void testMergeUpFalse() {
		GameBoard.setGame();
		GameBoard.getGame()[0][0].setVal(2);
		GameBoard.getGame()[1][0].setVal(3);
		assertTrue(!operations.mergeUp());

	}

	@Test
	public void testMergeDownFalse() {
		GameBoard.setGame();
		GameBoard.getGame()[3][0].setVal(2);
		GameBoard.getGame()[2][0].setVal(3);
		assertTrue(!operations.mergeDown());

	}

	@Test
	public void testMoveLeft() {
		int cell = 0;
		GameBoard.setGame();
		GameBoard.getGame()[0][1].setVal(5);
		operations.move(Direction.LEFT);
		for (int i = 0; i < GameBoard.getSize(); i ++) {
		for (int j = 0; j < GameBoard.getSize(); j++) {
			if (GameBoard.getGame()[i][j].getVal() == 2 || GameBoard.getGame()[i][j].getVal() == 4 ) {
				cell++;
			}


	}
}
	assertTrue(cell == 1);



}

	@Test
	public void testMoveRight() {
		int cell = 0;
		GameBoard.setGame();
		GameBoard.getGame()[0][1].setVal(5);
		operations.move(Direction.RIGHT);
		for (int i = 0; i < GameBoard.getSize(); i ++) {
		for (int j = 0; j < GameBoard.getSize(); j++) {
			if (GameBoard.getGame()[i][j].getVal() == 2 || GameBoard.getGame()[i][j].getVal() == 4 ) {
				cell++;
			}


	}
}
	assertTrue(cell == 1);



}

	@Test
	public void testMoveUp() {
		int cell = 0;
		GameBoard.setGame();
		GameBoard.getGame()[1][1].setVal(5);
		operations.move(Direction.UP);
		for (int i = 0; i < GameBoard.getSize(); i ++) {
		for (int j = 0; j < GameBoard.getSize(); j++) {
			if (GameBoard.getGame()[i][j].getVal() == 2 || GameBoard.getGame()[i][j].getVal() == 4 ) {
				cell++;
			}


	}
}
	assertTrue(cell == 1);



}

	@Test
	public void testMoveDown() {
		int cell = 0;
		GameBoard.setGame();
		GameBoard.getGame()[1][1].setVal(5);
		operations.move(Direction.DOWN);
		for (int i = 0; i < GameBoard.getSize(); i ++) {
		for (int j = 0; j < GameBoard.getSize(); j++) {
			if (GameBoard.getGame()[i][j].getVal() == 2 || GameBoard.getGame()[i][j].getVal() == 4 ) {
				cell++;
			}


	}
}
	assertTrue(cell == 1);



}

	@Test
	public void testUpdateHighScore() {
		GameBoard.setGame();
		GameBoard.setScore(5);
		operations.updateHighScore();
		assertTrue(GameBoard.getHighScore() == 5);
	}

	@Test
	public void testUpdateHighScoreNotHigher() {
		GameBoard.setGame();
		GameBoard.setScore(5);
		GameBoard.setHighScore(55);
		operations.updateHighScore();
		assertTrue(GameBoard.getHighScore() == 55);
	}


}
