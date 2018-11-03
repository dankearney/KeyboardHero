/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Dank
 * Main visualization of game
 */
public class GameplayPanel extends JPanel {
    
    private KeyboardHeroGame game;
    
    // Constructor for the gameplay panel
    public GameplayPanel(KeyboardHeroGame game) {
        super();
        
        // Attach the game
        this.game = game;
        
        // Set panel to be 3/4 the size of the window
        Dimension gpDimension = new Dimension(
                Constants.WINDOW_WIDTH * 3 / 4, Constants.WINDOW_HEIGHT
        );
        this.setPreferredSize(gpDimension);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        // Draw each note
        for ( Note note : this.game.getSong().getNotes() ) {
            note.draw(g, this.game);
        }
        
        // Draw the frets
        for ( Fret fret : this.game.getFrets() ) {
            fret.draw(g, game);
        }
        
        // Iterate the game one step
        this.game.step();
        
    }
}
