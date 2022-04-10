
public class Board {
	
	private char B[][]; //The board of the game
	
	private int rows; //The rows of the board
	
	private int columns; //The columns of the board
	
	private int currentGame[]; //This array will have as many columns as the board will have and it will hold in where the chip will drop
	
	private int currentColumn; //Holds the position of the last dropped chip
	
	
	public Board() {
		rows = 0;
		columns = 0;
		currentColumn = 0;
		
		B = new char[rows][columns];
		currentGame = new int[columns];
	}
	
	
	
	//Sets the B array as an array with r rows and c columns
	public void setBoard( int r, int c) {
		int i;
		
		rows = r;
		columns = c;
		
		B = new char[rows][columns];
		currentGame = new int[columns];
		
		for( i = 0; i < columns; i++ )
			currentGame[i] = rows - 1;
	}
	
	
	//The function that creates the array, making him ready for the game to start
	public void Start() {
		int i, j;
		
		for( i = 0; i < rows; i++ ) {
			for( j = 0; j < columns; j++ )
				B[i][j] = '-';
		}
	}
	
	
	//Inserts the ch chip on the board in the available spot on column col
	public boolean chipInsert(char ch, int col ) {
		
		if( currentGame[col] < 0)
			return false;
		else {
			B[currentGame[col]][col] = ch;
			currentGame[col]--;
			currentColumn = col;
			return true;
		}
	}
	
	
	//Checks if the game has ended. Returns 0 if no one won, 1 if Player1 won, 2 if Player2 won or 3 if its a draw
	public int checkB(char c) {
		
		int i;
		char p1, p2; //The chips of the two players
		int has_ended = 0; //Keeps the sum of the rows that are full
		String Commands[];
		
		Commands = new String[4];
		commandArray(Commands);
		
		p1 = c;
		if( p1 == 'X' ) p2 = 'O';
		else p2 = 'X';
		
		for( i = 0; i < columns; i++) {
			if(B[0][i] != '-') has_ended++;
		}
		
		if(has_ended == columns) return 3;
		
		for(i = 0; i < 4; i++) {
			if(checkTheBoard(Commands[i], p1)) return 1;
			else if(checkTheBoard(Commands[i], p2)) return 2;
		}
		
		return 0;
	}
	
	
	/*It checks the row 3 characters beside the character we are currently at and creates a sum. If the sum is 4 it returns true. When used with the command row it checks the row,
	 * with the command column it checks the column, the command diagonal_left the diagonal that has 130 degrees and with the command diagonal_right it checks the diagonal with 45 degrees */
	private boolean checkTheBoard( String command, char c) {
		
		int i;
		int checker = 0; //The variable that holds if there was formed a 4
		int rowOfInterest = currentGame[currentColumn] + 1; //The row we are checking if there are 4 in a row
		
		
		if( command == "row") {
			for( i = 0; i <= 3; i ++) {
				if(currentColumn + i >= columns) break;
				else if(B[rowOfInterest][currentColumn + i] == c )
					checker++;
				else break;
			}
			
			
			for( i = -1; i >= -3; i-- ) {
				if(checker == 4) return true;
				else if(currentColumn + i < 0) break;
				else if(B[rowOfInterest][currentColumn + i] == c)
					checker++;
				else break;
			}
			
			if(checker == 4) return true;
			
			return false;
		}
		else if( command == "column") {
			for( i = 0; i <= 3; i++) {
				if(rowOfInterest + i >= rows) break;
				else if(B[rowOfInterest + i][currentColumn] == c)
					checker++;
				else break;
			}
			
			for(i = -1; i >= -3; i--) {
				if(checker == 4) return true;
				else if(rowOfInterest + i < 0) break;
				else if(B[rowOfInterest + i][currentColumn] == c)
					checker++;
				else break;
			}
			
			if(checker == 4) return true;
			
			return false;
		}
		else if( command == "diagonal_right") {
			for( i = 0; i <= 3; i++) {
				if(rowOfInterest - i < 0 || currentColumn + i >= columns) break;
				else if(B[rowOfInterest - i][currentColumn + i] == c)
					checker++;
				else break;
			}
			
			for( i = 1; i <= 3; i++) {
				if(checker == 4) return true;
				else if(rowOfInterest + i >= rows || currentColumn - i < 0) break;
				else if(B[rowOfInterest + i][currentColumn - i] == c)
					checker++;
				else break;
			}
			
			if(checker == 4) return true;
			
			return false;
		}
		else {
			for( i = 0; i <= 3; i++) {
				if(rowOfInterest + i >= rows || currentColumn + i >= columns) break;
				else if(B[rowOfInterest + i][currentColumn + i] == c)
					checker++;
				else break;
			}
			
			for( i = -1; i >= -3; i--) {
				if(checker == 4) return true;
				else if(rowOfInterest + i < 0 || currentColumn + i < 0) break;
				else if(B[rowOfInterest + i][currentColumn + i] == c)
					checker++;
				else break;
			}
			
			if(checker == 4) return true;
			
			return false;
		}
	}
	
	
	//Creates the array with the commands for the checkTheBoard function 
	private void commandArray( String Com[] ) {
		
		Com[0] = "row";
		Com[1] = "column";
		Com[2] = "diagonal_right";
		Com[3] = "diagonal_left";
	}
	
	
	//The function that prints the board
	public void bPrint() {
		int i, j;
		
		System.out.print("\n");
		for(i = 0; i < rows; i++) {
			
			System.out.print("|");
			
			for( j = 0; j < columns; j++)
				System.out.print(" " + B[i][j]);
			
			System.out.print(" |\n");
		}
		
		for( i = 0; i < (3 + 2*columns); i++ )
			System.out.print("-");
		
		System.out.print("\n  ");
		for( i = 1; i <= columns; i++) 
			System.out.print( i + " ");
		
		System.out.print("\n");
		
	}
}
