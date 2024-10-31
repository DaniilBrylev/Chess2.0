package org.example;

import Color.Color;
import org.example.piece.CoordinatesShift;
import org.example.piece.Piece;

import java.util.Set;

public class Game {
    private final Board board;
private BoardConsoleRender renderer = new BoardConsoleRender();

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop () {
        boolean isWhiteToMove = true;
        while (true) {
             //render
            renderer.render(board);

            if (isWhiteToMove) {
                System.out.println("Ходят белые");
            } else {
                System.out.println("Ходят черные");
            }


            //input
           Coordinates sourceCoordinates = InputCoordinates.inputPieceCoordinatesForColor(
                   isWhiteToMove ? Color.WHITE : Color.BLACK, board
           );
            Piece piece = board.getPiece(sourceCoordinates);
           Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);


           Coordinates targetCoordinates = InputCoordinates.inputAvailableSquare(availableMoveSquares);

            // make move
            board.movePiece(sourceCoordinates, targetCoordinates);


            // pass move
            isWhiteToMove =! isWhiteToMove;

        }
    }
}
