
import java.util.*;
import com.github.sahasatvik.game.*;

public class Test {
	public static void main (String[] args) {
		TicTacToeBoard b = new TicTacToeBoard(100, 100, 2);
         	/*
		for (List<Cell> lc : b.winningSequences) {
			displaySequence(100, 100, lc);
			System.out.print("\n");
		}*/
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
		System.out.println(b.winningSequences.size());
	}
	public static void display (TicTacToeBoard b) {
		/*
		for (int i = 0; i < b.rows; i++) {
			for (int j = 0; j < b.columns; j++) {
				switch (b.getItemAt(i, j)) {
					case EMPTY:	System.out.print(" "); break;
					case CROSS:	System.out.print("X"); break;
					case NOUGHT:	System.out.print("O"); break;
				}
			}
			System.out.print("\n");
		}*/
		System.out.println(b.isMatchingWinningSequence(TicTacToePiece.EMPTY));
		System.out.println(b.isMatchingWinningSequence(TicTacToePiece.CROSS));
		System.out.println(b.isMatchingWinningSequence(TicTacToePiece.NOUGHT));
	}
	public static void displaySequence (int rows, int columns, List<Cell> seq) {
		String t;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				t = ".";
				for (Cell c : seq) {
					if ((c.row == i) && (c.column == j)) {
						t = "X";
						break;
					}
				}
				System.out.print(t);
			}
			System.out.print("\n");
		}
	}
}
