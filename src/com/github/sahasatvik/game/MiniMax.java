
package com.github.sahasatvik.game;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.BinaryOperator;


public abstract class MiniMax<T extends Game<T>> {

	public class GameTreeNode<T extends Game<T>> {
		public T game;
		public Integer score;
		public List<GameTreeNode<T>> children;
		public GameTreeNode (T game) {
			this.game = game;
			this.children = new ArrayList<>();
		}
	}
	
	public Move<T> minimax (T rootGame, int maxDepth) {
		GameTreeNode<T> root = createGameTree(rootGame.getNextPlayer(), rootGame, 0, maxDepth, Integer.MIN_VALUE, Integer.MAX_VALUE);
		GameTreeNode<T> bestNode = root.children.remove(0);
		for (GameTreeNode<T> node : root.children) {
			if (node.score > bestNode.score) {
				bestNode = node;
			}
		}
		T bestGame = bestNode.game;
		return () -> bestGame;
	}


	public GameTreeNode<T> createGameTree (Player<T> maximizing, T game, int depth, int maxDepth, int alpha, int beta) {
		depth++;
		GameTreeNode<T> newNode = new GameTreeNode<T>(game);
		boolean isMaximizing = (maximizing == game.getNextPlayer());
		if (depth >= maxDepth || game.isOver()) {
			newNode.score = isMaximizing? -evaluate(game, depth) : evaluate(game, depth);
			return newNode;
		}
		List<Move<T>> validMoves = game.getValidMoves();
		for (Move<T> m : validMoves) {
			GameTreeNode<T> child = createGameTree(maximizing, m.getNewGame(), depth, maxDepth, alpha, beta);
			newNode.children.add(child);
		}
		newNode.score = isMaximizing? Integer.MIN_VALUE : Integer.MAX_VALUE;
		for (GameTreeNode<T> currentNode : newNode.children) {
			if ((currentNode.score > newNode.score) && (isMaximizing)) {
				newNode.score = currentNode.score;
				alpha = Math.max(alpha, newNode.score);
				if (beta <= alpha) {
					return newNode;
				}
			}
			if ((currentNode.score < newNode.score) && (!isMaximizing)) {
				newNode.score = currentNode.score;
				beta = Math.min(beta, newNode.score);
				if (beta <= alpha) {
					return newNode;
				}
			}
			currentNode.children = null;
		}
		return newNode;
	}

	public abstract int evaluate (T game, int depth);
}
