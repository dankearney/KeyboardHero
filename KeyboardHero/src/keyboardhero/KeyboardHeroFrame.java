/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;

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
        this.keyboardHeroTabbedPane = new KeyboardHeroTabbedPane();
        this.addTabbedPane();
        this.setFrameDefaults();
    }
   
    
    // Makes the window visible
    public void run() {
        this.setVisible(true);
    }
    
    // Set JFrame defaults
    private void setFrameDefaults() {
        setSize(1200, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // Adds the tab pane to the content pane
    private void addTabbedPane() {
        this.getContentPane().add(keyboardHeroTabbedPane);
    }
}
