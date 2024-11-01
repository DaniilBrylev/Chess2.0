package org.example.piece;
// создал отдельный класс фигур(абстракто всех), расписываю какие в общем должны быть фигур
import Color.Color;
import org.example.Board;
import org.example.Coordinates;

import java.util.HashSet;
import java.util.Set;

abstract public class Piece {
    public final Color color; //всем фигурам прусущь цвет
    public Coordinates coordinates;

    public Piece(Color color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }

    public Set<Coordinates> getAvailableMoveSquares(Board board) {
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

    private boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        return  board.isSquareEmpty(coordinates) || board.getPiece(coordinates).color !=color;
    }

    protected abstract Set<CoordinatesShift> getPieceMoves();


}




