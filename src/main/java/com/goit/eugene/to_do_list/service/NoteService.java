package com.goit.eugene.to_do_list.service;


import com.goit.eugene.to_do_list.entity.Note;
import com.goit.eugene.to_do_list.noteexceptions.NoSuchNoteException;
import com.goit.eugene.to_do_list.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public List<Note> listAll(){
        return noteRepository.findAll();
    }

    public Note add(Note note){
        return noteRepository.save(note);
    }

    public void deleteById(long id){
        noteRepository.deleteById(id);
    }

    public void update(Note note){
        noteRepository.save(note);
    }

    public Note getById(long id){
        return noteRepository.findById(id).orElseThrow(NoSuchNoteException::new);
    }

    public List<Note> findByTitle(String request){
        return noteRepository.findByTitleContainingIgnoreCase(request);
    }

}
