/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2.game;

import ija.ija2015.homework2.board.Board;
import ija.ija2015.homework2.board.Disk;
import ija.ija2015.homework2.board.Field;

/**
 *
 * @author vratislav
 */
public class Player {
    private boolean isWhite, isAI;
    private int score;
    
    public Player(boolean isWhite, boolean isAI) {
        this.isWhite = isWhite;
        this.isAI = isAI;
    }
    
    public boolean emptyPool() {
        if (this.score > 0) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public boolean isWhite() {
        return this.isWhite;
    }
    
    public boolean isAI() {
        return this.isAI;
    }
    
    public void init(Board board) {
        this.score = 2;
    }
    
    public boolean canPutDisk(Field field) {
        Disk disk = new Disk(this.isWhite);
        if (field.canPutDisk(disk)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean putDisk(Field field) {
        if (this.canPutDisk(field)) {
            if (field.putDisk(new Disk(this.isWhite))) {
                return true;
            }
        }
        return false;
    }
    
    public void modifyScore(int value) {
        this.score += value;
    }
    
    /*public int getDisks(){
    	return numberOfDisks;
    }*/
    
    public int getScore(){
    	return score;
    }
    @Override
    public String toString() {
        if (this.isWhite) {
            return "white";
        }
        else {
            return "black";
        }
    }
}
