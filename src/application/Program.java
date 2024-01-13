package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChessMatch chessMatch = ChessMatch.getInsantance();
        
        while(true){
            try{
                UI.clearConsole();
                UI.printMatch(chessMatch);
                System.out.println();
                
                UI.printBoard(chessMatch.getPieces());

                System.out.println();
                ChessPosition sourcePosition;
                if(chessMatch.getPlayerInCheckCondition() == null){
                    System.out.print("Source: ");
    
                    sourcePosition = UI.readChessPosition(scanner);
                    chessMatch.validateSourcePosition(sourcePosition.toPosition());
    
                    boolean[][] possibleMoves = chessMatch.possibleMoves(sourcePosition);
                    
                    UI.clearConsole();
                    
                    UI.printBoard(chessMatch.getPieces(), possibleMoves);
                } else {
                    UI.clearConsole();
                    System.out.println("Watch out! you are checked! You must move the king!");
                    UI.printBoard(chessMatch.getPieces(), chessMatch.getCheckedKing().possibleMoves());
                    sourcePosition = ChessPosition.fromPosition( chessMatch.getCheckedKing().getPosition());
                    chessMatch.validateSourcePosition(sourcePosition.toPosition());
                }
                
                System.out.println();
                System.out.print("Target: ");

                ChessPosition targetPosition = UI.readChessPosition(scanner);
                
                chessMatch.performChessMove(sourcePosition, targetPosition);
                chessMatch.handleCheckCondition();
            }catch (ChessException e){
                System.out.print(e.getMessage());
                scanner.nextLine();
            } catch (InputMismatchException e){
                System.out.print(e.getMessage());
                scanner.nextLine();
            }

        }
    }
}
