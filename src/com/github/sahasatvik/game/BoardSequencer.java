
package com.github.sahasatvik.game;

import java.util.List;
import java.util.ArrayList;
import com.github.sahasatvik.game.Board;


public class BoardSequencer {
	
	public static <T> boolean isSequenceMatchingAny (Board<T> board, List<List<Point>> sequence, T item) {
		for (List<Point> subSequence : sequence)
			if (BoardSequencer.<T>isSequenceMatching(board, subSequence, item))
				return true;
		return false;
	}

	public static <T> boolean isSequenceMatching (Board<T> board, List<Point> sequence, T item) {
		for (Point p : sequence)
			if (board.getItemAt(p) != item)
				return false;
		return true;
	}

	public static <T> int getItemCount (Board<T> board, List<Point> sequence, T item) {
		int count = 0;
		for (Point p : sequence)
			if (board.getItemAt(p) == item)
				count++;
		return count;
	}

	public static List<List<Point>> getSequences (Board<?> b, int size) {
		List<List<Point>> sequences = new ArrayList<>();
		if (size <= b.columns) {
			for (int i = 0; i < b.rows; i++) {
				for (int j = 0; j < (b.columns - size + 1); j++) {
					List<Point> row = new ArrayList<>();
					for (int k = 0; k < size; k++) {
						row.add(new Point(i, (j + k)));
					}
					sequences.add(row);
				} 
			} 
		}
		if (size <= b.rows) {
			for (int i = 0; i < (b.rows - size + 1); i++) {
				for (int j = 0; j < b.columns; j++) {
					List<Point> column = new ArrayList<>();
					for (int k = 0; k < size; k++) {
						column.add(new Point((i + k), j));
					}
					sequences.add(column);
				} 
			} 
		}
		if ((size <= b.columns) && (size <= b.rows)) {
			for (int i = 0; i < (b.rows - size + 1); i++) {
				for (int j = 0; j < (b.columns - size + 1); j++) {
					List<Point> rightDiagonal = new ArrayList<>();
					List<Point> leftDiagonal = new ArrayList<>();
					for (int k = 0; k < size; k++) {
						rightDiagonal.add(new Point((i + k), (j + k)));
						leftDiagonal.add(new Point((i + k), (j + (size - k - 1))));
					}
					sequences.add(rightDiagonal);
					sequences.add(leftDiagonal);

				} 
			} 
		}
		return sequences;
	}
	
}
