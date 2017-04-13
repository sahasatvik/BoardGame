
package com.github.sahasatvik.game;

import java.util.List;
import java.util.function.BinaryOperator;


public class MiniMax {

	public class ScoredMove {
		public Move move;
		public int score;
		public ScoredMove (Move move, int score) {
			this.move = move;
			this.score = score;
		}
	}
	
	public Move minimax (Game rootGame, int maxDepth) {
		return minimax(rootGame, rootGame, maxDepth, 0).move;
	}

	public ScoredMove minimax (Game rootGame, Game currentGame, int maxDepth, int currentDepth) {
		List<Move> nextMoves = currentGame.getValidMoves();
		currentDepth++;
		
		if (currentDepth == maxDepth || nextMoves.isEmpty() || currentGame.isOver())
			return new ScoredMove(() -> (currentGame), evaluate(currentGame, currentDepth));
		
		BinaryOperator<ScoredMove> compareScoredMoves = (currentGame.getCurrentPlayer() == rootGame.getCurrentPlayer())
								? ((a, b) -> (a.score > b.score ? a : b))
								: ((a, b) -> (a.score < b.score ? a : b)); 

		ScoredMove currentScoredMove, bestScoredMove;
		bestScoredMove = minimax(rootGame, nextMoves.remove(0).getNewGame(), maxDepth, currentDepth);
		for (Move move : nextMoves) {
			currentScoredMove = minimax(rootGame, move.getNewGame(), maxDepth, currentDepth);
			bestScoredMove = compareScoredMoves.apply(bestScoredMove, currentScoredMove);
		}
		return bestScoredMove;
	}

	public int evaluate (Game game, int depth) {
		if (game.hasWon(game.getCurrentPlayer()))
			return 10 - depth;
		for (Player p : game.getPlayers())
			if (p != game.getCurrentPlayer() && game.hasWon(p))
				return depth - 10;
		return 0;
	}
}
