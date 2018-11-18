/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author Dank
 * Tab that contains the main gameplay elements
 */
public class GameplayTab extends KeyboardHeroTab {

    // Game to be played
    private KeyboardHeroGame game;
    
    // Constructor for the gameplay tab. Creates an instance of a game
    public GameplayTab() {
        super();
        this.tabName = "Gameplay";      
        
        // Create a game
        this.game = new KeyboardHeroGame();

    }
 
    @Override
    public void initializeTabRendering() {
        // Set up a two column layout
        // Start with a border layout
        this.setLayout(new BorderLayout());       
        
        // Create panels for gameplay control and gameplay itself
        GameplayControlPanel controlPanel = new GameplayControlPanel(this.game);
        GameplayPanel gameplayPanel = new GameplayPanel(this.game);
        
        // Add panels to left (West) and right (East) sides of the tab
        this.add(controlPanel, BorderLayout.WEST);
        this.add(gameplayPanel, BorderLayout.EAST);
        
    }
    
    // Getters and setters for gameplay
    public KeyboardHeroGame getGame() {
        return this.game;
    }
    
}
