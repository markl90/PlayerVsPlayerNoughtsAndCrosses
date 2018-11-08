import java.util.Scanner;

public class NoughtsAndCrosses {
	
	Scanner scanner = new Scanner(System.in);
	Board board;
	boolean win;
	
	Player player1;
	Player player2;
	

	public NoughtsAndCrosses() {
		createPLayer();
		board = new Board();
		play(player1, player2);
	}
	
	public static void main(String[] args) {
		NoughtsAndCrosses xo = new NoughtsAndCrosses();
	
	}
	
	
	public void createPLayer() {
		System.out.println("Enter the name of Player 1:");
		player1 = new Player(scanner.nextLine());
		player1.setGamePiece(" x|");
		System.out.println(player1.getName()+ " is crosses\n");
		
		System.out.println("Enter the name of Player 2:");
		player2 = new Player(scanner.nextLine());
		player2.setGamePiece(" o|");
		System.out.println(player2.getName() + " is noughts" + "\n");
	}
	
	
	public void makeMove(String piece) {
		boolean taken = false;
		do {
		System.out.println("Enter X pos:");
		int x = scanner.nextInt();
		System.out.println("Enter y pos:");
		int y = scanner.nextInt();
		taken = checktaken(y,x);
		if(!taken) {
		board.setPosition(x, y, piece);
		taken = false;
		}
		win = board.checkWin(piece);
		}
		while(taken);
	}
	
	public void play(Player player1, Player player2) {
		do {
			System.out.println(player1.getName()+"'s go");
			makeMove(player1.getGamePiece());
			if(win) {
				System.out.println(player1.getName()+" WINS");
				break;}
			System.out.println(player2.getName()+"'s go");
			makeMove(player2.getGamePiece());
			if(win) {
				System.out.println(player2.getName() +" WINS");
			}
		}
		while(!win);
		System.out.println("winner");
	}
	
	public boolean checktaken(int x, int y) {
		if (board.board[x][y].contains("  ")) {
		return false;
		}
		System.out.println("Already taken, try again");
	return true;
	}
	
	
}
