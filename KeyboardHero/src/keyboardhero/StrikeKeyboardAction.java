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
    public void actionPerformed(ActionEvent e) {
        for (Fret fret : this.game.getFrets()) {
            
            // First of all, strike the fret, if it's pressed.
            fret.strikeFret();
            
            // If the fret is struck, we may have a collision with a note!
            if (fret.isStruck())
            {
                // Detect a collision with the notes.
                for (Note note : this.game.getSong().getNotes()) {
                    
                    // Only bother looking at your string.
                    if (note.getKeyboardString() == fret.keyboardString) {

                        // Compute the time difference between the strike and the note
                        int differential = (int) (note.getTimestamp() - this.game.getCurrentTimestamp());
                        
                        differential += 4000;
                        
                        // If the time difference is small, we've struck the note.
                        if (Math.abs(differential) < Constants.STRIKE_SLOP_DURATION) {
                            note.setNoteState(NoteState.Hit);
                            break;
                        }
                    }
                }
            }
        }
    }

}
