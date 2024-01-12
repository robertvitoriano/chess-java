package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Horse extends ChessPiece {
    public Horse(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "♞ ";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] possibleMovesMatrix = new boolean[8][8];
        Position positionVerifier = new Position(0, 0);
        boolean canMove = false;

        // up
        positionVerifier.setColumn(this.position.getColumn() - 1);
        positionVerifier.setRow(this.position.getRow() - 2);
        canMove = !this.getBoard().thereIsAPiece(positionVerifier)
                || this.getBoard().thereIsAPiece(positionVerifier) && this.isThereOpponentPiece(positionVerifier);

        if (this.getBoard().positionExists(positionVerifier) && canMove) {
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
        }
        positionVerifier.setColumn(positionVerifier.getColumn() + 2);
        canMove = !this.getBoard().thereIsAPiece(positionVerifier)
                || this.getBoard().thereIsAPiece(positionVerifier) && this.isThereOpponentPiece(positionVerifier);

        if (this.getBoard().positionExists(positionVerifier) && canMove) {
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
        }

        // down
        positionVerifier.setColumn(this.position.getColumn() - 1);
        positionVerifier.setRow(this.position.getRow() + 2);
        canMove = !this.getBoard().thereIsAPiece(positionVerifier)
                || this.getBoard().thereIsAPiece(positionVerifier) && this.isThereOpponentPiece(positionVerifier);

        if (this.getBoard().positionExists(positionVerifier) && canMove) {
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
        }
        positionVerifier.setColumn(positionVerifier.getColumn() + 2);
        canMove = !this.getBoard().thereIsAPiece(positionVerifier)
                || this.getBoard().thereIsAPiece(positionVerifier) && this.isThereOpponentPiece(positionVerifier);

        if (this.getBoard().positionExists(positionVerifier) && canMove) {
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
        }
        
        
        // left
        positionVerifier.setColumn(this.position.getColumn() - 2);
        positionVerifier.setRow(this.position.getRow() - 1);
        canMove = !this.getBoard().thereIsAPiece(positionVerifier) || this.getBoard().thereIsAPiece(positionVerifier) && this.isThereOpponentPiece(positionVerifier);

        if (this.getBoard().positionExists(positionVerifier) && canMove) {
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
        }
        positionVerifier.setRow(positionVerifier.getRow() + 2);
        canMove = !this.getBoard().thereIsAPiece(positionVerifier)
                || this.getBoard().thereIsAPiece(positionVerifier) && this.isThereOpponentPiece(positionVerifier);

        if (this.getBoard().positionExists(positionVerifier) && canMove) {
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
        }
        
        // right
        positionVerifier.setColumn(this.position.getColumn() + 2);
        positionVerifier.setRow(this.position.getRow() - 1);
        canMove = !this.getBoard().thereIsAPiece(positionVerifier) || this.getBoard().thereIsAPiece(positionVerifier) && this.isThereOpponentPiece(positionVerifier);

        if (this.getBoard().positionExists(positionVerifier) && canMove) {
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
        }
        positionVerifier.setRow(positionVerifier.getRow() + 2);
        canMove = !this.getBoard().thereIsAPiece(positionVerifier)
                || this.getBoard().thereIsAPiece(positionVerifier) && this.isThereOpponentPiece(positionVerifier);

        if (this.getBoard().positionExists(positionVerifier) && canMove) {
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
        }

        return possibleMovesMatrix;
    }
}
