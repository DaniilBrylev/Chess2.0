package org.example.piece;
// создал отдельный класс фигур(абстракто всех), расписываю какие в общем должны быть фигур
import Color.Color;
import org.example.Coordinates;

abstract public class Piece {
    public final Color color; //всем фигурам прусущь цвет
    public Coordinates coordinates;

    public Piece(Color color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }
}