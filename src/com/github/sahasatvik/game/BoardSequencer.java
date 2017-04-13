
package com.github.sahasatvik.game;

import java.util.List;
import java.util.ArrayList;
import com.github.sahasatvik.game.Cell;
import com.github.sahasatvik.game.Board;


public class BoardSequencer {
	
	public static <T> boolean isSequenceMatchingAny (List<List<Cell>> sequence, T item) {
		for (List<Cell> subSequence : sequence) {
			if (isSequenceMatching(subSequence, item)) {
				return true;
			}
		}
		return false;
	}

	public static <T> boolean isSequenceMatching (List<Cell> sequence, T item) {
		for (Cell c : sequence) {
			if (c.item != item) {
				return false;
			}
		}
		return true;
	}

	public static List<List<Cell>> getSequences (Board<?> b, int size) {
		List<List<Cell>> sequences = new ArrayList<>();
		if (size <= b.columns) {
			for (int i = 0; i < b.rows; i++) {
				for (int j = 0; j < (b.columns - size + 1); j++) {
					List<Cell> row = new ArrayList<>();
					for (int k = 0; k < size; k++) {
						row.add(b.cells.get(i).get(j + k));
					}
					sequences.add(row);
				} 
			} 
		}
		if (size <= b.rows) {
			for (int i = 0; i < (b.rows - size + 1); i++) {
				for (int j = 0; j < b.columns; j++) {
					List<Cell> column = new ArrayList<>();
					for (int k = 0; k < size; k++) {
						column.add(b.cells.get(i + k).get(j));
					}
					sequences.add(column);
				} 
			} 
		}
		if ((size <= b.columns) && (size <= b.rows)) {
			for (int i = 0; i < (b.rows - size + 1); i++) {
				for (int j = 0; j < (b.columns - size + 1); j++) {
					List<Cell> rightDiagonal = new ArrayList<>();
					List<Cell> leftDiagonal = new ArrayList<>();
					for (int k = 0; k < size; k++) {
						rightDiagonal.add(b.cells.get(i + k).get(j + k));
						leftDiagonal.add(b.cells.get(i + k).get(j + (size - k - 1)));
					}
					sequences.add(rightDiagonal);
					sequences.add(leftDiagonal);

				} 
			} 
		}
		return sequences;
	}
	
}
