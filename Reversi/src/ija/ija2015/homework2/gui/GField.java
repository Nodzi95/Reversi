package ija.ija2015.homework2.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import ija.ija2015.homework2.board.Field;

public class GField {
	private final Field field;
	private final GBoard board;
	
	GField(Field field, GBoard board){
		this.field = field;
		this.board = board;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Color oldC = g2.getColor();
	
		
	}
}
