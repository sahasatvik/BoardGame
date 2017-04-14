
public class TicTacToePiece {
	public static final TicTacToePiece EMPTY = new TicTacToePiece(Integer.MIN_VALUE);
	public int id;
	public TicTacToePiece (int id) {
		this.id = id;
	}
	public boolean equals (TicTacToePiece p) {
		return this.id == p.id;
	}
}
