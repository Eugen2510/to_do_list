package com.goit.eugene.to_do_list.repository;

import com.goit.eugene.to_do_list.entity.Note;
import com.goit.eugene.to_do_list.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
//    @Query("FROM Note n WHERE LOWER(n.title) LIKE %LOWER(:request)%")

    List<Note> findNotesByUser(User user);
    List<Note> findNotesByUserAndTitleContainingIgnoreCase( User user, String request);
}
