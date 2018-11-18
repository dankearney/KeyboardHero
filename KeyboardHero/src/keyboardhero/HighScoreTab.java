/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Dank
 */
public class HighScoreTab extends KeyboardHeroTab {
    
    // Constructor for the high score tab
    public HighScoreTab() {
        super();
        // Set tab name 
        this.tabName = "High Scores";
    }
    
    @Override
    // Renders teh tab
    public void initializeTabRendering() {
        // Clear the UI
        this.removeAll();
        
        // Add an empty border to add padding around text
        this.setBorder(new EmptyBorder(0, Constants.WINDOW_WIDTH / 4, 0, Constants.WINDOW_WIDTH / 4));
        this.setBackground(Color.decode(Constants.BACKGROUND_COLOR_RGB));
        
        // Set up simple header
        JLabel header = new JLabel("High Scores");
        header.setFont(new Font("Arial", Font.BOLD, 40));
        this.add(header);
        
        // ADd a button to refresh high scores
        JButton highScoreRefreshButton = new JButton("Refresh");
        highScoreRefreshButton.addMouseListener(new HighScoreRefreshListener(this));
        this.add(highScoreRefreshButton);

        // Read high scores from file and append to the end
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        
        // Attempt to read high scores 
        String highScoreText = "";
        try {
            highScoreText = HighScoreReaderWriter.readHighScoresString();
        } catch (IOException ex) {
            System.out.println("Could not read high scores");
        }
        textArea.setText(highScoreText);
        textArea.setBackground(Color.decode(Constants.BACKGROUND_COLOR_RGB));
        textArea.setFont(new Font("Arail", Font.PLAIN, 16));
        
        // Add the text!
        this.add(textArea);
        
    }
    
}
