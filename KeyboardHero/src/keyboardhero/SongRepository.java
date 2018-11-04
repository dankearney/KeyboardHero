/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.util.ArrayList;
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
        
        // Set up test note list
        ArrayList<Note> notes = new ArrayList<Note>();
        
        // Set up possible notes to choose from
        KeyboardString[] kbs = new KeyboardString[] {
            KeyboardString.A, KeyboardString.S, KeyboardString.D,
            KeyboardString.F, KeyboardString.G
        };
        
        // Add a bunch of notes
        for (int i = 1000; i < 100000; i += 1000 * Math.random() + 250) {
            int rnd = new Random().nextInt(kbs.length);
            notes.add(new Note(kbs[rnd], i));
        }


        // Create the song with those notes
        return new Song(notes, name);
    }
    
}
