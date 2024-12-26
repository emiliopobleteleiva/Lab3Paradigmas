package org.example;

public class Player_204446830_PobleteLeiva implements PlayerMetodos_204446830_PobleteLeiva {
    final private int id;
    final private String name;
    final private Piece_204446830_PobleteLeiva piece;
    private int wins;
    private int losses;
    private int draws;
    private int remainingPieces;

    //crear clase Player
    public Player_204446830_PobleteLeiva(int id, String name, String colorString, int remainingPieces){
        this.id = id;
        this.name = name;
        this.piece = new Piece_204446830_PobleteLeiva(colorString, this);
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.remainingPieces = remainingPieces;
    }

    //getters / obtenedores de info
    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public Piece_204446830_PobleteLeiva getPiece(){
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
    @Override
    public void usePiece(){
        if (remainingPieces > 0){
            remainingPieces--;
        }
    }

    @Override
    public void playerWon(){
        wins++;
    }

    @Override
    public void playerLost(){
        losses++;
    }

    @Override
    public void playerDraw(){
        draws++;
    }

    @Override
    public void setRemainingPieces(int cant){
        this.remainingPieces = cant;
    }

    @Override
    public void actualizarEstadisticas(int event){

        switch(event){
            case 0:
                this.playerDraw();
                break;
            case 1:
                this.playerLost();
                break;
            case 2:
                this.playerWon();
                break;
        }
    }
}
