/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.util.Comparator;

/**
 *
 * @author Dank
 * Provides a comparator for high score objects so that 
 * high scores are displayed in a way that makes sense:
 * highest score for each song, songs sorted alphabetically
 */
public class HighScoreComparator implements Comparator {

    @Override
    // Overrides the default comparator
    public int compare(Object t, Object t1) {
        // Cast the objects to high scores
        HighScore hs1 = (HighScore) t;
        HighScore hs2 = (HighScore) t1;
        
        // If the two scores are from the same song, then use whichever has the higher value
        if (String.valueOf(hs1.getSongName()).equals(String.valueOf(hs2.getSongName()))) {
            return hs2.getScore() - hs1.getScore();
        }
        
        // if they're different songs, return whichever song is first alphabetically
        return hs1.getSongName().compareTo(hs2.getSongName());
    }
    
}
