import java.util.Random;
import java.util.Scanner;

public class Game {
	
	private Board B; //The board of the game
	
	private Player p1; //The first player
	private Player p2; //The second player
	
	private int played; //Indicates if the game has been played at least 1 time
	
	
	
	public Game() {
		p1 = new Player();
		p2 = new Player();
		
		B = new Board();
		
		played = 0;
	}
	
	
	
	//Returns the integer that says if the game has been played at least 1 time
	public int getPlayed() {
		return played;
	}
	
	
	//The Menu of the game
	//The function that asks the players what do they want to do and initializes players if they have not played again or if they want to restart the game
	 public int Menu() {
		 Scanner in = new Scanner(System.in);
		 
		 int answer; //The answer of the players
		 int ans; //If the players want to restart the game
		 
		 System.out.print("\n\nWhat do you want to do?\n\n 1) Play\n 2) Scoreboard\n 3) Instructions\n 4)Exit \n\n(Please enter the number of what you want to do)\n\nAnswer: ");
		 do {
			 answer = in.nextInt();
			 if(answer < 1 || answer > 4) {
				 System.out.println("Sorry, but " + answer + " is not a valid answer. Please try again (The answer must be 1, 2, 3 or 4)\n\nAnswer: ");
			 }
		 }while(answer < 1 || answer > 4);
		 
		 if(answer == 1) {
			 if(played == 0) {
				 GameStarting();
				 played = 1;
			 }
			 else {
				 System.out.println("There is already a started game with the names: Player1 - " + p1.getName() + " and Player2 - " + p2.getName() + " (P1's chip: " + p1.getChip() + ", P2's chip: " + p2.getChip() + "Do you want to restart the game? (1 for Yes, 2 for No)\n\nAnswer: ");
				 
				 do {
					 ans = in.nextInt();
					 if(ans != 1 && ans != 2) {
						 System.out.print("Sorry, answer not valid. (Remember answer must be only 1 or 2 (for Yes or No)\n\nAnswer: ");
					 }
				 }while(ans != 1 && ans != 2);
				 
				 
				 if(ans != 2) {
					 GameStarting();
				 }
			 }
		 }
		 
		 return answer;
	 }
 
	 
	 //The function that displays the Scoreboard
	 public void Scoreboard() {
		 
		 int pFirst, pSecond; //The points of the player in the first place and the second place
		 String nFirst, nSecond; //The name of the player in the first place and the second place
		 int draw = 0; //A variable that holds if the players have the same points. 0 means there is no draw and 1 means there is draw
		 
		 
		 if(played == 0)
			 System.out.print("\nThe emptyness in this scoreboard is painful. Play at least one game and come to see the scores...");
		 else {
			 if(p1.getPoints() > p2.getPoints()) {
				 pFirst = p1.getPoints();
				 nFirst = p1.getName();
				 
				 pSecond = p2.getPoints();
				 nSecond = p2.getName();
			 }
			 else if(p1.getPoints() < p2.getPoints() ) {
				 pFirst = p2.getPoints();
				 nFirst = p2.getName();
				 
				 pSecond = p1.getPoints();
				 nSecond = p1.getName();
			 }
			 else {
				 draw = 1;
				 
				 pFirst = p1.getPoints();
				 nFirst = p1.getName();
				 
				 pSecond = p2.getPoints();
				 nSecond = p2.getName();
			 }
			 
			 scorePrint(pFirst, pSecond, nFirst, nSecond, draw);
		 }
	 }
	 
	 
	 //All the printing of the Scoreboard is being held in this function
	 private void scorePrint(int p1, int p2, String n1, String n2, int dr) {
		 
		 System.out.println("_____________________________________________");
		 System.out.println("|          |        Name        |   Score   |");
		 System.out.println("|----------|--------------------|-----------|");
		 System.out.print("|1st Place |");
		 System.out.printf("%20s", n1);
		 System.out.print( "|");
		 System.out.printf("%11d", p1);
		 System.out.print("|\n");
		 System.out.println("|----------|--------------------|-----------|");
		 System.out.print("|2nd Place |");
		 System.out.printf("%20s", n2);
		 System.out.print( "|");
		 System.out.printf("%11d", p2);
		 System.out.print("|\n");
		 System.out.println("----------------------------------------------");
	 }
	 
	 
	 //The menu with the instructions of the game
	 public void Instructions() {
		 System.out.print(" The game 4-In-A-Row is a 2-player game where the objective is to create lines (horizontal, vertical or diagonal) with four pieces of \r\n" + 
		 		"your (chosen) chip. The game starts with selecting 1 from the menu and then entering the player names and player chips. Then after you\r\n" + 
		 		"choose how many rows and columns you would like your game to include, a board similar to the following will appear:\r\n" + 
		 		"\r\n" + 
		 		"| - - - - - - - |\r\n" + 
		 		"| - - - - - - - |\r\n" + 
		 		"| - - - - - - - |\r\n" + 
		 		"| - - - - - - - |\r\n" + 
		 		"| - - - - - - - |\r\n" + 
		 		"| - - - - - - - |\r\n" + 
		 		"-----------------\r\n" + 
		 		"  1 2 3 4 5 6 7\r\n" + 
		 		"\r\n" + 
		 		" Then the first player has to choose a column to insert a chip (the chip falls at the bottom). Then the second player inserts a chip and so forth.\r\n" + 
		 		"The game concludes when a player has created a horizontal, vertical or diagonal line with four of his chips or the board has been maxed out. Examples\r\n" + 
		 		"of concluded games (where X has won):\r\n" + 
		 		"\r\n" + 
		 		"| - - - - - - - |   |   | - - - - - - - |   |   | - - - - - - - |   |   | X O X O X O X |\r\n" + 
		 		"| - - - - - - - |   |   | - - - - X - - |   |   | - - - - O - - |   |   | O X O X O X O |\r\n" + 
		 		"| - - - O X X - |   |   | - - - O X X - |   |   | - - - O X X - |   |   | X O X O X O X |\r\n" + 
		 		"| - - O X X O - |   |   | - - O X X O - |   |   | - - O X X O - |   |   | X O X O X O X |\r\n" + 
		 		"| - X X X X O - |   |   | - - X X X O - |   |   | - - X X X O - |   |   | O X O X O X O |\r\n" + 
		 		"| - O O X O O - |   |   | - O O X O O - |   |   | - X O X O O - |   |   | X O X O X O X |\r\n" + 
		 		"-----------------   |   -----------------   |   -----------------   |   -----------------\r\n" + 
		 		"  1 2 3 4 5 6 7     |     1 2 3 4 5 6 7     |     1 2 3 4 5 6 7     |     1 2 3 4 5 6 7  \r\n" + 
		 		"\r\n" + 
		 		"\r\n");
	 }
	 
	 
	 //A function that prints the message 4 IN A ROW with big (custom made) letters
	 public void connectFourLogo() {
		 System.out.println("    ___________\r\n" + 
		 		"   /    _____   \\        ___________      _______         _____   _______         _____   ________________      ______________      _____________________			          ____      _____\r\n" + 
		 		"  /    /     \\   \\      /            \\    |      \\        |   |   |      \\        |   |   |              |     /    _______   \\     |			|			         /   /      |   |\r\n" + 
		 		" /    /       \\   \\    /     ____     \\   |       \\       |   |   |       \\       |   |   |    __________|    /    /       \\   \\    |_______     _______|			        /   /       |   |\r\n" + 
		 		"/    /         \\___\\   |    /    \\    |   |        \\      |   |   |        \\      |   |   |    |             /    /         \\___\\   	   |     |       			       /   /        |   |\r\n" + 
		 		"|   |                  |    |    |    |   |   |\\    \\     |   |   |   |\\    \\     |   |   |    |_______      |   |    	 	    	   |     |           __________________       /   /         |   |\r\n" + 
		 		"|   |                  |    |    |    |   |   | \\    \\    |   |   |   | \\    \\    |   |   |           |      |   |		    	   |     |          |                  |     /   /__________|   |\r\n" + 
		 		"|   |                  |    |    |    |   |   |  \\    \\   |   |   |   |  \\    \\   |   |   |     ______|      |   |	 	    	   |     |          |                  |    /               |   |\r\n" + 
		 		"|   |           ____   |    |    |    |   |   |   \\    \\  |   |   |   |   \\    \\  |   |   |    |             |   |	     ____   	   |     |          |__________________|   /________________|   |\r\n" + 
		 		" \\   \\         /   /   |    |    |    |   |   |    \\    \\ |   |   |   |    \\    \\ |   |   |    |              \\   \\         /   /   	   |     |       			                    |   |\r\n" + 
		 		"  \\   \\       /   /    |    \\____/    |   |   |     \\    \\|   |   |   |     \\    \\|   |   |    |__________     \\   \\       /   /    	   |     |       			                    |   |\r\n" + 
		 		"   \\   \\_____/   /     \\              /   |   |      \\        |   |   |      \\        |   |              |      \\   \\_____/   /     	   |     |       			                    |   |\r\n" + 
		 		"    \\___________/       \\____________/    |___|       \\_______|   |___|       \\_______|   |______________|       \\___________/      	   |_____|       			                    |___|");
	 }
	 
	 
	 //If the player chooses to begin the game this will start the player names and the types of each players chips
	 public void GameStarting() {
		 Scanner in = new Scanner(System.in);
		 Scanner iin = new Scanner(System.in);
		 
		 int i;
		 String name; //The variable that will hold the player names and then pass it to the Player class
		 char chip = ' '; //The variable that will hold the chip type (X or O) and then pass it to the Player class
		 int pl; //A variable used to print the player number (1 or 2)
		 
		 
		 //Starts the input for both players (where i each player)
		 for( i = 0; i < 2; i++ ) {
			 
			 //Player name input
			 pl = i+1;
			 System.out.println("\n\nPlease enter the Player" + pl + "'s name: ");
			 
			 if( i == 0) { name = in.nextLine(); } //I tried using in.nextLine for both names but for some reason it stopped the program and I couldn't type anything when it returned for a second time at line 35
			 else { name = iin.nextLine(); }
			 
			 
			 if( i == 0 ) {
				 
				 p1.setName(name); //Sets the Player1's name in the class
				 
				 
				 //Player chip input
				 System.out.println("Please enter " + p1.getName() + "'s chip type (Note: The chip can only be X or O): ");
			 
			 	do {
				 	chip = in.next().charAt(0);
				 	
				 	if( chip != 'X' && chip != 'O')
				 		System.out.println("\nSorry, answer invalid. Please try again.\n\n" + p1.getName() + "'s chip type(X or O): ");
				 	
			 	}while(chip != 'X' && chip != 'O');
			 
			 	p1.setChip(chip); //Sets the Player1's chip in the class
			 }
			 else {
				 p2.setName(name); //Sets the Player2's name in the class
				 
				 if(chip == 'X') { p2.setChip('O');} //Sets Player2's chip according to Player1's chip
				 else { p2.setChip('X'); }
				 
				 System.out.println("(Note: " + p2.getName() + "'s chip was set by default "+ p2.getChip() +")\n");
			 }
			 
		 }
		 
	 }
	 
	 
	 //The function that the whole game is played on
	 public void mainGame() {
		 Scanner in = new Scanner(System.in);
		 
		 Random rNumber = new Random();
		 
		 int rows, columns;//The rows and the columns of the game
		 
		 int pl = 1; //The integer that holds in which player the game is currently at
		 
		 int cInp; //The integer that is used so the player can choose where he wants to put his chip to
		 
		 boolean acCol; //The variable that returns as true if the program could insert the chip in the column if the column was acceptable) or false if it could not
		 
		 int ans = 0; //The integer that holds the answer if the game has ended, that starts with the answer 0 that means that the game is still ongoing
		 
		 
		 //Row input
		 System.out.print("How many rows will the game have? (Note: The rows must be at least 4 and at most 15)\n Answer: ");
		 do {
			 rows = in.nextInt();
			 
			 if(rows < 4 || rows > 15)
				 System.out.print("Sorry, but " + rows + " is not a valid answer. Please try again. (Remember the answer must be between 4 and 15)\n\n Answer: ");
		 }while(rows < 4 || rows > 15);
		 
		 //Column input
		 System.out.print("How many columns will the game have? (Note: The rows must be at least 4 and at most 15)\n Answer: ");
		 do {
			 columns = in.nextInt();
			 if(columns < 4 || columns > 15)
				 System.out.print("Sorry, but " + columns + " is not a valid answer. Please try again. (Remember the answer must be between 4 and 15)\n\n Answer: ");
		 }while(columns < 4 || columns > 15);
		 
		 B.setBoard(rows, columns);
		 
		 B.Start(); //Creates the board and fills it with -
		 
		 B.bPrint(); //Prints the board
		 
		 
		 //Chip entry proccess. Repeats until someone wins
		 
		 pl = rNumber.nextInt(2) + 1;
		 while(ans == 0) {
			 System.out.println("\nPlayer" + pl + "'s turn: ");
			 
			 if(pl == 1) {
				 System.out.println(p1.getName() + ", please enter the column that you want to enter your chip(Note: The column must be betweer 1 and " + columns + "): ");
				 do {
					 
					 do {
						 cInp = in.nextInt();
						 
						 if( cInp < 1 || cInp > columns )
							 System.out.print("Sorry, answer not valid. Please try again. (Remember the number must be between 1 and " + columns + ")\n\n Answer: ");
					 }while (cInp < 1 || cInp > columns);
			 
					 acCol = p1.chipInput(B, cInp);
					 
					 if(!(acCol))
						 System.out.print("Sorry the chip could not get inserted to column " + cInp + " because the column is full. Please try another one. (Reminder: The rows must be between 1 to " + columns + ")\n\n Answer: ");
				 }while(!(acCol));
				 
				 
			 }
			 else {
				 System.out.println("\n" + p2.getName() + ", please enter the column that you want to enter your chip(Note: The column must be betweer 1 and " + columns + "): ");
				 do {
					 
					 do {
						 cInp = in.nextInt();
						 
						 if( cInp < 1 || cInp > columns )
							 System.out.print("Sorry, answer not valid. Please try again. (Remember the number must be between 1 and " + columns + ")\n\n Answer: ");
					 }while (cInp < 1 || cInp > columns);
			 
					 acCol = p2.chipInput(B, cInp);
					 
					 if(!(acCol))
						 System.out.print("Sorry the chip could not get inserted to column " + cInp + " because the column is full. Please try another one. (Reminder: The rows must be between 1 to " + columns + ")\n\n Answer: ");
				 }while(!(acCol));
			 }
			 
			 B.bPrint();
			 
			 ans = p1.Check(B); //Returns 0 if the game has not yet ended, 1 if the game won Player1, 2 if the Player2 won and 3 if it ended as a draw
			 
			 if(ans == 1) {
				 System.out.println("\n GAME OVER. THE WINNER IS " + p1.getName() + "\n\n");
				 p1.setPoint();
			 }
			 else if(ans == 2) {
				 System.out.println("\n GAME OVER. THE WINNER IS " + p2.getName() + "\n\n");
				 p2.setPoint();
			 }
			 else if(ans == 3)
			 	System.out.println("\n GAME OVER! WE HAVE A DRAW!\n\n");
			 
			 if( pl == 1) pl = 2;
			 else pl = 1;
		 }
		 
	 }
	 

}
