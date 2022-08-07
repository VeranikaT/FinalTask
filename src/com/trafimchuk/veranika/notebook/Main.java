package com.trafimchuk.veranika.notebook;

import com.trafimchuk.veranika.notebook.console.NBConsole;
import com.trafimchuk.veranika.notebook.entity.Note;
import com.trafimchuk.veranika.notebook.entity.Notebook;
import com.trafimchuk.veranika.notebook.exception.ConsoleException;
import com.trafimchuk.veranika.notebook.instance.NBInstance;
import com.trafimchuk.veranika.notebook.service.NBService;

import java.util.Date;

public class Main {

    public static void main(String[] args) throws ConsoleException {

        Notebook notebook = NBInstance.getInstance().getNoteBook();
        NBService nbService = new NBService();
        notebook.setOwner("Vera");
        notebook.setName("All notes");

        int increment = 1;

        notebook.addNote(new Note(increment++, new Date(),"Note1","note1"));
        notebook.addNote(new Note(increment++, new Date(),"Note2","note2"));
        notebook.addNote(new Note(increment++, new Date(),"Note3","note3"));
        notebook.addNote(new Note(increment++,new Date(),"Note4"));
        System.out.println();
        NBConsole.console(notebook);
        System.out.println();

        System.out.println("\n" + nbService.getNotesById(notebook,1) + "\n");

        nbService.editNotesByName(notebook, "Note1", "First Note");
        nbService.deleteNoteById(notebook, 2);

        NBConsole.console(notebook);

        System.out.println("\nNotebook service methods has been tested with JUnit in test source.");
    }
}
