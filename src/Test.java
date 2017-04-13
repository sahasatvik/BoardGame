
import java.util.*;
import com.github.sahasatvik.game.*;

public class Test {
	public static void main (String[] args) {
		TicTacToeBoard b = new TicTacToeBoard(3, 3, 3);	
		display(b);
		b.setItemAt(0, 0, TicTacToePiece.NOUGHT);
		b.setItemAt(1, 0, TicTacToePiece.CROSS);
		display(b);
		b.setItemAt(1, 1, TicTacToePiece.NOUGHT);
		b.setItemAt(2, 2, TicTacToePiece.NOUGHT);
		b.setItemAt(2, 0, TicTacToePiece.CROSS);
		display(b);
		b.setItemAt(2, 1, TicTacToePiece.CROSS);
		b.setItemAt(2, 2, TicTacToePiece.CROSS);
		display(b);
	}
	public static void display (TicTacToeBoard b) {
		for (int i = 0; i < b.rows; i++) {
			for (int j = 0; j < b.columns; j++) {
				switch (b.getItemAt(i, j)) {
					case EMPTY:	System.out.print(" "); break;
					case CROSS:	System.out.print("X"); break;
					case NOUGHT:	System.out.print("O"); break;
				}
			}
			System.out.print("\n");
		}
		System.out.println(b.isMatchingWinningSequence(TicTacToePiece.EMPTY));
		System.out.println(b.isMatchingWinningSequence(TicTacToePiece.CROSS));
		System.out.println(b.isMatchingWinningSequence(TicTacToePiece.NOUGHT));
	}
}
