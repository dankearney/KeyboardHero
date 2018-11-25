/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

/**
 *
 * @author Dank
 * Represents a single completed game record
 */
public class HighScore {
    
    // Member variables
    private String username;
    private String songName;
    private int score;

    
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
    
    // A single high score record
    // Requires three pieces of data: user, song name, score they achieved
    public HighScore(String username, String songName, int score) {
        this.username = username;
        this.songName = songName;
        this.score = score;
    }
    
    // Returns as a tab-separated for easy writing as CSV
    public String toString() {
        return this.username + "\t" + this.songName + "\t" + Integer.toString(score) + "\r\n";
    }
    
    // Returns as pretty string for printing
    public String toPrettyString() {
        return String.format("%-30s\t%-50s\t%-30d\r\n", this.username, this.songName, this.score);
    }
    
}
