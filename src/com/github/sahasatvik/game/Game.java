
package com.github.sahasatvik.game;

import java.util.List;


public interface Game<T extends Game> {
	public List<Player<T>> getPlayers ();
	public Player getCurrentPlayer();
	public Player getNextPlayer ();
	public boolean hasWon (Player<T> p);
	public boolean isOver ();
	public boolean makeMove (Move<T> m);
	public List<Move<T>> getValidMoves ();
	public Game getCopy ();
}
