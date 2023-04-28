/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SecondAssignment;

/**
 *
 * @author Mahammad Isayev
 */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FourGameGUI {
    private JFrame frame;
    private BoardGUI boardGUI;
    private final int Bsize = 3;

    /**
     * Creates a new frame and adds the board and the buttons as well
     * , other than that it create the menu bar and implemets the
     * event handlers.
     */
    public FourGameGUI() {
        frame = new JFrame("SecondAssignment.FourGame");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        boardGUI = new BoardGUI(Bsize);
        frame.getContentPane().add(boardGUI.getBoardPanel(), BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);
        JMenu newMenu = new JMenu("New");
        gameMenu.add(newMenu);
        int[] bSizes = { 3, 5, 7 };
        for (int size : bSizes) {
            JMenuItem sizeMenu = new JMenuItem(size + "x" + size);
            newMenu.add(sizeMenu);
            sizeMenu.addActionListener(new ActionListener() {
                /**
                 * So basically this is called in every size when its assigned to the frame and
                 * what it does it’s that removes the current board and creates a new one
                 * based on the size that we clicked on and then adds it back to the frame.
                 * 
                 * @param e
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.getContentPane().remove(boardGUI.getBoardPanel());
                    boardGUI = new BoardGUI(size);
                    frame.getContentPane().add(boardGUI.getBoardPanel(), BorderLayout.CENTER);
                    frame.pack();

                }
            });
        }
        JMenuItem exitMenu = new JMenuItem("Exit");
        gameMenu.add(exitMenu);
        exitMenu.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);

    }
}

