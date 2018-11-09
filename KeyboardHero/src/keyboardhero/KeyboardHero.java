/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

/**
 *
 * @author Dank
 */
public class KeyboardHero  {

    /**
     * @param args the command line arguments
     * Main entry point for the Keyboard Hero game.
     * Instantiates the necessary UI frame which kicks off the game 
     */
    public static void main(String[] args) throws InterruptedException {
        // Initialize the main UI frame
        KeyboardHeroFrame khf = new KeyboardHeroFrame();
        
        // Run the main UI frame
        khf.run();
    }
    
}
