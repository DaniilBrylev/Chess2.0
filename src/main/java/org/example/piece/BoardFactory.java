package org.example.piece;

import org.example.*;

public class BoardFactory {

    private final PieceFactory pieceFactory = new PieceFactory();

public ChessBoard fromFEN(String fen) {
    // создаем стартовое значение доски
    ChessBoard board = new ChessBoard();
 String[] parts = fen.split(" ");
 String piecePositions = parts[0];

 String[] fenRows = piecePositions.split("/");

    for (int i = 0; i < fenRows.length; i++) {
        String row = fenRows[i];
        int rank = 8-i;

        int fileIndex = 0;
        for (int j = 0; j < row.length() ; j++) {
            char fenChar = row.charAt(j);

            if (Character.isDigit(fenChar)) {
                fileIndex += Character.getNumericValue(fenChar);
            } else {
                File file = File.values()[fileIndex];
                Coordinates coordinates = new Coordinates (file, rank);

                board.setPiece(coordinates, pieceFactory.fromFenChar(fenChar, coordinates));
                fileIndex++;

                   }
                }
             }
                return board;
          }


        }
