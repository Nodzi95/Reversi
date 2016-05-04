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
public interface Field {
    void addNextField(Field.Direction dirs, Field field);
    boolean canPutDisk(ija.ija2015.homework2.board.Disk disk);
    ija.ija2015.homework2.board.Disk getDisk();
    boolean isEmpty();
    Field nextField(Field.Direction dirs);
    boolean putDisk(Disk disk);

    public boolean process(Field field, Disk disk, Direction dir);
    public static enum Direction {
        D (1, 0),
        L (0, -1),
        LD (1, -1),
        LU (-1, -1),
        R (0, 1),
        RD (1, 1),
        RU (-1, 1),
        U (-1, 0);
        private final int row;
        private final int col;
        Direction(int row, int col) {
            this.row = row;
            this.col = col;
        }
        public int row() {
            return row;
        }
        public int col() {
            return col;
        }
    }
}
