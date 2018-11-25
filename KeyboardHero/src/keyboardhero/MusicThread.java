/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Dank
 * This class plays a music file in a new thread.
 * Reads the file name from the song specified. 
 */
public class MusicThread extends Thread {
    
    // Associated game
    private KeyboardHeroGame game;
    
     // Has the thread been explicitly killed?
    private boolean isKilled;
    
    // Constructor
    public MusicThread(KeyboardHeroGame game) {
        this.game = game;
        this.isKilled = false;
    }
    
    
    @Override
    // Plays the song in a new thread
    public void run() {
        // A clip is how to play a song
        Clip clip;
        try {
            // Creates a playable sound clip
            clip = this.createSongClip();
            
            // Play the sound!
            clip.start();
            
            // If the game is currently being played, keep the thread alive.
            // Only check every 250 ms to save system resources
            // Also ensure that the game has not been killed explicitly
            while (this.game.isPlaying() && !this.isKilled) {
                Thread.sleep(250);
            }
            
            // If the game is not playing anymore, we can terminate the thread.
            clip.stop();
            clip.close();
            
        } catch (Exception ex) {
            System.out.println("Error playing  music file: " + ex.getMessage());
        }
        
    }
    
    // Creates a playable sound clip
    private Clip createSongClip() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        // The song specifies the filename
        File file = new File(this.game.getSong().getFileName());
        
        // Read the file as an audio input stream
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        return clip;
    }
    
    // Explicitly end the song
    public void kill() {
        this.isKilled = true;
    }
    
}
