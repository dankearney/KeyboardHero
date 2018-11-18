/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyboardhero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dank
 * Helper class for reading and writing high scores to and from a CSV
 */
public class HighScoreReaderWriter {
    
    // Hard-code the file location of the CSV
    private static final String fileName = ".\\scores.csv";
    
    // Writes a high score
    public static void writeHighScore(HighScore hs) throws IOException {
        // Write high score to a static CSV
        FileWriter f = new FileWriter(fileName, true);
        BufferedWriter b = new BufferedWriter(f);
        b.write(hs.toString());
        b.close();
        f.close(); 
    }
    
    // Reads the high score from the CSV
    public static ArrayList<HighScore> readHighScores() throws FileNotFoundException, IOException {

        // List to store our high scores
        ArrayList<HighScore> highScores = new ArrayList<>();
        
        // Attempt to read the high scores file.
        try {
            // Create a file reader
            FileReader f = new FileReader(fileName);
            BufferedReader buff = new BufferedReader(f);
            
            // Grab the first line of the file
            String s = buff.readLine();
            
            // Read the high scores line by line
            while (s != null) {
                HighScore hs = deserialize(s);
                highScores.add(hs);
                s = buff.readLine();
            }
        } catch (Exception e) {
            System.out.println("Could not read high scores" + e.getMessage());
        }
        highScores.sort(new HighScoreComparator());
        return highScores;
    }
    
    // Returns a string value
    public static String readHighScoresString() throws IOException {
        // Read the high scores
        ArrayList<HighScore> highScores = readHighScores();
        
        // Initialize output string
        String hsString = "";
        
        // Iterate through high scores, generating a printable string
        // Readably!
        for (HighScore hs : highScores ) {
            hsString += hs.toPrettyString();
        }
        return hsString;
    }
    
    // Converts a string to a High Score, assuming it's tab-separated
    public static HighScore deserialize(String s) {
        String[] segments = s.split("\t");
        return new HighScore(segments[0], segments[1], Integer.valueOf(segments[2]));
    }
   
}
