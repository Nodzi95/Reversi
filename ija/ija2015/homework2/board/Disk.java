/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2.board;

/**
 *
 * @author vratislav
 */
public class Disk {
    private boolean isWhite;
    public Disk(boolean isWhite) {
        this.isWhite = isWhite;
    }
    public void turn() {
        this.isWhite = !this.isWhite;
    }
    public boolean isWhite() {
        return this.isWhite;
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Disk) {
            Disk c = (Disk) o;
            return (isWhite == c.isWhite);
        }
        else {
            return false;
        }
    }    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.isWhite ? 1 : 0);
        return hash;
    }
    public String toString() {
		if(this.isWhite()) return "white";
		else return "black";
	}
}
