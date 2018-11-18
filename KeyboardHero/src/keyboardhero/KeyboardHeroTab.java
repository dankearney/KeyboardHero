/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import javax.swing.JPanel;

/**
 *
 * @author Dank
 * Abstract class for a tab in the game UI
 */
abstract class KeyboardHeroTab extends JPanel {
    
    protected String tabName = "Tab Name";
    
    // Constructor
    public KeyboardHeroTab() {
        super();
    }
    
    // Subclasses must implement this to initially render    
    abstract void initializeTabRendering();
    
    // Getter for tab name
    public String getTabName() {
        return tabName;
    }

    // Setter for tab name
    public void setTabName(String name) {
        this.tabName = name;
    }
    
}
