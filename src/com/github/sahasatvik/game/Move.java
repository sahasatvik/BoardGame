
package com.github.sahasatvik.game;

/**
 * <code>Move</code> is a container for the state of a <code>Game</code> after some
 * modifications are made to its parent state.
 * A <code>Move</code> simply encapsulates a new <code>Game</code> object which
 * would replace its parent if it is executed. This container interface is made
 * largely to semantically differentiate a game state from a possible move.
 * 
 * 	@author		Satvik Saha
 * 	@param	<T>	the type of <code>Game</code> the <code>Move</code> provides
 * 			a new state for
 * 	@see		com.github.sahasatvik.game.Game
 * 	@version	0.1.0, 11/04/2017
 * 	@since		0.1.0
 */

@FunctionalInterface
public interface Move<T extends Game> {

	/**
	 * Returns the new <code>Game</code> object contained in the <code>Move</code>.
	 *
	 * 	@return			the new <code>Game</code> to be used after the execution
	 * 				of the <code>Move</code>
	 * 	@see	com.github.sahasatvik.game.Game
	 * 	@since	0.1.0
	 */
	public T getNewGame ();
}
