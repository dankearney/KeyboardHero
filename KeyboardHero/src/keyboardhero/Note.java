/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Dank
 * A note to be played in Keyboard Hero
 */
public class Note implements Drawable {
    
    // Keeps track of note's state 
    private NoteState noteState;
    
    // which fret(s) are  the note on
    private final KeyboardString fret;
    
    // When is the note to be played (in milliseconds)
    private final int timestamp;
    
    public Note(KeyboardString fret, int timestamp) {
        this.fret = fret;
        this.timestamp = timestamp;
        this.noteState = NoteState.Unplayed;
    }
    
    // Getters and setters 
    public void setNoteState(NoteState noteState) {
        this.noteState = noteState;
    }
    
    public NoteState getNoteState() {
        return this.noteState;
    }
    
    public int getTimestamp() {
        return this.timestamp;
    }
    
    public KeyboardString getFret() {
        return this.fret;
    }
    
    // Draw the note on the given graphics object
    @Override
    public void draw(Graphics g, KeyboardHeroGame game) {       
        
        // The y coordinate is the note's timestamp plus the game timestamp
        int y = (int) (-this.getTimestamp() / 10 + game.getCurrentTimestamp() / 5);
        
        // The x coordinate depends on the fret value
        int x = 0;
        
        switch (this.getFret()) 
        {
            case A: 
                x = 1 * Constants.FRET_WIDTH;
                break;
            case B: 
                x = 2 * Constants.FRET_WIDTH;
                break;
            case C: 
                x = 3 * Constants.FRET_WIDTH;
                break;
            case D: 
                x = 4 * Constants.FRET_WIDTH;
                break;
            case E: 
                x = 5 * Constants.FRET_WIDTH;
                break;
            default: {
                x = 0;
            }
        }
        
        // Note color depends on the state of the note
        Color noteColor;
        
        switch (this.getNoteState()) 
        {
            case Unplayed:
                noteColor = Color.blue;
                break;
            case Missed:
                noteColor = Color.red;
                break;
            case Hit:
                noteColor = Color.green;
                break;
            default:
                noteColor = Color.black;
        }
        
        // Set fill color to the note's specified
        g.setColor(noteColor);
        
        // Draw an oval at the specified spot
        g.fillOval(x, y, 50, 25);
    }
    
}