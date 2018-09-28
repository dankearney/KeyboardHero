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
    
    // Initializes a JFrame at 800x1000 px
    // Closing the window kills the application.
    public KeyboardHeroFrame() {
        super("Keyboard Hero");
        setSize(1200, 1000);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
