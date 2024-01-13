package boardgame;

import java.util.ArrayList;
import java.util.List;

import chess.ChessPiece;
import chess.pieces.Pawn;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;
    private List<ChessPiece> chessPiecesList = new ArrayList<>();

    public Board(int rows, int columns) {

        if(rows < 1 || columns < 1){
            throw new BoardException("Error creating board, you need a lease 1 line and column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
        this.makechessPiecesList();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column){
        if(!positionExists(row, column)){
            return null;
        }
        return pieces[row][column];
    }

    public Piece piece(Position position){
        if(!positionExists(position)){
            return null;
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("Position: " + position.toString() + " is occupied!");
        }
        this.pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
        if(piece instanceof Pawn){
            ((Pawn) piece).updatePawnMoves();
        }
        this.makechessPiecesList();
    }

    public Piece removePiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        Piece pieceToRemove = piece(position);

        if(pieceToRemove == null){
            return null;
        }
        pieceToRemove.position = null;
        pieces[position.getRow()][position.getColumn()] = null;
        return pieceToRemove;
    }
    private boolean positionExists(int row, int column){

        return row >= 0 && row < this.rows && column >= 0 && column < this.columns;
    }
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){

        return this.piece(position) != null;
    }

    /**
     * @return the pieces
     */
    private void makechessPiecesList(){
        List<ChessPiece> newchessPiecesList = new ArrayList<>();
        for(int i  = 0; i< pieces.length; i++){
            for (int j = 0; j< pieces[i].length; j++){
                if( pieces[i][j] != null && this.thereIsAPiece(pieces[i][j].position)){
                    newchessPiecesList.add((ChessPiece)pieces[i][j]);
                }
            }
        }
        chessPiecesList = newchessPiecesList;
        
    }
    public List<ChessPiece> getchessPiecesList() {
        return chessPiecesList;
    }    
}
