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
 * Handles the high score tab refreshing button press
 */
public class HighScoreRefreshListener implements MouseListener {

    // The container tab
    private HighScoreTab ht;
    
    // Constructor
    public HighScoreRefreshListener(HighScoreTab ht) {
        this.ht = ht;
    }

    @Override
    // Handle the click of the high scroe refresh button
    // By simply re-loading the high score tab.
    // This will automaticall refresh the high screos
    public void mouseClicked(MouseEvent me) {
        ht.initializeTabRendering();
    }

    // Below overrides are not imiplemented because we do not need them
    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
