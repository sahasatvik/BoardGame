
package com.github.sahasatvik.game;

import java.util.List;


public interface Game {
	public List<Player> getPlayers ();
	public Player getCurrentPlayer();
	public Player getNextPlayer ();
	public boolean hasWon (Player p);
	public boolean isOver ();

	public List<Move> getValidMoves ();
	public Game getGameCopy ();
}
