
public class Board {
	
	String [][] board;
	
	public Board() {
		board = new String[4][4];
		initialiseBoard();
		showBoard();
	}
	
	public void initialiseBoard() {
		for ( int i = 1; i<board.length; i++) {
			for (int j = 1; j<board.length; j++) {
				board[i][j] = "  |";
			}
		}
	}
	
	public void showBoard() {
		System.out.println("\n");
		for ( int i = board.length-1; i>0; i--) {
			System.out.print(i);
			for (int j = 1; j<board.length; j++) {
				if(j == 1) {
					System.out.print("|"+board[i][j]);
				}
				else {
				System.out.print(board[i][j]);
				}
			}
			System.out.println("");
		}
		System.out.println("   1  2  3 ");
		
	
	}
	
	public void setPosition(int x, int y, String piece) {
		board[y][x] = piece;
		showBoard();
	}
	
	public boolean checkColumns(String piece) {
		
		if (board[1][1].contains(piece) && board[2][1].contains(piece) && board[3][1].contains(piece)){
			return true;
		}
		if (board[1][2].contains(piece) && board[2][2].contains(piece) && board[3][2].contains(piece)){
			return true;
		}
		if (board[1][3].contains(piece) && board[2][3].contains(piece) && board[3][3].contains(piece)){
			return true;
		}
		return false;
	}
	
	public boolean checkRows(String piece) {
		
		if (board[1][1].contains(piece) && board[1][2].contains(piece) && board[1][3].contains(piece)){
			return true;
		}
		if (board[2][1].contains(piece) && board[2][2].contains(piece) && board[2][3].contains(piece)){
			return true;
		}
		if (board[3][1].contains(piece) && board[3][2].contains(piece) && board[3][3].contains(piece)){
			return true;
		}
		return false;
	}

	public boolean checkDiagonal(String piece) {
		if (board[1][1].contains(piece) && board[2][2].contains(piece) && board[3][3].contains(piece)){
			return true;
		}
		if (board[3][1].contains(piece) && board[2][2].contains(piece) && board[1][3].contains(piece)){
			return true;
		}
		return false;
	}
	
	
	public boolean checkWin(String piece) {
		return (checkRows(piece)||checkColumns(piece)||checkDiagonal(piece));
	}
	
	

}
