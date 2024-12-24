package org.con4;

public interface BoardMetodos {
    boolean canPlay();
    boolean playPiece(Piece piece, int columna);
    void printBoard();
    int verticalCheck();
    int horizontalCheck();
    int diagonalCheck();
    int entregarGanador();
}