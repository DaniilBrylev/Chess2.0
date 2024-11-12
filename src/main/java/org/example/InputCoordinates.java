package org.example;

import org.example.piece.Piece;

import java.util.Scanner;
import java.util.Set;

public class InputCoordinates {

    private static final Scanner scanner = new Scanner(System.in);

    public static Coordinates input(){
        while (true){
            System.out.println("Пожайлуста, введите координату (например: a1)");

            // a1
            String line = scanner.nextLine();
            if (line.length() !=2) {
                System.out.println("Неправильный формат");
                continue;
            }
            char fileChar = line.charAt(0);
            char rankChar = line.charAt(1);

            if (!Character.isLetter(fileChar)) {
                System.out.println("Неправильный формат");
                continue;
            }
            if (!Character.isDigit(rankChar)) {
               System.out.println("Неправильный формат");
               continue;
           }
           int rank = Character.getNumericValue(rankChar);
           if (rank < 1 || rank > 8) {
               System.out.println("Неправильный формат");
               continue;
           }

           File file = File.fromChar(fileChar);
           if (file == null) {
               System.out.println("Неправильный формат");
               continue;
           }

           return new Coordinates(file, rank);

        }
    }



    public static Coordinates inputPieceCoordinatesForColor(Color color, Board board){
        while (true) {
            System.out.println("Введите координаты фигуры для перемещения");
            Coordinates coordinates = input();

            if(board.isSquareEmpty(coordinates)) {
                System.out.println("Ничего нет");
                continue;
            }
            Piece piece = board.getPiece(coordinates);
           if (piece.color !=color) {
               System.out.println("Нельзя двигать чужую фигуру");
               continue;
           }

           Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);
           if (availableMoveSquares.size() == 0) {
                System.out.println("Эта фигура заблокирована");
                continue;
            }
            return  coordinates;
         }
    }
    public static Coordinates inputAvailableSquare(Set<Coordinates> coordinates) {
        while (true) {
            System.out.println("Введите ваш ход для выбранной фигуры");
            Coordinates input = input();
            if (!coordinates.contains(input)) {
                System.out.println("Недоступное для хода поле");
                continue;
            }
             return input;
        }
    }
    public static void main(String[] args) {
        Board board = new Board();
        board.setupDefaultPiecesPositions();

       Coordinates coordinates = inputPieceCoordinatesForColor(Color.WHITE, board);
        System.out.println(coordinates);
    }


}
