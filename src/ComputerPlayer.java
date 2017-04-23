
import java.util.List;
import java.util.ArrayList;
import com.github.sahasatvik.game.*;

public class ComputerPlayer extends MiniMax<TicTacToeGame> implements Player<TicTacToeGame> {
	
	public int maxDepth;

	public ComputerPlayer (int maxDepth) {
		this.maxDepth = maxDepth;
	}
	
	public Move<TicTacToeGame> getMove (TicTacToeGame game) {
		return minimax(game, maxDepth);
	}

	public int evaluate (TicTacToeGame game, int depth) {
		int score = 0;
		int inARow = 0;
		for (List<Point> row : game.board.winningSequences) {
			for (Player<TicTacToeGame> p : game.getPlayers()) {
				inARow = BoardSequencer.getItemCount(game.board, row, game.getPiece(p));
				if (inARow == game.board.goal) {
					if (p == game.getCurrentPlayer()) {
						return Integer.MAX_VALUE - depth;
					} else {
						return depth - Integer.MAX_VALUE;
					}
					
				}
				if ((inARow + BoardSequencer.getItemCount(game.board, row, TicTacToePiece.EMPTY)) == game.board.goal) {
					if (p == game.getCurrentPlayer()) {
						score += (Integer.MAX_VALUE >> ((game.board.goal - inARow) * game.board.goal)) - depth;
					} else {
						score -= (Integer.MAX_VALUE >> ((game.board.goal - inARow) * game.board.goal)) + depth;
					}
				}
			}
		}
		return score;
	}
}
