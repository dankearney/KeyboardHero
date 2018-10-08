/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dank
 */
abstract class KeyboardHeroTab extends JPanel {
    
    private String tabName;
    
    public KeyboardHeroTab() {
        super();
    }
    
    abstract void renderTabComponents();
    
    public String getTabName() {
        return tabName;
    }

    public void setTabName(String name) {
        this.tabName = name;
    }
    
}
