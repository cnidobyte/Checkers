package core;
import java.util.ArrayList;

public class Coordinate {
	private ArrayList<Integer> coords;
	
	public Coordinate(int row, int col) {
		coords = new ArrayList<Integer>(2);
		coords.add(row);
		coords.add(col);
	}
	
	public Coordinate() {
		coords = new ArrayList<Integer>(2);
	}
	
	public ArrayList<Integer> getCoords() {
		return coords;
	}
	
	public int getCoords(int coord) {
		return coords.get(coord);
	}
	
	public void addCoord(int coord) {
		coords.add(coord);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {return false;}
		if(obj.getClass() != this.getClass()) {return false;}
		
		final Coordinate other = (Coordinate) obj;
		for(int i = 0; i < coords.size(); i++) {
			if(this.coords.get(i) != other.coords.get(i)) {return false;}
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 31 * hash + this.coords.get(0);
		hash = 31 * hash + this.coords.get(1);
		return hash;
	}
}
