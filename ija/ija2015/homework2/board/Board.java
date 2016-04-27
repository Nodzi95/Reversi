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
public class Board {
    private Field[][] fieldArray;
    private Rules rules;
    
    public Board(Rules rules) {
        this.rules = rules;
        fieldArray = new Field[rules.getSize()+2][rules.getSize()+2];
        for (int row = 0; row <= rules.getSize()+1; row++) {
            for (int col = 0; col <= rules.getSize()+1; col++) {
                fieldArray[row][col] = rules.createField(row, col);
            }
        }
        for (int row = 1; row <= rules.getSize(); row++) {
            for (int col = 1; col <= rules.getSize(); col++) {
                for (Field.Direction dir : Field.Direction.values()) {
                    fieldArray[row][col].addNextField(dir, fieldArray[row + dir.row()][col + dir.col()]);
                }
            }
        }
    }
    
    public int getSize() {
        return rules.getSize();
    }
    
    public Field getField(int row, int col) {
        return fieldArray[row][col];
    }
    
    public Rules getRules() {
        return this.rules;
    }
}
