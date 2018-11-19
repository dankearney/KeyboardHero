/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

/**
 *
 * @author Dank
 * Configuration constants stored here.
 */
public class Constants {
    
    // Height and width of the window
    public static final int WINDOW_WIDTH = 1200;
    public static final int WINDOW_HEIGHT = 1000;
    
    // Widht of a fret, and distance between strings
    public static final int FRET_SPACING = 150;
    
    // Height of a base fret
    public static final int BASE_FRET_HEIGHT = 50;
    
    // Amount of slop between when a note is supposed to be struck
    // And when we are allowed to
    public static final int STRIKE_SLOP_DURATION = 250;
    
    // Supported song name
    public static final String[] SONG_NAMES = new String[] 
        {"Easy: Cheap Thrills", "Medium: Under the Bridge", "Hard: Harder, Better, Faster, Stronger"};
    
    // Number of pixels from the bottom of the screen the frets should be
    public static final int FRET_OFFSET_HEIGHT = 700;
    
    // Background color
    public static final String BACKGROUND_COLOR_RGB = "#f9f9f9";
    
    // Song length (30 seconds)
    public static final int SONG_LENGTH = 30_000; 
    
}
