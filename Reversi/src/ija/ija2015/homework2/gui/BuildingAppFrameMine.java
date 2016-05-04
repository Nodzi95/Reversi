/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2.gui;

import ija.ija2015.homework2.board.Board;
import ija.ija2015.homework2.game.Game;
import ija.ija2015.homework2.game.Player;
import ija.ija2015.homework2.game.ReversiRules;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;


/**
 *
 * @author vratislav
 */
public class BuildingAppFrameMine extends JFrame {
    private JRadioButton six, eight, ten, twelve, AI1, AI2, noAI;
    private JButton okButton;
    
    public BuildingAppFrameMine() {
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Othello Reversi");
        this.setResizable(false);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        six = new JRadioButton("6x6");
        eight = new JRadioButton("8x8");
        ten = new JRadioButton("10x10");
        twelve = new JRadioButton("12x12");
        AI1 = new JRadioButton("AI1");
        AI2 = new JRadioButton("AI2");
        noAI = new JRadioButton("2 Players");
        
        ButtonGroup boardSize = new ButtonGroup();
        
        boardSize.add(six);
        boardSize.add(eight);
        boardSize.add(ten);
        boardSize.add(twelve);
        
        JPanel boardSizePanel = new JPanel();
        
        Border radButtonsBorder = BorderFactory.createTitledBorder("Size of board");
        boardSizePanel.setBorder(radButtonsBorder);
        
        boardSizePanel.add(six);
        boardSizePanel.add(eight);
        boardSizePanel.add(ten);
        boardSizePanel.add(twelve);
        
        eight.setSelected(true);
        boardSizePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(boardSizePanel);
        
        ButtonGroup artificialInt = new ButtonGroup();
        artificialInt.add(noAI);
        artificialInt.add(AI1);
        artificialInt.add(AI2);
        
        JPanel artificialIntPanel = new JPanel();
        
        Border aiButtonsBorder = BorderFactory.createTitledBorder("Artificial intelligence");
        
        artificialIntPanel.setBorder(aiButtonsBorder);
        artificialIntPanel.add(noAI);
        artificialIntPanel.add(AI1);
        artificialIntPanel.add(AI2);
        
        noAI.setSelected(true);
        
        artificialIntPanel.setAlignmentX(Component.CENTER_ALIGNMENT);;
        panel.add(artificialIntPanel);
        
        okButton = new JButton("OK");
        
        OkButtonListener okListener = new OkButtonListener();
        
        okButton.addActionListener(okListener);
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(okButton);
        
        this.add(panel);
        this.setVisible(true);
    }
    
    private class OkButtonListener implements ActionListener{
        
        private int size, aiType;
        boolean isAI;
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if (six.isSelected()) {
                size = 6;
            }
            else if (eight.isSelected()) {
                size = 8;
            }
            else if (ten.isSelected()) {
                size = 10;
            }
            else {
                size = 12;
            }
            if (noAI.isSelected()) {
                aiType = 0;
                isAI = false;
            }
            else if (AI1.isSelected()) {
                aiType = 1;
                isAI = true;
            }
            else {
                aiType = 2;
                isAI = true;
            }
            ReversiRules rules = new ReversiRules(size);
            Board board = new Board(rules);
            Game game = new Game(board);
            Player player1 = new Player(true, false);
            Player player2 = new Player(false, isAI);
            game.addPlayer(player1);
            game.addPlayer(player2);
            new GameFrame(game, aiType);
        }
    }
}
