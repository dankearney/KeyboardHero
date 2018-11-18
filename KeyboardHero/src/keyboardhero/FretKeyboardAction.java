/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.AbstractAction;

/**
 *
 * @author Dank
 * An event handler for when the frets are struck.
 */
class FretKeyboardAction extends AbstractAction {

    // Fret that was struck
    private Fret fret;
    
    // is the fret pressed?
    private boolean pressed;

    // Constructor
    public FretKeyboardAction(Fret fret, boolean pressed) {
        super();
        this.fret = fret;
        this.pressed = pressed;
    }

    @Override
    // Handle the fret being pressed
    public void actionPerformed(ActionEvent e) {
        // If the action is to press, press the fret
        if (this.pressed) {
            this.fret.pressFret();
        } 
        // If the action is to unpress, unpress
        else
        {
            this.fret.unpressFret();
        }
    }

}
