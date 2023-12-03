package com.goit.eugene.to_do_list.noteexceptions;

public class NoSuchNoteException extends IllegalArgumentException{
    public NoSuchNoteException(){
        super("You such note exists");
    }
}
