package com.example.ZPO_Lab6;

import java.util.List;


public interface NoteService {
    void addNote(Note note);
    List<Note> listOfNotes();
    void clearNotes();
}
