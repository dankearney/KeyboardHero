/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Dank
 * A song is a collection of notes to be played
 */
public class Song {
    
    // List of notes to be played
    private final ArrayList<Note> notes;
    
    // Name of song
    private final String name;
    
    // Filename of song
    private String fileName;
    
    // Speed of song (lower is faster)
    private int pixelsPerMilli;
    
    // Constructor for song takes a list of notes and a name
    public Song(ArrayList<Note> notes, String name, String fileName, int pixelsPerMilli) {
        this.notes = notes;
        this.name = name;
        this.fileName = fileName;
        this.pixelsPerMilli = pixelsPerMilli;
    }
    
    // Getter for list of notes
    public ArrayList<Note> getNotes() {
        return notes;
    }
    
    // Getter for name
    public String getName() {
        return name;
    }
    
    // Getter for file name
    public String getFileName() {
        return this.fileName;
    }
    
    // Getter for pixels per milli
    public int getPixelsPerMilli() {
        return this.pixelsPerMilli;
    }
    
}
