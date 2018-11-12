/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Dank
 */
public class HighScoreTab extends KeyboardHeroTab {
    
    public HighScoreTab() {
        super();
        this.tabName = "High Scores";
    }
 
    @Override
    public void renderTabComponents() {
        // Clear the UI
        this.removeAll();
        
       // Set up simple header
        JLabel header = new JLabel("High Scores");
        this.add(header);
                
        // Read high scores from file and append to the end
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        
        String highScoreText = "";
        try {
            highScoreText = HighScoreReaderWriter.readHighScoresString();
        } catch (IOException ex) {
            System.out.println("Could not read high scores");
        }
        textArea.setText(highScoreText);
        
        // ADd UI to refresh high scores
        JButton highScoreRefreshButton = new JButton("Refresh");
        
        highScoreRefreshButton.addMouseListener(new HighScoreRefreshListener(this));
        this.add(highScoreRefreshButton);
        // Add the text!
        this.add(textArea);
    }
    
}
