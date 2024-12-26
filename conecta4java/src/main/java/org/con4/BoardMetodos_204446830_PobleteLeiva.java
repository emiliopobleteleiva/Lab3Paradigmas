package org.con4;

public interface BoardMetodos_204446830_PobleteLeiva {
    boolean canPlay();
    boolean playPiece(Piece_204446830_PobleteLeiva piece, int columna);
    void printBoard();
    int verticalCheck();
    int horizontalCheck();
    int diagonalCheck();
    int entregarGanador();
}