/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2;

import ija.ija2015.homework2.board.Board;
import ija.ija2015.homework2.board.BoardField;
import ija.ija2015.homework2.board.Field;
import ija.ija2015.homework2.game.Game;
import ija.ija2015.homework2.game.ReversiRules;
import ija.ija2015.homework2.game.Player;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;


import static org.junit.Assert.*;

import java.util.Arrays;



/**
 * Test 2. ukolu.
 * @author koci
 */
public class Homework2Test {

	@Test
    public void testGame() {
        System.out.println("Game");
        int size = 8;
        
        ReversiRules rules = new ReversiRules(size);
        Board board = new Board(rules);
        Game game = new Game(board);
        
        Player p1 = new Player(true);
        Player p2 = new Player(false);
        
        game.addPlayer(p1);
        game.addPlayer(p2);

        Field[][] save = new Field[size+2][size+2];
        Field[][] load = null;
        load = game.getBoard().saveFields();
        
        //save = SerializationUtils.clone(load);
        /*Cloner cloner = new Cloner();
        save = cloner.deepClone(load);*/
        /*
        for(int i = 0; i <= size +1; i++){
        	//System.arraycopy(load[i], 0, save[i], 0, 10);
        	save[i] = load[i].clone();
        }*/
        save = Arrays.stream(load).map(x -> x.clone()).toArray(Field[][]::new);

        System.out.println("save " +save[4][5].getDisk());
        //System.out.println(game.getBoard().getField(4, 5).getDisk());
        Field f2 = game.getBoard().getField(4, 6);
        assertTrue("Umisteni kamene.", game.currentPlayer().putDisk(f2));
        
        
        
        
        System.out.println("save " +save[4][5].getDisk());
        //System.out.println(game.getBoard().getField(4, 5).getDisk());
        /*for(int i = 1; i <= 8; i++){
        	for(int j = 1; j <= 8; j++){
        		System.out.print(" " +game.getBoard().getField(i, j).getDisk() + " |");
        	}
        	System.out.println();
        }
        System.out.println();
        
        //game.getBoard().loadFields(save.get(0));
        
        for(int i = 1; i <= 8; i++){
        	for(int j = 1; j <= 8; j++){
        		System.out.print(" " +game.getBoard().getField(i, j).getDisk() + " |");
        	}
        	System.out.println();
        }
        System.out.println();*/
    }   
}
