package com.trafimchuk.veranika.notebook.service;

import com.trafimchuk.veranika.notebook.entity.Note;
import com.trafimchuk.veranika.notebook.entity.Notebook;
import com.trafimchuk.veranika.notebook.instance.NBInstance;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NBServiceTest {

    Notebook notebook = NBInstance.getInstance().getNoteBook();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    NBService service = new NBService();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @org.junit.jupiter.api.Test
    void getNotesById() {
        notebook.addNote(new Note(1, new Date(), "note1", "note1"));

        List<Note> note = service.getNotesById(notebook, 1);

        assertEquals(1, note.size());
    }

    @org.junit.jupiter.api.Test
    void getNotesByContent() {
        notebook.addNote(new Note(2, new Date(), "note2", "note2"));

        List<Note> note = service.getNotesByContent(notebook, "note2");

        assertEquals(1, note.size());
    }

    @org.junit.jupiter.api.Test
    void getNotesByName() {
        notebook.addNote(new Note(3, new Date(), "note3", "note3"));

        List<Note> note = service.getNotesByName(notebook, "note3");

        assertEquals(1, note.size());
    }

    @org.junit.jupiter.api.Test
    void editNotesByName() {

        notebook.addNote(new Note(1, new Date(), "note5", "note5"));
        service.editNotesByName(notebook, "note5", "FirstNote");

        List<Note> note = service.getNotesByName(notebook, "FirstNote");

        assertEquals(1, note.size());
    }

    @org.junit.jupiter.api.Test
    void deleteNoteById() {

        service.deleteNoteById(notebook, 1);

        assertEquals(0, notebook.getNotes().stream().count());
    }

    @org.junit.jupiter.api.Test
    void deleteNoteByContent() {

        service.deleteNoteByContent(notebook, "note2");

        assertEquals(0, notebook.getNotes().stream().count());
    }

    @org.junit.jupiter.api.Test
    void deleteNoteByName() {

        service.deleteNoteByName(notebook, "note3");

        assertEquals(1, notebook.getNotes().stream().count());
    }

    @org.junit.jupiter.api.Test
    void deleteNoteByDate() {

        service.deleteNoteByDate(notebook, simpleDateFormat.format(new Date()));

        assertEquals(2, notebook.getNotes().stream().count());
    }
}