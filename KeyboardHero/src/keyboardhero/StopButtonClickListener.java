/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Dank
 * A class that handles stoppoing the bame
 */
public class StopButtonClickListener implements MouseListener {

    private KeyboardHeroGame game;
    
    // Constructor
    public StopButtonClickListener(KeyboardHeroGame game) {
        super();
        this.game = game;
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        game.stop();
    }

    @Override
    public void mousePressed(MouseEvent me) {  }

    @Override
    public void mouseReleased(MouseEvent me) {   }

    @Override
    public void mouseEntered(MouseEvent me) { }

    @Override
    public void mouseExited(MouseEvent me) {   }
    
}
