package com.goit.eugene.to_do_list.service;


import com.goit.eugene.to_do_list.entity.Note;
import com.goit.eugene.to_do_list.entity.User;
import com.goit.eugene.to_do_list.noteexceptions.NoSuchNoteException;
import com.goit.eugene.to_do_list.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;
    private final UserService userService;


    public List<Note> listAllUsersNote(String username){
        User userById = userService.getUserById(username);
        return noteRepository.findNotesByUser(userById);
    }


    public Note add(Note note){
        return noteRepository.save(note);
    }

    public void deleteById(long id){
        Note byId = getById(id);
        User user = byId.getUser();
        user.getNotes().remove(byId);
        noteRepository.deleteById(id);
    }

    public void update(Note note){
        noteRepository.save(note);
    }

    public Note getById(long id){
        return noteRepository.findById(id).orElseThrow(NoSuchNoteException::new);
    }

    public List<Note> findByTitle(String username, String request){
        User user = userService.getUserById(username);
        return noteRepository.findNotesByUserAndTitleContainingIgnoreCase(user, request);
    }

}
