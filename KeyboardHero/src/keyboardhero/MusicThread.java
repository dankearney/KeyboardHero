/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Dank
 * This class plays a music file in a new thread.
 */
public class MusicThread extends Thread {
    
    // Associated game
    private KeyboardHeroGame game;
    
    // Constructor
    public MusicThread(KeyboardHeroGame game) {
        this.game = game;
    }
    
    @Override
    // Plays the song in a new thread
    public void run() {
        Clip clip;
        try {
            // Gets a playable sound clip
            clip = this.createSongClip();
            
            // Play the sound!
            clip.start();
            
            // If the game is currently being played, keep the thread alive
            while (this.game.isPlaying()) {
                Thread.sleep(10);
            }
            
            // If the game is not playing anymore, we can terminate the thread.
            clip.close();
            clip.stop();
            
        } catch (Exception ex) {
            System.out.println("Error playing  music file: " + ex.getMessage());
        }
        
    }
    
    // Creates a playable sound clip
    private Clip createSongClip() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        // The song specifies the file
        File file = new File(this.game.getSong().getFileName());
        
        // Read the file as an audio input stream
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        return clip;
    }
    
}
