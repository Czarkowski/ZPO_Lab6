package com.example.ZPO_Lab6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private NoteService noteService;

    @GetMapping({"/list"})
    public String index(Model model){
//        model.addAttribute("Importances", Importance.values());
        model.addAttribute("Importances", com.example.ZPO_Lab6.Importance.values());
        Note note = new Note();
        model.addAttribute("Note",  note);
        List<Note> notes = noteService.listOfNotes();
        model.addAttribute("Notes", notes);
        return "list";
    }
    @PostMapping({"/list"})

    public String post(@ModelAttribute("note") Note note, Model model){
        System.out.println(note);
        noteService.addNote(note);
        return "redirect:/list";
    }

    @DeleteMapping({"/list"})
    public ResponseEntity<?> delete(Model model) {
        System.out.println("clear repo");
        noteService.clearNotes();
        return ResponseEntity.ok().build();
    }
}

