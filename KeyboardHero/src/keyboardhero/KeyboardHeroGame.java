/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.io.IOException;
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
    
    // The name of the song to be played
    private String songName;
    
    // The song to be played
    private Song song;
    
    // Current currentTimestamp
    private Long currentTimestamp;
    
    // Initial timestamp for computing relative timestamps
    private Long initialTimestamp;
    
    // Frets to be struck
    private ArrayList<Fret> frets;
    
    // Username of the player
    private String username;
    
    // Thread for music
    private MusicThread musicThread;
    
    // constructor for game takes a song to be played 
    public KeyboardHeroGame() {
        
        // Initialize score at 0
        this.score = 0;
        
        // Set username to the supplied username
        this.username = "username";
        
        // Initialize game state as dormant
        this.gameState = GameState.Dormant;
        
        // Set currentTimestamp to -3000 to give music time to catch up
        this.currentTimestamp = 0L;
        
        // Set initial currentTimestamp to current time in milliseconds
        Date date = new Date();
        this.initialTimestamp = date.getTime();
        
        // Set up frets
        this.initalizeFrets();
        
    }

    public String getUsername() {
        return username;
    }

    // Getter for song
    public Song getSong() {
        return this.song;
    }
    
    // Getter for current relative timestamp
    public Long getCurrentTimestamp() {
        return this.currentTimestamp;
    }
    
    /// Getter for score
    public int getScore() {
        return this.score;
    }
    
    // Moves the game forward as many milliseconds as have passed
    public void step() {
        // Set initial currentTimestamp to current time in milliseconds
        Date date = new Date();
        Long currentTime = date.getTime();
        
        // Set current timestamp
        this.currentTimestamp = (currentTime - this.initialTimestamp);
        
        // Unstrike frets that have been sruck too far in the past
        this.unstrikeFrets();
        
        // Mark notes we missed as such
        this.updateMissedNotes();
        
        // If the game is over, end the game
        if (this.isGameComplete()) {
            this.handleGameCompletion();
        }
        
    }
    
    // Determine if the game is over
    public boolean isGameComplete() {
        // Iterate through the notes and determine if the last note has passed
        for (Note note : this.song.getNotes()) {
            if (this.currentTimestamp - 500 < note.getTimestamp()) {
                return false;
            }
        }
        // No? game still being played.
        return true;
    }
    
    // Handle the game ending
    private void handleGameCompletion() {
        // Set the game state to complete
        this.gameState = GameState.Complete;
        
        // Write the high score result to the file
        try
        {
            HighScore hs = new HighScore(this.username, this.songName, this.score);
            HighScoreReaderWriter.writeHighScore(hs);
        }
        catch (IOException e)
        {
            
        }
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
    
    // Unstrum frets that were strummed too long ago
    public void unstrikeFrets() {
        // Frets stay "struck" for a little bit after striking them.
        // This clears that state.
        for (Fret fret : this.getFrets()) {
            fret.unstrikeFret();
        }
    }
    
    // Detects and annotates missed notes
    public void updateMissedNotes() {
        for (Note note : this.song.getNotes()) {
            // If we already hit the note, skip it.
            if (note.getNoteState() == NoteState.Hit || note.getNoteState() == NoteState.Missed) {
                continue;
            }
            // If we haven't hit the note after teh slop period, we missed it
            if ((this.currentTimestamp - note.getTimestamp()) > Constants.STRIKE_SLOP_DURATION  ) {
                note.setNoteState(NoteState.Missed);
                this.missScoreDeduction();
            }
        }
    }
    
    // increments the score by 20 when you hit a note
    public void strikeScoreBoost() {
        this.score += 20;
    }
    
    // Decrement score by 10 when a note is missed
    public void missScoreDeduction() {
        this.score -= 10;
    }
    
    // Decrement score by 10 when a strike doesn't lead to a hit
    public void badStrikeScoreDeduction() {
        this.score -= 10;
    }
    
    // Returns if the game is dormant
    public boolean isDormant() {
        return this.gameState == GameState.Dormant;
    }
    
    // Returns if the game is being played
    public boolean isPlaying() {
        return this.gameState == GameState.Playing;
    }
    
    // Returns if the game is complete
    public boolean isComplete() {
        return this.gameState == GameState.Complete;
    }
    
    // Begins a new game session
    public void start() {
        // Mark the game as playing
        this.gameState = GameState.Playing;
        
        // Reset the score
        this.score = 0;
        
        // Load the song
        this.song = SongRepository.getSong(this.songName);
        
        // Compute initial timestamp
        Date date = new Date();
        this.initialTimestamp = date.getTime();
        
        // Initialize music thread
        this.musicThread = new MusicThread(this);
        
        // Play the music in a new thread
        musicThread.start();
        
    }
    
    // Stops a game
    public void stop() {
        // Mark the game as dormant
        this.gameState = GameState.Dormant;
    }
    
    // Sets the song name
    public void setSongName(String songName) {
        this.songName = songName;
    }
    
    // Sets the username
    public void setUsername(String username) {
        this.username = username;
    }
    
}
