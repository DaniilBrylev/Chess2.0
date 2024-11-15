package org.example;
import org.example.piece.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ChessBoard {
    HashMap<Coordinates, ChessPiece> pieces = new HashMap<>();//добавил колекцию, координаты сделал ключами, а фигуры значениями

    public void setPiece(Coordinates coordinates, ChessPiece chessPiece) {
        chessPiece.coordinates = coordinates;
        pieces.put(coordinates, chessPiece);
    }

    public void removePiece(Coordinates coordinates) {
        pieces.remove(coordinates);
    }

    public void movePiece(Coordinates from, Coordinates to) {

        ChessPiece chessPiece = getPiece(from);

        removePiece(from);
        setPiece(to, chessPiece);
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !pieces.containsKey(coordinates);
    }

    public ChessPiece getPiece(Coordinates coordinates) {
        return pieces.get(coordinates);
    }

    // где будем раставлять фигуры
    public void setupDefaultPiecesPositions() {
//установил пешки
        for (File file : File.values()) {
            setPiece(new Coordinates(file, 2), new Pawn(Color.WHITE, new Coordinates(file, 2)));
            setPiece(new Coordinates(file, 7), new Pawn(Color.BLACK, new Coordinates(file, 7)));
        }
        // поставил ладьи
        setPiece(new Coordinates(File.A, 1), new Rook(Color.WHITE, new Coordinates(File.A, 1)));
        setPiece(new Coordinates(File.H, 1), new Rook(Color.WHITE, new Coordinates(File.H, 1)));
        setPiece(new Coordinates(File.A, 8), new Rook(Color.BLACK, new Coordinates(File.A, 8)));
        setPiece(new Coordinates(File.H, 8), new Rook(Color.BLACK, new Coordinates(File.H, 8)));

        // поставил коней
        setPiece(new Coordinates(File.B, 1), new Knight(Color.WHITE, new Coordinates(File.B, 1)));
        setPiece(new Coordinates(File.G, 1), new Knight(Color.WHITE, new Coordinates(File.G, 1)));
        setPiece(new Coordinates(File.B, 8), new Knight(Color.BLACK, new Coordinates(File.B, 8)));
        setPiece(new Coordinates(File.G, 8), new Knight(Color.BLACK, new Coordinates(File.G, 8)));

        // поставил слонов
        setPiece(new Coordinates(File.C, 1), new Bishop(Color.WHITE, new Coordinates(File.C, 1)));
        setPiece(new Coordinates(File.F, 1), new Bishop(Color.WHITE, new Coordinates(File.F, 1)));
        setPiece(new Coordinates(File.C, 8), new Bishop(Color.BLACK, new Coordinates(File.C, 8)));
        setPiece(new Coordinates(File.F, 8), new Bishop(Color.BLACK, new Coordinates(File.F, 8)));

        // поставил ферзей
        setPiece(new Coordinates(File.D, 1), new Queen(Color.WHITE, new Coordinates(File.D, 1)));
        setPiece(new Coordinates(File.D, 8), new Queen(Color.BLACK, new Coordinates(File.D, 8)));

        // поставил королей
        setPiece(new Coordinates(File.E, 1), new King(Color.WHITE, new Coordinates(File.E, 1)));
        setPiece(new Coordinates(File.E, 8), new King(Color.BLACK, new Coordinates(File.E, 8)));


    }

    public static boolean isSquareDark(Coordinates coordinates) {
        return (((coordinates.file.ordinal() + 1) + coordinates.rank) % 2) == 0;
    }


    private List<ChessPiece> getPiecesByColor(Color color) {
        List<ChessPiece> result = new ArrayList<>();
        for (ChessPiece chessPiece : pieces.values()) {
            if (chessPiece.color == color) {
                result.add(chessPiece);
            }
        }

        return result;
    }

    public boolean isSquareAttackedByColor(Coordinates coordinates, Color color) {
        List<ChessPiece> chessPieces = getPiecesByColor(color);
        for (ChessPiece chessPiece : chessPieces)  {
            Set<Coordinates> attackedSquares = chessPiece.getAttackedSquares(this);

            if (attackedSquares.contains(coordinates)) {
                return  true;

            }

        }
         return  false;

    }
}

