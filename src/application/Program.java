package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch cm = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while(true) {
            try {
                UI.clearScreen();
                UI.printMatch(cm,captured);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = cm.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(cm.getPieces(),possibleMoves);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = cm.performChessMove(source, target);
                if(capturedPiece != null){
                    captured.add(capturedPiece);
                }

            }
            catch (ChessException cE){
                System.out.println(cE.getMessage());
                sc.nextLine();
            }
            catch (InputMismatchException iMe){
                System.out.println(iMe.getMessage());
                sc.nextLine();
            }
        }

    }
}
