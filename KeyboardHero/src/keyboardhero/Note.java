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
    
    // which keyboardString(s) are  the note on
    private final KeyboardString keyboardString;
    
    // When is the note to be played (in milliseconds)
    private final int timestamp;
    
    public Note(KeyboardString fret, int timestamp) {
        this.keyboardString = fret;
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
    
    public KeyboardString getKeyboardString() {
        return this.keyboardString;
    }
    
    // Draw the note on the given graphics object
    @Override
    public void draw(Graphics g, KeyboardHeroGame game) {       
        
        // Initially, position the note at its timestamp, so
        // that later notes are higher on page
        int y = -this.getTimestamp();
        
        // Now, adjust the position by the current game time so that
        // as time passes, notes move down the screen
        y += game.getCurrentTimestamp();
        
        // Convert milliseconds to pixels
        y /= 3;
        
        /// Now offset the 0 position so that t=0 is where the frets are
        y += 790;
        
        // The x coordinate depends on the keyboardString value
        int x = 0;
        
        switch (this.getKeyboardString()) 
        {
            case A: 
                x = 1 * Constants.FRET_WIDTH;
                break;
            case S: 
                x = 2 * Constants.FRET_WIDTH;
                break;
            case D: 
                x = 3 * Constants.FRET_WIDTH;
                break;
            case F: 
                x = 4 * Constants.FRET_WIDTH;
                break;
            case G: 
                x = 5 * Constants.FRET_WIDTH;
                break;
            default: {
                x = 0;
            }
        }
        
        // Draw the note, differently depending on its state
        switch (this.getNoteState()) 
        {
            case Unplayed:
                drawUnplayedNote(g, x, y);
                break;
            case Missed:
                drawMissedNote(g, x, y);
                break;
            case Hit:
                drawHitNote(g, x, y);
                break;
        }
    }
    
    private void drawHitNote(Graphics g, int x, int y) {
        // Set color of outline
        g.setColor(Color.BLUE);
        
        // Draw a filled rectangle
        g.fillRect(x - 11, y - 11, 72, 47);
        
        // Set color of filled inside
        g.setColor(Color.WHITE);
        
        // Draw a filled rectangle
        g.fillRect(x - 10, y - 10, 70, 45);
   
    }
    
    private void drawUnplayedNote(Graphics g, int x, int y) {
       // Set color 
        g.setColor(Color.BLUE);
        
        // Draw a filled rectangle
        g.fillRect(x, y, 50, 25);
    }
    
    private void drawMissedNote(Graphics g, int x, int y) {
        
        // Set color to red
        g.setColor(Color.RED);
        
        // Draw a filled rectangle
        g.fillRect(x - 10, y - 10, 70, 45);
        
    }
    
}
