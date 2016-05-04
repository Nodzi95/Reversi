/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.ija2015.homework2.board;

import java.util.List;

/**
 *
 * @author vratislav
 */
public class BorderField implements Field {
    public BorderField() {
        
    }
    
    @Override
    public void addNextField(Field.Direction dirs, Field field) {
    }
    
    @Override
    public Field nextField(Field.Direction dirs) {
        return null;
    }
    
    @Override
    public boolean putDisk(Disk disk) {
        return false;
    }
    
    @Override
    public Disk getDisk() {
        return null;
    }
    
    @Override
    public boolean isEmpty() {
        return true;
    }
    
    @Override
    public boolean canPutDisk(ija.ija2015.homework2.board.Disk disk) {
        return false;
    }

    @Override
    public boolean process(Field field, Disk disk, Direction dir) {
        return false;
    }
    
}
