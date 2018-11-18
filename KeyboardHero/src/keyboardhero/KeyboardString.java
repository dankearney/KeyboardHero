/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Dank
 * Possible strings for a note to be played on, or a fret to live on.
 * For simplicity, just call them A, S, D, F, and G, which are the
 * valid keys to use.
 */
public enum KeyboardString {
    A, S, D, F, G;

    // Returns a random KeyboardString
    public static KeyboardString random() {
        // Select a random index
        int index = new Random().nextInt(KeyboardString.values().length);
        
        // Get the value at that index
        return KeyboardString.values()[index];
    }
    
    // Returns multiple random KeyboardStrings
    public static HashSet<KeyboardString> nRandom(int n) {
        // Ensure the N are distinct
        HashSet<KeyboardString> kbs = new HashSet<KeyboardString>();
        // Iteratively try to add random notes to the ste
        while (kbs.size() < n) {
            KeyboardString kb = random();
            kbs.add(kb);
        }
        return kbs;
    }
    
}
