
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
		GameTreeNode<T> root = createGameTree(rootGame.getNextPlayer(), rootGame, 0, maxDepth);
		GameTreeNode<T> bestNode = root.children.remove(0);
		System.out.print("\nScores : ");
		for (GameTreeNode<T> node : root.children) {
			System.out.print(node.score + " ");
			if (node.score > bestNode.score) {
				bestNode = node;
			}
		}
		T bestGame = bestNode.game;
		return () -> bestGame;
	}

	/*
	public void minimax (Player<T> maximizing, GameTreeNode<T> parent, int depth, int maxDepth) {
		depth++;
		boolean isMaximizing = maximizing == parent.game.getNextPlayer();
		if (parent.game.isOver() || depth == maxDepth) {
			parent.score = evaluate(parent.game, depth);
			parent.score *= isMaximizing? -1 : 1;
			return;
		}
		parent.score = isMaximizing? Integer.MIN_VALUE : Integer.MAX_VALUE;
		for (GameTreeNode<T> currentNode : parent.children) {
			minimax(maximizing, currentNode, depth, maxDepth);
			if (isMaximizing) {
				if (currentNode.score > parent.score) {
					parent.score = currentNode.score;
				}
			} else {
				if (currentNode.score < parent.score) {
					parent.score = currentNode.score;
				}
			}
			currentNode.children = null;
		}
	}*/

	public GameTreeNode<T> createGameTree (Player<T> maximizing, T game, int depth, int maxDepth) {
		depth++;
		GameTreeNode<T> newNode = new GameTreeNode<T>(game);
		boolean isMaximizing = (maximizing == game.getNextPlayer());
		if (depth >= maxDepth || game.isOver()) {
			newNode.score = isMaximizing? -evaluate(game, depth) : evaluate(game, depth);
			System.out.print(" " + newNode.score);
			return newNode;
		}
		List<Move<T>> validMoves = game.getValidMoves();
		for (Move<T> m : validMoves) {
			GameTreeNode<T> child = createGameTree(maximizing, m.getNewGame(), depth, maxDepth);
			newNode.children.add(child);
		}
		newNode.score = isMaximizing? Integer.MIN_VALUE : Integer.MAX_VALUE;
		for (GameTreeNode<T> currentNode : newNode.children) {
			if (((currentNode.score > newNode.score) && (isMaximizing))
			 || ((currentNode.score < newNode.score) && (!isMaximizing))) {
				newNode.score = currentNode.score;
			}
		}
		return newNode;
	}

	public abstract int evaluate (T game, int depth);
}
