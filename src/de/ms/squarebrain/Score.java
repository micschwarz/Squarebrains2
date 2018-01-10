package de.ms.squarebrain;

/**
* Scoreelement
* @author 5pixels
*/
public class Score implements Comparable<Score> {
	private String score;
	private String name;
	
	/**
	 * Erstellt Score
	 * @param score Scorewert
	 * @param name Spielername
	 */
	public Score(String score, String name){
		this.score = score;
		this.name = name;
	}
	
	//Compare with argument
	/**
	 * vergleicht Score mit einem anderen
	 * @return Vergleichsergebnis
	 */
	public int compareTo(Score argument){
		if(Integer.parseInt(score)< Integer.parseInt(argument.score)){
			return -1;
		}else if(Integer.parseInt(score) > Integer.parseInt(argument.score)){
			return 1;
		}else{
			return 0;
		}
	}
	
	/**
	 * Gibt Namen aus
	 * @return {@link #name}
	 */
	public String getName(){
		return name;
	}
	/**
	 * Gibt Score aus
	 * @return {@link #score}
	 */
	public String getScore(){
		return score;
	}


}
