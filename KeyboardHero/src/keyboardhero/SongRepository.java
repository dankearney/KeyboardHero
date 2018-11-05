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
        
        if (String.valueOf(name) == "Random")
        {

            // Set up possible notes to choose from
            KeyboardString[] kbs = new KeyboardString[] {
                KeyboardString.A, KeyboardString.S, KeyboardString.D,
                KeyboardString.F, KeyboardString.G
            };

            // Add a bunch of notes
            for (int i = 2000; i < 100000; i += 1000) {
                int rnd = new Random().nextInt(kbs.length);
                notes.add(new Note(kbs[rnd], i));
                if (new Random().nextInt(2) >= 1) {
                    notes.add(new Note(kbs[(rnd + new Random().nextInt(kbs.length)) % 5], i));
                }
            }

            // Create the song with those notes
            return new Song(notes, name);
        }
        
        if (String.valueOf(name) == "Titanium") 
        {
notes.add(new Note(KeyboardString.	A	,	0	));
notes.add(new Note(KeyboardString.	D	,	500	));
notes.add(new Note(KeyboardString.	S	,	1000	));
notes.add(new Note(KeyboardString.	F	,	1500	));
notes.add(new Note(KeyboardString.	D	,	2000	));
notes.add(new Note(KeyboardString.	G	,	2500	));
notes.add(new Note(KeyboardString.	A	,	3000	));
notes.add(new Note(KeyboardString.	A	,	3500	));
notes.add(new Note(KeyboardString.	D	,	4000	));
notes.add(new Note(KeyboardString.	S	,	4500	));
notes.add(new Note(KeyboardString.	F	,	5000	));
notes.add(new Note(KeyboardString.	D	,	5500	));
notes.add(new Note(KeyboardString.	G	,	6000	));
notes.add(new Note(KeyboardString.	A	,	6500	));
notes.add(new Note(KeyboardString.	A	,	7000	));
notes.add(new Note(KeyboardString.	D	,	7500	));
notes.add(new Note(KeyboardString.	S	,	8000	));
notes.add(new Note(KeyboardString.	F	,	8500	));
notes.add(new Note(KeyboardString.	D	,	9000	));
notes.add(new Note(KeyboardString.	G	,	9500	));
notes.add(new Note(KeyboardString.	A	,	10000	));
notes.add(new Note(KeyboardString.	A	,	10500	));
notes.add(new Note(KeyboardString.	D	,	11000	));
notes.add(new Note(KeyboardString.	S	,	11500	));
notes.add(new Note(KeyboardString.	F	,	12000	));
notes.add(new Note(KeyboardString.	D	,	12500	));
notes.add(new Note(KeyboardString.	G	,	13000	));
notes.add(new Note(KeyboardString.	A	,	13500	));
notes.add(new Note(KeyboardString.	A	,	14000	));
notes.add(new Note(KeyboardString.	D	,	14500	));
notes.add(new Note(KeyboardString.	S	,	15000	));
notes.add(new Note(KeyboardString.	F	,	15500	));
notes.add(new Note(KeyboardString.	D	,	16000	));
notes.add(new Note(KeyboardString.	G	,	16500	));
notes.add(new Note(KeyboardString.	A	,	17000	));
notes.add(new Note(KeyboardString.	A	,	17500	));
notes.add(new Note(KeyboardString.	D	,	18000	));
notes.add(new Note(KeyboardString.	S	,	18500	));
notes.add(new Note(KeyboardString.	F	,	19000	));
notes.add(new Note(KeyboardString.	D	,	19500	));
notes.add(new Note(KeyboardString.	G	,	20000	));
notes.add(new Note(KeyboardString.	A	,	20500	));
notes.add(new Note(KeyboardString.	A	,	21000	));
notes.add(new Note(KeyboardString.	D	,	21500	));
notes.add(new Note(KeyboardString.	S	,	22000	));
notes.add(new Note(KeyboardString.	F	,	22500	));
notes.add(new Note(KeyboardString.	D	,	23000	));
notes.add(new Note(KeyboardString.	G	,	23500	));
notes.add(new Note(KeyboardString.	A	,	24000	));
notes.add(new Note(KeyboardString.	A	,	24500	));
notes.add(new Note(KeyboardString.	D	,	25000	));
notes.add(new Note(KeyboardString.	S	,	25500	));
notes.add(new Note(KeyboardString.	F	,	26000	));
notes.add(new Note(KeyboardString.	D	,	26500	));
notes.add(new Note(KeyboardString.	G	,	27000	));
notes.add(new Note(KeyboardString.	A	,	27500	));
            return new Song(notes, name);
        }
        return null;
    }
}
   
