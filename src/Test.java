
import java.util.*;
import com.github.sahasatvik.game.*;

public class Test {
	public static String[] symbols = {"X", "O"};
	
	public static void main (String[] args) {
		/*
		Player<TicTacToeGame> crosses = new HumanPlayer();
		ComputerPlayer noughts = new ComputerPlayer(9);
		TicTacToeGame game = new TicTacToeGame(3, 3, 3, crosses, noughts);
		
		System.out.println(game.getCurrentPlayer() == noughts);
		
		game.board.setItemAt(0, 0, game.getPiece(crosses));
		game.board.setItemAt(0, 1, game.getPiece(crosses));
		game.board.setItemAt(1, 1, game.getPiece(noughts));
		
		game.currentPlayerId = game.getNextPlayerId();
		List<Move<TicTacToeGame>> moves = game.getValidMoves();
		for (Move<TicTacToeGame> m : moves) {
			paint(m.getNewGame().board);
			System.out.println(m.getNewGame().getCurrentPlayer().toString() + " : " + noughts.evaluate(noughts, m.getNewGame(), 0));
			for (Move<TicTacToeGame> n : m.getNewGame().getValidMoves()) {
				paint(n.getNewGame().board);
				System.out.println(n.getNewGame().getCurrentPlayer().toString() + " : " + noughts.evaluate(noughts, n.getNewGame(), 1));
			}
		}
		game.makeMove(noughts.getMove(game));
		paint(game.board);
		System.out.println(game.getCurrentPlayer().toString() + " : " + noughts.evaluate(noughts, game, 1));

		*/
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
