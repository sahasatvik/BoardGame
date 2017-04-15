
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.github.sahasatvik.game.Game;
import com.github.sahasatvik.game.Move;
import com.github.sahasatvik.game.Player;

public class TicTacToeGame implements Game<TicTacToeGame> {
	public TicTacToeBoard board;
	public List<Player<TicTacToeGame>> players;
	public List<TicTacToePiece> pieces;
	public int currentPlayerId;

	@SafeVarargs
	public TicTacToeGame (int rows, int columns, int goal, Player<TicTacToeGame> ... players) {
		board = new TicTacToeBoard(rows, columns, goal);
		this.players = new ArrayList<>();
		this.pieces = new ArrayList<>();
		for (int i = 0; i < players.length; i++) {
			this.players.add(players[i]);
			this.pieces.add(new TicTacToePiece(i));
		}
		currentPlayerId = players.length - 1;
	}

	public TicTacToeGame (TicTacToeGame parentCopy) {
		this.board = parentCopy.board.getCopy();
		this.currentPlayerId = parentCopy.currentPlayerId;
		this.players = parentCopy.players;
		this.pieces = parentCopy.pieces;
	}

	public TicTacToeGame getCopy () {
		return new TicTacToeGame(this);
	}

	public boolean equals (TicTacToeGame g) {
		if ((this.currentPlayerId != g.currentPlayerId) || (this.players != g.players) || (this.pieces != g.pieces))
			return false;
		return this.board.equals(g.board);
	}

	public List<TicTacToePiece> getPieces () {
		return pieces;
	}

	public TicTacToePiece getPiece (Player<TicTacToeGame> p) {
		return pieces.get(players.indexOf(p));
	}

	public Player<TicTacToeGame> getPlayer (TicTacToePiece t) {
		return players.get(pieces.indexOf(t));
	}

	public List<Player<TicTacToeGame>> getPlayers () {
		return players;
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
		return board.isMatchingWinningSequence(getPiece(p));
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
		this.players = newGame.players;
		this.pieces = newGame.pieces;
		return true;
	}

	public boolean makeMove (int row, int column) {
		if ((row < 0) || (row >= board.rows) || (column < 0) || (column >= board.columns))
			return false;
		if (board.getItemAt(row, column) == TicTacToePiece.EMPTY) {
			currentPlayerId = getNextPlayerId();
			board.setItemAt(row, column, pieces.get(currentPlayerId));
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
