/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author Dank
 * This class returns fully formed songs with notes 
 * 
 */
public class SongRepository {
    
    // Returns the song specified
    public static Song getSong(String name) {

        // Set up the list to store the batch of notes in the song
        ArrayList<Note> notes = new ArrayList<Note>();

        // Declare the filename where the song is stored
        String fileName = "";

        // The speed of the notes
        int speed = 1000;
        
        // Time at which first note begins
        int beginningTime = 0;
        
        // Time when the song is over
        int endTime = 0;
        
        switch (name) {
            case "Easy: Cheap Thrills":
                fileName = ".\\sia.wav";
                speed = 450;
                beginningTime = 1500;
                endTime = 214_000;
                break;
            case "Medium: Under the Bridge":
               fileName = ".\\under_the_bridge.wav";
               speed = 500;
               beginningTime = 1500;
               endTime = 220_000;
               break;
            case "Hard: Harder, Better, Faster, Stronger":
                fileName = ".\\daft_punk.wav";
                speed = 475;
                beginningTime = 6000;
                endTime = 264_000;
                break;
            default:
                throw new IllegalArgumentException("Unknown song supplied: " + name);
        }
    

        // Add the notes to be played!
        for (int timestamp = beginningTime; timestamp < endTime; timestamp += speed) {

            // Add notes to the song at random.
            // Prefer single notes (75% of the time)
            // Allow chords 20% of the time
            // Allow no note 5% of the time
            
            int diceroll = new Random().nextInt(100);
            int numNotes = 0;
            if (diceroll < 75) {
                numNotes = 1;
            } else if (diceroll < 95) {
                numNotes = 2;
            }
            
            // Add the random notes
            HashSet<KeyboardString> kbs = KeyboardString.nRandom(numNotes);
            for (KeyboardString kb : kbs) {
                notes.add(new Note(kb, timestamp));
            }

        }
      
        return new Song(notes, name, fileName);
    }
}
   
