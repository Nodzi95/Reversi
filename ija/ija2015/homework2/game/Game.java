/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2.game;

import ija.ija2015.homework2.board.Board;
/**
 *
 * @author vratislav
 */
public class Game {
    private Board board;
    private Player black;
    private Player white;
    private Player current;
    
    public Game(Board board) {
        this.board = board;
       // this.current = white;
    }
    
    public boolean addPlayer(Player player) {
        if (player.isWhite()) {
            if (this.white == null) {
                this.white = player;
                this.current = player;
            }
            else {
                return false;
            }
        }
        else {
            if (this.black == null) {
                this.black = player;
            }
            else {
                return false;
            }
        }
        player.init(this.board);
        return true;
    }
    
    public Player currentPlayer() {
        return this.current;
    }
    
    public Player nextPlayer() {
        this.current.modifyScore(ija.ija2015.homework2.board.BoardField.getScoreChange());
        if (this.current.equals(this.white)) {
            this.current = this.black;
            this.current.modifyScore(-ija.ija2015.homework2.board.BoardField.getScoreChange());
            return this.current;
        }
        else {
            this.current = this.white;
            this.current.modifyScore(-ija.ija2015.homework2.board.BoardField.getScoreChange());
            return this.current;
        }
    }
    
    public Board getBoard() {
        return this.board;
    }
}
