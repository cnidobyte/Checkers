package core;

import java.util.ArrayList;
import java.util.Map.Entry;

public class CheckersComputerPlayer {
	/**
	 * Field Description
	 */
		
	/**
	 * Returns a list of all possible moves that the computer player can take.
	 * @param game
	 * @return ArrayList<Move>
	 */
	public static ArrayList<Move> computerMove(Board game) {
		ArrayList<Move> moves = new ArrayList<Move>();
		for(Entry<Coordinate, Piece> piece : game.getOhPieces().entrySet()) {
			
			if(piece.getValue().getMoves().size() > 0) {
				for(int i = 0; i < piece.getValue().getMoves().size(); i++) {
					moves.add(piece.getValue().getMoves().get(i));
				}
			}
		}
		return moves;
	}
}
