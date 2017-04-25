
package com.github.sahasatvik.game;

import java.util.List;

/**
 * <code>Game</code> defines methods a class must implement in order to use the
 * {@link com.github.sahasatvik.game} framework.
 * <code>Game</code> outlines the basic behaviour of turn-based games.
 *
 * 	@author		Satvik Saha
 * 	@param	<T>	the type of Game object implemented
 * 	@version	0.1.0, 11/04/2017
 * 	@since		0.1.0
 */

public interface Game<T extends Game> {

	/**
	 * Returns a List of Players participating in the Game.
	 *
	 * 	@return			the List of Player objects
	 * 	@see	com.github.sahasatvik.game.Player
	 * 	@since	0.1.0
	 */
	public List<Player<T>> getPlayers ();

	/**
	 * Returns the Player who was the last to make a Move.
	 *
	 * 	@return 		the last Player to Move
	 * 	@see	com.github.sahasatvik.game.Player
	 * 	@since	0.1.0
	 */
	public Player<T> getCurrentPlayer();

	/**
	 * Returns the Player who will be the next to make a Move.
	 *
	 * 	@return			the next Player to Move
	 * 	@see	com.github.sahasatvik.game.Player
	 * 	@since	0.1.0
	 */
	public Player<T> getNextPlayer ();

	/**
	 * Returns <code>true</code> if the current Game has been won by a Player.
	 *
	 * 	@param	p		the Player to be checked
	 * 	@return			<code>true</code> if the current Game has been
	 * 				won by the Player supplied
	 * 	@see	com.github.sahasatvik.game.Player
	 * 	@since	0.1.0
	 */
	public boolean hasWon (Player<T> p);

	/**
	 * Returns <code>true</code> if the current Game in over.
	 * This includes when a Player has won, the Game is drawn or there are no
	 * possible valid moves.
	 *
	 * 	@return			<code>true</code> if the current Game is over
	 * 	@since	0.1.0
	 */
	public boolean isOver ();

	/**
	 * Applies the given Move on the current Game.
	 *
	 * 	@param	m		the Move to be applied on the current Game
	 * 	@return			<code>true</code> if the Move was made successfully
	 * 	@see	com.github.sahasatvik.game.Move
	 * 	@since	0.1.0
	 */
	public boolean makeMove (Move<T> m);

	/**
	 * Returns a List of all possible, valid Moves that can be applied on the
	 * current Game.
	 *
	 * 	@return			the List of all valid Moves
	 * 	@see	com.github.sahasatvik.game.Move
	 * 	@since	0.1.0
	 */
	public List<Move<T>> getValidMoves ();

	/**
	 * Returns a copy of the current Game object.
	 * This copy can be changed without affecting the parent Game object.
	 * 
	 * 	@return			the new copy of the current  Game object
	 * 	@since	0.1.0
	 */
	public T getCopy ();
}
