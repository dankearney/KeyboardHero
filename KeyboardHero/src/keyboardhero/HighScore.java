/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

/**
 *
 * @author Dank
 * Keeps track of a single high score record
 */
public class HighScore {
    
    private String username;
    private String songName;

    // Getters and setters
    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    private int score;
    
    // A single high score record
    // Requires three bits of data: user, song name, score they achieves.
    public HighScore(String username, String songName, int score) {
        this.username = username;
        this.songName = songName;
        this.score = score;
    }
    
    // Returns as a tab-separated for easy writing as CSV
    public String toString() {
        return this.username + "\t" + this.songName + "\t" + Integer.toString(score) + "\r\n";
    }
    
}
