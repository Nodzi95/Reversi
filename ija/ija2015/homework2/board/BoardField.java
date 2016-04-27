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
public class BoardField implements Field {
    private int row;
    private int col;
    private Disk disk;
    private static int counter;
    private Field[] neighbours = new Field[9];
    public BoardField(int row, int col) {
        this.row = row;
        this.col = col;
        if ((row == 4 && col == 4) || (row == 5 && col == 5)) {
            this.disk = new Disk(true);
        }
        else if ((row == 4 && col == 5) || (row == 5 && col == 4)) {
            this.disk = new Disk(false);
        }
    }
    
    public static int getScoreChange() {
        return counter;
    }
    /*@Override
    public boolean putDisk(Disk disk) {
        if (null != this.disk) {
            return false;
        }
        this.disk = disk;
        return true;
    }*/

    @Override
    public Disk getDisk() {
        return this.disk;
    }
    @Override
    public void addNextField(Field.Direction dirs, Field field) {
        neighbours[3 * (dirs.row() + 1) + (dirs.col()+1)] = field;
    }
    @Override
    public Field nextField(Field.Direction dirs) {
        return neighbours[3 * (dirs.row() + 1) + (dirs.col()+1)];
    }
    
    @Override
    public boolean isEmpty() {
        if (this.disk == null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public boolean process(Field field, Disk disk, Field.Direction dir) {
        if (field.isEmpty()) {
            return false;
        }
        else {
            if (field.getDisk().equals(disk)) {
                return true;
            }
            else {
                if (field.process(field.nextField(dir), disk, dir)) {
                    field.getDisk().turn();
                    counter++;
                    return true;
                }
                else {
                    return false;
                }
            }
        }
    }
    
    @Override
    public boolean canPutDisk(ija.ija2015.homework2.board.Disk disk) {
        if (this.isEmpty()) {
            for (Field.Direction dir : Field.Direction.values()) {
                Field field = this.nextField(dir);
                if (!disk.equals(field.getDisk())) {
                    while (!disk.equals(field.getDisk()) && !field.isEmpty()) {
                        field = field.nextField(dir);
                    }
                    //staci nam vedet, ze existuje alespon 1 platny smer
                    if (disk.equals(field.getDisk())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean putDisk(ija.ija2015.homework2.board.Disk disk) {
        counter = 0;
        if (this.canPutDisk(disk)) {
            this.disk = disk;
            for (Field.Direction dir : Field.Direction.values()) {
                if (!disk.equals(this.nextField(dir).getDisk())) {
                    this.process(this.nextField(dir), disk, dir);
                }
            }
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof BoardField) {
            return ((this.row == ((BoardField) o).row) && (this.col == ((BoardField) o).col));
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.row;
        hash = 29 * hash + this.col;
        return hash;
    }

    
    
}
