package com.trafimchuk.veranika.notebook.entity;

import java.util.Date;
import java.util.Objects;

public class Note {

    private int id;
    private Date date;
    private String name;
    private String note;

    public Note(int id, String note) {
        this.id = id;
        this.note = note;
    }

    public Note(int id, String name, String note) {
        this.id = id;
        this.name = name;
        this.note = note;
    }

    public Note(int id, Date date, String name) {
        this.id = id;
        this.date = date;
        this.name = name;
    }

    public Note(int id, Date date, String name, String note) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note1 = (Note) o;
        return id == note1.id && Objects.equals(date, note1.date) && Objects.equals(name, note1.name) && Objects.equals(note, note1.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, name, note);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
