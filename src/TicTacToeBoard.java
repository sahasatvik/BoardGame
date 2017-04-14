
import java.util.List;
import java.util.ArrayList;
import com.github.sahasatvik.game.Point;
import com.github.sahasatvik.game.Board;
import com.github.sahasatvik.game.BoardSequencer;

public class TicTacToeBoard extends Board<TicTacToePiece> {
	
	public int goal;
	public List<List<Point>> winningSequences;
	
	public TicTacToeBoard (TicTacToeBoard parentCopy) {
		super(parentCopy);
		this.goal = parentCopy.goal;
		this.winningSequences = parentCopy.winningSequences;
	}
	
	public TicTacToeBoard (int rows, int columns, int goal) {
		super(rows, columns, TicTacToePiece.EMPTY);
		this.goal = goal;
		this.winningSequences = BoardSequencer.getSequences(this, goal);
	}

	public TicTacToeBoard getCopy () {
		return new TicTacToeBoard(this);
	}

	public boolean isMatchingWinningSequence (TicTacToePiece piece) {
		return BoardSequencer.<TicTacToePiece>isSequenceMatchingAny(this, winningSequences, piece);
	}
}
