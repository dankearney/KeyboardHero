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
            for (int i = 0; i < 100; i += 1) {
                int rnd = new Random().nextInt(kbs.length);
                notes.add(new Note(kbs[rnd], i * 500));
                if (new Random().nextInt(3) == 1) {
                    notes.add(new Note(kbs[(rnd + new Random().nextInt(kbs.length)) % 5], i * 500));
                }
            }

            // Create the song with those notes
            String fileName = "";
            switch (name) {
                case "Medium: Under the Bridge":
                    fileName = ".\\under_the_bridge.wav";
                    break;
                case "Easy: Cheap Thrills":
                    fileName = ".\\sia.wav";
                    break;
                case "Hard: Harder, Better, Faster, Stronger":
                    fileName = ".\\daft_punk.wav";
                    break;
            }
            return new Song(notes, name, fileName);
    }
}
   
