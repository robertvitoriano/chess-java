package chess;

import application.UI;
import boardgame.Board;
import boardgame.Position;
import chess.pieces.*;

public class ChessMatch {
    private Board board;

    public ChessMatch(){
        this.board = new Board(8, 8);
        this.initialSetup();
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] chessPieceMatrix = new ChessPiece[this.board.getRows()][this.board.getColumns()];
            for(int i = 0; i< board.getRows(); i++){
                for(int j = 0; j< board.getColumns(); j++ ){
                    chessPieceMatrix[i][j] = (ChessPiece) board.piece(i,j);
                }
            }
            return chessPieceMatrix;
    }

    private void initialSetup(){
        board.placePiece(new Rook(board, Color.WHITE), new Position(2, 0));
        board.placePiece(new King(board, Color.WHITE), new Position(3, 1));
        board.placePiece(new Pawn(board, Color.WHITE), new Position(4, 4));
        board.placePiece(new Horse(board, Color.WHITE), new Position(2, 1));
        board.placePiece(new Queen(board, Color.WHITE), new Position(6, 4));
        board.placePiece(new Bishop(board, Color.WHITE), new Position(3, 4));




    }
}
