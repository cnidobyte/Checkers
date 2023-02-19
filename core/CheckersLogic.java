package core;

import java.util.Scanner;
import java.util.ArrayList;

import ui.*;
/**
 * The <em>CheckersLogic</em> class provides all the necessary checks and underlying game logic
 * determining behavior of movement and display. Initializes the game boards and provides functions
 * that modify the playing space.
 * @author Shota Bennett
 *
 */
public class CheckersLogic {
	
	
	Board gameboard;
	Scanner scan = new Scanner(System.in);
	CheckersTextConsole uiHandler = new CheckersTextConsole();
	private boolean xTurn = true;
	
	/** 
	 * Class Constructor.
	 */
	public CheckersLogic() {
		
	}
	
	/**
	 * Intro point for the game. Initialize the game board, the pieces, and calls methods to print ui.
	 */
	public void gameStart() {
		gameboard = new Board();
		uiHandler.gameStartPrint(gameboard);
		String gameChoice = "O"; 
		while(!gameChoice.equalsIgnoreCase("C") && !gameChoice.equalsIgnoreCase("P")) {
			gameChoice = scan.nextLine();
		}
		gameChoice = gameChoice.toUpperCase();
		
		switch (gameChoice) {
			case "C": {
				uiHandler.displayTurnPrompt(xTurn);
				versusComputer();
				break;
			}
			case "P": {
				uiHandler.displayTurnPrompt(xTurn);
				playerRounds();
				break;
			}
		}
	}
	
	/**
	 * Main game loop. Turns decided on the truth of xTurn. 
	 */
	private void playerRounds() {
		while(!gameOver()) {
			String moveInput = scan.nextLine();
			Move move = new Move(moveInput);
			movePiece(move);
			xTurn = !xTurn;
			gameboard.updateGrid();
			uiHandler.displayBoard(gameboard);
			uiHandler.displayTurnPrompt(xTurn);
		}
	}
	
	private void versusComputer() {
		while(!gameOver()) {
			if(xTurn) {
				//Player Turn
				String moveInput = scan.nextLine();
				Move move = new Move(moveInput);
				movePiece(move);
				xTurn = !xTurn;
				gameboard.updateGrid();
				uiHandler.displayBoard(gameboard);
			}
			else {
				//Computer Turn
				ArrayList<Move> moves = CheckersComputerPlayer.computerMove(gameboard);
				for(int i = 0; i < moves.size(); i++) {
					if(validMove(moves.get(i))) {
						movePiece(moves.get(i));
						break;
					}
				}
				xTurn = !xTurn;
				gameboard.updateGrid();
				uiHandler.displayBoard(gameboard);
				uiHandler.displayTurnPrompt(true);
			}
		}
	}
	
	/**
	 * Win conditions for the game.
	 * @return boolean
	 */
	private boolean gameOver() {
		if(gameboard.getExPieces().isEmpty() || !movesAvailable(PlayerType.EX)) {
			uiHandler.displayWinner(PlayerType.OH);
			return true;
		} else if(gameboard.getOhPieces().isEmpty() || !movesAvailable(PlayerType.OH)) {
			uiHandler.displayWinner(PlayerType.EX);
			return true;
		}
		return false;
	}

	/**
	 * Governing logic for movement, includes a validation loop for coordinates.
	 * @param Move  Coordinates for the move.
	 */
	public void movePiece(Move move) {
		//TODO: Parse inputs to moves, take format 2A-3B
		
		while(!validMove(move)) {
			//TODO: Print Invalid, reprompt.
			System.out.println("oops!");
			System.out.println("This move is a jump: " + move.isJump());
			System.out.println("This move is adjacent: " + move.isAdjacent());
			uiHandler.displayTurnPrompt(xTurn);
			String moveInput = scan.nextLine();
			move = new Move(moveInput);
		}
		
		// Moves the piece to the destination spot, removing opponent pieces if jumped.
		if(gameboard.getExPieces().containsKey(move.getSourceCoords())) {
			gameboard.getExPieces().put(
					move.getDestinationCoords(), 
					new Piece(
							move.getDestinationCoords().getCoords(0), 
							move.getDestinationCoords().getCoords(1), 
							PlayerType.EX
							));
			gameboard.getExPieces().remove(move.getSourceCoords());
			if(move.isJump()) {
				gameboard.getOhPieces().remove(move.getMidpointCoords());
			}
		} else {
			gameboard.getOhPieces().put(
					move.getDestinationCoords(), 
					new Piece(
							move.getDestinationCoords().getCoords(0), 
							move.getDestinationCoords().getCoords(1), 
							PlayerType.OH
							));
			gameboard.getOhPieces().remove(move.getSourceCoords());
			if(move.isJump()) {
				gameboard.getExPieces().remove(move.getMidpointCoords());
			}
		}
	}
	
	/**
	 * Checks if the move entered is valid. Ensures that the player is only moving their own piece. Checks if 
	 * the move is diagonally adjacent or is a jump.
	 * @return boolean
	 */
	public boolean validMove(Move move) {
		
		boolean result = false;
		//Verifies that the player is moving their own pieces.
		if(xTurn && gameboard.getExPieces().containsKey(move.getSourceCoords())) {
			result = true;
		}
		else if(!xTurn && gameboard.getOhPieces().containsKey(move.getSourceCoords()))
			result = true;
		
		//Verifies that the move is only adjacent or jump
		result = move.isAdjacent() || move.isJump();
		System.out.println("The destination spot is empty" + gameboard.isEmpty(move.getDestinationCoords().getCoords(0),move.getDestinationCoords().getCoords(1)) );
		return result && gameboard.isEmpty(move.getDestinationCoords().getCoords(0),move.getDestinationCoords().getCoords(1));
	}
	

	/**
	 * For the Pieces belonging to player, checks if there are valid moves available.
	 * @return boolean
	 */
	public boolean movesAvailable(PlayerType player) {
		// TODO: add parameters, functionality, update Javadoc.
		if(player == PlayerType.EX) {
			for(Piece piece : gameboard.getExPieces().values()) {
				return piece.getMoves() != null;
			}
		}
		else if(player == PlayerType.OH) {
			for(Piece piece : gameboard.getOhPieces().values()) {
				return piece.getMoves() != null;
			}
		}
		return false;
	}
}
