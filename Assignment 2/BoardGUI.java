/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SecondAssignment;

/**
 *
 * @author Mahammad Isayev
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class BoardGUI {
    private JButton[][] buttons;
    private Board board;
    private JPanel boardPan;

    /**
     * This creates the board and the board panel
     * and implements the buttons as a 2D array
     * plus it implements the event handlers in the
     * buttons
     * 
     * @param boardsize
     */
    public BoardGUI(int boardsize) {
        board = new Board(boardsize);
        boardPan = new JPanel();
        boardPan.setLayout(new GridLayout(boardsize, boardsize));
        buttons = new JButton[boardsize][boardsize];
        for (int i = 0; i < boardsize; i++) {
            for (int j = 0; j < boardsize; j++) {
                JButton button = new JButton("0");
                button.addActionListener(new ButtonListener(i, j));
                button.setPreferredSize(new Dimension(80, 40));

                buttons[i][j] = button;
                boardPan.add(button);
            }
        }

    }

    /**
     * This takes the board as a parameter and resets it everything back by using
     * the loops.
     * 
     * @param board
     */
    public void resBoard(Board board) {
        for (int i = 0; i < board.getBoardsize(); i++) {
            for (int j = 0; j < board.getBoardsize(); j++) {
                board.getField(i, j).setScore(-4);
                board.getField(i, j).setColor(null);
                buttons[i][j].setBackground(null);
                buttons[i][j].setText("0");
            }

        }

    }

    /**
     * This takes the coordinates of the field and sets its background to the color
     * of the player.
     * 
     * @param x
     * @param y
     * @param c
     */
    public void colorize(int x, int y, Color c) {
        buttons[x][y].setBackground(c);
    }

    public JPanel getBoardPanel() {
        return boardPan;
    }

    class ButtonListener implements ActionListener {
        private int x, y;

        public ButtonListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Basically this implements the whole game first it goes by checking if the
         * button or its neighbors are colorized
         * and aren’t 4 if not then it will add up the score by one and if the scores
         * reaches 4 of the actual button or
         * its neighbors then the button will be colorized by the color of the player
         * which we count with the button clicks
         * so one player clicks on odd numbers of buttonclicks and the other on the even
         * numbers, after this it checks
         * whether the game its over and decides which of the player won then shows the
         * message and restarts the whole game
         * by calling resBoard().
         * 
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            if (board.getField(x, y).getColor() == null) {
                board.countClick++;
                for (int i = x - 1; i <= x + 1; i++) {
                    if (i >= 0 && i < board.getBoardsize()) {
                        if (board.getField(i, y).getScore() != 4 && board.getField(i, y).getColor() == null) {
                            board.getField(i, y).setScore(1);
                            int score = board.getField(i, y).getScore();
                            buttons[i][y].setText(Integer.toString(score));
                            if (score == 4) {
                                if (board.countClick % 2 == 0) {
                                    board.getField(i, y).setColor(Color.blue);
                                    colorize(i, y, Color.blue);
                                } else {
                                    board.getField(i, y).setColor(Color.red);
                                    colorize(i, y, Color.red);
                                }

                            }
                        } else if (board.getField(i, y).getColor() == null) {
                            if (board.countClick % 2 == 0) {
                                board.getField(i, y).setColor(Color.blue);
                                colorize(i, y, Color.blue);
                            } else {
                                board.getField(i, y).setColor(Color.red);
                                colorize(i, y, Color.red);
                            }
                        }

                    }
                }

                for (int j = y - 1; j <= y + 1; j++) {
                    if (j >= 0 && j < board.getBoardsize() && j != y) {
                        if (board.getField(x, j).getScore() != 4 && board.getField(x, j).getColor() == null) {
                            board.getField(x, j).setScore(1);
                            int score = board.getField(x, j).getScore();
                            buttons[x][j].setText(Integer.toString(score));
                            if (score == 4) {
                                if (board.countClick % 2 == 0) {
                                    board.getField(x, j).setColor(Color.blue);
                                    colorize(x, j, Color.blue);
                                } else {
                                    board.getField(x, j).setColor(Color.red);
                                    colorize(x, j, Color.red);
                                }

                            }
                        } else if (board.getField(x, j).getColor() == null) {
                            if (board.countClick % 2 == 0) {
                                board.getField(x, j).setColor(Color.blue);
                                colorize(x, j, Color.blue);
                            } else {
                                board.getField(x, j).setColor(Color.red);
                                colorize(x, j, Color.red);
                            }
                        }

                    }

                }

            }
            if (board.isOver()) {
                int cntB = 0;
                int cntR = 0;
                for (int i = 0; i < board.getBoardsize(); i++) {
                    for (int j = 0; j < board.getBoardsize(); j++) {
                        if (board.getField(i, j).getColor() == Color.red) {
                            cntR++;
                        } else {
                            cntB++;
                        }
                    }
                }
                if (cntB > cntR) {
                    JOptionPane.showMessageDialog(boardPan, "The blue player has won the game", "Congrats",
                            JOptionPane.PLAIN_MESSAGE);
                    resBoard(board);

                } else if (cntR > cntB) {
                    JOptionPane.showMessageDialog(boardPan, "The red player has won the game", "Congrats",
                            JOptionPane.PLAIN_MESSAGE);
                    resBoard(board);

                } else {
                    JOptionPane.showMessageDialog(boardPan, "Nobody won the game.", "TIE!",
                            JOptionPane.PLAIN_MESSAGE);
                    resBoard(board);

                }

            }
        }

    }
}
