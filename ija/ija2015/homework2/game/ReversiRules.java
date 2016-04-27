/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2.game;

import ija.ija2015.homework2.board.BoardField;
import ija.ija2015.homework2.board.BorderField;
import ija.ija2015.homework2.board.Field;
import ija.ija2015.homework2.board.Rules;

/**
 *
 * @author vratislav
 */
public class ReversiRules implements Rules{
    private int size;
    public ReversiRules(int size) {
        this.size = size;
    }
    
    @Override
    public Field createField(int row, int col) {
        if ((row > 0 && row <= size) && (col > 0 && col <= size)) {
            return new BoardField(row, col);
        }
        else {
            return new BorderField();       
        }
    } 
    
    @Override
    public int getSize() {
        return this.size;
    }
    
    @Override
    public int numberDisks() {
        return (this.size * this.size / 2);
    }
}
