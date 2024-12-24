package org.con4;

import java.util.List;

public interface GameMetodos {
    Board getBoard();
    List<Object[]> getHistory();
    void printHistory();
    boolean esEmpate();
    Player getCurrentPlayer();
    Board boardGetState();
    void endGame();
    boolean realizarMovimiento(Player player, int columna);
}
