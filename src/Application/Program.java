package Application;

import Chess.ChessMatch;
import boardgame.Board;
import boardgame.Position;

public class Program {
    public static void main(String[] args) {
        ChessMatch cm = new ChessMatch();
        UI.printBoard(cm.getPieces());


    }
}
