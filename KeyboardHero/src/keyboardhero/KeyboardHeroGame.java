/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dank
 * This class contains the information about a keyboard hero game,
 * including its notes, its score, its state, and other things required
 */
public class KeyboardHeroGame {
    
    // Score of the game
    private int score;
    
    // State of the game (playing, paused)
    private GameState gameState;
    
    // The song to be pplayed
    private Song song;
    
    // Current currentTimestamp
    private Long currentTimestamp;
    
    // Initial timestamp for computing relative timestamps
    private Long initialTimestamp;
    
    // Frets to be struck
    private ArrayList<Fret> frets;
    
    // constructor for game takes a song to be played 
    public KeyboardHeroGame(Song song) {
        this.song = song;
        
        // Initialize score at 0
        this.score = 0;
        
        // Initialize game state as dormant
        this.gameState = GameState.Dormant;
        
        // Set currentTimestamp to 0 
        this.currentTimestamp = 0L;
        
        // Set initial currentTimestamp to current time in milliseconds
        Date date = new Date();
        this.initialTimestamp = date.getTime();
        
        // Set up frets
        this.initalizeFrets();
        
    }
    
    // Getter for song
    public Song getSong() {
        return this.song;
    }
    
    // Getter for current relative timestamp
    public Long getCurrentTimestamp() {
        return this.currentTimestamp;
    }
    
    // Moves the game forward as many milliseconds as have passed
    public void step() {
        // Set initial currentTimestamp to current time in milliseconds
        Date date = new Date();
        Long currentTime = date.getTime();
        
        this.currentTimestamp = (currentTime - this.initialTimestamp);
    }
    
    // Add the 5 frets to the game
    public void initalizeFrets() {
        this.frets = new ArrayList<Fret>();
        for (KeyboardString kbs : KeyboardString.values()) {
            frets.add(new Fret (kbs) );
        }
    }
    
    // Getter for list of frets
    public ArrayList<Fret> getFrets() {
        return this.frets;
    }
    
}
