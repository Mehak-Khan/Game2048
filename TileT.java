/**
* @file TileT.java
* @author Mehak Khan
* @brief an ADT for the tiles of game 2048
* @date 4th April 2021
*/

package src;
import java.awt.Color;


/**
* @brief This is an ADT for the tiles in the game 2048
* @details This ADT has a value for each tile and a colour
*/

public class TileT {
	private int value;
	private Color colourBG, colourFONT = new Color(0, 0, 0);

	  private static final Color[] COLOUR_BG = new Color[] {
        new Color(205, 193, 180), // 0
        new Color(238, 228, 218), // 2
        new Color(237, 224, 200), // 4
        new Color(242, 177, 121), // 8
        new Color(245, 149, 99), // 16
        new Color(247, 124, 95), // 32
        new Color(246, 94, 59), // 64
        new Color(244, 216, 107), // 128
        new Color(242, 208, 75), // 256
        new Color(228, 193, 42), // 512
        new Color(227, 186, 19), // 1024
        new Color(236, 196, 2) // 2048
    };

    private static final Color[] COLOUR_FONT = new Color[]{
        new Color(205, 193, 180), //0
        new Color(119, 110, 101), //2
        new Color(119, 110, 101), //4
        new Color(249, 246, 242), //8
        new Color(249, 246, 242), // 16
        new Color(249, 246, 242), // 32
        new Color(249, 246, 242), // 64
        new Color(249, 246, 242), // 128
        new Color(249, 246, 242), // 256
        new Color(249, 246, 242), // 512
        new Color(249, 246, 242), // 1024
        new Color(249, 246, 242), // 2048
    };

/**
* @brief This is the constructor for the ADT
* @param val This is the value of the tile
*/
	public TileT(int val) {
        if (val < 0) {
            throw new IllegalArgumentException("Value cannot be less than 0");
        }
		this.value = val;
	    this.setColour(); //sets the colours of the tiles
	}

/**
* @brief Getter for the value
* @return Integer value of the tile
*/
	public int getVal() {
		return this.value;
	}

/**
* @brief Setter for the value of the tile
* @param val the value of the tile
*/
    public void setVal(int val) {
        if (val < 0) {
            throw new IllegalArgumentException("Value cannot be less than 0");
        }
        this.value = val;
    }

/**
* @brief Setter for the colour of the tile. This does not take in any parameters as it uses the value of the tile to set the tile colour.
*/
    public void setColour() {
        int colourIndex;
        if (this.value == 0) {
            colourIndex = 0;
        }
        else {
        colourIndex = (int) (Math.log(this.value) / Math.log(2));
    }
        this.colourBG = COLOUR_BG[colourIndex];
        this.colourFONT = COLOUR_FONT[colourIndex];

    }

/**
* @brief Getter for the background colour
* @return Color the color of the background of the tile
*/
    public Color getBG() {
        return this.colourBG;
    }
/**
* @brief Getter for the font colour
* @return Color the color of the font in the tile
*/
    public Color getFONT() {
        return this.colourFONT;
    }


}