/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

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
        
        this.setKeyBindings();
        
    }

    private void setKeyBindings() {
        // Set up key bindings to handle button presses
        InputMap inMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actMap = getActionMap();
        
        // Iterate over the frets and add a key binding for each key value
        // Help for implementing this found on Stack Overflow:
        // https://stackoverflow.com/questions/7940173/how-do-i-use-keyeventdispatcher/7940227#7940227
        for (Fret fret : this.game.getFrets()) {
            // Pull the name of the fret from the string the fret is on
            String fretStr = fret.getKeyboardString().toString();
            
            // Create a unique action string for the fret 
            String pressActionStr = "pressed" + fretStr;
            String unpressActionStr = "unpressed" + fretStr;
            
            // Determine correct keyboard letter
            int k = -1;
            switch (fret.getKeyboardString()) {
                case A:
                    k = KeyEvent.VK_A;
                    break;
                case S:
                    k = KeyEvent.VK_S;
                    break;
                case D:
                    k = KeyEvent.VK_D;
                    break;
                case F:
                    k = KeyEvent.VK_F;
                    break;
                case G:
                    k = KeyEvent.VK_G;
                    break;                   
            }
            
            // Assign key stroke actions to the fret button for pressing
            KeyStroke pressed = KeyStroke.getKeyStroke(k, 0, false);
            inMap.put(pressed, pressActionStr);
            actMap.put(pressActionStr, new FretKeyboardAction(fret, true));
            
            // Assign key stroke actions to the fret button for un-pressing
            KeyStroke unpressed = KeyStroke.getKeyStroke(k, 0, true);
            inMap.put(unpressed, unpressActionStr);
            actMap.put(unpressActionStr, new FretKeyboardAction(fret, false));
        }
        
        // Create a unique action string for the fret 
        String strikeActionStr = "struck";
        KeyStroke struck = KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true);
        inMap.put(struck, strikeActionStr);
        actMap.put(strikeActionStr, new StrikeKeyboardAction(game));
    }
    
    @Override
    public void paintComponent(Graphics g) {

        // Draw the frets
        for ( Fret fret : this.game.getFrets() ) {
            fret.draw(g, game);
        }
        
        // Draw each note
        for ( Note note : this.game.getSong().getNotes() ) {
            note.draw(g, this.game);
        }
        
        // Draw score on top left
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString(Integer.toString(this.game.getScore()), 50, 50);
        
        
        // Iterate the game one step
        this.game.step();
        
    }
}
