/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Dank
 * Panel for controlling gameplay
 */
public class GameplayControlPanel extends JPanel {
    
    private KeyboardHeroGame game;
    private JTextField usernameTextField;
    
    public GameplayControlPanel(KeyboardHeroGame game) {
        super();
        
        // Attach game to control panel
        this.game = game;
        
        // Set panel to be 1/4 the size of the window
        Dimension gpDimension = new Dimension(Constants.WINDOW_WIDTH * 1 / 4, Constants.WINDOW_HEIGHT);
        this.setPreferredSize(gpDimension);
        this.setBackground(Color.white);
        
        // Add a label and text box for a user to enter their name
        JLabel usernameLabel = new JLabel("Username: ");
        usernameTextField = new JTextField(game.getUsername());
        this.add(usernameLabel);
        this.add(usernameTextField);        
        
        // Add a combo box for picking a song
        JComboBox songPicker = new JComboBox();
        
        // Add references to our songs
        for (String songName : Constants.SONG_NAMES) {
            songPicker.addItem(songName);
        }
        
        // Set the current song to the first item in the combo box
        game.setSongName(songPicker.getItemAt(0).toString());
        
        // Add a listener to changing the dropdown menu
        songPicker.addActionListener(new SongPickerListener(game));
        
        // Add the combo box to the frame
        this.add(songPicker);
        
        // Add the play button
        JButton playButton = new JButton("Start");
                
        // Set up click listener
        playButton.addMouseListener(new PlayButtonClickListener(game, this));
        this.add(playButton);
        
        // Add the play button
        JButton stopButton = new JButton("Stop");
                
        // Set up click listener
        stopButton.addMouseListener(new StopButtonClickListener(game));
        this.add(stopButton);
        
        
    }

    public String getUsernameLabelValue() {
        return this.usernameTextField.getText();
    }
    
}
