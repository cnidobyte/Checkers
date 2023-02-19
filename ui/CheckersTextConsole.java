package ui;

import core.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Handles all the display functions of the game.
 * @author Shota Bennett
 *
 */
public class CheckersTextConsole {
	
	/**
	 * Class Constructor.
	 */
	public CheckersTextConsole() {}
	
	/**
	 * Prints the initial board, starting the game with player X.
	 * @param board
	 */
	public void gameStartPrint(Board board) {
		//Print Grid
		displayBoard(board);
		System.out.println("Begin Game. Enter 'P' if you want to play against another player;"
				+ " enter 'C' to play against the computer.");
		//displayTurnPrompt(true);
		//Print turn prompt player X.
	}
	
	/**
	 * Prints the game board. Recommended updating board before displaying.
	 * @param board
	 */
	public void displayBoard(Board board) {
		int bound = board.getXDimension();
		for(int row = 0; row < bound; row++) {
			// Print Left Margin (Numbers of rows)
			System.out.print(bound - row + " ");
			printBox(row, bound, board);
			System.out.println("|");
		}
		
		System.out.println("    A   B   C   D   E   F   G   H ");
	}
	
	/**
	 * Helper function. Prints the row of boxes, taking into account the occupied spaces.
	 * @param row
	 * @param bound
	 * @param board
	 */
	private void printBox(int row, int bound, Board board) {
		for(int col = 0; col < bound; col++) {
			System.out.print("|");
			if(board.getTakenSpaces()[row][col] == true) {
				if(board.getOhPieces().containsKey(new Coordinate(row, col))) {
					System.out.print(" O ");
				}
				if(board.getExPieces().containsKey(new Coordinate(row, col))) {
					System.out.print(" X ");
				}
			}
			else {
				System.out.print(" _ ");
			}
			// System.out.print("|");
		}
	}
	
	/**
	 * Prompts the user for input.
	 * @param turn
	 */
	public void displayTurnPrompt(boolean turn) {
		//Player (player) - your turn. 
		String player;
		if(turn)
			player = " X";
		else
			player = " O";
		System.out.println("Player" + player + " - your turn.");
		//Choose a cell position of piece to be move and the new position. e.g., 3a-4b  3a - 4h.
		System.out.println("Choose a cell position of piece to be moved and the new position.");
		System.out.println("e.g., 3b-4c");
		
	}
	
	/**
	 * On win, winner is printed.
	 * @param type
	 */
	public void displayWinner(PlayerType type) {
		switch(type ) {
		case EX: {
			System.out.println("Player X won the game!");
			break;
		}
		case OH: {
			System.out.println("Player O won the game!");
		}
		}
	}
	
	/**
	 * Unfinished function. Functional, but incomplete. Can add specific warnings.
	 */
	public void invalidMove() {
		System.out.println("Invalid move, try again.");
	}
}
