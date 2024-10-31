package org.example;

import File.File;
import org.example.piece.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
Board board = new Board();
board.setupDefaultPiecesPositions();
//BoardConsoleRender renderer = new BoardConsoleRender();
//        renderer.render (board);
//
//       Piece piece = board.getPiece(new Coordinates(File.G, 8));
//       Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);
//       int a = 123;


        Game game = new Game(board);
        game.gameLoop();


        }

    }
