/**
* @file TestTileT.java
* @author Mehak Khan
* @brief Testing TileT module
* @date 8th April 2021
*/

package src;
import org.junit.*;
import static org.junit.Assert.*;
import java.awt.Color;

public class TestTileT {

	TileT t1;

	@Before
	public void setUp() {
		t1 = new TileT(0);
	}

	@After
	public void tearDown() {
		t1 = null;
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor() {
		TileT t2 = new TileT(-1);
	}

	@Test
	public void testGetVal() {
		assertTrue(t1.getVal() == 0);
	}

	@Test
	public void testSetVal() {
		t1.setVal(12);
		assertTrue(t1.getVal() == 12);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetValException() {
		t1.setVal(-2);
	}

	@Test
	public void testColourSetandGet() {
		t1.setColour();
		assertTrue(t1.getBG().equals(new Color(205,193,180)));
		assertTrue(t1.getFONT().equals(new Color(205, 193, 180)));
	}

	@Test
	public void testColourSetandGet2() {
		t1.setVal(16);
		t1.setColour();
		assertTrue(t1.getBG().equals(new Color(245, 149, 99)));
		assertTrue(t1.getFONT().equals(new Color(249, 246, 242)));

	}

	@Test
	public void testColourNotAValue() {
		t1.setVal(5); //this should set the colour to a value 4
		t1.setColour();
		assertTrue(t1.getBG().equals(new Color(237, 224, 200)));
		assertTrue(t1.getFONT().equals(new Color(119, 110, 101)));		

	}








}