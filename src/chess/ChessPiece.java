package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece {
    Color color;
    int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    @Override
    public boolean[][] possibleMoves() {
        return new boolean[0][];
    }
}
