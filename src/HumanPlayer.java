
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import com.github.sahasatvik.game.*;

public class HumanPlayer implements Player<TicTacToeGame> {
	public Scanner inp;
	public HumanPlayer () {
		inp = new Scanner(System.in);
	}
	public Move<TicTacToeGame> getMove (TicTacToeGame game) {
		int row = -1, column = -1;
		TicTacToeGame newGame = new TicTacToeGame(game);
		System.out.print("Enter your move (row <space> column): ");
		try {
			row = inp.nextInt();
			column = inp.nextInt();
		} catch (Exception e) {
		} finally {
			while (!newGame.makeMove(row, column)) {
				System.out.print("Invalid Move! Try again: ");
				row = inp.nextInt();
				column = inp.nextInt();
			}
		}
		return () -> newGame;
	}
}
