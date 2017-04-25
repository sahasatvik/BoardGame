
package com.github.sahasatvik.game;

/**
 * <code>Player</code> defines the behaviour of an entity, participating in a specific type
 * of game, which is capable of making moves given a particular instance of that game.
 * A <code>Player</code> simply links a new <code>Game</code> object with its parent,
 * via a <code>Move</code> container, determining how a turn-based game proceeds.
 *
 * 	@author		Satvik Saha
 * 	@param	<T>	the type of <code>Game</code> the <code>Player</code> can
 * 			make <code>Move</code>s on
 * 	@see		com.github.sahasatvik.game.Game
 * 	@version	0.1.0, 11/04/2017
 * 	@since		0.1.0
 */

@FunctionalInterface
public interface Player<T extends Game> {

	/**
	 * Returns a <code>Move</code> object based on the state of a <code>Game</code>.
	 *
	 * 	@param	game		the <code>Game</code> based on which a <code>Move</code>
	 * 				is to be made
	 * 	@return			the <code>Move</code> which provides information about
	 * 				the <code>Game</code> after it is executed
	 * 	@see	com.github.sahasatvik.game.Move
	 * 	@see	com.github.sahasatvik.game.Game
	 * 	@since	0.1.0
	 */
	public Move<T> getMove (T game);
}
