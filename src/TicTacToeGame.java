
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.github.sahasatvik.game.Game;
import com.github.sahasatvik.game.Move;
import com.github.sahasatvik.game.Player;

public class TicTacToeGame implements Game<TicTacToeGame> {
	public TicTacToeBoard board;
	public Map<Player<TicTacToeGame>, TicTacToePiece> playerMap;
	public int currentPlayerId;

	@SafeVarargs
	public TicTacToeGame (int rows, int columns, int goal, Player<TicTacToeGame> ... players) {
		board = new TicTacToeBoard(rows, columns, goal);
		currentPlayerId = 0;
		this.playerMap = new HashMap<>();
		for (int i = 0; i < players.length; i++) {
			this.playerMap.put(players[i], new TicTacToePiece(i));
		}
	}

	public TicTacToeGame (TicTacToeGame parentCopy) {
		this.board = parentCopy.board.getCopy();
		this.currentPlayerId = parentCopy.currentPlayerId;
		this.playerMap = parentCopy.playerMap;
	}

	public TicTacToeGame getCopy () {
		return new TicTacToeGame(this);
	}

	public boolean equals (TicTacToeGame g) {
		if ((this.currentPlayerId != g.currentPlayerId) || (this.playerMap != g.playerMap))
			return false;
		return this.board.equals(g.board);
	}

	public List<TicTacToePiece> getPieces () {
		return new ArrayList<TicTacToePiece>(playerMap.values());
	}

	public List<Player<TicTacToeGame>> getPlayers () {
		return new ArrayList<Player<TicTacToeGame>>(playerMap.keySet());
	}

	public int getPlayerCount () {
		return getPlayers().size();
	}

	public Player<TicTacToeGame> getCurrentPlayer () {
		return getPlayers().get(currentPlayerId);
	}

	public Player<TicTacToeGame> getNextPlayer () {
		return getPlayers().get(getNextPlayerId());
	}

	public int getNextPlayerId () {
		return (currentPlayerId + 1) % getPlayerCount();
	}

	public boolean hasWon (Player<TicTacToeGame> p) {
		return board.isMatchingWinningSequence(playerMap.get(p));
	}

	public boolean isOver () {
		if (board.getItemCount(TicTacToePiece.EMPTY) == 0)
			return true;
		for (Player<TicTacToeGame> p : getPlayers())
			if (hasWon(p))
				return true;
		return false;
	}

	public boolean makeMove (Move<TicTacToeGame> move) {
		TicTacToeGame newGame = move.getNewGame();
		this.board = newGame.board.getCopy();
		this.currentPlayerId = newGame.currentPlayerId;
		this.playerMap = newGame.playerMap;
		return true;
	}

	public boolean makeMove (int row, int column) {
		if ((row < 0) || (row >= board.rows) || (column < 0) || (column >= board.columns))
			return false;
		if (board.getItemAt(row, column) == TicTacToePiece.EMPTY) {
			currentPlayerId = getNextPlayerId();
			board.setItemAt(row, column, playerMap.get(getCurrentPlayer()));
			return true;
		}
		return false;
	}

	public boolean isValidMove (Move<TicTacToeGame> move) {
		for (Move validMove : getValidMoves())
			if (validMove.getNewGame().equals(move.getNewGame()))
				return true;
		return false;
	}

	public List<Move<TicTacToeGame>> getValidMoves () {
		List<Move<TicTacToeGame>> validMoves = new ArrayList<>();
		if (isOver())
			return validMoves;
		for (int i = 0; i < board.rows; i++) {
			for (int j = 0; j < board.columns; j++) {
				TicTacToeGame newGame = new TicTacToeGame(this);
				if (newGame.makeMove(i, j)) {
					validMoves.add(() -> newGame);
				}	
			} 
		}
		return validMoves;
	}
}
