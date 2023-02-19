//package core;
//
//public class Player {
//	//TODO: ex or oh
//	private PlayerType type;
//	private Piece[] pieces;
//	/** 
//	 * Constructor.
//	 */
//	Player(int player) {
//		if(player == 1) {
//			this.type = PlayerType.EX;
//			pieces = new Piece[12];
//			
//			pieces[0].setCoords(5, 1);
//			pieces[1].setCoords(5, 3);
//			pieces[2].setCoords(5, 5);
//			pieces[3].setCoords(5, 7);
//			
//			pieces[4].setCoords(6, 0);
//			pieces[5].setCoords(6, 2);
//			pieces[6].setCoords(6, 4);
//			pieces[7].setCoords(6, 6);
//			
//			pieces[8].setCoords(7, 1);
//			pieces[9].setCoords(7, 3);
//			pieces[10].setCoords(7, 5);
//			pieces[11].setCoords(7, 7);
//			//TODO: place pieces?
//		}
//		else {
//			this.type = PlayerType.OH;
//			pieces = new Piece[12];
//			
//			pieces[0].setCoords(0, 0);
//			pieces[1].setCoords(0, 2);
//			pieces[2].setCoords(0, 4);
//			pieces[3].setCoords(0, 6);
//			
//			pieces[4].setCoords(1, 1);
//			pieces[5].setCoords(1, 3);
//			pieces[6].setCoords(1, 5);
//			pieces[7].setCoords(1, 7);
//			
//			pieces[8].setCoords(2, 0);
//			pieces[9].setCoords(2, 2);
//			pieces[10].setCoords(2, 4);
//			pieces[11].setCoords(2, 6);
//			
//			//TODO: place pieces?
//		}
//		
//	}
//	
//	public Piece getPiece(int i) {
//		return pieces[i];
//	}
//}
