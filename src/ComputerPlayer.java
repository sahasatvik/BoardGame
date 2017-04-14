
import java.util.List;
import java.util.ArrayList;
import com.github.sahasatvik.game.*;

public class ComputerPlayer extends MiniMax<TicTacToeGame> implements Player<TicTacToeGame> {
	
	public int maxDepth;

	public ComputerPlayer (int maxDepth) {
		this.maxDepth = maxDepth;
		this.scorer = (g, d) -> evaluate(g, d);
	}
	
	public Move<TicTacToeGame> getMove (TicTacToeGame game) {
		return minimax(game, maxDepth);
	}
	
	public int evaluate (TicTacToeGame game, int depth) {
		if (game.hasWon(game.getCurrentPlayer()))
			return Integer.MAX_VALUE - depth;
		for (Player<TicTacToeGame> p : game.getPlayers())
			if (game.hasWon(p))
				return Integer.MIN_VALUE + depth;
		return 0;
	}
}
