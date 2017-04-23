
import com.github.sahasatvik.game.*;

public class Launcher {
	public static String[] symbols = {"X", "O", "H"};
	
	public static void main (String[] args) {
		Player<TicTacToeGame> crosses = new HumanPlayer();
		Player<TicTacToeGame> noughts = new ComputerPlayer(7);
		TicTacToeGame game = new TicTacToeGame(4, 4, 3, crosses, noughts);

		paint(game.board);
		while (!game.isOver()) {
			game.makeMove(game.getNextPlayer().getMove(game));
			paint(game.board);
		}
	}
	
	public static void paint (TicTacToeBoard b) {
		for (int i = 0; i < b.rows; i++) {
			for (int j = 0; j < b.columns; j++) {
				System.out.print("+---");
			}
			System.out.print("+\n");
			for (int j = 0; j < b.columns; j++) {
				String s = "| ";
				int id = b.getItemAt(i, j).id;
				if (id == Integer.MIN_VALUE) {
					s += " ";
				} else {
					s += symbols[id];
				}
				s += " ";
				System.out.print(s);
			} 
			System.out.print("|\n");
		}
		for (int j = 0; j < b.columns; j++) {
			System.out.print("+---");
		}
		System.out.print("+\n");

	}
} 
