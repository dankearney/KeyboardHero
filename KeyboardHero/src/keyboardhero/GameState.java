/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

/**
 *
 * @author Dank
 * The possible states of a game.
 * Dormant means waiting for game to begin
 * Playing means game is in session
 * Paused means paused
 * Complete means game is over
 */
public enum GameState {
    Dormant, Playing, Paused, Complete;
}
