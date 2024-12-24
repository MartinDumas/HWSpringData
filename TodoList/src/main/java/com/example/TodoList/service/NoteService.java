package com.example.TodoList.service;

import com.example.TodoList.entity.Note;
import com.example.TodoList.exception.NotFoundNoteException;
import com.example.TodoList.repository.NoteRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        note.setId(null);
        return noteRepository.save(note);
    }

    @SneakyThrows
    public void deleteById(Long id) {
        if (!noteRepository.existsById(id)) {
            throw new NotFoundNoteException("Note with id " + id + " not found");
        }
        noteRepository.deleteById(id);
    }

    @SneakyThrows
    public void update(Note note) {
        if (!noteRepository.existsById(note.getId())) {
            throw new NotFoundNoteException("Note with id " + note.getId() + " not found");
        }
        noteRepository.save(note);

    }

    @SneakyThrows
    public Note getById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NotFoundNoteException("Note with id " + id + " not found"));
    }
}
