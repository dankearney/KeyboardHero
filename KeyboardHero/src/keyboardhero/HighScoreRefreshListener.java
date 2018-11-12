/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Dank
 */
public class HighScoreRefreshListener implements MouseListener {

    // The container tab
    private HighScoreTab ht;
    
    public HighScoreRefreshListener(HighScoreTab ht) {
        this.ht = ht;
    }


    @Override
    public void mouseClicked(MouseEvent me) {
        ht.renderTabComponents();
    }

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
