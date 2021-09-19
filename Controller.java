/**
 * @file Game2048.java
 * @author Mehak Khan
 * @brief A library for the controller module
 * @date 4th April 2021
 */
package src;
import java.awt.event.KeyEvent;
/**
@brief The library module that contains the method to control user input from the keyboard
*/

public class Controller extends Game2048 {
    
/**
* @brief This method is detected each time a key is pressed 
* @param evt The KeyEvent that was detected on the keyboard
*/
     public static void formKeyPressed(KeyEvent evt) {

        //System.out.print("KEY PRESSED: ");
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                //System.out.println("UP");
                operations.move(Direction.UP);
                updateGameBoard();
                break;

            case KeyEvent.VK_DOWN:
                //System.out.println("DOWN");
                operations.move(Direction.DOWN);
                updateGameBoard();
                break;

            case KeyEvent.VK_LEFT:
                //System.out.println("LEFT");
                operations.move(Direction.LEFT);
                updateGameBoard();
                break;

            case KeyEvent.VK_RIGHT:
                //System.out.println("RIGHT");
                operations.move(Direction.RIGHT);
                updateGameBoard();
                break;

        }
    }
    
}