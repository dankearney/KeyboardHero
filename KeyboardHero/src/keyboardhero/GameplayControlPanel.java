/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Dank
 * Panel for controlling gameplay
 */
public class GameplayControlPanel extends JPanel {
    
    public GameplayControlPanel() {
        super();
        
        // Set panel to be 1/4 the size of the window
        Dimension gpDimension = new Dimension(Constants.WINDOW_WIDTH * 1 / 4, Constants.WINDOW_HEIGHT);
        this.setPreferredSize(gpDimension);
        this.setBackground(Color.yellow);
        
        // TODO: Add UI elements for controlling game
    }
    
}
