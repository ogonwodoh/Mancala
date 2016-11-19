package Mancala;
public class MancalaGame {

	public static void main(String[] args){
		MancalaBoard board = new MancalaBoard();
		java.util.Scanner in = new java.util.Scanner(System.in);
		String play;
		int x;
		
		while(board.isWinner().equals("Nobody has won yet")){
			if(board.emptyBoard()){
				System.out.println("Error");
				System.exit(0);
			}
			System.out.println("Player 1, please choose a node to move");
			play="player1";
			x=in.nextInt();
			while(!board.pickNode(x, play).equals("OK")){
				System.out.println("Can't pick "+ x+". Player 1, please choose a node in the range 1-6.");
				play="player1";
				x=in.nextInt();
			}			System.out.println("Player 2, please choose a node to move");
			play="player2";
			x=in.nextInt();
			while(!board.pickNode(x, play).equals("OK")){
				System.out.println("Can't pick "+ x+". Player 2, please choose a node in the range 7-12.");
				play="player2";
				x=in.nextInt();
			}
			board.BoardStanding();
		}
		
		
	}
	
}
