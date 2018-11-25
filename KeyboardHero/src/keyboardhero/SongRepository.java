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
 * This class returns fully formed songs with notes.
 * 
 */
public class SongRepository {
    
    // Returns the song specified
    public static Song getSong(String name) {

        // Set up the list to store the batch of notes in the song
        ArrayList<Note> notes = new ArrayList<>();

        // Declare the filename where the song is stored
        String fileName = "";

        // The speed of the notes
        int speed = 1000;
        
        // Time at which first note begins
        int beginningTime = 0;
        
        // Pixels per millisecond of note
        int pixelsPerMilli = 0;
        
        // Hard-code values for each song
        switch (name) {
            case "Easy: Cheap Thrills":
                fileName = ".\\sia.wav";
                speed = 900;
                beginningTime = 1500;
                pixelsPerMilli = 4;
                break;
            case "Medium: Under the Bridge":
               fileName = ".\\under_the_bridge.wav";
               speed = 450;
               beginningTime = 1500;
               pixelsPerMilli = 3;
               break;
            case "Hard: Harder, Better, Faster, Stronger":
                fileName = ".\\daft_punk.wav";
                speed = 325;
                beginningTime = 6000;
                pixelsPerMilli = 2;
                break;
            default:
                throw new IllegalArgumentException("Unknown song supplied: " + name);
        }
    

        // Add the notes to be played!
        for (int timestamp = beginningTime; timestamp < Constants.SONG_LENGTH; timestamp += speed) {

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
      
        // Construct the song and return it
        return new Song(notes, name, fileName, pixelsPerMilli);
    }
}
   
