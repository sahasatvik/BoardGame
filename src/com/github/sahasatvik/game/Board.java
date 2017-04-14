
package com.github.sahasatvik.game;

import java.util.List;
import java.util.ArrayList;


public class Board<T> {

	public int rows;
	public int columns;
	public List<List<T>> cells;

	public Board (int rows, int columns) {
		this(rows, columns, null);
	}

	public Board (int rows, int columns, T defaultItem) {
		this.rows = rows;
		this.columns = columns;
		this.cells = new ArrayList<>();
		for (int i = 0; i < rows; i++) {
			ArrayList<T> row = new ArrayList<>();
			for (int j = 0; j < columns; j++) {
				row.add(defaultItem);
			}
			cells.add(row);
		}
	}
	
	public Board (Board<T> parentBoard) {
		this.rows = parentBoard.rows;
		this.columns = parentBoard.columns;
		this.cells = new ArrayList<>();
		for (int i = 0; i < parentBoard.rows; i++) {
			ArrayList<T> row = new ArrayList<>();
			for (int j = 0; j < parentBoard.columns; j++) {
				row.add(parentBoard.getItemAt(i, j));
			}
			cells.add(row);
		}
	}

	public Board<T> getCopy () {
		return new Board<T>(this);
	}

	public boolean equals (Board<T> b) {
		if ((this.rows != b.rows) || (this.columns != b.columns))
			return false;	
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				if (this.getItemAt(i, j) != b.getItemAt(i, j))
					return false;
		return true;
	}

	public T getItemAt (Point p) {
		return getItemAt(p.row, p.column);
	}

	public T getItemAt (int row, int column) {
		return cells.get(row).get(column);
	}

	public void setItemAt (int row, int column, T item) {
		cells.get(row).set(column, item);
	}

	public int getItemCount (T item) {
		int count = 0;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				if (getItemAt(i, j) == item)
					count++;
		return count;
	}
} 

