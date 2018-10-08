/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import javax.swing.JTabbedPane;

/**
 *
 * @author Dank
 */
public class KeyboardHeroTabbedPane extends JTabbedPane {
    
    private final KeyboardHeroTab[] keyboardHeroTabs;
    
    public KeyboardHeroTabbedPane() {
        super();
        keyboardHeroTabs = new KeyboardHeroTab[] {
            new GameplayTab(), 
            new HighScoreTab(), 
            new SettingsTab() 
        };
        this.addAllTabs();
    }
    
    // Adds all tabs to current view
    private void addAllTabs() {
        for ( KeyboardHeroTab kht : keyboardHeroTabs ) {
            kht.renderTabComponents();
            this.add(kht);
        }
    }
    
    // Adds the kht tab to the panel and sets the tab name
    private void add(KeyboardHeroTab kht) {
        this.add(kht.getTabName(), kht);
    }
    
}
