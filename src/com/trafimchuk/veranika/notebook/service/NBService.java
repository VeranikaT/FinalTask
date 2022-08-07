package com.trafimchuk.veranika.notebook.service;

import com.trafimchuk.veranika.notebook.entity.Note;
import com.trafimchuk.veranika.notebook.entity.Notebook;
import java.util.ArrayList;
import java.util.List;

public class NBService {

    public NBService() {
    }

    public List<Note> getNotesById(Notebook notebook, int id){
        List<Note> notes = new ArrayList();
        notebook.getNotes().forEach(foundNote -> {
            if (foundNote.getId() == id) {
                notes.add(foundNote);
            }
        });
        return notes;
    }

    public List<Note> getNotesByContent(Notebook notebook, String content) {
        List<Note> notes = new ArrayList();
        notebook.getNotes().forEach(foundNote -> {
            if (foundNote.getNote().contains(content)) {
                notes.add(foundNote);
            }
        });
        return notes;
    }

    public List<Note> getNotesByName(Notebook notebook, String name) {
        List<Note> notes = new ArrayList();
        notebook.getNotes().forEach(foundNote -> {
            if (foundNote.getName().contains(name)) {
                notes.add(foundNote);
            }
        });
        return notes;
    }

    public List<Note> getNotesByDate(Notebook notebook, String date) {
        List<Note> notes = new ArrayList();
        notebook.getNotes().forEach(foundNote -> {
            if (foundNote.getDate().equals(date)) {
                notes.add(foundNote);
            }
        });
        return notes;
    }

    public List<Note> editNotesByName(Notebook notebook, String name, String replace) {
        List<Note> notes = new ArrayList();
        notebook.getNotes().forEach(foundNote -> {
            if (foundNote.getName().contains(name)) {
                notebook.getNotes().get(foundNote.getId()-1).setName(replace);
            }
        });
        return notes;
    }

    public void deleteNoteById(Notebook notebook, int id) {
        getNotesById(notebook, id).forEach(foundNote -> {
            notebook.getNotes().remove(foundNote);
        });
    }

    public void deleteNoteByContent(Notebook notebook, String content) {
        getNotesByContent(notebook, content).forEach(foundNote -> {
            notebook.getNotes().remove(foundNote);
        });
    }

    public void deleteNoteByName(Notebook notebook, String name) {
        getNotesByName(notebook, name).forEach(foundNote -> {
            notebook.getNotes().remove(foundNote);
        });
    }

    public void deleteNoteByDate(Notebook notebook, String date) {
        getNotesByDate(notebook, date).forEach(foundNote -> {
            notebook.getNotes().remove(foundNote);
        });
    }
}
