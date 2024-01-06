package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        while(true){
            try{
                UI.clearConsole();
                UI.printBoard(chessMatch.getPieces());

                System.out.println();
                System.out.print("Source: ");

                ChessPosition sourcePosition = UI.readChessPosition(scanner);

                System.out.println();
                System.out.print("Target: ");

                ChessPosition targetPosition = UI.readChessPosition(scanner);
                ChessPiece capturedPiece = chessMatch.performChessMove(sourcePosition, targetPosition);
            }catch (ChessException e){
                System.out.println(e.getMessage());
                scanner.nextLine();
            } catch (InputMismatchException e){
                System.out.println(e.getMessage());
                scanner.nextLine();
            }

        }
    }
}