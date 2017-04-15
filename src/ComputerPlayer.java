
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
		if (game.hasWon(game.getCurrentPlayer())) {
			return 100 - depth;
		}
		for (Player<TicTacToeGame> p : game.getPlayers()) {
			if (game.hasWon(p)) {
				return depth - 100;
			}
		}
		return 0;
	}
}
