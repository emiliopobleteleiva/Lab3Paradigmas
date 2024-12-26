package org.con4;

import java.util.List;

public interface GameMetodos_204446830_PobleteLeiva {
    Board_204446830_PobleteLeiva getBoard();
    List<Object[]> getHistory();
    void printHistory();
    boolean esEmpate();
    Player_204446830_PobleteLeiva getCurrentPlayer();
    Board_204446830_PobleteLeiva boardGetState();
    void endGame();
    boolean realizarMovimiento(Player_204446830_PobleteLeiva player, int columna);
    void cambiarTurno();
    void newBoard();
    void resetGame(int cantRemainingPieces);
}
