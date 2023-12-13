package com.goit.eugene.to_do_list.controller;


import com.goit.eugene.to_do_list.security.PrincipalService;
import com.goit.eugene.to_do_list.service.NoteService;
import com.goit.eugene.to_do_list.entity.Note;
import com.goit.eugene.to_do_list.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RequiredArgsConstructor
@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;
    private final PrincipalService principalService;
    private final UserService userService;

    @GetMapping
    public String getWelcomePage() {
        return "note/welcome_page";
    }

    @GetMapping("/list")
    public ModelAndView getNotes() {
        ModelAndView modelAndView = new ModelAndView("note/note_list");
        modelAndView.addObject("notes", noteService
                .listAllUsersNote(principalService.getUsername()));
        return modelAndView;
    }

    @GetMapping("/create")
    public String showCreateNotePage() {
        return "note/create_note";
    }

    @PostMapping("/create")
    public String createNote(@ModelAttribute Note note){
        note.setUser(userService.getUserById(principalService.getUsername()));
        noteService.add(note);
        return "redirect:/note/list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam(name = "id") long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }


    @GetMapping("/edit/{id}")
    public String getEditNotePage(@PathVariable(name = "id") long id, Model model) {
        model.addAttribute("note", noteService.getById(id));
        return "note/edit_note";
    }

    @PostMapping("/edit/{id}")
    public String editNote(@ModelAttribute Note note){
        noteService.update(note);
        return "redirect:/note/list";
    }

    @GetMapping("/search")
    public String getNotesByTitle(@RequestParam(name = "request") String request, Model model){
        String username = principalService.getUsername();
        model.addAttribute("notes", noteService.findByTitle(username, request));
        return "note/searched_notes";
    }
}
