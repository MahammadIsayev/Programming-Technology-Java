/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Databases {
    public Databases(String name, int score, HighScores hs) {
        try {
            HighScore highS = new HighScore(name, score);
            hs.putHighScore(name, score);
        } catch (SQLException ex) {
            Logger.getLogger(Databases.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
