/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 *
 * @author Dank 
 * This handles the change in state when a user switches songs from the 
 * song dropdown menu
 */
public class SongPickerListener implements ActionListener {

    // Game state
    KeyboardHeroGame game;
    
    // Constructor
    public SongPickerListener(KeyboardHeroGame game) {
        this.game = game;
    }

    @Override
    // Handles when a user changes the state of the dropdown
    public void actionPerformed(ActionEvent ae) {
        // Get the value of the selected item, which is the song name
        String songName = (String) ((JComboBox) ae.getSource()).getSelectedItem();
        
        // Set the song name to be the selected song name
        game.setSongName(songName);
    }
    
}
