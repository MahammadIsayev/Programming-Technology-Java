/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SecondAssignment;

/**
 *
 * @author Mahammad Isayev
 */

import java.awt.Color;

public class Field {
    private int score;
    private Color color;

    /**
     * Creates a new Field
     */
    public Field() {
        score = 0;
        color = null;
    }

    public Color getColor() {
        return color;
    }

    public int getScore() {
        return score;
    }

    public void setColor(Color color) {
        if (color == null) {
            this.color = null;
        }
        this.color = color;

    }

    public void setScore(int score) {
        this.score += score;

    }
}
