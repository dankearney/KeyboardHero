/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.awt.Graphics;

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
    
    // Constructor for fret takes in the relevant string
    public Fret(KeyboardString keyboardString) {
        this.keyboardString = keyboardString;
        this.state = FretState.Unpressed;
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
        
        g.drawRect(x, 800, 50, 25);
        
    }
    
}
