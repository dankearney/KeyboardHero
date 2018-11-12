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
 */
public class SongPickerListener implements ActionListener {

    KeyboardHeroGame game;
    
    public SongPickerListener(KeyboardHeroGame game) {
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Get the value of the selected item, which is the song name
        String songName = (String) ((JComboBox) ae.getSource()).getSelectedItem();
        
        // Set the song name to be the selected song name
        game.setSongName(songName);
    }
    
}
