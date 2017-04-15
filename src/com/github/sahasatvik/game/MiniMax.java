
package com.github.sahasatvik.game;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.BinaryOperator;


public abstract class MiniMax<T extends Game<T>> {

	public class GameTreeNode<T extends Game<T>> {
		public T game;
		public int score;
		public GameTreeNode<T> bestChild ;
		public GameTreeNode (T game) {
			this.game = game;
		}
	}
	
	public Move<T> minimax (T rootGame, int maxDepth) {
		return () -> minimax(rootGame.getNextPlayer(), new GameTreeNode<T>(rootGame), 0, maxDepth).bestChild.game;
	}

	public GameTreeNode<T> minimax (Player<T> maximizing, GameTreeNode<T> parent, int depth, int maxDepth) {
		depth++;
		List<Move<T>> validMoves = parent.game.getValidMoves();		
		if (depth == maxDepth || validMoves.isEmpty()) {
			parent.score = evaluate(parent.game, depth);
			return parent;
		}

		BinaryOperator<GameTreeNode<T>> minOrMax = (maximizing == parent.game.getNextPlayer())
								? ((a, b) -> ((a.score < b.score)? a : b))
								: ((a, b) -> ((a.score > b.score)? a : b));
		GameTreeNode<T> currentNode;
		GameTreeNode<T> bestNode = minimax(maximizing, new GameTreeNode<T>(validMoves.remove(0).getNewGame()), depth, maxDepth);
		for (Move<T> move : validMoves) {
			currentNode = new GameTreeNode<T>(move.getNewGame());
			currentNode.score = evaluate(move.getNewGame(), depth);
			System.out.println(currentNode.score + " ");
			//currentNode = minimax(maximizing, new GameTreeNode<T>(move.getNewGame()), depth, maxDepth);
			bestNode = minOrMax.apply(bestNode, currentNode);
		}
		parent.bestChild = bestNode;
		System.out.print("\nMin => " + bestNode.score + "\n");
		return parent;
	}

	public abstract int evaluate (T game, int depth);
}
