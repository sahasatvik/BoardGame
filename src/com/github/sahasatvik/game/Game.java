
package com.github.sahasatvik.game;

import java.util.List;


public interface Game<T extends Game> {
	public List<Player<T>> getPlayers ();
	public Player<T> getCurrentPlayer();
	public Player<T> getNextPlayer ();
	public boolean hasWon (Player<T> p);
	public boolean isOver ();
	public boolean makeMove (Move<T> m);
	public List<Move<T>> getValidMoves ();
	public Game getCopy ();
}
