package org.con4;

public class Board implements BoardMetodos{
    //se crean las variables a usar y se modifican como 'final' de manera que no puedan ser modificadas
    private final Piece[][] tablero;
    private final int filas = 6;
    private final int columnas = 7;

    //Casilla vacía
    Player none = new Player(0, "none", "-", 0);
    Piece noPiece = none.getPiece();

    //constructor del board
    public Board() {
        tablero = new Piece[filas][columnas];
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                tablero[i][j] = noPiece;
            }
        }
    }

    //se puede jugar?
    @Override
    public boolean canPlay(){
        boolean playable = false;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                if(tablero[i][j] == noPiece){
                    playable = true;
                }
            }
        }
        return playable;
    }

    @Override
    public boolean playPiece(Piece piece, int columna){
        if(columna > 6 || columna < 0){
            System.out.println("Valor columna fuera de rango."); //fuera de rango
            return false;
        }
        else{
            for(int i = 5; i >= 0; i--){
                if(tablero[i][columna] == noPiece){
                    tablero[i][columna] = piece;
                    System.out.println("\nMovimiento realizado: ");
                    return true;
                }
            }
            System.out.println("Columna llena.");
            return false;
        }
    }

    @Override
    public void printBoard() {
        for (int i = 0; i < filas; i++) {
            //print "|"
            System.out.print("| ");
            for (int j = 0; j < columnas; j++) {
                System.out.print(Character.toUpperCase(tablero[i][j].getColor().charAt(0)) + " ");
                //print tablero[i][j];
            }
            //print "|", newline
            System.out.print("|\n");
        }
    }

    @Override
    public int verticalCheck(){
        int count = 0;
        Piece piezaActual = noPiece;

        for(int j = 0; j < 7; j++){
            for(int i = 0; i < 6; i++){
                if(tablero[i][j] == noPiece){
                    count = 0;
                }
                else if(tablero[i][j] != piezaActual){
                    count = 1;
                    piezaActual = tablero[i][j];
                }
                else{
                    count++;
                }

                if(count >= 4){
                    //devolver el jugador del color
                    return piezaActual.getPlayer().getId();
                }
            }
            count = 0;
        }
        return 0;
    }

    @Override
    public int horizontalCheck() {
        int count = 0;
        Piece piezaActual = noPiece;

        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                if(tablero[i][j] == noPiece){
                    count = 0;
                }
                else if(tablero[i][j] != piezaActual){
                    count = 1;
                    piezaActual = tablero[i][j];
                }
                else{
                    count++;
                }

                if(count >= 4){
                    //devolver el jugador del color
                    return piezaActual.getPlayer().getId();
                }
            }
            count = 0;
        }
        return 0;
    }

    @Override
    public int diagonalCheck() {
        int count = 0;
        Piece piezaActual = noPiece;

        for (int i = 0; i <= filas - 4; i++) {
            for (int j = 0; j <= columnas - 4; j++) {
                count = 0;
                piezaActual = tablero[i][j];
                for (int k = 0; k < 4; k++) {
                    if (tablero[i + k][j + k] == piezaActual && piezaActual != noPiece) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count == 4) {
                    return 1;
                }
            }
        }

        for (int i = 3; i < filas; i++) {
            for (int j = 0; j <= columnas - 4; j++) {
                count = 0;
                piezaActual = tablero[i][j];
                for (int k = 0; k < 4; k++) {
                    if (tablero[i - k][j + k] == piezaActual && piezaActual != noPiece) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count == 4) {
                    return piezaActual.getPlayer().getId();
                }
            }
        }

        return 0; // No hay ganador
    }

    @Override
    public int entregarGanador(){
        int winner = this.verticalCheck();
        if (winner != 0) {
            return winner; // Termina si hay un ganador
        }
        winner = this.horizontalCheck();
        if (winner != 0) {
            return winner;
        }
        winner = this.diagonalCheck();
        return winner;
    }
}