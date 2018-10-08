/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import javax.swing.JLabel;

/**
 *
 * @author Dank
 */
public class GameplayTab extends KeyboardHeroTab {
    
    public GameplayTab() {
        super();
    }
 
    @Override
    public void renderTabComponents() {
        this.setTabName("Gameplay");
        JLabel label = new JLabel();
        label.setText(String.format("Welcome to %s", this.getTabName()) );
        this.add(label);
    }
    
}
