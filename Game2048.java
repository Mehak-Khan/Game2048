/**
 * @file Game2048.java
 * @author Mehak Khan
 * @brief A GUI for the game 2048
 * @date 4th April 2021
 */
package src;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;

/**
 * @brief An ADT that implements the GUI of the game to view and control
 */
public class Game2048 {

    protected static Operations operations = Operations.Instance();
    protected static JTextField textField[][] = new JTextField[GameBoard.getSize()][GameBoard.getSize()];
    protected static JTextField score = new JTextField();
    protected static JTextField highscore = new JTextField();
    protected static JFrame frame;
    protected static JPanel panel, panel_score, panel_hscore, newG;
    protected static JLabel jLabelGameOver, Score, HighScore;
    protected static JButton newGame;
    protected static Font font = new Font(Font.SERIF, Font.BOLD, 30);

 /**
 * @brief Constructor for game 2048 that starts the game
 */
     public Game2048() {
        gui_game();
        operations = Operations.Instance();
        operations.startGame();
        updateGameBoard();
                
        
    }

/**
* @brief This method initializes the frame and all the labels that are required by the GUI
* @details The method initialized the window, and in the window it adds the labels for score, highscore, and the textfields for the tiles. Finally, it adds a button to start a new game.
*/
    public static void gui_game() {

        jLabelGameOver = new JLabel("GAME OVER");
        Score = new JLabel("SCORE");
        HighScore = new JLabel("HIGHSCORE");

        newGame = new JButton("NEW GAME");
        newG = new JPanel();
        newG.add(newGame);
        panel = new JPanel();
        panel_score = new JPanel();
        panel_hscore = new JPanel();
       
        frame = new JFrame("2048");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNewGameActionPerformed(evt);

            }
        });


        frame.add(jLabelGameOver, BorderLayout.EAST);
        frame.add(newG, BorderLayout.WEST);
        frame.add(panel_score, BorderLayout.NORTH);
        frame.add(panel);
        frame.add(panel_hscore, BorderLayout.SOUTH);

        panel.setLayout(new GridLayout(GameBoard.getSize(), GameBoard.getSize()));

        setTiles(); 

        panel_score.add(Score, BorderLayout.NORTH);
        panel_score.add(score, BorderLayout.NORTH);
        panel_hscore.add(HighScore, BorderLayout.SOUTH);
        panel_hscore.add(highscore, BorderLayout.SOUTH);

        highscore.setBackground(Color.cyan);
        score.setColumns(5);
        highscore.setColumns(5);
        score.setBackground(Color.yellow);
        score.setEditable(false);
        highscore.setEditable(false);
        frame.setVisible(true);

        frame.setSize(1000, 1000);
        newG.setFocusable(false);
        newGame.setFocusable(false);
        frame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                Controller.formKeyPressed(evt);
            }
        });
        frame.setFocusable(true);

    }
/**
* @brief This method initializes the tile fields
*/
        private static void setTiles() {

        for (int i = 0; i < GameBoard.getSize(); i++) {
            for (int j = 0; j < GameBoard.getSize(); j++) {
                JTextField t_field = new JTextField();
                textField[i][j] = new JTextField();
                textField[i][j].setEditable(false);
                textField[i][j].setFont(font);
                textField[i][j].setHorizontalAlignment(JTextField.CENTER);
                panel.add(textField[i][j]);
            }
        }

    }


/**
* @brief This method is called each time a new game button is pressed
* @param evt the ActionEvent that occurs when new button is pressed
*/
    private static void jButtonNewGameActionPerformed(java.awt.event.ActionEvent evt) {
       
        operations.restartGame();
        updateGameBoard();


    }

/**
* @brief This method is used to update the game board everytime a change occurs in the tiles
* @details The method sets all the tiles to their current values and respective colours and sets the highscore and score.
*/
    public static void updateGameBoard() {
               for (int i = 0; i < GameBoard.getSize(); i++) {
            for (int j = 0; j < GameBoard.getSize(); j++) {
                textField[i][j].setText("");
                textField[i][j].setForeground(new Color(0, 0, 0));
                textField[i][j].setBackground(new Color(0,0,0));
               
            }
        }
        jLabelGameOver.setVisible(false);
        for (int i = 0; i < GameBoard.getSize(); i++) {
            for (int j = 0; j < GameBoard.getSize(); j++) {

                if (GameBoard.getGame()[i][j].getVal() != 0) {
                    textField[i][j].setText("" + GameBoard.getGame()[i][j].getVal());
                    GameBoard.getGame()[i][j].setColour();
                } else {
                    textField[i][j].setText("");
                }

                GameBoard.getGame()[i][j].setColour();
                textField[i][j].setForeground(GameBoard.getGame()[i][j].getFONT());
                textField[i][j].setBackground(GameBoard.getGame()[i][j].getBG());
                score.setText("" + GameBoard.getScore());
                operations.updateHighScore();
                highscore.setText("" + GameBoard.getHighScore());
              
            }
        }
    }


}