/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Date;

/**
 *
 * @author Dank
 * The Fret in a game of KeyboardHero.
 * Each fret is on a string
 * Players try to strike the fret when a note on the same string is passing
 */
public class Fret implements Drawable {
    
    // which keyboard string is the fret on
    public KeyboardString keyboardString;
    
    // State (pressed, struck, unpressed)
    public FretState state;
    
    // Time of last strike 
    public Long lastStrike;
    
    // Constructor for fret takes in the relevant string
    public Fret(KeyboardString keyboardString) {
        this.keyboardString = keyboardString;
        this.state = FretState.Unpressed;
        this.lastStrike = 0L;
    }
    
    @Override
    // Draws fret on the screen
    public void draw(Graphics g, KeyboardHeroGame game) {
        
        // X position of note
        int x = 0;
        
        switch (this.keyboardString) 
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
        
        // height and width of the frets
        int height = 10;
        int width = 50;
        
        // Offset from center
        int offset_x = -20;
        int offset_y = 785;
        
        // Set color of fret based on fret state 
        Color fretColor;
        switch (this.state) {
            case Pressed:
                fretColor = Color.white;
                break;
            case Struck:
                fretColor = Color.white;
                height = 20;
                width = 75;
                offset_x = -15;
                offset_y -= 10;
                break;
            case Unpressed:
                fretColor = Color.black;
                break;
            default:
                fretColor = Color.white;
        }
        
        g.setColor(fretColor);
        g.fillRoundRect(x - offset_x, offset_y, height, width, 25, 25);
        
        
    }
    
    public KeyboardString getKeyboardString() {
        return this.keyboardString;
    }
    
    // Transition state to pressed
    public void pressFret() {
        this.state = FretState.Pressed;
    }
    
    // Transition stake to unpressed
    public void unpressFret() {
        this.state = FretState.Unpressed;
    }
    
    public boolean isPressed() {
        return this.state == FretState.Pressed;
    }
    
    public boolean isStruck() {
        return this.state == FretState.Struck;
    }
    
    // Transition state to struck
    public void strikeFret() {
        // if the fret is pressed, we can transition it to struck.
        if (this.isPressed()) {
            this.state = FretState.Struck;
            // Also set last timestamp to current time
            Date date = new Date();
            this.lastStrike = date.getTime();
        }
    }
    
    // If the strike happened too long ago, return the fret to its unstrummed
    // state
    public void unstrikeFret() {
        // first of all, only a currently struck fret can be unstruck.
        if (!this.isStruck()) {
            return;
        }
        
        Date date = new Date();
        Long timestamp = date.getTime();
        
        if ((timestamp - this.lastStrike) > Constants.STRIKE_SLOP_DURATION) {
            this.pressFret();
        }
    }
    
}
