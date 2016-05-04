package ija.ija2015.homework2.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import ija.ija2015.homework2.Othello;
import ija.ija2015.homework2.game.Game;

public class BuildingAppFrame {
	private final Game game;
	private JFrame frame;
	private final GBoard gb;
	private final JMenuBar menuBar;
	
	public BuildingAppFrame(Game g){
		JMenu menu;
		JMenuItem menuItem;
		this.game = g;
		
		frame = new JFrame("Othello");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WListener());
		frame.setLocation(200, 200);
		
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		menuBar.add(menu);
		
		menuItem = new JMenuItem("Nova hra 6x6");
		menuItem.addActionListener((ActionEvent e) -> {
			new Othello(6);
		});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Nova hra 8x8");
		menuItem.addActionListener((ActionEvent e) -> {
			new Othello(8);
		});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Nova hra 10x10");
		menuItem.addActionListener((ActionEvent e) -> {
			new Othello(10);
		});
		menu.add(menuItem);
		
		
		menuItem = new JMenuItem("Nova hra 12x12");
		menuItem.addActionListener((ActionEvent e) -> {
			new Othello(12);
		});
		menu.add(menuItem);
		
		menu.addSeparator();
		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener((ActionEvent e) -> {
			destroy();
			frame.setVisible(false);
			//System.exit(0);
		});
		menu.add(menuItem);
		
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		
		gb = new GBoard(game);
		
		frame.getContentPane().add(createTop(), BorderLayout.NORTH);
		frame.getContentPane().add(createSide(1), BorderLayout.WEST);
		frame.getContentPane().add(createSide(2), BorderLayout.EAST);
		frame.getContentPane().add(gb, BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);
		
	}
	public Label createLabel(String text){
		Font font = new Font("Courier", Font.BOLD,15);
		Label label = new Label();
		label.setAlignment(Label.CENTER);
		label.setText(text);
		label.setFont(font);
		return label;
	}
	public JPanel createTop(){
		
		
		Label label1 = createLabel(game.getPlayer(1).toString());	
		Label label2 = createLabel("Score: " + game.getPlayer(1).getScore() + ":" + game.getPlayer(2).getScore());
		Label label3 = createLabel(game.getPlayer(2).toString());
		
		label1.setAlignment(Label.LEFT);
		label3.setAlignment(Label.RIGHT);
		JPanel panel = new JPanel(new GridLayout(1, 3));
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		
		return panel;
	}
	
	public JPanel createSide(int i){
		Label label1 = createLabel("Pocet kamenu");
		Label label2 = createLabel("" + game.getPlayer(i).getDisks());
		
		JPanel panel = new JPanel(new GridLayout(2, 1));
		panel.add(label1);
		panel.add(label2);
		return panel;
	}
	
	private void destroy() {
		System.out.println("Zaviram....");
		
	}
	private class WListener extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			destroy();
		}
	}
}
