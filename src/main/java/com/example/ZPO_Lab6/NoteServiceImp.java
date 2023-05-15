package com.example.ZPO_Lab6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class NoteServiceImp implements NoteService{

    @Autowired
    NoteRepo noteRepo;

    @Override
    public void addNote(Note note) {
        note.setTimestamp(new Timestamp(System.currentTimeMillis()));
        noteRepo.save(note);
    }

    @Override
    public List<Note> listOfNotes() {
        return noteRepo.findByOrderByTimestampDesc();
    }

    @Override
    public void clearNotes() {
        noteRepo.deleteAll();
    }
}
