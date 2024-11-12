package org.example;

import org.example.piece.BoardFactory;

public class Main {
    public static void main(String[] args) {
//Board board = new Board();
//board.setupDefaultPiecesPositions();
        Board board =(new BoardFactory()).fromFEN(
                // "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"
                 //"3k4/8/5n2/2N5/3B4/8/8/3K4 w - - 0 1"
                 "3k4/8/p7/8/R7/8/P7/3K4 w - - 0 1"


        );

BoardConsoleRender renderer = new BoardConsoleRender();
//        renderer.render (board);
//
//       Piece piece = board.getPiece(new Coordinates(File.G, 8));
//       Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);
//       int a = 123;


        Game game = new Game(board);
        game.gameLoop();


        }

    }
