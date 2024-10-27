package org.example;
import Color.Color;
import File.File;
import org.example.piece.Pawn;
import org.example.piece.Piece;

import java.util.HashMap;

public class Board {
    HashMap<Coordinates, Piece> pieces = new HashMap<>();//добавил колекцию, координаты сделал ключами, а фигуры значениями

    public void setPiece(Coordinates coordinates,Piece piece) {
        piece.coordinates = coordinates;
        pieces.put(coordinates, piece);
    }

    // где будем раставлять фигуры
    public void setupDefaultPiecesPositions() {

        for (File file : File.values()) {
             setPiece(new Coordinates(file,2),new Pawn(Color.WHITE,new Coordinates(file,2)));
            setPiece(new Coordinates(file,7),new Pawn(Color.BLACK,new Coordinates(file,7)));
        }
    }
    public static boolean isSquareDark (Coordinates coordinates){
            return (((coordinates.file.ordinal()+1)+coordinates.rank) % 2) == 0;
    }
}