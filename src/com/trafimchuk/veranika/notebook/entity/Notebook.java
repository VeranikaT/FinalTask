package com.trafimchuk.veranika.notebook.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Notebook {
    private String owner;
    private String name;
    private List<Note> notes;

    public Notebook() {
        this.notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return owner.equals(notebook.owner) && name.equals(notebook.name) && Objects.equals(notes, notebook.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, name, notes);
    }


    @Override
    public String toString() {
        return "NoteBook: {" + "Owner='" + owner + '\'' + ", Name='" + name + '\'' + ", Notes=" + notes + '}';
    }
}
