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
 */
class FretKeyboardAction extends AbstractAction {

    private Fret fret;
    private boolean pressed;

    public FretKeyboardAction(Fret fret, boolean pressed) {
        super();
        this.fret = fret;
        this.pressed = pressed;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.pressed) {
            this.fret.pressFret();
            Date date = new Date();
            System.out.printf("Note: %s\tTimestamp: %d\r\n", e.getActionCommand(), 1541306700751L - date.getTime());
        } 
        else
        {
            this.fret.unpressFret();
        }
    }

}
