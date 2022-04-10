public class Main {

	public static void main(String[] args) {
		
		Game connect4 = new Game();
		
		int Answer = 4; //The variable that holds the answer that player gave in the menu
		
		connect4.connectFourLogo();
		System.out.print("\nWelcome!!\n\n");
		do {
			Answer = connect4.Menu(); //Prints the menu and asks the players the basic questions (Names and chips)
			if(Answer == 1) connect4.mainGame(); //Starts the game
			else if(Answer == 2) connect4.Scoreboard(); //Displays the scoreboard
			else if(Answer == 3) connect4.Instructions(); //Displays the game instructions
		}while(Answer != 4);
	}
	 
}