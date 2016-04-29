/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2;

import ija.ija2015.homework2.board.Board;
import ija.ija2015.homework2.game.Game;
import ija.ija2015.homework2.game.ReversiRules;
import ija.ija2015.homework2.gui.BuildingAppFrame;
import ija.ija2015.homework2.game.Player;


/**
 * Test 2. ukolu.
 * @author koci
 */
public class Othello {

	
	private final Game game;
	
	
	public static void main(String argv[]){
		int size = 8;
		new Othello(size);
	}
	
	public Othello(int size){
		
		//System.out.println(size);
		ReversiRules rules = new ReversiRules(size);
		Board board = new Board(rules);
        game = new Game(board);
        
        Player p1 = new Player(true);
        Player p2 = new Player(false);
        
        game.addPlayer(p1);
        game.addPlayer(p2);
        
        createAndShowGUI();
	}
	
	private void createAndShowGUI(){
		//JFrame.setDefaultLookAndFeelDecorated(true);
		new BuildingAppFrame(game);
	}
	
	
}
