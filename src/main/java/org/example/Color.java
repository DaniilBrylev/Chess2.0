package org.example;
// Создал оттдельный класс для цвета белого и черного
public enum Color {
    WHITE,
    BLACK;

    public Color opposite() {
        return this == WHITE ? BLACK : WHITE;
    }
}
