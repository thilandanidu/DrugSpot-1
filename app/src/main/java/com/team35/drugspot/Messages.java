package com.team35.drugspot;

public class Messages {
    String NoteID;
    String Date;
    String Note;

    public Messages(String noteID, String date, String note) {
        NoteID = noteID;
        Date = date;
        Note = note;
    }

    public String getNoteID() {
        return NoteID;
    }

    public String getDate() {
        return Date;
    }

    public String getNote() {
        return Note;
    }
}
