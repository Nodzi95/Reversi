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
    private boolean isWhite;
    private int numberOfDisks;
    private int score;
    private Board board;
    public Player(boolean isWhite) {
        this.isWhite = isWhite;
        this.numberOfDisks = 0;
    }
    
    public boolean emptyPool() {
        if (this.numberOfDisks > 0) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public boolean isWhite() {
        return this.isWhite;
    }
    
    public void init(Board board) {
        this.board = board;
        this.numberOfDisks = board.getSize() * board.getSize() / 2;
        this.score = 2;
    }
    
    public boolean canPutDisk(Field field) {
        if (this.score < this.numberOfDisks) {
            Disk disk = new Disk(this.isWhite);
            if (field.canPutDisk(disk)) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
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
