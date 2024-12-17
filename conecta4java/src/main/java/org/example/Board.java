import org.example.*;

public class Board {
    //se crean las variables a usar y se modifican como 'final' de manera que no puedan ser modificadas
    private final String[][] tablero;
    private final int filas = 6;
    private final int columnas = 7;

    //constructor del board
    public Board() {
        tablero = new String[filas][columnas];
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                tablero[i][j] = "-";
            }
        }
        return tablero;
    }

    //se puede jugar?
    public bool canPlay?(){
        int i = 0;
        for (int j = 0; j < columnas; j++){
            if(tablero[i][j] == "-"){ //si es jugable
                return true;
            }
            else{
                return false;
            }
            i++;
        }
    }

    public int playPiece(String color, int columna){
        if(columna > 6){
            break; //fuera de rango
        }
        else{
            for(int i = 0; i < filas; i++){
                if(tablero[i][columna] != "0"){
                    return --i; //de momento devolver i-1 de mantera que se devuelva la posicidon fila en que se debería poner la ficha
                }
            }
        }
    }

    public print() {
        for (int i = 0; i < filas; i++) {
            //print "|"
            for (int j = 0; j < columnas; j++) {
                //print tablero[i][j];
            }
            //print "|", newline
        }
    }

    public int verticalCheck(){
        int j = 0;
        int count = 0;
        String piezaActual;
        for(int i = 0; i < filas; i++){ //se exploren todas las filas en
            //comprobar si
            if(tablero[i][j] == piezaActual){
                count++;
            }
            else{
                count = 1;
                piezaActual = tablero[i][j];
            }

            if (count == 4) {
                return 1; //de momento que se devuelva 1 si hay ganador
            }

            else if (i == 5) {
                if (j == 6) {
                    return 0; //no gana nadie
                    }
                    else {
                        i = 0;
                        j++;
                    }
            }
        }
    }

    public int horizontalCheck() {
        int i = 0;
        int count = 0;
        String piezaActual;
        for(int j = 0; j < filas; j++){ //se exploren todas las filas en
            //comprobar si
            if(tablero[i][j] == piezaActual){
                count++;
            }
            else{
                count = 1;
                piezaActual = tablero[i][j];
            }

            if (count == 4) {
                return 1; //de momento que se devuelva 1 si hay ganador
            }

            else if (j == 5) {
                if (i == 6) {
                    return 0; //no gana nadie
                }
                else {
                    j = 0;
                    i++;
                }
            }
        }
    }

    public int diagonalCheck() {
        int count = 0;
        String piezaActual;

        for (int i = 0; i <= filas - 4; i++) {
            for (int j = 0; j <= columnas - 4; j++) {
                count = 0;
                piezaActual = tablero[i][j];
                for (int k = 0; k < 4; k++) {
                    if (tablero[i + k][j + k] == piezaActual && piezaActual != "-") {
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
                    if (tablero[i - k][j + k] == piezaActual && piezaActual != "-") {
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

        return 0; // No hay ganador
    }

    public int entregarGanador(){
        int winner = 0;

        while(winner == 0){
            winner = tablero.verticalCheck();
            winner = tablero.horizontalCheck();
            winner = tablero.diagonalCheck();
            break;
        }
        return winner;
    }
}