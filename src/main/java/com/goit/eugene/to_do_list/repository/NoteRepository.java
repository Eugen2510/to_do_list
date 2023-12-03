package com.goit.eugene.to_do_list.repository;

import com.goit.eugene.to_do_list.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
//    @Query("FROM Note n WHERE LOWER(n.title) LIKE %LOWER(:request)%")
    List<Note> findByTitleContainingIgnoreCase(/*@Param("request")*/ String request);
}
