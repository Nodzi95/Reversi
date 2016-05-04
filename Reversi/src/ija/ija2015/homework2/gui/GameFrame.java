/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2.gui;


import ija.ija2015.homework2.board.Field;
import ija.ija2015.homework2.game.Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author vratislav
 */
public class GameFrame extends JFrame {
    private final Game game;
    private JPanel gamePanel, buttonPanel, playerPanel, rowNumbers, colNumbers;
    private JMenuBar menu;
    private int size, aiType;
    private JButton[][] buttonArray;
    private boolean isEqual, gameOver;
    private Field field;
    private JLabel label1, label2, label3;
    
    public GameFrame(Game game, int aiType) {
        this.size = game.getBoard().getSize();
        this.aiType = aiType;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.game = game;
        this.setTitle("Othello");
        
        gamePanel = new JPanel();

        playerPanel = new JPanel(/*new GridLayout(0, 4, 50, 30)*/);
        
        Font font = new Font("Courier", Font.BOLD, 15);
        
        label1 = new JLabel(game.getPlayer(1).toString()+ "   ");
        label1.setFont(font);
	label2 = new JLabel("Score: " + game.getPlayer(1).getScore() + ":" + game.getPlayer(2).getScore());
	label2.setFont(font);
        label3 = new JLabel("   " + game.getPlayer(2).toString());
        label3.setFont(font);
        
        
        label1.setAlignmentX(LEFT_ALIGNMENT);
        label2.setAlignmentX(CENTER_ALIGNMENT);
        label3.setAlignmentX(RIGHT_ALIGNMENT);
        playerPanel.add(label1);
        playerPanel.add(label2);
        playerPanel.add(label3);
        
        
        this.getContentPane().add(playerPanel, BorderLayout.NORTH);
        
        rowNumbers = new JPanel(new GridLayout(0, 1));
        for (int i = 1; i <= size; i++) {
            rowNumbers.add(new JLabel("  " + Integer.toString(i) + "  "));
        }
        
        colNumbers = new JPanel(new GridLayout(1, 0));
        colNumbers.add(new JLabel(" "));
        for (int i = 1; i <= size; i++) {
            colNumbers.add(new JLabel(Integer.toString(i)));
        }
        
        
        this.getContentPane().add(rowNumbers, BorderLayout.WEST);
        this.getContentPane().add(colNumbers, BorderLayout.SOUTH);
        this.getContentPane().add(new JPanel().add(new JLabel("    ")), BorderLayout.EAST);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, size));
        buttonArray = new JButton[size][size];
        Border buttonBorder = new LineBorder(Color.red, 1);
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                buttonArray[x][y] = new JButton("");
                buttonArray[x][y].setBorder(buttonBorder);
                buttonArray[x][y].setPreferredSize(new Dimension(40, 40));
                ButtonListener buttonListener = new ButtonListener();
                buttonArray[x][y].addActionListener(buttonListener);
                buttonPanel.add(buttonArray[x][y]);
            }
        }
        showChanges();
        buttonPanel.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
        this.getContentPane().add(buttonPanel, BorderLayout.CENTER);
        this.pack();
        this.add(gamePanel);
        this.setResizable(false);
        this.setVisible(true);
        
    }
    
    
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            isEqual = false;
            gameOver = true;
            //Field field;
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    if (e.getSource().equals(buttonArray[x][y])) {
                        field = game.getBoard().getField(x+1, y+1);
                        if (game.currentPlayer().putDisk(field)) {
                            game.nextPlayer();
                            showChanges();
                            if (game.currentPlayer().isAI()) {
                                if (aiType == 1) {
                                    ai1();
                                }
                                else {
                                    ai2();
                                }
                            }
                        }
                        else {
                            showMessageDialog(null, "Invalid move");
                        }
                        isEqual = true;
                    }
                }
                if (isEqual) {
                    break;
                }
            }
        }        
    }
    
    private void showChanges() {
        gameOver = true;
        
        for (int x = 1; x <= size; x++) {
            for (int y = 1; y <= size; y++) {
                field = game.getBoard().getField(x, y);
                if (game.currentPlayer().canPutDisk(field)) {
                    buttonArray[x-1][y-1].setBackground(Color.GRAY);
                    gameOver = false;
                }
                else if (!field.isEmpty()) {
                    if (field.getDisk().isWhite()) {
                        buttonArray[x-1][y-1].setBackground(Color.WHITE);
                        buttonArray[x-1][y-1].setEnabled(false);
                    }
                    else {
                        buttonArray[x-1][y-1].setBackground(Color.BLACK);
                        buttonArray[x-1][y-1].setEnabled(false);
                    }
                }
                else {
                    buttonArray[x-1][y-1].setBackground(Color.GREEN);
                }
            }
        }
        label2.setText("Score: " + game.getPlayer(1).getScore() + ":" + game.getPlayer(2).getScore());
        if (gameOver) {
            showMessageDialog(null, "Game over!");
        }
    }
    
    private void ai1() {
        for (int row = 1; row <= size; row++) {
            for (int col = 1; col <= size; col++) {
                field = game.getBoard().getField(row, col);
                if (game.currentPlayer().putDisk(field)) {
                    row = size + 1;
                }
            }
        }
        showChanges();
        if (!gameOver) {
            game.nextPlayer();
            showChanges();
        }
    }
    
    private void ai2() {
        for (int row = size; row > 0; row--) {
            for (int col = size; col > 0; col--) {
                field = game.getBoard().getField(row, col);
                if (game.currentPlayer().putDisk(field)) {
                    row = 0;
                }
            }
        }
        showChanges();
        if (!gameOver) {
            game.nextPlayer();
            showChanges();
        }
    }
    
}

