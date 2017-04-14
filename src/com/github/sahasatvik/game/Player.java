
package com.github.sahasatvik.game;

public interface Player<T extends Game> {
	public Move<T> getMove (T game);
}
