package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract  class ChessPiece extends Piece {
    Color color;
    int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    protected boolean isThereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != this.color;
    }
}
