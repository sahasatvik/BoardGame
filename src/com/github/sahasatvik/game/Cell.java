
package com.github.sahasatvik.game;

public class Cell<T> {
	public int row;
	public int column;
	public T item;
	public Cell (int row, int column, T item) {
		this.row = row;
		this.column = column;
		this.item = item;
	}
}
