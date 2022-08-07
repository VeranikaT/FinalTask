package com.trafimchuk.veranika.notebook.console;


import com.trafimchuk.veranika.notebook.entity.Note;
import com.trafimchuk.veranika.notebook.entity.Notebook;
import com.trafimchuk.veranika.notebook.exception.ConsoleException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NBConsole {

    public static void console(Notebook notebook) throws ConsoleException {
        try {
            System.out.println(String.format("%s", Stream.generate(() -> "\u2550").limit(79).collect(Collectors.joining())));
            System.out.println(String.format("\u2551%38s\u2502%38s\u2551", arrange("Belongs to: " + notebook.getOwner(), 38), arrange("For: " + notebook.getName(), 38)));
            System.out.println(String.format("%s", Stream.generate(() -> "\u2550").limit(79).collect(Collectors.joining())));
            System.out.println(String.format("\u2551%10s\u2502%20s\u2502%20s\u2502%24s\u2551",
                    arrange("Id", 10),
                    arrange("Name", 20),
                    arrange("Date", 20),
                    arrange("Note", 24)
            ));
            System.out.println(String.format("%s", Stream.generate(() -> "\u2550").limit(79).collect(Collectors.joining())));
            notebook.getNotes().forEach(note -> {
                try {
                    console(note);
                } catch (ConsoleException e) {
                    e.printStackTrace();
                }
                System.out.println(String.format("%s", Stream.generate(() -> "\u2550").limit(79).collect(Collectors.joining())));

            });
        } catch (NullPointerException e) {
            throw new ConsoleException("This is an error in your print view for Notebook;");

        }

    }

    public static void console(Note note) throws ConsoleException {
        try {
            String dateFormatString = "yyyy-MM-dd HH:mm";
            DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
            System.out.println(String.format("\u2551%10s\u2502%20s\u2502%20s\u2502%24s\u2551",
                    arrange(String.valueOf(note.getId()), 10),
                    arrange(note.getName(), 20),
                    arrange(dateFormat.format(note.getDate()), 20),
                    arrange(note.getNote(), 24)
            ));
        } catch (NullPointerException e) {
            throw new ConsoleException("This is an error in your print view for Note;");
        }
    }

    private static String arrange(String string, int size) {
        return arrange(string, size, ' ');
    }

    private static String arrange(String string, int size, char space) {
        if (string == null || size <= string.length())
            return string;

        StringBuilder stringBuilder = new StringBuilder(size);
        for (int i = 0; i < (size - string.length()) / 2; i++) {
            stringBuilder.append(space);
        }
        stringBuilder.append(string);
        while (stringBuilder.length() < size) {
            stringBuilder.append(space);
        }
        return stringBuilder.toString();
    }
}
