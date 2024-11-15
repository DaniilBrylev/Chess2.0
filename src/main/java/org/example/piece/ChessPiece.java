package org.example.piece;
// создал отдельный класс фигур(абстракто всех), расписываю какие в общем должны быть фигур
import org.example.Color;
import org.example.ChessBoard;
import org.example.Coordinates;

import java.util.HashSet;
import java.util.Set;

abstract public class ChessPiece {
    public final Color color; //всем фигурам прусущь цвет
    public Coordinates coordinates;

    public ChessPiece(Color color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }

    public Set<Coordinates> getAvailableMoveSquares(ChessBoard board) {
        Set<Coordinates> result = new HashSet<>();
        for (CoordinatesShift shift : getPieceMoves()) {
            if (coordinates.canShift(shift)) {
                Coordinates newCoordinates = coordinates.shift(shift);

                if (isSquareAvailableForMove(newCoordinates, board)) {
                    result.add(newCoordinates);
                }

            }
        }
        return result;
    }

    protected boolean isSquareAvailableForMove(Coordinates coordinates, ChessBoard board) {
        return  board.isSquareEmpty(coordinates) || board.getPiece(coordinates).color !=color;
    }
    protected abstract Set<CoordinatesShift> getPieceMoves();
    protected Set<CoordinatesShift> getPieceAttacked() {
        return getPieceMoves();
    }


    public Set<Coordinates> getAttackedSquares(ChessBoard board) {
        Set<CoordinatesShift> pieceAttacks = getPieceAttacked();
        Set<Coordinates> result = new HashSet<>();

        for (CoordinatesShift pieceAttack : pieceAttacks) {
            if (coordinates.canShift(pieceAttack)) {
                Coordinates shiftedCoordinates = coordinates.shift(pieceAttack);

                if (isSquareAvailableForAttack(shiftedCoordinates, board)) {
                    result.add(shiftedCoordinates);
                }

            }
            
        }


        return  result;
    }

    protected boolean isSquareAvailableForAttack(Coordinates coordinates, ChessBoard board) {
        return true;
    }
}





