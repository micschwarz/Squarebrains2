package de.ms.squarebrain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
* Verwaltet Highscores
* @author 5pixels
*/
public class Highscore {
	private int lines;
	private String mode;
	private Score[] scorelist;
	
	/**
	 * Erstelle Verwalter
	 * @param mode Spielmodus
	 */
	
	public Highscore(String mode){
		lines = 10;
		this.mode = mode;
		String file = mode + ".txt";
		String userpath = System.getProperty("user.home");
		Path scorepath = Paths.get(userpath, ".squarebrain", "scores", file);
		if(Files.exists(scorepath)){
			System.out.println("\'" + scorepath.toString() + "\' exestiert bereits");
		}else{
			File score = new File(scorepath.toString());
			score.getParentFile().mkdirs();
			System.out.println("\'" + scorepath.toString() + "\' erstellt");
			try {
				PrintWriter writer = new PrintWriter(score);
				//for geht nicht .-.
				writer.println("000_5pixels_easy");
				writer.println("000_5pixels_easy");
				writer.println("000_5pixels_easy");
				writer.println("000_5pixels_easy");
				writer.println("000_5pixels_easy");
				writer.println("000_5pixels_easy");
				writer.println("000_5pixels_easy");
				writer.println("000_5pixels_easy");
				writer.println("000_5pixels_easy");
				writer.println("000_5pixels_easy");
				writer.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		scorelist = new Score[11];
		String[] scores = readList();
		for(int i = 0; i <=9; i++){
			String s = scores[i];
			String[] b = s.split("_");
			scorelist[i] = new Score(b[0], b[1]);
		}
		scorelist[10]=null;

	}
	
	/**
	 * Gibt die aktuelle Scoreliste aus
	 * @return Scoreliste
	 */
	public Score[] getScores(){
		scorelist = new Score[11];
		String[] scores = readList();
		for(int i = 0; i <=9; i++){
			String s = scores[i];
			String[] b = s.split("_");
			scorelist[i] = new Score(b[0], b[1]);
		}
		scorelist[10]=null;
		return scorelist;
	}
	
	/**
	 * Liest Scoredatei und gibt die Scores aus
	 * @return Datenliste
	 */
	public String[] readList(){
		String file = mode + ".txt";
		String userpath = System.getProperty("user.home");
		Path scorepath = Paths.get(userpath, ".squarebrain", "scores", file);
			FileReader fr = null;
			try {
				fr = new FileReader(scorepath.toString());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			BufferedReader textReader = new BufferedReader(fr);
			String[] data = new String[lines];
			System.out.println("Scores:");
			for(int i = 0; i < lines; i++){
				try {
					data[i] = textReader.readLine();
					System.out.println(data[i]);
				} catch (IOException e) {
					e.printStackTrace();
				}
			};
			try {
				textReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return data;
	}
	
	//Punktzahl zu String wandeln und mit "0" vorne auff�llen
	/**
	 * F�llt einen int score mit "0" bis auf 0 stellen auf und wandelt ihn in String um
	 * @param score zu wandelnder Score
	 * @return Score als String 
	 */
    public String getScoreString(int score) {
        String result = String.valueOf(score);
        while (result.length() < 3) {
            result = "0" + result;
        }
        return result;
    }
	
    //Scoreliste neu schreiben
    /**
     * Schreibt neuen Score sortiert in eine Textdatei
     * @param name Name des neuen Scores
     * @param sco Scorewert
     */
	public void writeScore(String name, int sco){
		String sc = getScoreString(sco);
		Score s = new Score(sc, name);
		scorelist[10]=s;
		java.util.Arrays.sort(scorelist);
		String file = mode + ".txt";
		String userpath = System.getProperty("user.home");
		Path scorepath = Paths.get(userpath, ".squarebrain", "scores", file);
		File score = new File(scorepath.toString());
		try {
			PrintWriter writer = new PrintWriter(score);
			//"for" nicht m�glich
			writer.println(scorelist[1].getScore()+"_"+scorelist[1].getName());
			writer.println(scorelist[2].getScore()+"_"+scorelist[2].getName());
			writer.println(scorelist[3].getScore()+"_"+scorelist[3].getName());
			writer.println(scorelist[4].getScore()+"_"+scorelist[4].getName());
			writer.println(scorelist[5].getScore()+"_"+scorelist[5].getName());
			writer.println(scorelist[6].getScore()+"_"+scorelist[6].getName());
			writer.println(scorelist[7].getScore()+"_"+scorelist[7].getName());
			writer.println(scorelist[8].getScore()+"_"+scorelist[8].getName());
			writer.println(scorelist[9].getScore()+"_"+scorelist[9].getName());
			writer.println(scorelist[10].getScore()+"_"+scorelist[10].getName());
			writer.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
