package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

   public Queen(Board board, Color color) {
      super(board, color);
   }

   @Override
   public String toString() {
      return "♛ ";
   }

   @Override
   public boolean[][] possibleMoves() {
      boolean[][] possibleMovesMatrix = new boolean[8][8];
      Position positionVerifier = new Position(0, 0);

      // above
      positionVerifier.setRow(this.position.getRow() - 1);
      positionVerifier.setColumn(this.position.getColumn());

      while (this.getBoard().positionExists(positionVerifier) && !this.getBoard().thereIsAPiece(positionVerifier)) {
         possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
         positionVerifier.setRow(positionVerifier.getRow() - 1);
      }

      if (this.getBoard().thereIsAPiece(positionVerifier) && this.isThereOpponentPiece(positionVerifier)) {
         possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
      }

      // bottom
      positionVerifier.setRow(this.position.getRow() + 1);
      positionVerifier.setColumn(this.position.getColumn());
      while (getBoard().positionExists(positionVerifier) && !getBoard().thereIsAPiece(positionVerifier)) {
         possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
         positionVerifier.setRow(positionVerifier.getRow() + 1);
      }
      if (this.getBoard().thereIsAPiece(positionVerifier) && isThereOpponentPiece(positionVerifier)) {
         possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
      }

      // right
      positionVerifier.setRow(this.position.getRow());
      positionVerifier.setColumn(this.position.getColumn() + 1);

      while (this.getBoard().positionExists(positionVerifier) && !this.getBoard().thereIsAPiece(positionVerifier)) {
         possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
         positionVerifier.setColumn(positionVerifier.getColumn() + 1);
      }

      if (this.getBoard().thereIsAPiece(positionVerifier) && this.isThereOpponentPiece(positionVerifier)) {
         possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
      }

      // left
      positionVerifier.setRow(this.position.getRow());
      positionVerifier.setColumn(this.position.getColumn() - 1);

      while (this.getBoard().positionExists(positionVerifier) && !this.getBoard().thereIsAPiece(positionVerifier)) {
         possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
         positionVerifier.setColumn(positionVerifier.getColumn() - 1);
      }

      if (this.getBoard().thereIsAPiece(positionVerifier) && this.isThereOpponentPiece(positionVerifier)) {
         possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
      }
      // up right
      positionVerifier.setColumn(this.position.getColumn() + 1);
      positionVerifier.setRow(this.position.getRow() - 1);

      while (this.getBoard().positionExists(positionVerifier) && !this.getBoard().thereIsAPiece(positionVerifier)) {
         possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
         positionVerifier.setColumn(positionVerifier.getColumn() + 1);
         positionVerifier.setRow(positionVerifier.getRow() - 1);
      }

      if (this.getBoard().thereIsAPiece(positionVerifier) && this.isThereOpponentPiece(positionVerifier)) {
         possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
      }
      // up left
      positionVerifier.setColumn(this.position.getColumn() - 1);
      positionVerifier.setRow(this.position.getRow() - 1);

      while (this.getBoard().positionExists(positionVerifier) && !this.getBoard().thereIsAPiece(positionVerifier)) {
         possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
         positionVerifier.setColumn(positionVerifier.getColumn() - 1);
         positionVerifier.setRow(positionVerifier.getRow() - 1);
      }
      if (this.getBoard().thereIsAPiece(positionVerifier) && this.isThereOpponentPiece(positionVerifier)) {
         possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
      }
      // down right
      positionVerifier.setColumn(this.position.getColumn() + 1);
      positionVerifier.setRow(this.position.getRow() + 1);

      while (this.getBoard().positionExists(positionVerifier) && !this.getBoard().thereIsAPiece(positionVerifier)) {
         possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
         positionVerifier.setColumn(positionVerifier.getColumn() + 1);
         positionVerifier.setRow(positionVerifier.getRow() + 1);
      }
      if (this.getBoard().thereIsAPiece(positionVerifier) && this.isThereOpponentPiece(positionVerifier)) {
         possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
      }
      // down left
      positionVerifier.setColumn(this.position.getColumn() - 1);
      positionVerifier.setRow(this.position.getRow() + 1);

      while (this.getBoard().positionExists(positionVerifier) && !this.getBoard().thereIsAPiece(positionVerifier)) {
         possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
         positionVerifier.setColumn(positionVerifier.getColumn() - 1);
         positionVerifier.setRow(positionVerifier.getRow() + 1);
      }
      if (this.getBoard().thereIsAPiece(positionVerifier) && this.isThereOpponentPiece(positionVerifier)) {
         possibleMovesMatrix[positionVerifier.getRow()][positionVerifier.getColumn()] = true;
      }

      return possibleMovesMatrix;
   }
}
