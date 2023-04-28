/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SecondAssignment;

/**
 *
 * @author Mahammad Isayev
 */

import java.awt.Point;

public class Board {
    private Field[][] board;
    private final int boardsize;
    protected int countClick = 0;

    /**
     * Takes a boardsize as a parameter and then
     * based on the size it implements a new Board
     * object
     * 
     * @param boardsize
     */
    public Board(int boardsize) {
        this.boardsize = boardsize;
        board = new Field[this.boardsize][this.boardsize];
        for (int i = 0; i < this.boardsize; i++) {
            for (int j = 0; j < this.boardsize; j++) {
                board[i][j] = new Field();
            }
        }
    }

    /**
     * Checks whether all the fields in the board are colorized
     * if one of them is not it will return false otherwise it returns true
     * 
     * @return
     */
    public boolean isOver() {
        for (int i = 0; i < this.boardsize; i++) {
            for (int j = 0; j < this.boardsize; j++) {
                if (board[i][j].getColor() == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public Field getField(int x, int y) {
        return board[x][y];
    }

    public Field getField(Point p) {
        return board[(int) p.getX()][(int) p.getY()];
    }

    public int getBoardsize() {
        return this.boardsize;

    }

}
