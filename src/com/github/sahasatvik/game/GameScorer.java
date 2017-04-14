
package com.github.sahasatvik.game;

public interface GameScorer<T extends Game> {
	public int evaluate (T game, int depth);
}
