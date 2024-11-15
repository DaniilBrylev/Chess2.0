package org.example.piece;

import org.example.ChessBoard;
import org.example.canMoveToPosition;
import org.example.Color;
import org.example.Coordinates;

import java.util.List;

public abstract class LongRangeChessPiece extends ChessPiece {
    public LongRangeChessPiece(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, ChessBoard board) {
        boolean result = super.isSquareAvailableForMove(coordinates, board);
        if (result) {
             return isSquareAvailableForAttack(coordinates, board);
        } else {

            return false;
        }
    }

    @Override
    protected boolean isSquareAvailableForAttack(Coordinates coordinates, ChessBoard board) {
        List<Coordinates> coordinatesBetween;
        if (this.coordinates.file == coordinates.file) {
            coordinatesBetween = canMoveToPosition.getVerticalCoordinatesBetween(this.coordinates, coordinates);
        } else if (this.coordinates.rank.equals(coordinates.rank)) {
            coordinatesBetween = canMoveToPosition.getHorizontalCoordinatesBetween(this.coordinates, coordinates);
        } else {
            coordinatesBetween = canMoveToPosition.getDiagonalCoordinatesBetween(this.coordinates, coordinates);

        }

        for (Coordinates c : coordinatesBetween) {
            if (!board.isSquareEmpty(c)) {
                return false;

            }
        }
        return true;
    }
}
