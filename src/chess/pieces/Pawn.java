package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    private int pawnMoves = 0;
    private int direction = this.getColor() == Color.WHITE ? -1 : 1;

    @Override
    public String toString() {
        return "♟ ";
    }

    public void updatePawnMoves() {
        this.pawnMoves++;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] possibleMovesMatrix = new boolean[this.getBoard().getRows()][getBoard().getColumns()];
        Position positionVerifier = new Position(0, 0);

        positionVerifier.setRow(this.position.getRow() + this.direction);
        positionVerifier.setColumn(this.position.getColumn());
        Boolean canMove = !this.getBoard().thereIsAPiece(positionVerifier);
        
        if (this.pawnMoves > 1) {
            if (this.getBoard().positionExists(positionVerifier) && canMove) {
                possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
            }
        } else if (this.getBoard().positionExists(positionVerifier) && canMove && this.pawnMoves == 1 ) {
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
            positionVerifier.setRow(positionVerifier.getRow() + this.direction);
            canMove = !this.getBoard().thereIsAPiece(positionVerifier);
    
            if (this.getBoard().positionExists(positionVerifier) && canMove) {
                possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
            }
        }
        positionVerifier.setRow(this.position.getRow() + this.direction);
        positionVerifier.setColumn(this.position.getColumn() + 1);
        canMove = this.getBoard().thereIsAPiece(positionVerifier) && this.isThereOpponentPiece(positionVerifier);
        if(canMove){
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
        }
        positionVerifier.setRow(this.position.getRow() + this.direction);
        positionVerifier.setColumn(this.position.getColumn() - 1);
        canMove = this.getBoard().thereIsAPiece(positionVerifier) && this.isThereOpponentPiece(positionVerifier);
        if(canMove){
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
        }
        return possibleMovesMatrix;
        
    }
    
}
