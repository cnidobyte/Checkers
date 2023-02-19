package core;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/**
 * The <em>Board</em> Class represents the playing board 
 * @author Shota Bennett
 */

public class Board {
	/**
	 * Field Description. Probably pieces here.
	 */
	private int xDimension = 8;
	private int yDimension = 8;
	
	//private ArrayList<Piece> exPieces;
	private HashMap<Coordinate, Piece> exPieces;
	//private ArrayList<Piece> ohPieces;
	private HashMap<Coordinate, Piece> ohPieces;
	private boolean[][] takenSpaces = new boolean[yDimension][xDimension];
	
	/** 
	 * Constructor.
	 */
	Board() {
		exPieces = new HashMap<Coordinate, Piece>();
		ohPieces = new HashMap<Coordinate, Piece>();
		clearGrid();
		setup();
	}
	
	/**
	 * Initializes the game pieces and their locations on the board.
	 * 
	 */
	public void setup() {
		
		//set ex and oh pieces
		PlayerType oh = PlayerType.OH;
		PlayerType ex = PlayerType.EX;
		for(int i = 1; i < xDimension; i += 2) {
			 
			ohPieces.put(
					//TODO change this to coords
					new Coordinate(1, i), 
					new Piece(1, i, oh)
					);
			exPieces.put(
					new Coordinate(5 , i), 
					new Piece(5, i, ex)
					);
			exPieces.put(
					new Coordinate(7, i), 
					new Piece(7, i, ex)
					);
		}
		
		for(int i = 0; i < xDimension - 1; i += 2) {
			ohPieces.put(
					new Coordinate(0, i), 
					new Piece(0, i, oh)
					);
			ohPieces.put(
					new Coordinate(2 , i), 
					new Piece(2, i, oh)
					);
			exPieces.put(
					new Coordinate(6 , i), 
					new Piece(6, i, ex)
					);
		}
		
		updateGrid();
	}
	/**
	 * Refreshes the occupancy grid that governs the state of the board.
	 */
	public void updateGrid() {
		clearGrid();
		
		for(Coordinate ohCoords : ohPieces.keySet()) {
			takenSpaces[ohCoords.getCoords(0)][ohCoords.getCoords(1)] = true;
		}
		for(Coordinate exCoords : exPieces.keySet()) {
			takenSpaces[exCoords.getCoords(0)][exCoords.getCoords(1)] = true;
		}
	}
	/**
	 * Prepares fresh slate grid for updating.
	 */
	private void clearGrid() {
		for(int row = 0; row < yDimension - 1; row++) {
			for(int col = 0; col < xDimension - 1; col++) {
				takenSpaces[row][col] = false;
			}
		}
	}
	/**
	 * Checks if the coordinate passed is empty. Returns true if the coordinate space is empty.
	 * @param x X-coordinate of the grid.
	 * @param y Y-coordinate of the grid.
	 * @return boolean
	 */
	public boolean isEmpty(int y, int x) {
		return !takenSpaces[y][x];
	}
	
	/**
	 * Magic Number prevention. Possible to scale checkerboard to larger sizes.
	 * @return int
	 */
	public int getXDimension() {
		return xDimension;
	}
	
	/**
	 * Getter function of the occupancy grid.
	 * @return boolean[][]
	 */
	public boolean[][] getTakenSpaces() {
		return takenSpaces;
	}
	
	/**
	 * Getter function for Player O's pieces.
	 * @return HashMap<Coordinate, Piece>
	 */
	public HashMap<Coordinate, Piece> getOhPieces() {
		return ohPieces;
	}
	
	/**
	 * Getter function for Player X's pieces.
	 * @return HashMap<Coordinate, Piece>
	 */
	public HashMap<Coordinate, Piece> getExPieces() {
		return exPieces;
	}
}