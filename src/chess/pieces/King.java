package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King  extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }
    @Override
    public String toString(){
        return "♚ ";
    }
    
    private boolean canMove(Position position){
        return this.isThereOpponentPiece(position) || !this.getBoard().thereIsAPiece(position);
        }
    @Override
    public boolean[][] possibleMoves() {
        boolean [][] possibleMovesMatrix = new boolean[8][8];
        Position positionVerifier = new Position(0, 0);
        //above
        positionVerifier.setRow(this.position.getRow() - 1);
        positionVerifier.setColumn(this.position.getColumn());
        if(getBoard().positionExists(positionVerifier) && this.canMove(positionVerifier)){
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
        }
         //bottom
        positionVerifier.setRow(this.position.getRow() + 1);
        positionVerifier.setColumn(this.position.getColumn());		
        if(getBoard().positionExists(positionVerifier) && canMove(positionVerifier)){
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
        }
         
         //right
         positionVerifier.setRow(this.position.getRow());
         positionVerifier.setColumn(this.position.getColumn() + 1);
         
        if(getBoard().positionExists(positionVerifier) && canMove(positionVerifier)){
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
        }
         
         //left
         positionVerifier.setRow(this.position.getRow());
         positionVerifier.setColumn(this.position.getColumn() - 1);
         
        if(getBoard().positionExists(positionVerifier) && canMove(positionVerifier)){
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
        }
         
         // diagonal up left
         positionVerifier.setColumn(this.position.getColumn() - 1);
         positionVerifier.setRow(this.position.getRow() - 1);
         
        if(getBoard().positionExists(positionVerifier) && canMove(positionVerifier)){
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
        }
         
         // diagonal up right
         positionVerifier.setColumn(this.position.getColumn() + 1);
         positionVerifier.setRow(this.position.getRow() - 1);
         
        if(getBoard().positionExists(positionVerifier) && canMove(positionVerifier)){
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
        }
         
        // diagonal bottom left
         positionVerifier.setColumn(this.position.getColumn() - 1);
         positionVerifier.setRow(this.position.getRow() + 1);
         
        if(getBoard().positionExists(positionVerifier) && canMove(positionVerifier)){
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
        }
         
        // diagonal bottom right
        positionVerifier.setColumn(this.position.getColumn() + 1);
        positionVerifier.setRow(this.position.getRow() + 1);
         
        if(getBoard().positionExists(positionVerifier) && canMove(positionVerifier)){
            possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
        }
         
         return possibleMovesMatrix;
    }
}
