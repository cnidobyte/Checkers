package core;
import java.util.ArrayList;


/**
 * The <em>Coordinate</em> class represents the 2D grid coordinates of pieces.
 * @author Shota
 *
 */
public class Coordinate {
	private ArrayList<Integer> coords;
	
	
	/**
	 * Ctor: Stores the two coordinate pair in row-column order.
	 * @param row	y-coordinate
	 * @param col	x-coordinate
	 */
	public Coordinate(int row, int col) {
		coords = new ArrayList<Integer>(2);
		coords.add(row);
		coords.add(col);
	}
	
	/**
	 * Ctor: Initializes and empty coordinate list.
	 */
	public Coordinate() {
		coords = new ArrayList<Integer>(2);
	}
	
	
	/**
	 * Accessor method, retrieves coordinate pair.
	 * @return coords	coordinate pair
	 */
	public ArrayList<Integer> getCoords() {
		return coords;
	}
	
	/**
	 * Get a specific coordinate in a coordinate pair.
	 * @param coord	specific coordinate
	 * @return	value of the coordinate in the pair.
	 */
	public int getCoords(int coord) {
		return coords.get(coord);
	}
	
	/**
	 * Used to build coordinate pairs.
	 * @param coord
	 */
	public void addCoord(int coord) {
		coords.add(coord);
	}
	
	/**
	 * Equals method. Usual checks and then checks that integers of the coordinate pair match.
	 * @Override
	 */
	public boolean equals(Object obj) {
		if(obj == null) {return false;}
		if(obj.getClass() != this.getClass()) {return false;}
		
		final Coordinate other = (Coordinate) obj;
		for(int i = 0; i < coords.size(); i++) {
			if(this.coords.get(i) != other.coords.get(i)) {return false;}
		}
		return true;
	}
	
	/**
	 * Hash code method. Simple implementation.
	 * @Override
	 */
	public int hashCode() {
		int hash = 3;
		hash = 31 * hash + this.coords.get(0);
		hash = 31 * hash + this.coords.get(1);
		return hash;
	}
}
