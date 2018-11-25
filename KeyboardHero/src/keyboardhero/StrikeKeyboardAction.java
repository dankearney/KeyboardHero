/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;

/**
 *
 * @author Dank
 * Handles when a user strikes the keyboard strum button (L)
 * Computes collisions with notes and adjusts the note and game state
 * accordingly.
 */
class StrikeKeyboardAction extends AbstractAction {

    // The game associated
    private KeyboardHeroGame game;

    // Strums the keyboard
    public StrikeKeyboardAction(KeyboardHeroGame game) {
        super();
        this.game = game;
    }

    @Override
    // Handles the strike button press
    public void actionPerformed(ActionEvent e) {
        
        // keep track of whether or not this was a successful strike
        boolean success = false;
        
        for (Fret fret : this.game.getFrets()) {
            
            // First of all, strike the fret, if it's pressed.
            fret.strikeFret();
            
            // If the fret is struck, we may have a collision with a note!
            if (fret.isStruck())
            {
                // Detect a collision with the notes
                // by brute-force checking to see if the current timestamp
                // matches with the notes we're pressing
                for (Note note : this.game.getSong().getNotes()) {
                    
                    // Only bother looking at your string.
                    if (note.getKeyboardString() == fret.keyboardString) {

                        // Compute the time difference between the strike and the note
                        int differential = (int) (note.getTimestamp() - this.game.getCurrentTimestamp());
                                               
                        // If the time difference is small, we've struck the note.
                        if (Math.abs(differential) < Constants.STRIKE_SLOP_DURATION) {
                            note.setNoteState(NoteState.Hit);
                            this.game.strikeScoreBoost();
                            success = true;
                            break;
                        }
                    }
                }
            }
        }
        
        // If we didn't strike a fret, deduct the score
        if (!success && game.isPlaying()) {
            this.game.badStrikeScoreDeduction();
        }
        
    }

}
