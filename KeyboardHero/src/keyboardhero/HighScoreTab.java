/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

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
        // Set up simple header
        JLabel header = new JLabel("High Scores");
        this.add(header);
        
        // Read high scores from file and append to the end
        JLabel label = new JLabel();
        String highScoreText = "";
        try {
            highScoreText = HighScoreReaderWriter.readHighScores();
        } catch (IOException ex) {
            System.out.println("Unable to read high scores");
        }
        label.setText(highScoreText);

        this.add(label);
    }
    
}
