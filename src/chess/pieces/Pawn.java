package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "♟ ";
    }
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] possibleMovesMatrix = new boolean[this.getBoard().getRows()][getBoard().getColumns()];
        Position positionVerifier = new Position(0,0);

        positionVerifier.setRow(this.position.getRow() - 1);
        positionVerifier.setColumn(this.position.getColumn());

        while(this.getBoard().positionExists(positionVerifier) && (!this.getBoard().thereIsAPiece(positionVerifier))){
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
            positionVerifier.setRow(positionVerifier.getRow() - 1);
        }

        if(this.getBoard().positionExists(positionVerifier) && this.isThereOpponentPiece(positionVerifier)){
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
        }

        return possibleMovesMatrix;
    }
}
