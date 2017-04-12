
package com.github.sahasatvik.game;

import java.util.List;


public abstract class MiniMax {

	public class ScoredMove {
		public int score;
		public Move move;
	}

	public ScoredMove minimax (Game rootGame, Game currentGame, int depth) {
		List<Move> nextMoves = currentGame.getValidMoves();

		ScoredMove bestScoredMove = new ScoredMove();
		bestScoredMove.score = (rootGame.getCurrentPlayer() == currentGame.getCurrentPlayer())
						? Integer.MIN_VALUE : Integer.MAX_VALUE;
		int currentScore;

		if (depth == 0 || nextMoves.size() == 0) {
			bestScoredMove.score = evaluate(currentGame);
		} else {
			for (Move move : nextMoves) {
				currentScore = minimax(rootGame, move.getNewGame(), depth - 1).score - depth;
				if (rootGame.getCurrentPlayer() == currentGame.getCurrentPlayer()) {
					if (currentScore > bestScoredMove.score) {
						bestScoredMove.score = currentScore;
						bestScoredMove.move = move;
					}
				} else {
					if (currentScore < bestScoredMove.score) {
						bestScoredMove.score = currentScore;
						bestScoredMove.move = move;
					}
				}
			}
		}

		return bestScoredMove;
	}

	public abstract int evaluate (Game game);
}
