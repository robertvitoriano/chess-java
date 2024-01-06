package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {
    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "♜ ";
    }
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] possibleMovesMatrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position positionVerifier = new Position(0, 0);
		
		// above
		positionVerifier.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(positionVerifier) && !getBoard().thereIsAPiece(positionVerifier)) {
			possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
			positionVerifier.setRow(positionVerifier.getRow() - 1);
		}
		if (getBoard().positionExists(positionVerifier) && isThereOpponentPiece(positionVerifier)) {
			possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
		}
		
		// left
		positionVerifier.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(positionVerifier) && !getBoard().thereIsAPiece(positionVerifier)) {
			possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
			positionVerifier.setColumn(positionVerifier.getColumn() - 1);
		}
		if (getBoard().positionExists(positionVerifier) && isThereOpponentPiece(positionVerifier)) {
			possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
		}
		
		// right
		positionVerifier.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(positionVerifier) && !getBoard().thereIsAPiece(positionVerifier)) {
			possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
			positionVerifier.setColumn(positionVerifier.getColumn() + 1);
		}
		if (getBoard().positionExists(positionVerifier) && isThereOpponentPiece(positionVerifier)) {
			possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
		}
		
		// below
		positionVerifier.setValues(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(positionVerifier) && !getBoard().thereIsAPiece(positionVerifier)) {
			possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
			positionVerifier.setRow(positionVerifier.getRow() + 1);
		}
		if (getBoard().positionExists(positionVerifier) && isThereOpponentPiece(positionVerifier)) {
			possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
		}
		
        return possibleMovesMatrix;
	}
}
