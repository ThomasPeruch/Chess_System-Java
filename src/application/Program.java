package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch cm = new ChessMatch();

        while(true) {
            try {
                UI.clearScreen();
                UI.printBoard(cm.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = cm.performChessMove(source, target);
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
