
public class Player {
	
	private String name; //The name of the player
	
	private char chip; //The type of his chip (X or O)
	
	private int points; //The points the player has won
	
	
	
	public Player() { 
		name = "";
		chip = ' ';
		points = 0;
	}
	
	
	
    //Sets the player name as the string n
	public void setName( String n) {
		name = n;
	}
	
	
	//Sets the chip as the character c
	public void setChip( char c) {
		chip = c;
	}
	
	
	public void setPoint() {
		points++;
	}
	
	
	//Returns the name of the player
	public String getName() {
		return name;
	}
	
	
	//Returns the chip the player has
	public char getChip() {
		return chip;
	}
	
	
	//Returns the point that the player has earned
	public int getPoints() {
		return points;
	}
	
	
	//A function that only Player1 uses, that checks if the game has ended. 0 the game is still ongoing, 1 Player1 won, 2 Player2 won, 3 it's a draw
	public int Check(Board b) {
		return b.checkB(chip);
	}
	
	
	//Enters the chip to the column c if it can and returns true. If it can not enter the chip it returns false
	public boolean chipInput(Board b, int c) {
		c--;
		return b.chipInsert(chip, c);
	}
}
