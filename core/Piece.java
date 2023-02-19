package core;
import java.util.ArrayList;
/**
 * Represents the game pieces, their location, and their owners.
 * @author Shota Bennett
 */
public class Piece {
	/**
	 * Field Description.
	 */
	private PlayerType player;
	private ArrayList<Integer> coords = new ArrayList<Integer>(2);
	private ArrayList<Move> movesAvailable = new ArrayList<Move>();
	
	/**
	 * Class constructor. Sets the coordinates and the owner of the pieces.
	 * @param y Y-coordinate
	 * @param x X-coordinate
	 * @param type owner of the game piece.
	 */
	public Piece(int y, int x, PlayerType type){
		coords.add(y);
		coords.add(x);
		player = type;

		ArrayList<Move> moveList = new ArrayList<Move>();
		if(type == PlayerType.EX) {
			moveList.add(new Move(x, x - 1, y, y + 1));
			moveList.add(new Move(x, x - 2, y, y + 2));
			moveList.add(new Move(x, x + 1, y, y + 1));
			moveList.add(new Move(x, x + 2, y, y + 2));
			
			
		} else {
			moveList.add(new Move(x, x - 1, y, y - 1));
			moveList.add(new Move(x, x - 2, y, y - 2));
			moveList.add(new Move(x, x + 1, y, y - 1));
			moveList.add(new Move(x, x + 2, y, y - 2));
		}
		for(Move move : moveList) {
			if(move.isInBounds()) {
				movesAvailable.add(move);
			}
		}
	}
	

	/**
	 * Setter method to change owner.
	 * @param playertype enumeration of player (X or O).
	 */
	public void setPlayer(PlayerType playertype) {
		player = playertype;
	}
	
	/**
	 * Setter method to change the coordinates. Should not be used to change the position of the game piece.
	 * @param x
	 * @param y
	 */
	public void setCoords(int y, int x) {
		coords.clear();
		coords.add(y);
		coords.add(x);
	}
	
	/**
	 * Getter method for piece coordinate. 
	 * @return coords coordinate pair to be returned (y, x)
	 */
	public ArrayList<Integer> getCoords() {
		return coords;
	}
	
	/**
	 * Getter method for piece owner.
	 * @return PlayerType
	 */
	public PlayerType getPlayer() {
		return player;
	}
	
	/**
	 * Accessor for possible moves
	 * @return ArrayList<Moves> 
	 */
	public ArrayList<Move> getMoves() {
		return movesAvailable;
	}
}
