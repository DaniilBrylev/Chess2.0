package org.example;

import BoardConsoleRenderer.BoardConsoleRenderer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
Board board = new Board();
board.setupDefaultPiecesPositions();
        BoardConsoleRenderer renderer = new BoardConsoleRenderer();
        renderer.render (board);
        int a = 123;

        }
    }
