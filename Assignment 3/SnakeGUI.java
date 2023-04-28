/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import javax.swing.*;
import java.awt.*;

public class SnakeGUI {
    private JFrame frame;
    private GameEngine gameArea;
    private Timer timer;
    private long startTime;
    private JLabel timeLabel;
    /**
     * Snake GUI constructor
     */
    public SnakeGUI() {
        frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);
        JMenuItem highmenu = new JMenuItem("Highscore Table");
        gameMenu.add(highmenu);
        gameArea = new GameEngine();
        frame.getContentPane().add(gameArea);
        frame.getContentPane().add(gameArea.getBoardPanel(), BorderLayout.SOUTH);


        frame.setPreferredSize(new Dimension(800, 600));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

}
