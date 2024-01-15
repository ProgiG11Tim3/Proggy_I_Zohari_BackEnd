package com.progiizohari.ozdravi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class SickNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int excuseNoteId;

    @ManyToOne
    @JoinColumn(name = "child_OIB")
    private Child child;

    @NotNull
    private String noteData;

    public SickNote() {
    }

    public SickNote(Child child, String noteData) {
        this.child = child;
        this.noteData = noteData;
    }

    public int getExcuseNoteId() {
        return excuseNoteId;
    }

    public void setExcuseNoteId(int excuseNoteId) {
        this.excuseNoteId = excuseNoteId;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public String getNoteData() {
        return noteData;
    }

    public void setNoteData(String noteData) {
        this.noteData = noteData;
    }

    @Override
    public String toString() {
        return "SickNote{" +
                "excuseNoteId=" + excuseNoteId +
                ", child=" + child +
                ", noteData='" + noteData + '\'' +
                '}';
    }
}
