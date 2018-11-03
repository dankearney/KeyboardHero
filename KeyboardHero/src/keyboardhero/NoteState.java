/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

/**
 *
 * @author Dank
 * The possible states of a note are:
 * Unplayed (not yet in play)
 * Missed (user did not strike note)
 * Hit (user hit note)
 */
public enum NoteState {
    Unplayed, Missed, Hit;
}
