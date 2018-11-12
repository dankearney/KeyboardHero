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
 * A class that handles what happens when the "start" button is presssed
 */
public class PlayButtonClickListener implements MouseListener {

    private KeyboardHeroGame game;
    private GameplayControlPanel gcp;
    
    // Constructor
    public PlayButtonClickListener(KeyboardHeroGame game, GameplayControlPanel gcp) {
        super();
        this.game = game;
        this.gcp = gcp;
    }
    
    @Override
    // Starts the game when the button is clicked
    public void mouseClicked(MouseEvent me) {
        // Grab the username
        game.setUsername(gcp.getUsernameLabelValue());
        game.start();
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
