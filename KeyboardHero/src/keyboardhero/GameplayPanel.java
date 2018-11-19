/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.awt.Color;
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
    
    // The relevant game object
    private final KeyboardHeroGame game;
    
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
        
        // Attach click logic
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
            
            // Determine correct keyboard letter to map to the key events
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
        KeyStroke struck = KeyStroke.getKeyStroke(KeyEvent.VK_L, 0, false);
        inMap.put(struck, strikeActionStr);
        actMap.put(strikeActionStr, new StrikeKeyboardAction(game));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        // If the game is dormant, just draw something simple.
        if (this.game.isDormant()) {
            // Draw score on top left
            g.setFont(new Font("Arial", Font.BOLD, 40));
            
            String text = "Select a song to begin.";
            g.drawString(text, 250, 450);
        }
        
        // Draw the game in gameplay mode.
        else if (this.game.isPlaying()) 
        {
            
            // Draw the fret line
            g.setColor(Color.black);
            int height = 2;
            int width = Constants.FRET_SPACING * (this.game.getFrets().size());
            int x = 100;
            int y = Constants.FRET_OFFSET_HEIGHT + Constants.BASE_FRET_HEIGHT / 2 - height / 2;
            g.fillRect(x, y, width, height);
            
            // Draw helper text for fret line
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("L", x - 30, y + 10);
            
            // Draw the frets
            for ( Fret fret : this.game.getFrets() ) {
                fret.draw(g, game);
            }

            // Draw each note
            for ( Note note : this.game.getSong().getNotes() ) {
                note.draw(g, this.game);
            }
            
            // Draw score on top left with time remaining
            int timeRemaining = (int) (Constants.SONG_LENGTH - game.getCurrentTimestamp()) / 1000;
            String labelText = String.format(
                    "Time remaining: %d    Score: %d", 
                    timeRemaining, 
                    this.game.getScore()
            );
            g.setColor(Color.black);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString(labelText, 50, 50);

            // Iterate the game state forward one step
            this.game.step();
        }
        
        // Draw the game completed UI
        else if (this.game.isComplete()) 
        {
            // Draw score on top left in large font
            g.setFont(new Font("Arial", Font.BOLD, 40));
            String text = "Song complete! Your score: " + Integer.toString(this.game.getScore());
            g.drawString(text, 150, 400);
    
        }
    }
}
