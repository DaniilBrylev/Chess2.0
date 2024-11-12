package org.example.piece;

import org.example.Board;
import org.example.BoardUtils;
import org.example.Color;
import org.example.Coordinates;

import java.util.List;

public abstract class LongRangePiece extends Piece {
    public LongRangePiece(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        boolean result = super.isSquareAvailableForMove(coordinates, board);
        if (result) {
            List<Coordinates> coordinatesBetween = BoardUtils.getVerticalCoordinatesBetween(this.coordinates, coordinates);

            for (Coordinates c : coordinatesBetween) {
                if (!board.isSquareEmpty(c)) {
                    return false;

                }
            }
            return true;
        } else {

            return false;
        }
    }
}
