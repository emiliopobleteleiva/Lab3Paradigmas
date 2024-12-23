package org.con4;

public class Piece {
    private String color;
    private Player player;

    //crear clase
    public Piece(String color, Player playerIn) {
        this.color = color;
        this.player = playerIn;
    }

    //obtener informacion
    public String getColor(){
        return color;
    }

    public Player getPlayer() {
        return player;
    }
}