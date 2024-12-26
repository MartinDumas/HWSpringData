package com.example.TodoList.controller;

import com.example.TodoList.entity.Note;
import com.example.TodoList.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/note")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Note>> listNotes() {
        return ResponseEntity.ok(noteService.listAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Note note = noteService.getById(id);
        return ResponseEntity.ok(note);
    }

    @PostMapping("/save")
    public ResponseEntity<Note> saveOrUpdateNote(@RequestBody Note note) {
        Note savedNote = (note.getId() == null || note.getId() == -1) ? noteService.add(note) : noteService.update(note);
        return ResponseEntity.ok(savedNote);
    }
}

