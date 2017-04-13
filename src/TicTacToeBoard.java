
import java.util.List;
import java.util.ArrayList;
import com.github.sahasatvik.game.Cell;
import com.github.sahasatvik.game.Board;
import com.github.sahasatvik.game.BoardSequencer;

public class TicTacToeBoard extends Board<TicTacToePiece> {
	
	public int winningSequenceSize;
	public List<List<Cell>> winningSequences;
	
	public TicTacToeBoard (int rows, int columns, int winningSequenceSize) {
		super(rows, columns, TicTacToePiece.EMPTY);
		this.winningSequenceSize = winningSequenceSize;
		this.winningSequences = BoardSequencer.getSequences(this, winningSequenceSize);
	}

	public boolean isMatchingWinningSequence (TicTacToePiece piece) {
		return BoardSequencer.<TicTacToePiece>isSequenceMatchingAny(winningSequences, piece);
	}
}
