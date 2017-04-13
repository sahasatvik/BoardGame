
package com.github.sahasatvik.game;

import java.util.List;
import java.util.ArrayList;


public class Board<T> {

	public int rows;
	public int columns;
	public List<List<Cell<T>>> cells;

	public Board (int rows, int columns) {
		this(rows, columns, null);
	}

	public Board (int rows, int columns, T defaultItem) {
		this.rows = rows;
		this.columns = columns;
		cells = new ArrayList<>();
		for (int i = 0; i < rows; i++) {
			ArrayList<Cell<T>> row = new ArrayList<>();
			for (int j = 0; j < columns; j++) {
				row.add(new Cell<T>(i, j, defaultItem));
			}
			cells.add(row);
		}
	}
	
	public Board (Board<T> parentBoard) {
		this.rows = parentBoard.rows;
		this.columns = parentBoard.columns;
		cells = new ArrayList<>();
		for (int i = 0; i < parentBoard.rows; i++) {
			ArrayList<Cell<T>> row = new ArrayList<>();
			for (int j = 0; j < parentBoard.columns; j++) {
				row.add(new Cell<T>(i, j, parentBoard.getItemAt(i, j)));
			}
			cells.add(row);
		}
	}

	public Board<T> getCopy () {
		return new Board<T>(this);
	}

	public T getItemAt (int row, int column) {
		return cells.get(row).get(column).item;
	}

	public void setItemAt (int row, int column, T item) {
		cells.get(row).get(column).item = item;
	}
} 

