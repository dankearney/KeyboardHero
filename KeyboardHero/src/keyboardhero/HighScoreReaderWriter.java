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

/**
 *
 * @author Dank
 */
public class HighScoreReaderWriter {
    
    // Writes a high score
    public static void writeHighScore(String username, String song, int score) throws IOException {
        FileWriter f = new FileWriter(".\\scores.csv");
        BufferedWriter buff = new BufferedWriter(f);
        
        try
        {
            buff.append(username + "    " + song + "    " + Integer.toString(score));
        }
        catch (Exception e)
        {
            System.out.println("Failed to write high score");
        }
        finally
        {
            buff.close();
            f.close();
        }
    }
    
    // Reads the high score
    public static String readHighScores() throws FileNotFoundException, IOException {
        FileReader f = new FileReader(".\\scores.csv");
        BufferedReader buffReader = new BufferedReader(f);
        String scores = "";
        
        try
        {
            while (true)
            {
                String nextLine = buffReader.readLine();
                if (nextLine == null || nextLine.length() == 0) {
                    break;
                }
                else
                {
                    scores += nextLine;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Failed to write high score");
        }
        finally
        {
            buffReader.close();
            f.close();
        }
        
        return scores;
    }
    
}
