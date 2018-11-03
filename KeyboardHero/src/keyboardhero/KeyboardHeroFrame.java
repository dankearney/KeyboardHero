/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import javax.swing.JFrame;

/**
 *
 * @author Dank
 */
public class KeyboardHeroFrame extends JFrame {
    
    private KeyboardHeroTabbedPane keyboardHeroTabbedPane;
    
    // Initializes a JFrame at 800x1000 px
    // Closing the window kills the application.
    public KeyboardHeroFrame() {
        super("Keyboard Hero");

        // Add the tabs to the frame
        this.keyboardHeroTabbedPane = new KeyboardHeroTabbedPane();
        this.addTabbedPane();
        
        // Set the frame default 
        this.setFrameDefaults();
    }
   
    // Makes the window visible
    public void run() {
        this.setVisible(true);
        while (true) {
            this.repaint();
        }
    }
    
    // Set JFrame defaults
    private void setFrameDefaults() {
        // Sets the size of the panel fixed
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        
        // Closing the frame kills the application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // Adds the tab pane to the content pane
    private void addTabbedPane() {
        this.getContentPane().add(keyboardHeroTabbedPane);
    }
}
