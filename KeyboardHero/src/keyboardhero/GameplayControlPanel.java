/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Dank
 * Panel for controlling gameplay
 */
public class GameplayControlPanel extends JPanel {
    
    // Game to be played
    private KeyboardHeroGame game;
    
    // Text field of the supplied username
    private JTextField usernameTextField;
    
    // Constructor
    public GameplayControlPanel(KeyboardHeroGame game) {
        super();
        
        // Attach game to control panel
        this.game = game;
        
        // Set panel to be 1/4 the size of the window
        Dimension gpDimension = new Dimension(Constants.WINDOW_WIDTH * 1 / 4, Constants.WINDOW_HEIGHT);
        this.setPreferredSize(gpDimension);
        this.setBackground(Color.decode(Constants.BACKGROUND_COLOR_RGB));

        
        // Add a header
        JLabel headerLabel = new JLabel("Keyboard Hero");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 35));
        this.add(headerLabel); 
       
        // Add a label and text box for a user to enter their name
        JLabel usernameLabel = new JLabel("Username: ");
        usernameTextField = new JTextField(game.getUsername(), 16);
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
        
        // Add the play button with a click event listener
        JButton playButton = new JButton("Start");
        playButton.addMouseListener(new PlayButtonClickListener(game, this));
        this.add(playButton);
        
        // Add the play button
        JButton stopButton = new JButton("Stop");
                
        // Set up click listener for stop button
        stopButton.addMouseListener(new StopButtonClickListener(game));
        this.add(stopButton);
        
        // Helpful text on how to play the game.
        // HTML format so that it can be multi-line
        JLabel helpLabel = new JLabel(
            "<html>"
                    + "<br />"
                    + "Use A S D F G to hold down a fret."
                    + "<br />"
                    + "Press L while holding a fret to strike the fret."
                    + "<br />"
                    + "Gain points by striking notes!"
                    + "</html>"
        );
        this.add(helpLabel);
    }

    // Getter for the user's supplied name
    public String getUsernameLabelValue() {
        return this.usernameTextField.getText();
    }

}
