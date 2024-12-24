package org.con4;

import java.util.List;
import java.util.ArrayList;

public class Game implements GameMetodos {
    public Player p1;
    public Player p2;
    public Board board;
    public int currentTurn;
    public List<Object[]> history;

    //constructor
    public Game(Player p1, Player p2){
        this.p1 = p1;
        this.p2 = p2;
        this.board = new Board();
        this.currentTurn = 1;
        this.history = new ArrayList<>();
    }

    //getter history
    @Override
    public List<Object[]> getHistory(){
        return history;
    }

    //métodos
    @Override
    public void printHistory() {
        System.out.println("\nHistorial de movimientos: ");
        int i = 1;
        for (Object[] move : history) {
            Piece piece = (Piece) move[0];
            int column = (int) move[1] + 1;
            System.out.println("Movimiento "+ i + ":\n-Pieza: " + piece.getColor() + " (" + piece.getPlayer().getName() + ")\n-Columna: " + column );
            i++;
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
    public Player getCurrentPlayer(){
        if(currentTurn == p1.getId()){
            return p1;
        }
        else{
            return p2;
        }
    }

    @Override
    public Board boardGetState(){
        board.printBoard();
        return board;
    }

    @Override
    public Board getBoard(){
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
    public boolean realizarMovimiento(Player p, int columna){
        if(board.playPiece(p.getPiece(), columna)){
            p.usePiece();
            currentTurn = 3 - p.getId();
            Board board = this.boardGetState();
            Object[] move = {p.getPiece(), columna};
            history.add(move);

            return true;
        }
       else{
           return false;
        }

    }
}