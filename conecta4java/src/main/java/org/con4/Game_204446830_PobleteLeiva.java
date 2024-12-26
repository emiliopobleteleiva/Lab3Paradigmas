package org.con4;

import java.util.List;
import java.util.ArrayList;

public class Game_204446830_PobleteLeiva implements GameMetodos_204446830_PobleteLeiva {
    public Player_204446830_PobleteLeiva p1;
    public Player_204446830_PobleteLeiva p2;
    public Board_204446830_PobleteLeiva board;
    public int currentTurn;
    public List<Object[]> gameHistory;
    public List<List<Object[]>> history;

    //constructor
    public Game_204446830_PobleteLeiva(Player_204446830_PobleteLeiva p1, Player_204446830_PobleteLeiva p2){
        this.p1 = p1;
        this.p2 = p2;
        this.board = new Board_204446830_PobleteLeiva();
        this.currentTurn = 1;
        this.gameHistory = new ArrayList<>();
        this.history = new ArrayList<>();
    }

    //getter history
    @Override
    public List<Object[]> getHistory(){
        return gameHistory;
    }

    //métodos
    @Override
    public void printHistory() {
        System.out.println("Historial de todos los juegos:");

        // Mostrar los juegos anteriores
        int gameNumber = 1;
        for (List<Object[]> movimientos : history) {
            System.out.println("\nJuego " + gameNumber + ":");
            int moveNumber = 1;
            for (Object[] move : movimientos) {
                Piece_204446830_PobleteLeiva piece = (Piece_204446830_PobleteLeiva) move[0];
                int column = (int) move[1] + 1;
                System.out.println("Movimiento " + moveNumber + ":\n-Pieza: " + piece.getColor() + " (" + piece.getPlayer().getName() + ")\n-Columna: " + column);
                moveNumber++;
            }
            gameNumber++;
        }

        // Mostrar el juego actual
        if (!gameHistory.isEmpty()) {
            System.out.println("\nJuego Actual:");
            int moveNumber = 1;
            for (Object[] move : gameHistory) {
                Piece_204446830_PobleteLeiva piece = (Piece_204446830_PobleteLeiva) move[0];
                int column = (int) move[1] + 1;
                System.out.println("Movimiento " + moveNumber + ":\n-Pieza: " + piece.getColor() + " (" + piece.getPlayer().getName() + ")\n-Columna: " + column);
                moveNumber++;
            }
        } else {
            System.out.println("\nNo hay movimientos en el juego actual.");
        }
    }

    @Override
    public boolean esEmpate(){
        if(board.canPlay()){
            if(p1.getRemainingPieces() + p2.getRemainingPieces() == 0){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return true;
        }
    }

    @Override
    public Player_204446830_PobleteLeiva getCurrentPlayer(){
        if(currentTurn == p1.getId()){
            return p1;
        }
        else{
            return p2;
        }
    }

    @Override
    public Board_204446830_PobleteLeiva boardGetState(){
        board.printBoard();
        return board;
    }

    @Override
    public Board_204446830_PobleteLeiva getBoard(){
        return board;
    }

    @Override
    public void endGame(){
        int winner = this.getBoard().entregarGanador();

        if(winner == p1.getId()){
            p1.playerWon();
            p2.playerLost();
        }
        else if(winner == p2.getId()){
            p1.playerLost();
            p2.playerWon();
        }
        else{
            p1.playerDraw();
            p2.playerDraw();
        }

        System.out.println("\n### Estadísticas actualizadas ###");
        System.out.println(p1.getName() + " (" + p1.getColor() + "):");
        System.out.println("- Victorias: "+ p1.getWins());
        System.out.println("- Derrotas: " + p1.getLosses());
        System.out.println("- Empates: " + p1.getDraws());


        System.out.println("\n" + p2.getName() + " (" + p2.getColor() + "):");
        System.out.println("- Victorias: "+ p2.getWins());
        System.out.println("- Derrotas: " + p2.getLosses());
        System.out.println("- Empates: " + p2.getDraws());


    }

    @Override
    public boolean realizarMovimiento(Player_204446830_PobleteLeiva p, int columna){
        if(board.playPiece(p.getPiece(), columna)){
            p.usePiece();
            Board_204446830_PobleteLeiva board = this.boardGetState();
            Object[] move = {p.getPiece(), columna};
            gameHistory.add(move);

            return true;
        }
       else{
           return false;
        }

    }

    @Override
    public void cambiarTurno(){
        currentTurn = 3 - currentTurn;
    }

    @Override
    public void newBoard(){
        this.board = new Board_204446830_PobleteLeiva();
    }

    @Override
    public void resetGame(int cantRemainingPieces){
        if (!gameHistory.isEmpty()) {
            history.add(new ArrayList<>(gameHistory));
        }

        this.gameHistory = new ArrayList<>();
        this.newBoard();
        p1.setRemainingPieces(cantRemainingPieces);
        p2.setRemainingPieces(cantRemainingPieces);
    }
}