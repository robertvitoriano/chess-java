package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece {
    Color color;
    int moveCount;
    ChessPosition getChessPosition(){
        return (ChessPosition) this.position;
    }
    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

}
