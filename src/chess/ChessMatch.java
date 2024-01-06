package chess;

import application.UI;
import boardgame.Board;
import boardgame.Piece;
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
    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source,target);
        return (ChessPiece) capturedPiece;
    }
    
    public boolean[][] possibleMoves(ChessPosition sourcePosition){
        Position position = sourcePosition.toPosition();
        return board.piece(position).possibleMoves();
        
    }

    private void validateSourcePosition(Position position){
        if(!board.thereIsAPiece(position)){
            throw new ChessException("There is no piece on the source position");
        }
        if(!board.piece(position).isThereAnyPossibleMove()){
            throw new ChessException("There is no possible move for the chosen piece!");
        }
    }
    private void validateTargetPosition(Position source, Position target){
        if(!board.piece(source).isPossibleMove(target)){
            throw new ChessException("This movement is not allowed!");
        }
    }
    
    private Piece makeMove(Position source, Position target){
        Piece sourcePieceRemoved = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(sourcePieceRemoved, target);
        return capturedPiece;
    }
    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup(){
        placeNewPiece('h',1, new Rook(board, Color.WHITE));
        placeNewPiece('g',1, new Horse(board, Color.WHITE));
        placeNewPiece('f',1, new Bishop(board, Color.WHITE));
        placeNewPiece('e',1, new King(board, Color.WHITE));
        placeNewPiece('d',1, new Queen(board, Color.WHITE));
        placeNewPiece('c',1, new Bishop(board, Color.WHITE));
        placeNewPiece('b',1, new Horse(board, Color.WHITE));
        placeNewPiece('a',1, new Rook(board, Color.WHITE));


        placeNewPiece('h',2, new Pawn(board, Color.WHITE));
        placeNewPiece('g',2, new Pawn(board, Color.WHITE));
        placeNewPiece('f',2, new Pawn(board, Color.WHITE));
        placeNewPiece('e',2, new Pawn(board, Color.WHITE));
        placeNewPiece('d',2, new Pawn(board, Color.WHITE));
        placeNewPiece('c',2, new Pawn(board, Color.WHITE));
        placeNewPiece('b',2, new Pawn(board, Color.WHITE));
        placeNewPiece('a',2, new Pawn(board, Color.WHITE));

        placeNewPiece('h',8, new Rook(board, Color.BLACK));
        placeNewPiece('g',8, new Horse(board, Color.BLACK));
        placeNewPiece('f',8, new Bishop(board, Color.BLACK));
        placeNewPiece('e',8, new King(board, Color.BLACK));
        placeNewPiece('d',8, new Queen(board, Color.BLACK));
        placeNewPiece('c',8, new Bishop(board, Color.BLACK));
        placeNewPiece('b',8, new Horse(board, Color.BLACK));
        placeNewPiece('a',8, new Rook(board, Color.BLACK));


        placeNewPiece('h',7, new Pawn(board, Color.BLACK));
        placeNewPiece('g',7, new Pawn(board, Color.BLACK));
        placeNewPiece('f',7, new Pawn(board, Color.BLACK));
        placeNewPiece('e',7, new Pawn(board, Color.BLACK));
        placeNewPiece('d',7, new Pawn(board, Color.BLACK));
        placeNewPiece('c',7, new Pawn(board, Color.BLACK));
        placeNewPiece('b',7, new Pawn(board, Color.BLACK));
        placeNewPiece('a',7, new Pawn(board, Color.BLACK));



    }
}
