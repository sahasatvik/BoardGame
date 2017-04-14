
package com.github.sahasatvik.game;

import java.util.List;
import java.util.ArrayList;
import java.util.function.BinaryOperator;


public class MiniMax<T extends Game<T>> {

	public GameScorer<T> scorer;

	public class GameTreeNode<T extends Game<T>> {
		public T game;
		public int score;
		public List<GameTreeNode<T>> nodes;
		public GameTreeNode (T game) {
			this.game = game;
			nodes = new ArrayList<>();
		}
	}
	
	public Move<T> minimax (T rootGame, int maxDepth) {
		return () -> minimax(rootGame).game;
	}

	public ScoredMove<T> minimax () {
				
	}

	public GameTreeNode<T> getGameTree (T game) {
		GameTreeNode<T> head = new GameTreeNode<T>(game);
		for (Move<T> move : game.getValidMoves()) {
			head.nodes.add(new GameTreeNode<T>(move.getNewGame()));
		}
		return head;
	}
}
