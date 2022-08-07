package com.trafimchuk.veranika.notebook.instance;

import com.trafimchuk.veranika.notebook.entity.Notebook;

public class NBInstance {

    private static NBInstance instance;
    public Notebook noteBook;

    private NBInstance() {

        this.noteBook = new Notebook();
    }

    public static NBInstance getInstance() {
        if (instance == null) {
            instance = new NBInstance();
        }
        return instance;
    }

    public Notebook getNoteBook() {

        return this.noteBook;
    }

}
