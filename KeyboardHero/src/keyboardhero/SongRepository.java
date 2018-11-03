/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.util.ArrayList;

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
        
        // Add a bunch of notes
        notes.add(new Note(KeyboardString.A, 1000));
        notes.add(new Note(KeyboardString.D, 2000));
        notes.add(new Note(KeyboardString.C, 3000));
        notes.add(new Note(KeyboardString.B, 4000));
        notes.add(new Note(KeyboardString.A, 5000));
        notes.add(new Note(KeyboardString.A, 6000));
        notes.add(new Note(KeyboardString.E, 7000));
        notes.add(new Note(KeyboardString.E, 8000));
        notes.add(new Note(KeyboardString.B, 9000));
        notes.add(new Note(KeyboardString.A, 10000));

        // Create the song with those notes
        return new Song(notes, name);
    }
    
}
