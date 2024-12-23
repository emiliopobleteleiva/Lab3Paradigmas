package org.con4;

public class Player{
    final private int id;
    final private String name;
    final private Piece piece;
    private int wins;
    private int losses;
    private int draws;
    private int remainingPieces;

    //crear clase Player
    public Player(int id, String name, String colorString, int remainingPieces){
        this.id = id;
        this.name = name;
        this.piece = new Piece(colorString, this);
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.remainingPieces = remainingPieces;
    }

    //obtenedores de informacion
    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public Piece getPiece(){
        return piece;
    }

    public String getColor() {
        return piece.getColor();
    }

    public int getWins() {
        return wins;
    }
    public int getLosses() {
        return losses;
    }
    public int getDraws() {
        return draws;
    }
    public int getRemainingPieces() {
        return remainingPieces;
    }

    //modificadores
    public void usePiece(){
        if (remainingPieces > 0){
            remainingPieces--;
        }
    }
    public void playerWon(){
        wins++;
    }
    public void playerLost(){
        losses++;
    }
    public void playerDraw(){
        draws++;
    }
}
