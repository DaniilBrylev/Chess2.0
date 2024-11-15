package org.example;

import org.example.piece.ChessPiece;

import java.util.Set;

public class Game {
    private final ChessBoard board;
private BoardConsoleRender renderer = new BoardConsoleRender();

    public Game(ChessBoard board) {
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
            ChessPiece chessPiece = board.getPiece(sourceCoordinates);
           Set<Coordinates> availableMoveSquares = chessPiece.getAvailableMoveSquares(board);

            renderer.render(board, chessPiece);
           Coordinates targetCoordinates = InputCoordinates.inputAvailableSquare(availableMoveSquares);

            // make move
            board.movePiece(sourceCoordinates, targetCoordinates);


            // pass move
            isWhiteToMove =! isWhiteToMove;

        }
    }
}
