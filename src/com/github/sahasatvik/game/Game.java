
package com.github.sahasatvik.game;

import java.util.List;

/**
 * Game is an interface which defines methods a Game must implement in order to
 * be able to use the <code>com.github.sahasatvik.game</code> framework.
 *
 * 	@author		Satvik Saha
 * 	@param	<T>	type of Game object implemented
 * 	@version	0.1.0, 11/04/2017
 * 	@since		0.1.0
 */

public interface Game<T extends Game> {

	/**
	 * Gets a List of Players participating in the Game.
	 *
	 * 	@return			List of Player objects
	 * 	@see	com.github.sahasatvik.game.Player
	 * 	@since	0.1.0
	 */
	public List<Player<T>> getPlayers ();
	public Player<T> getCurrentPlayer();
	public Player<T> getNextPlayer ();
	public boolean hasWon (Player<T> p);
	public boolean isOver ();
	public boolean makeMove (Move<T> m);
	public List<Move<T>> getValidMoves ();
	public T getCopy ();
}
