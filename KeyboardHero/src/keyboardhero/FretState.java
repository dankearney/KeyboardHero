/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

/**
 *
 * @author Dank
 * Possible states for a fret to be in:
 * Pressed (user pressing the key down, but did not strike)
 * Struck (user pressed key down, and also struck the fret)
 * Unpressed (not being pressed)
 */
public enum FretState {
    Pressed, Struck, Unpressed;
}
